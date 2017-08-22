#include "opencv2/opencv.hpp"
#include <iostream>
using namespace cv;

Mat threshold(String path) {
    Mat image = imread(path, IMREAD_GRAYSCALE);
    Mat thresholdImage(image.rows, image.cols, CV_8UC1);

    for (int x = 0; x < image.rows; x++)
    {
        for(int y = 0; y < image.cols; y++)
        {
            thresholdImage.at<uchar>(x, y) = (image.ptr<uchar>(x, y)[0] > 125) ? 255 : 0;
        }
    }
    return thresholdImage;
}

int main(int argc, char** argv) {
    if (argc != 2) {
        std::cout << "Error: Missing command line argumanets.\n\tUsage: ./CustomThreshold <image_path>" << std::endl;
        return -1;
    }
    Mat thresholdImage = threshold(argv[1]);
    namedWindow("Custom threshold window", 1);
    imshow("Custom threshold window", thresholdImage);

    waitKey(0);
    return 0;
}
