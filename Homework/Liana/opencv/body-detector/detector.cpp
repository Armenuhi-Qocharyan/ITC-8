#include <opencv2/opencv.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <vector>
#include <stdio.h>
#include <iostream>
#include <time.h>
#include <ctime>

using namespace cv;
using namespace std;



int main(int argc, const char** argv)
{

    CascadeClassifier detectorBody;
    CascadeClassifier detectorUpper;
    string cascadeName1 = "haarcascade_fullbody.xml";
    string cascadeName2 = "haarcascades/haarcascade_upperbody.xml";

    bool loaded1 = detectorBody.load(cascadeName1);
    bool loaded3 = detectorUpper.load(cascadeName2);
    const clock_t begin_time = clock();

    vector<Rect> human;
    vector<Rect> upperBody;

    Mat img = imread(argv[1]);
    Mat original;

    resize(img, img, Size(640, 480));
    img.copyTo(original);
    cvtColor(img, img, CV_BGR2GRAY);
    detectorBody.detectMultiScale(img, human, 1.1, 2, 0 | 1, Size(40,70), Size(80, 300));
            detectorUpper.detectMultiScale(img, upperBody, 1.1, 2, 0 | 1, Size(40, 70), Size(80, 300));

    if (human.size() > 0) {
        for (int gg = 0; gg < human.size(); gg++) {

            rectangle(original, human[gg].tl(), human[gg].br(), Scalar(0,0,255), 2, 8, 0);

        }
    }

  
       if (upperBody.size() > 0) {
       for (int gg = 0; gg < upperBody.size(); gg++) {

       rectangle(original, upperBody[gg].tl(), upperBody[gg].br(),  Scalar(255,0,0), 2, 8, 0);

       }
       }
       clock_t diff = clock() - begin_time;
    char buffer[126];
    sprintf(buffer, "%d",diff);
    namedWindow("prew", WINDOW_AUTOSIZE);
    imshow("prew", original);

    while(true) {
        int c;
        c = waitKey( 20 );
        if( (char)c == 27 ) {
            break;
        }
    }

}

