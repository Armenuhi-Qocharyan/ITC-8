#include <iostream>
#include <opencv2/opencv.hpp>

using namespace cv;

int main(int argc, char** argv) {
    if (argc != 2) {
        std::cout << "Error: Missing command line argumanets.\n\tUsage: ./Test <Image_Path>" << std::endl;
        return -1;
    }

    Mat image = imread(argv[1], 1);
    if (!image.data) {
        std::cout << "No image data" << std::endl;
        return -1;
    }

    // Show initial image
    namedWindow("Test image", WINDOW_AUTOSIZE);
    imshow("Test image", image);

    // Draw line
    line(image, *(new Point(0,0)), *(new Point(100,100)), *(new Scalar(255,0,0)), 5);

    //Draw rectangle
    rectangle(image,*(new Point(50,0)), *(new Point(150,100)), *(new Scalar(0,255,0)), 3);

    // Draw circle
    circle(image,*(new Point(250,100)), 50, *(new Scalar(0,0,255)), -1);

    // Show image with drawings
    namedWindow("Drawn image", WINDOW_AUTOSIZE);
    imshow("Drawn image", image);

    // Modify image to grayscale
    namedWindow("Grayscale image", WINDOW_AUTOSIZE);
    Mat grayImage;
    cvtColor(image, grayImage, CV_BGR2GRAY);
    imshow("Grayscale image", grayImage);

    // Save grayscale image
    imwrite("./gray_image.jpg", grayImage);

    // Modify image to binary
    namedWindow("Threshold image", WINDOW_AUTOSIZE);
    Mat binaryImage;
    threshold(grayImage, binaryImage, 128.0, 255.0, THRESH_BINARY);
    imshow("Threshold image", binaryImage);

    waitKey(0);
    return 0;
}
