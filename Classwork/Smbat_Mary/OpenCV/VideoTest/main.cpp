#include "opencv2/opencv.hpp"
#include <iostream>

using namespace cv;

int main(int argc, char** argv) {
    if (argc != 2) {
        std::cout << "Error: Missing command line argumanets.\n\tUsage: ./VideoTest <video_Path>" << std::endl;
        return -1;
    }

    String path = argv[1]; //"/home/student/workspace/ITC-8/Classwork/Smbat_Mary/OpenCV/VideoTest/demo.mp4";
    VideoCapture cap(path);
     if(!cap.isOpened()) {
        std::cout << "File or device not found" << std::endl;
        return -1;
    }

    namedWindow("Video Frame", 1);
    Mat frame;
    while (cap.read(frame)) {
        Mat grayImage;
        cvtColor(frame, grayImage, CV_BGR2GRAY);
        imshow("Video Frame", grayImage);
        if(waitKey(20) == 27) break;
    }
    return 0;
}
