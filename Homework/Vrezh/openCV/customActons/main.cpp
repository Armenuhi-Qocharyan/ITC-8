#include <opencv2/opencv.hpp>

bool openImage(cv::Mat image, std::string name) {
    if (!image.data) {
        printf("No image data \n");
        return false;
    }
    namedWindow(name, cv::WINDOW_AUTOSIZE );
    imshow(name, image);
    return true;
}


bool binaryImage(cv::Mat image) {
    for (int y = 0; y < image.rows; y++) {
        for (int x = 0; x < image.cols; x++) {
            cv::Vec3b color = image.at<cv::Vec3b>(cv::Point(x,y));
            color[0] = color[1] = color[2];
            if (color[0] > 100) {
                color[0] = color[1] = color[2] = 255;
            } else {
                color[0] = color[1] = color[2] = 0;
            }
            image.at<cv::Vec3b>(cv::Point(x,y)) = color;
        }
    }
}

bool changeImageColor(cv::Mat image) {
    for (int y = 0; y < image.rows; y++) {
        for (int x = 0; x < image.cols; x++) {
            cv::Vec3b color = image.at<cv::Vec3b>(cv::Point(x,y));
            color[0] = color[1] = color[2];
            image.at<cv::Vec3b>(cv::Point(x,y)) = color;
        }
    }
}

void drawCircle(const cv::Mat & img, cv::Point point, int radius) {
    cv::Scalar black(0, 0, 0);
    cv::circle(img, point, radius, black);
}


int main(int argc, char** argv ) {
    if (argc != 2 ) {
        std::cout << "usage: DisplayImage.out <Image_Path>\n";
        return -1;
    }
 
    cv::Mat image;
    image = cv::imread( argv[1], 1 );

    if (!openImage(image, "show")) {
        return -1;
    } 
        
    //custom gray
    cv::Mat grayImage = image.clone();
    changeImageColor(grayImage);// gray image
    openImage(grayImage.clone(), "custom_gray");// open image
    
    //gray
    grayImage = image.clone();
    cv::cvtColor(image, grayImage, CV_BGR2GRAY);
    openImage(grayImage, "gray");// open image

    //binary
    cv::Mat dst;
    cv::threshold( grayImage, dst, 0, 255, 3);
    threshold( grayImage, dst, 100,255,cv::THRESH_BINARY );
    openImage(dst, "binary");

    //custom binary
    cv::Mat binary = image.clone();
    binaryImage(binary);
    openImage(binary, "custom_binary");
    
    //draw circle 
    cv::RNG& rng = cv::theRNG();
    cv::Point pt;
    pt.x = rng.uniform(0, image.cols/2);
    pt.y = rng.uniform(0, image.rows/2 - 100);

    cv::Mat circleImage = image.clone();
    drawCircle(circleImage, pt, 100);// draw circle
    openImage(circleImage, "circle");// open image
    
    cv::waitKey(0);

    return 0;
}
