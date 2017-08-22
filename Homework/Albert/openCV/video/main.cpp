#include <iostream>
#include <string>
#include <opencv2/opencv.hpp>
#include <string>

int main (int argc, char **argv) {

    cv::VideoCapture cap(argv[1]);
    if (!cap.isOpened()) {
        std::cerr << "ERROR: Could not open video " << argv[1] << std::endl;
        return 1;
    }

    int i = 0;
    std::string fileName[] = {"img1.jpg","img2.jpg","img3.jpg"}; 
    while(i <= 2) {
        cv::Mat frame;
        cap >> frame;
        cv::imwrite(fileName[i], frame);
        ++i;
    }

  return 0;
}
