/*
#include <stdio.h>
#include <opencv2/opencv.hpp>

using namespace cv;

int main(int argc, char** argv )
{

    printf(argv[1]);
    if ( argc != 2 )
    {
        printf("usage: DisplayImage.out <Image_Path>\n");
        return -1;
    }

    Mat image;
    image = imread( argv[1], 1 );

    if ( !image.data )
    {
        printf("No image data \n");
        return -1;
    }

    Mat gray_image;
    cvtColor( image, gray_image, COLOR_BGR2GRAY );

 //   imwrite( "../Gray_Image.jpg", gray_image );
    namedWindow("Image1", WINDOW_AUTOSIZE );
    namedWindow("Image2", WINDOW_AUTOSIZE );


    Mat A, C;
    A = imread(argv[1], IMREAD_COLOR);
    Mat D (A, Rect(10, 10, 100, 100) );

    imshow("Image1", image);
    imshow("Image2", gray_image);

    waitKey(0);

    return 0;
}

*/

/*
#include "opencv2/opencv.hpp";
#include <iostream>;

using namespace cv;

using namespace std;

int main(int, char**)
{

    String filename = "../source/video.avi";
    VideoCapture cap(filename); // open the default camera
   // cout << cap << endl;
    if(!cap.isOpened())  // check if we succeeded
        return -1;

    Mat edges;
    namedWindow("edges",1);
  //  for(int i = 0;i < 150; ++i)
    while(true)
    {
        Mat frame;
        cap >> frame; // get a new frame from camera
        cvtColor(frame, edges, COLOR_BGR2GRAY);
        GaussianBlur(edges, edges, Size(7,7), 1.5, 1.5);
        Canny(edges, edges, 0, 30, 3);
        imshow("edges", edges);
        if(waitKey(30) >= 0) break;
    }
    // the camera will be deinitialized automatically in VideoCapture destructor
    return 0;
}

*/



#include <opencv2/opencv.hpp>
#include <iostream>
#include <stdio.h>
using namespace cv;
using namespace std;
int main(int, char**)
{
    Mat frame;
    //--- INITIALIZE VIDEOCAPTURE
    VideoCapture cap;
    // open the default camera using default API
   // cap.open("../video.mp4");
    // OR advance usage: select any API backend
    int deviceID = 0;             // 0 = open default camera
    int apiID = cv::CAP_ANY;      // 0 = autodetect default API
    // open selected camera using selected API
    cap.open(deviceID + apiID);
    // check if we succeeded
    if (!cap.isOpened()) {
        cerr << "ERROR! Unable to open camera\n";
        return -1;
    }
    //--- GRAB AND WRITE LOOP
    cout << "Start grabbing" << endl
        << "Press any key to terminate" << endl;
    int count = 0;
    for (;;)
    {

        // wait for a new frame from camera and store it into 'frame'
        cap.read(frame);
        // check if we succeeded
        if (frame.empty()) {
            cerr << "ERROR! blank frame grabbed\n";
            break;
        }
        // show live and wait for a key with timeout long enough to show images
        imshow("Live", frame);
      //  String nkar = "../source/nkar.jpg";
        imwrite( "../source/nkar.jpg", frame );

        if (waitKey(5) >= 0)
            break;
    }
    // the camera will be deinitialized automatically in VideoCapture destructor
    return 0;
}
