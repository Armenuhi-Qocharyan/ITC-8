
#include <iostream>
#include <string>
#include <opencv2/opencv.hpp>
#include "opencv2/imgproc/imgproc.hpp"
#include "opencv2/highgui/highgui.hpp"

using namespace cv;

Mat gray_image, dst,dst2,other;

String window_name = "image3";
String window_name2 = "Image4";
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

 //   imwrite( "../Gray_Image.jpg", gray_image );
    namedWindow("Image1", WINDOW_NORMAL );
    namedWindow("Image2", WINDOW_NORMAL );
    namedWindow( window_name, CV_WINDOW_NORMAL );

    createTrackbar( "value",
                  window_name, &threshold_value,
                  max_value, Threshold_Demo );


    createTrackbar( "value",
                    window_name2, &threshold_type,
                    max_type, Threshold_Demo );



    imshow("Image1", image);
    imshow("Image2", gray_image);

    Threshold_Demo( 0, 0 );

    other = imread("../other.jpg" ,1 );
    namedWindow(window_name2, WINDOW_NORMAL );

 //   imshow(,dst2);

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

 // threshold( gray_image, dst, threshold_value, max_BINARY_value,threshold_type );
  threshold( other, dst2, threshold_value, max_BINARY_value, threshold_type);

 // imshow( window_name, dst );
  imshow( window_name2, dst2 );
}


/*
#include "opencv2/imgproc/imgproc.hpp"
#include "opencv2/highgui/highgui.hpp"
#include <stdlib.h>
#include <stdio.h>

using namespace cv;

/// Global variables

int threshold_value = 0;
int threshold_type = 3;
int const max_value = 255;
int const max_type = 4;
int const max_BINARY_value = 255;

Mat src, src_gray, dst;
char* window_name = "Threshold Demo";
char* window_name2 = "Threshold Demo2";

char* trackbar_type = "Type: \n 0: Binary \n 1: Binary Inverted \n 2: Truncate \n 3: To Zero \n 4: To Zero Inverted";
char* trackbar_value = "Value";

/// Function headers
void Threshold_Demo( int, void* );


int main( int argc, char** argv )
{
  /// Load an image
  src = imread( argv[1], 1 );

  /// Convert the image to Gray
  cvtColor( src, src_gray, CV_BGR2GRAY );

  /// Create a window to display results
  namedWindow( window_name, CV_WINDOW_NORMAL );
//  namedWindow( window_name2, CV_WINDOW_NORMAL  );

  /// Create Trackbar to choose type of Threshold

  createTrackbar( trackbar_type,
                  window_name, &threshold_type,
                  max_type, Threshold_Demo );


  createTrackbar( trackbar_value,
                  window_name, &threshold_value,
                  max_value, Threshold_Demo );

  /// Call the function to initialize
  Threshold_Demo( 0, 0 );

  /// Wait until user finishes program
  while(true)
  {
    int c;
    c = waitKey( 20 );
    if( (char)c == 27 )
      { break; }
   }

}


void Threshold_Demo( int, void* )
{

  threshold( src_gray, dst, threshold_value, max_BINARY_value,threshold_type );

  imshow( window_name, dst );
//  imshow( window_name2, dst );
}
*/
