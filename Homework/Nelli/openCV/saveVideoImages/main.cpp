#include <iostream>
#include <string>
#include <opencv2/opencv.hpp>

int main (int argc, char **argv) {
    cv::VideoCapture cap(0);
    if (!cap.isOpened()) {
        std::cerr << "ERROR: Could not open video " << argv[1] << std::endl;
        return 1;
    }

    int i = 0;
    while(i <= 3) {
        cv::Mat frame;
        cap >> frame;
        std::string filename = "image" + std::to_string(i) + ".jpg";
        cv::imwrite(filename, frame);
        ++i;
    }

  return 0;
}
