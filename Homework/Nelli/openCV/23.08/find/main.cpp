#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace cv;
using namespace std;

Mat src; 
Mat src_gray;

void thresh_callback(int, void* );


int main( int argc, char** argv ) {
 /// Load source image and convert it to gray
    src = imread( argv[1], 1 );
    if (!src.data) {
        std::cout << "Image file not found\n";
        return 1;
    }

    
  /// Convert image to gray and blur it
    cvtColor( src, src_gray, CV_BGR2GRAY );
    blur( src_gray, src_gray, Size(12,17) );
    thresh_callback( 0, 0 );
    waitKey(0);
    return(0);
}

/** @function thresh_callback */
void thresh_callback(int, void* )
{
  Mat canny_output;
  vector<vector<Point> > contours;
  vector<Vec4i> hierarchy;

  /// Detect edges using canny
  Canny( src_gray, canny_output, 30, 50, 3 );

  /// Find contours
  findContours( canny_output, contours, hierarchy, CV_RETR_EXTERNAL, CV_CHAIN_APPROX_NONE, Point(0, 0) );

  /// Draw contours
    Mat drawing = Mat::zeros( canny_output.size(), CV_8UC3 );
    for( int i = 0; i< contours.size(); i++ ) {
       Scalar color = Scalar( 255,255,0 );
       drawContours( drawing, contours, i, color, 10, 8, hierarchy, 0, Point() );
    }
 
     cvtColor( drawing, drawing, CV_BGR2GRAY );
     Canny( drawing, drawing, 10, 10, 3 );
  /// Find contours
    findContours( drawing, contours, CV_RETR_EXTERNAL, CV_CHAIN_APPROX_NONE, Point(0, 0) );

  /// Draw contours
    drawing = Mat::zeros( drawing.size(), CV_8UC3 );
    std::vector<cv::Point> man;
    std::vector<cv::Point> dog;
    cv::Rect rectangle;
    for( int i = 0; i< contours.size(); i++ ) {
        Scalar color = Scalar( 255,i%2*200,0 );
        rectangle = cv::boundingRect(contours[i]);
        if (rectangle.width > 20 &&  rectangle.height > 350) {
            man.push_back(rectangle.tl());
            man.push_back(rectangle.br());
            drawContours( drawing, contours, i, color, 10, 8, hierarchy, 0, Point() );
        } else if (rectangle.width > 50 && rectangle.width < 300 && 
          rectangle.height > 266 && rectangle.height < 300) {
            dog.push_back(rectangle.tl());
            dog.push_back(rectangle.br());
            drawContours( drawing, contours, i, Scalar( 155,i%2*200,85 ), 10, 8, hierarchy, 0, Point() );
        }
    }
    cv::Rect rectangleMan = cv::boundingRect(man);
    cv::rectangle(src, rectangleMan.tl(), rectangleMan.br(), cv::Scalar(128,0,128),3);

    cv::Rect rectangleDog = cv::boundingRect(dog);
    cv::rectangle(src, rectangleDog.tl(), rectangleDog.br(), cv::Scalar(165,42,42),3);
    /// Show in a window
    const char* source_window = "Source";
    namedWindow( source_window, CV_WINDOW_NORMAL );
    resizeWindow(source_window, 800,800);
    moveWindow(source_window, 0, 0);
    imshow( source_window,  src);
}
