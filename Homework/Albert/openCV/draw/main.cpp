#include <iostream>
#include <opencv2/opencv.hpp>
#include <opencv2/imgproc.hpp> // drawing shapes

using namespace cv;

void drawCircle(const cv::Mat& image) {
    //cv::Mat image(500,500, CV_8UC3, cv::Scalar(0,0,0));
    cv::Point center(650,300);
    int radius = 150;
    cv::Scalar color(0,0,255);
    int thickness = 3;
    cv::circle(image, center, radius, color, thickness);
}

void drawRect(const cv::Mat& image) {
    cv::Point p3(400,100), p4(900,530);
    cv::Scalar color(0,0,255);
    int thickness = 3;
    cv::rectangle(image, p3, p4, color,thickness);
}

void changeColor(cv::Mat& image) {
    namedWindow("Custom change color image", WINDOW_NORMAL);
    for(int x = 0; x < image.rows; ++x) {
        for(int y = 0; y < image.cols; ++y) {
            int color = (image.at<cv::Vec3b>(x,y)[0] + image.at<cv::Vec3b>(x,y)[1] + image.at<cv::Vec3b>(x,y)[2]) / 3;
                image.at<cv::Vec3b>(x,y)[0] = color;
                image.at<cv::Vec3b>(x,y)[1] = color;
                image.at<cv::Vec3b>(x,y)[2] = color;
        }
    }
    imshow("Custom change color image", image);
}


void grey(const cv::Mat& image) {
    namedWindow("Grayscale image", WINDOW_NORMAL);
    Mat grayImage;
    cvtColor(image, grayImage, CV_BGR2GRAY);
    imshow("Grayscale image", grayImage);
}

void binary(const cv::Mat& imageMat) {
    namedWindow("Binary image", WINDOW_NORMAL);
    cv::Mat binaryImg;
    cv::threshold(imageMat, binaryImg, 100, 255, cv::THRESH_BINARY);
    imshow("Binary image", binaryImg);
}

int main(int argc, char** argv) {

    if (argc != 2) {
        printf("usage: DisplayImage.out <Image_Path>\n");
        return -1;
    }
    cv::Mat image = imread(argv[1], 1);

    if (!image.data) {
        printf("No image data \n");
        return -1;
    }
    cv::Mat imageGrey = image.clone();
    cv::Mat imageBin = image.clone();
    cv::Mat imageCol = image.clone();

    drawCircle(image);
    drawRect(image);
    cv::namedWindow("Display Image", CV_WINDOW_NORMAL);
    cv::imshow("Display Image", image);

    grey(imageGrey);
    binary(imageBin);
    changeColor(imageCol);

    waitKey(0);
    return 0;
}

