#include <iostream>
#include <opencv2/opencv.hpp>

using namespace cv;

int main(int argc, char** argv) {
    if (argc != 2) {
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

    namedWindow("Test image", WINDOW_AUTOSIZE);
    // Draw line
    line(image, *(new Point(0,0)), *(new Point(511,511)), *(new Scalar(255,0,0)), 5);

    //Draw rectangle
    rectangle(image,*(new Point(50,0)), *(new Point(150,100)), *(new Scalar(0,255,0)), 3);

    // Draw circle
    circle(image,*(new Point(447,63)), 63, *(new Scalar(0,0,255)), -1);

    // Show image with drawings
    imshow("Test image", image);

    // Modify image to grayscale
    namedWindow("Grayscale image", WINDOW_AUTOSIZE);
    Mat grayImage;
    cvtColor(image, grayImage, CV_BGR2GRAY);
    imshow("Grayscale image", grayImage);

    // Save grayscale image
    imwrite("./gray_image.jpg", grayImage);

    waitKey(0);
    return 0;
}
