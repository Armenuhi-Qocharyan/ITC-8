#include <opencv2/opencv.hpp>
#include <iostream>

int threshold_value = 0;
int threshold_type = 3;
int const max_value = 255;
int const max_type = 4;
int const max_BINARY_value = 255;
cv::Mat src, src_gray, dst;
const char* window_name = "Threshold Demo";
const char* trackbar_type = "Type: \n 0: Binary \n 1: Binary Inverted \n 2: Truncate \n 3: To Zero \n 4: To Zero Inverted";
const char* trackbar_value = "Value";

void Threshold_Demo( int, void* );

using namespace cv;

int main(int argc, char** argv) {
    if (argc != 3) {
        std::cout << "Error: Missing command line argumanets.\n\tUsage: ./VideoTest <video_Path>" << std::endl;
        return -1;
    }

    String path = argv[1]; 
    VideoCapture cap(path);
     if(!cap.isOpened()) {
        std::cout << "File or device not found" << std::endl;
        return -1;
    }
    src = imread( argv[2], 1 );
  cvtColor( src, src_gray, COLOR_RGB2GRAY );
  namedWindow( window_name, WINDOW_AUTOSIZE );
  createTrackbar( trackbar_type,
                  window_name, &threshold_type,
                  max_type, Threshold_Demo );
  createTrackbar( trackbar_value,
                  window_name, &threshold_value,
                  max_value, Threshold_Demo );

    namedWindow("Video Frame", 1);
    Mat frame;
    int i = 0;
    int thickness = -1;
    int lineType = 8;
    Point pt =  Point(100, 100);
    while(cap.read ( frame)) {
       Mat grayImage;
       cvtColor(frame, grayImage, CV_BGR2GRAY);
      // circle( frame,pt, 32, Scalar( 0, 0, 255 ), thickness,lineType );
       putText(grayImage, "Hello from Nelli :D", cvPoint(100,300), 
    FONT_HERSHEY_COMPLEX_SMALL, 5, cvScalar(100,250,250), 1, CV_AA);
       imshow("Video Frame", grayImage);
       char filename[80];
       sprintf(filename,"./frames/test_%d.png",i);
       imwrite(filename, grayImage);
       i++;
       char key = waitKey(10);
       if ( key == 27) break;
    }
    Mat img = imread("./images/image.jpg");
    Mat grey;
    cvtColor(img, grey, CV_BGR2GRAY);

    Mat sobelx;
    Sobel(grey, sobelx, CV_32F, 1, 0);

    double minVal, maxVal;
    minMaxLoc(sobelx, &minVal, &maxVal); //find minimum and maximum intensities
    Mat draw;
    sobelx.convertTo(draw, CV_8U, 255.0/(maxVal - minVal), -minVal * 255.0/(maxVal - minVal));

    namedWindow("image", CV_WINDOW_AUTOSIZE);
    imshow("image", draw);
    waitKey(0);
    return 0;
}

void Threshold_Demo( int, void* )
{
  /* 0: Binary
     1: Binary Inverted
     2: Threshold Truncated
     3: Threshold to Zero
     4: Threshold to Zero Inverted
   */
  threshold( src_gray, dst, threshold_value, max_BINARY_value,threshold_type );
  imshow( window_name, dst );
}
