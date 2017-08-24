#include <iostream>
#include <opencv2/opencv.hpp>

using namespace std;
using namespace cv;

int main (int argc, const char * argv[])
{
    /*
       VideoCapture cap("video.mp4");
       cap.set(CV_CAP_PROP_FRAME_WIDTH, 320);
       cap.set(CV_CAP_PROP_FRAME_HEIGHT, 240);    
       if (!cap.isOpened())
       return -1;
       */
    Mat img;
    img = imread(argv[1]);
    HOGDescriptor hog;
    hog.setSVMDetector(HOGDescriptor::getDefaultPeopleDetector());

    //  namedWindow("video capture", CV_WINDOW_AUTOSIZE);
    //    while (true)
    //    {
    // cap >> img;
    if (!img.data)
        return -1;

    vector<Rect> found, found_filtered;
    hog.detectMultiScale(img, found, 0, Size(8,8), Size(10,10), 1.05, 2);
//    imshow("capture", img);


    cout << found[0] << endl;
    size_t i, j;
    for (i=0; i<found.size(); i++)
    {
        Rect r = found[i];
        for (j=0; j<found.size(); j++)
            if (j!=i && (r & found[j])==r)
                break;
        if (j==found.size())
            found_filtered.push_back(r);
    }
    for (i=0; i<found_filtered.size(); i++)
    {
        Rect r = found_filtered[i];
        r.x += cvRound(r.width*0.1);
        r.width = cvRound(r.width*0.8);
        r.y += cvRound(r.height*0.06);
        r.height = cvRound(r.height*0.9);
        rectangle(img, r.tl(), r.br(), cv::Scalar(0,255,0), 2);
    }
    imshow("video capture", img);
    while(true) {
        int c;
        c = waitKey( 20 );
        if( (char)c == 27 ) {
            break;
        }
    }

    //    }
    return 0;
}
