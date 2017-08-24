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
    src = imread( argv[1], 1 );
    if (!src.data) {
        std::cout << "Image file not found\n";
        return 1;
    }
    cvtColor( src, src_gray, CV_BGR2GRAY );
    for(int i = 0 ; i < 20; i++){    
       blur( src_gray, src_gray, Size(4,4) );
    }
    thresh_callback( 0, 0 );
    waitKey(0);
    return(0);
}

void thresh_callback(int, void* ) {
  Mat canny_output;
  vector<vector<Point> > contours;
  vector<Vec4i> hierarchy;

  Canny( src_gray, canny_output, 30, 30, 3 );
  findContours( canny_output, contours, hierarchy, CV_RETR_EXTERNAL, CV_CHAIN_APPROX_NONE, Point(0, 0) );
    Mat drawing = Mat::zeros( canny_output.size(), CV_8UC3 );
    for( int i = 0; i< contours.size(); i++ ) {
       Scalar color = Scalar( 255,255,0 );
       drawContours( drawing, contours, i, color, 10, 8, hierarchy, 0, Point() );
    }
 
    cvtColor( drawing, drawing, CV_BGR2GRAY );
    Canny( drawing, drawing, 10, 10, 3 );
    findContours( drawing, contours, CV_RETR_EXTERNAL, CV_CHAIN_APPROX_NONE, Point(0, 0) );
    drawing = Mat::zeros( drawing.size(), CV_8UC3 );
    std::vector<cv::Point> man;
    cv::Rect rectangle;
    for( int i = 0; i< contours.size(); i++ ) {
        Scalar color = Scalar( 255,i%2*200,0 );
        rectangle = cv::boundingRect(contours[i]);
        if (rectangle.width > 40 &&  rectangle.height > 300) {
            man.push_back(rectangle.tl());
            man.push_back(rectangle.br());
            drawContours( drawing, contours, i, color, 10, 8, hierarchy, 0, Point() );
            cv::Rect rectangleMan = cv::boundingRect(man);
            cv::rectangle(src, rectangleMan.tl(), rectangleMan.br(), cv::Scalar(128,0,128),3);
        }
    }

    namedWindow( "image", CV_WINDOW_NORMAL );
    imshow( "image",  src);
}
