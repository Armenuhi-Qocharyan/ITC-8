#include "opencv2/opencv.hpp"
using namespace cv;

Mat convertToGray(Mat image) {
    Mat grayImage = image.clone();
    int gray = 0;
    for (int y = 0; y < image.rows; y++)
    {
        for(int x = 0; x < image.cols; x++)
        {
            Vec3b pixel = image.at<Vec3b>(Point(x, y));
            gray = (pixel[0] + pixel[1] + pixel[2]) / 3;
            for (int k = 0; k < 3; ++k) {
                pixel[k] = gray;
            }
            grayImage.at<Vec3b>(Point(x, y)) = pixel;
        }
    }
    return grayImage;
}

int main(int argc, char** argv) {
    if (argc != 2) {
        std::cout << "Error: Missing command line argumanets.\n\tUsage: ./CustomGrey <image_path>" << std::endl;
        return -1;
    }

    Mat image = imread(argv[1]);
    if (!image.data) {
        std::cout << "Image not found" << std::endl;
        return -1;
    }

    Mat grayImage = convertToGray(image);
    namedWindow("Custom grayscaled window", 1);
    imshow("Custom grayscaled window", grayImage);

    waitKey(0);
    return 0;
}
