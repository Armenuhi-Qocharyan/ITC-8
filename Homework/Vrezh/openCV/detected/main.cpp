#include <opencv2/opencv.hpp>
#include <vector>
#include <iostream>

using namespace std;
using namespace cv;

int main (int argc, const char * argv[]) {

    if (argc != 2 ) {
        std::cout << "usage: DisplayImage.out <Image_Path>\n";
        return -1;
    }

    cv::Mat img;
    img = cv::imread( argv[1], 1 );

    namedWindow("opencv", CV_WINDOW_NORMAL);
    HOGDescriptor hog;
    hog.setSVMDetector(HOGDescriptor::getDefaultPeopleDetector());


    vector<Rect> found, found_filtered;
    hog.detectMultiScale(img, found, 0, Size(8,8), Size(32,32), 1.05, 2);
    size_t i, j;
    for ( i = 0; i < found.size(); i++) {
        Rect r = found[i];
        for (j = 0; j < found.size(); j++) {
            if (j != i && (r & found[j]) == r)
                break;
        }
        if (j == found.size()) {
            found_filtered.push_back(r);
        }
    }

    for (i = 0; i < found_filtered.size(); i++) {
        Rect r = found_filtered[i];
        r.x += cvRound(r.width*0.1);
        r.width = cvRound(r.width*0.8);
        r.y += cvRound(r.height*0.07);
        r.height = cvRound(r.height*0.8);
        rectangle(img, r.tl(), r.br(), Scalar(0,255,0), 3);
    }

    imshow("opencv", img);
    waitKey(0);

    return 0;
}
