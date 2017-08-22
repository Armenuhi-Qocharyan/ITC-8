#include <stdio.h>
#include <opencv2/opencv.hpp>

void showImage(cv::Mat image) {
    if (!image.data) {
        printf("No image data \n");
    }
    namedWindow("DisplayImage", cv::WINDOW_AUTOSIZE );
    imshow("DisplayImage", image);
}


void changeImageColor(cv::Mat image) {
    for (int y=0;y<image.rows;y++) {
        for (int x=0;x<image.cols;x++) {
            cv::Vec3b color = image.at<cv::Vec3b>(cv::Point(x,y));
            color[0] = color[1] = color[2];
            image.at<cv::Vec3b>(cv::Point(x,y)) = color;
        }
    }
}

void drawCircle(const cv::Mat & img, cv::Point cp, int radius) {
    cv::Scalar black( 255, 0, 0 );
    cv::circle( img, cp, radius, black );
    cv::imshow( "circle", img ); 
}

int main(int argc, char** argv ) {
    if (argc != 2 ) {
        std::cout << "usage: DisplayImage.out <Image_Path>\n";
        return -1;
    }
 
    cv::Mat image;
    image = cv::imread( argv[1], 1 );

    cv::waitKey( 0 );

    showImage(image);
    
     
    cv::RNG& rng = cv::theRNG();
    cv::Point pt;
    pt.x = rng.uniform(0, image.cols);
    pt.y = rng.uniform(0, image.rows);
    
    changeImageColor(image);// grey image
    drawCircle(image, pt, 20);// draw circle
    showImage(image);// open image
    
    cv::waitKey(0);
    return 0;
}
