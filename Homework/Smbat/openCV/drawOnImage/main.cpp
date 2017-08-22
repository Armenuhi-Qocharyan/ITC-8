#include <iostream>
#include <string>
#include <opencv2/opencv.hpp>

void show(cv::Mat image) {
    cv::imshow("window1", image);
    cv::waitKey(0);
}
void imThreshold(cv::Mat img){
    cv::Mat image = img;
        for(int y=0;y<img.rows;y++) {
            for(int x=0;x<img.cols;x++) {
                cv::Vec3b color = image.at<cv::Vec3b>(cv::Point(x,y));
                if(color[0] > 150 && color[1] > 150 && color[2] > 150) {
                    color[0] = 0;
                    color[1] = 0;
                    color[2] = 0;
                    //std::cout << "Pixel >200 :" << x << "," << y << std::endl;
                }
                else {
                    color.val[0] = 255;
                    color.val[1] = 255;
                    color.val[2] = 255;
                }
                image.at<cv::Vec3b>(cv::Point(x,y)) = color;
            }
        }
        show(image);
}

int main() {
    std::string path = "/home/smbat/workspace/ITC-8/Homework/Smbat/openCV/drawOnImage/image.png";
    cv::Mat img = cv::imread(path);
    if (!img.data) {
           std::cout << "No image data" << std::endl;
           return -1;
    }
    cv::namedWindow("window1", cv::WINDOW_AUTOSIZE);

    //Gray Image
    cv::Mat grayImg;
    cv::cvtColor(img, grayImg, CV_BGR2GRAY);
    show(grayImg);

//----Threshold
    cv::Mat thresholdImg;
    cv::threshold(grayImg, thresholdImg, 100, 200, cv::THRESH_BINARY_INV);
    cv::threshold(grayImg, thresholdImg, 100, 200, cv::THRESH_BINARY);
    show(thresholdImg);

//--- custom Threshold
    imThreshold(img);

//---Drow on image
    cv::line(img, *(new cv::Point(0,0)), *(new cv::Point(1000,1000)), *(new cv::Scalar(255,168,97)), 10);
    cv::rectangle(img,*(new cv::Point(1000,400)), *(new cv::Point(400,700)), *(new cv::Scalar(255,255,0)), 4);
    cv::circle(img,*(new cv::Point(250,100)), 50, *(new cv::Scalar(0,0,255)), -1);
    show(img);

    return 0;
}

