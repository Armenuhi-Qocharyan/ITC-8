#include "opencv2/opencv.hpp"
using namespace cv;

const int alpha_slider_max = 100;
int alpha_slider;
double alpha;
double beta;
Mat image1;
Mat image2;
Mat result;

void showTrackbar(int, void*) {
    alpha = (double)alpha_slider / alpha_slider_max ;
    beta = (1.0 - alpha);
    addWeighted(image1, alpha, image2, beta, 0.0, result);
    imshow( "Trackbar", result);
}

int main(int argc, char** argv) {
    if (argc != 3) {
        std::cout << "Error: Missing arguments.\n\tUsage: ./Trackbar <image_path1> <image_path2>" << std::endl;
        return -1;
    }

    image1 = imread(argv[1]);
    image2 = imread(argv[2]);
    if (!image1.data) {
        std::cout << "Image 1 not found" << std::endl;
        return -1;
    }

    if (!image2.data) {
        std::cout << "Image 2 not found" << std::endl;
        return -1;
    }

    alpha_slider = 0;
    namedWindow("Trackbar", 1);
    char TrackbarName[50];

    sprintf(TrackbarName, "Opacity ");
    createTrackbar(TrackbarName, "Trackbar", &alpha_slider, alpha_slider_max, showTrackbar);
    showTrackbar(alpha_slider, 0);

    waitKey(0);
    return 0;
}
