#include <iostream>
#include <opencv2/opencv.hpp>

using namespace cv;

int main(int argc, char** argv) {
    if ( argc != 2 ) {
        std::cout << "Error: Missing command line argumanets.\n\tUsage: DisplayImage.out <Image_Path>" << std::endl;
        return -1;
    }

    Mat image = imread(argv[1], 1);
    if (!image.data) {
        std::cout << "No image data" << std::endl;
        return -1;
    } else {
        std::cout << "Found image ^^" << std::endl;
    }

    namedWindow("Display Image", WINDOW_AUTOSIZE );
    imshow("Display Image", image);
    waitKey(0);

    return 0;
}
