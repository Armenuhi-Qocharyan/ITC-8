#include "opencv2/highgui/highgui.hpp"
#include "opencv2/imgproc/imgproc.hpp"
#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace cv;
using namespace std;

void contoure(cv::Mat &src_gray);

int main( int argc, char** argv ) {
  Mat src = imread( argv[1], 1 );
  Mat src_gray;

  cvtColor( src, src_gray, CV_BGR2GRAY );
  blur( src_gray, src_gray, Size(5,10) );
  contoure(src_gray);

  char* source_window = "Source";
  namedWindow( source_window, CV_WINDOW_NORMAL );
  imshow( source_window, src );

  waitKey(0);
  return(0);
}

void contoure(cv::Mat &src_gray) {
    Mat canny_output;
    vector<vector<Point>> contours;
    vector<Vec4i> hierarchy;

    Canny(src_gray, canny_output, 80, 80*2, 3);
    findContours(canny_output, contours, hierarchy, CV_RETR_TREE, CV_CHAIN_APPROX_SIMPLE, Point(0, 0));

    Mat drawing = Mat::zeros( canny_output.size(), CV_8UC3 );
    for (int i = 0; i < contours.size(); ++i) {
        Scalar color (255, 0, 0);
        drawContours(drawing, contours, i, color, 10, 8, hierarchy, 0, Point());
    }

    namedWindow("Contours", CV_WINDOW_NORMAL);
    imshow("Contours", drawing);
}
