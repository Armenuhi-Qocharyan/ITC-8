#include "opencv2/highgui/highgui.hpp"
#include "opencv2/imgproc/imgproc.hpp"
#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace cv;
using namespace std;

Mat src; Mat src_gray;

/// Function header
void thresh_callback(int, void* );
cv::Rect findObject (Mat , vector<vector<Point> >, vector<Vec4i>, int, int , int, int);

/** @function main */
int main( int argc, char** argv )
{
    src = imread( argv[1], 1 );

    /// Convert image to gray and blur it
    cvtColor( src, src_gray, CV_BGR2GRAY );
    blur( src_gray, src_gray, Size(13,17) );

    /// Create Window
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
    Canny( drawing, drawing, 30, 50, 3 );

    findContours( drawing, contours, CV_RETR_EXTERNAL, CV_CHAIN_APPROX_NONE, Point(0, 0) );

    /// Draw contours
    cv::Rect r = findObject(drawing, contours, hierarchy, 90, 300, 200, 100);
    cv::rectangle(src, r.tl(), r.br(), cv::Scalar(255, 0, 0), 3);
    cv::Rect r2 = findObject(drawing, contours, hierarchy, 60, 200, 1000, 350);
    cv::rectangle(src, r2.tl(), r2.br(), cv::Scalar(0, 51, 0), 3);
    /// Show in a window
    namedWindow( "Contours", CV_WINDOW_NORMAL );
    resizeWindow("Contours", 600,500);
    moveWindow("Contours", 0,0);
 
    imshow( "Contours",  src);
}

cv::Rect findObject (Mat drawing, vector<vector<Point> > contours, vector<Vec4i> hierarchy, int width1, int width2, int height1, int height2) {
    drawing = Mat::zeros( drawing.size(), CV_8UC3 );
    std::vector<cv::Point> points;
    cv::Rect r;
    for( int i = 0; i< contours.size(); i++ ) {
        Scalar color = Scalar( 255,i%2*200,0 );
        r = cv::boundingRect(contours[i]);
        if (r.width > width1 && r.width < width2 &&  r.height < height1 && r.height > height2) {
            points.push_back(r.tl());
            points.push_back(r.br());
            drawContours( drawing, contours, i, color, 10, 8, hierarchy, 0, Point() );
        }
    }
    cv::Rect rr = cv::boundingRect(points);
    return rr;
 
}
