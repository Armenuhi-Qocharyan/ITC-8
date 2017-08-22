#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <stdio.h>
#include <cv.h>
#include <iostream>

using namespace cv;
using namespace std;

void showImage ( Mat image ) {
    namedWindow( "Original image", 0);// Create a window for display.
    resizeWindow("Original image", 500,300);
    moveWindow("Original image", 0,0);
    imshow( "Original image", image );                   // Show our image inside it.
}

void showGrayImage ( Mat image ) {
    Mat gray_image;
    cvtColor( image, gray_image, CV_BGR2GRAY );
    imwrite( "../Gray_Image.jpg", gray_image );
    namedWindow( "Gray image", 0);// Create a window for display.
    resizeWindow("Gray image", 500,300);
    moveWindow("Gray image", 700,0);
    imshow( "Gray image", gray_image);                   // Show our image inside it.
}

void thrashold ( Mat image ) {
    Mat dst;
     
    // Set threshold and maxValue
    double thresh = 127;
    double maxValue = 255; 
    // Binary Threshold
    threshold(image, dst, thresh, maxValue, THRESH_BINARY_INV);
    namedWindow( "Thrashold image", 0);// Create a window for display.
    resizeWindow("Thrashold image", 500,300);
    moveWindow("Thrashold image", 700,500);
    imwrite( "../trashold_Image.jpg", dst );
    imshow( "Thrashold image", dst);                   // Show our image inside it.
}

void toCustomColor (Mat img) {
    Mat image = img;
    for(int y=0;y<img.rows;y++) {
        for(int x=0;x<img.cols;x++) {
            Vec3b color = image.at<Vec3b>(Point(x,y));
            int c = (color[0] + color[1] + color[2]) / 3;
            color[0] = c;
            color[1] = c;
            color[2] = c;
            image.at<Vec3b>(Point(x,y)) = color;
        }
    }
    namedWindow( "Custom color image", 0);// Create a window for display.
    resizeWindow("Custom color image", 500,300);
    moveWindow("Custom color image", 0,500);
    imwrite( "../customColor_Image.jpg", image );
    imshow( "Custom color image", image);                   // Show our image inside it.
}

int main ( int argc, char** argv ) {
    if ( argc != 2) {
        cout <<" Usage: display_image ImageToLoadAndDisplay" << endl;
        return -1;
    }

    Mat image;
    image = imread(argv[1]);   // Read the file
    if (! image.data ) {
        cout <<  "Could not open or find the image" << std::endl ;
        return -1;
    }
    showImage(image);
    showGrayImage(image);
    thrashold(image);
    toCustomColor(image);
    waitKey(0);         
    return 0;
}
