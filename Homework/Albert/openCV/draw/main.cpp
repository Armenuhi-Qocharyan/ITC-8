#include <iostream>
#include <opencv2/opencv.hpp>
#include <opencv2/imgproc.hpp> // drawing shapes

using namespace cv;

void drawCircle(const cv::Mat & image) {
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

void changeColor(cv::Mat image) {
    for(int x = 0; x < image.rows; ++x) {
        for(int y = 0; y < image.cols; ++y) {
            // get pixel
            cv::Vec3b color = image.at<cv::Vec3b>(cv::Point(x,y));
            color[0] = 220;
            color[1] = 220;
            color[2] = 220;
            // set pixel
            image.at<cv::Vec3b>(cv::Point(x,y)) = color;
        }
    }
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
    drawCircle(image);
    drawRect(image);
    //changeColor(image);
    cv::namedWindow("Display Image", CV_WINDOW_NORMAL);
    cv::imshow("Display Image", image);
    waitKey(0);
    return 0;
}

