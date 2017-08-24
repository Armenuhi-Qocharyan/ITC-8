#include "opencv2/imgproc/imgproc.hpp"
#include "opencv2/objdetect/objdetect.hpp"
#include "opencv2/highgui/highgui.hpp"

//#include <stdio.h>
#include <iostream>
#include <string>
#include <ctype.h>

using namespace cv;
using namespace std;

int main() {
    Mat img = imread("../Images/test_1.jpg");
    Mat img_gray;
    String haarcascade_upperbody = "../haarcascade_upperbody.xml";
    CascadeClassifier upperbodyClassifier;

    upperbodyClassifier.load( haarcascade_upperbody );

    std::vector<Rect> found;
    cvtColor( img, img_gray, COLOR_BGR2GRAY );
    equalizeHist( img_gray, img_gray );

    upperbodyClassifier.detectMultiScale( img_gray, found, 1.1, 2, 0|CASCADE_SCALE_IMAGE, Size(30, 30) );

    for (int i = 0; i < found.size(); i++) {
                Rect r = found[i];
                r.x += cvRound(r.width * 0.1);
                r.width = cvRound(r.width * 0.8);
                r.y += cvRound(r.height * 0.07);
                r.height = cvRound(r.height * 0.8);
                rectangle(img, r.tl(), r.br(), Scalar(0, 255, 0), 3);
            }

    imshow("People Detection", img);
    waitKey(0);
    return 0;
}
