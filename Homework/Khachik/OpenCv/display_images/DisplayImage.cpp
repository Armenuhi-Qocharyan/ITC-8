#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <stdio.h>
#include <cv.h>
#include <iostream>

using namespace cv;
using namespace std;

void showImage ( Mat image ) {
    namedWindow( "Display window", 0);// Create a window for display.
    resizeWindow("Display window", 1000,700);
    imshow( "Display window", image );                   // Show our image inside it.
    waitKey(0);         
}

void showGrayImage ( Mat image ) {
    Mat gray_image;
    cvtColor( image, gray_image, CV_BGR2GRAY );
    imwrite( "../Gray_Image.jpg", gray_image );
    namedWindow( "Display window2", 0);// Create a window for display.
    resizeWindow("Display window2", 1000,700);
    imshow( "Display window2", gray_image);                   // Show our image inside it.
    waitKey(0);         
}

void thrashold ( Mat image ) {
    Mat dst;
     
    // Set threshold and maxValue
    double thresh = 127;
    double maxValue = 255; 
    // Binary Threshold
    threshold(image, dst, thresh, maxValue, THRESH_BINARY_INV);
    namedWindow( "Display window3", 0);// Create a window for display.
    resizeWindow("Display window3", 1000,700);
    imwrite( "../trashold_Image.jpg", dst );
    imshow( "Display window3", dst);                   // Show our image inside it.
    waitKey(0);         

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
    namedWindow( "Display window4", 0);// Create a window for display.
    resizeWindow("Display window4", 1000,700);
    imwrite( "../customColor_Image.jpg", image );
    imshow( "Display window4", image);                   // Show our image inside it.
    waitKey(0);         
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
    return 0;
}
