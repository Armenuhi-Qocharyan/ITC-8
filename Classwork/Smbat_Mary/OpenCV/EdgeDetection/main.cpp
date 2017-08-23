#include "opencv2/opencv.hpp"
#include <iostream>

using namespace cv;
int MAX_KERNEL_LENGTH = 31;

int main(int argc, char** argv) {
    if (argc != 2) {
        std::cout << "Error: Missing command line argumanets.\n\tUsage: ./EdgeDetection <image_path>" << std::endl;
        return -1;
    }

    String path = argv[1];
    // Read image
    Mat image = imread(path);
    if (!image.data) {
        std::cout << "Image not found" << std::endl;
        return -1;
    }
    namedWindow("Image", 1);
    imshow("Image", image);

    // Blur and show image
    Mat blurImage = image.clone();
    bilateralFilter(image, blurImage, 30, 150, 10, 1);
    namedWindow("Blur image", 1);
    imshow("Blur image", blurImage);

    // Grayscale image
    cvtColor(blurImage, blurImage, CV_BGR2GRAY);

    // Apply Canny filter to image and show
    Mat cannyImage;
    int lowThreshold = 100;
    int ratio = 3;
    int kernel_size = 3;
    Canny(blurImage, cannyImage, lowThreshold, lowThreshold * ratio, kernel_size);
    namedWindow("Canny image", 1);
    imshow("Canny image", cannyImage);

    // Find contours
    std::vector<std::vector<Point> > contours;
    Mat contourImage = cannyImage.clone();
    findContours(contourImage, contours, CV_RETR_LIST, CV_CHAIN_APPROX_NONE);

    // Draw contours
    Mat contourOutput(image.size(), CV_8UC3, Scalar(0,0,0));
    Scalar colors[2];
    colors[0] = Scalar(255, 0, 127);
    colors[1] = Scalar(0, 76, 153);
    for (size_t i = 0; i < contours.size(); i++) {
        Rect r = boundingRect(contours[i]);
        drawContours(contourOutput, contours, i, colors[1]);
    }
    namedWindow("Contour image", 1);
    imshow("Contour image", contourOutput);

    waitKey(0);
    return 0;
}
