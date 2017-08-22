#include <cv.hpp>
#include <opencv2/core/core.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <iostream>

using namespace cv;
void Threshold( );
void Threshold_changed (int, void*);

    int threshold_value = 0;
    int threshold_type = 3;;
    int const max_value = 255;
    int const max_type = 4;
    int const max_BINARY_value = 255;

    Mat dst, src;
    Mat src_gray;
    std::string window_name = "Threshold";

    std::string trackbar_type = "Type: \n 0: Binary \n 1: Binary Inverted \n 2: Truncate \n 3: To Zero \n 4: To Zero Inverted";
    std::string trackbar_value = "Value";



int main ( int argc, char** argv ) {
    char* imageName = argv[1];

    src = imread( imageName, 1 );

    if ( argc != 2 || !src.data ) {
        printf( " No image data \n " );
        return -1;
    }

    cvtColor( src, src_gray, CV_BGR2GRAY );
    std::string label = "hello";
    Mat draw = src.clone();
    putText(draw, label, Point(100, 100), FONT_HERSHEY_PLAIN, 1.0, CV_RGB(0,255,0), 2.0);

    imwrite( "./Gray_Image.jpg", src_gray );
    
    namedWindow( "Draw", CV_WINDOW_AUTOSIZE );
    namedWindow( imageName, CV_WINDOW_AUTOSIZE );
    namedWindow( "Gray image", CV_WINDOW_AUTOSIZE );

    imshow( imageName, src );
    imshow( "Gray image", src_gray );
    imshow( " Draw ", draw );
    Threshold();

    return 0;
}


void Threshold() {
    
    cvtColor( src, src_gray, CV_BGR2GRAY );
    namedWindow( window_name, CV_WINDOW_AUTOSIZE );
    createTrackbar( trackbar_type,
            window_name, &threshold_type,
            max_type, Threshold_changed );

    createTrackbar( trackbar_value,
            window_name, &threshold_value,
            max_value, Threshold_changed );
    Threshold_changed (0, 0);


    while (true) {
        int c;
        c = waitKey( 20 );
        if ( (char)c == 27 ) { 
            break; 
        }
    }

}

void Threshold_changed (int, void*) {
    threshold( src_gray, dst, threshold_value, max_BINARY_value,threshold_type );
    imshow( window_name, dst );
}




