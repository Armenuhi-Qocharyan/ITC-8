#include <iostream>
#include <string>
#include <opencv2/opencv.hpp>
#include "opencv2/imgproc/imgproc.hpp"
#include "opencv2/highgui/highgui.hpp"

using namespace cv;

Mat gray_image, dst,other;

String window_name = "Image3";
int threshold_value = 0;
int threshold_type = 3;
int const max_value = 255;
int const max_type = 4;
int const max_BINARY_value = 255;

void Threshold_Demo( int, void* );

int main(int argc, char** argv )
{
    if ( argc != 2 )
    {
        std::cout << "usage: DisplayImage.out <Image_Path>\n";
        return -1;
    }

    Mat image;
    image = imread( argv[1], 1 );

    if ( !image.data )
    {
        std::cout << "No image data \n";
        return -1;
    }
    cvtColor( image, gray_image, COLOR_BGR2GRAY );
    namedWindow("Image1", WINDOW_NORMAL );
    namedWindow("Image2", WINDOW_NORMAL );
    namedWindow( window_name, CV_WINDOW_NORMAL );
    createTrackbar( "value",
            window_name, &threshold_value,
            max_value, Threshold_Demo );
    imshow("Image1", image);
    imshow("Image2", gray_image);
    Threshold_Demo( 0, 0 );
    while(true) {
        int c;
        c = waitKey( 20 );
        if( (char)c == 27 ) {
            break;
        }
    }

    return 0;
}

void Threshold_Demo( int, void* )
{

    threshold( gray_image, dst, threshold_value, max_BINARY_value,threshold_type );

    imshow( window_name, dst );
}



