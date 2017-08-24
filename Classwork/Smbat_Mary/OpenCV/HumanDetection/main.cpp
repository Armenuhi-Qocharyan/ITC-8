#include "opencv2/imgproc/imgproc.hpp"
#include "opencv2/objdetect/objdetect.hpp"
#include "opencv2/highgui/highgui.hpp"

//#include <stdio.h>
#include <iostream>
#include <string>
#include <ctype.h>

using namespace cv;
using namespace std;

int main(int argc, char** argv) {
    if (argc == 1) {
        std::cout << "Usage: ./HumanDetection (<image_filename> | <image_list>.txt)" << std::endl;
        return 0;
    }

    FILE* f = 0;
    char _filename[1024];

    Mat img = imread(argv[1]);
    if (img.data) {
        strcpy(_filename, argv[1]);
    } else {
        f = fopen(argv[1], "rt");
        if (!f) {
            std::cerr << "ERROR: the specified file could not be loaded" << std::endl;
            return -1;
        }
    }

    HOGDescriptor hog;
    hog.setSVMDetector(HOGDescriptor::getDefaultPeopleDetector());
    namedWindow("People Detection", 1);

    for (;;) {
        char* filename = _filename;
        if (f) {
            if (!fgets(filename, (int)sizeof(_filename) - 2, f)) {
                break;
            }

            if (filename[0] == '#') {
                continue;
            }

            int l = (int)strlen(filename);
            while (l > 0 && isspace(filename[l - 1])) {
                --l;
            }

            filename[l] = '\0';
            img = imread(filename);
        }

        std::cout << filename << std::endl;
        if (!img.data) {
            std::cout << filename << " not found" << std::endl;
            continue;
        }

        fflush(stdout);
        vector<Rect> found, found_filtered;
        double t = (double)getTickCount();

        hog.detectMultiScale(img, found, 0, Size(8, 8), Size(32, 32), 1.05, 2);
        t = (double)getTickCount() - t;
        std::cout << "Detection time = " << t * 1000.0 / getTickFrequency() << std::endl;
        size_t i, j;
        for (i = 0; i < found.size(); i++) {
            Rect r = found[i];
            for (j = 0; j < found.size(); j++) {
                if (j != i && (r & found[j]) == r) {
                    break;
                }
            }

            if (j == found.size()) {
                found_filtered.push_back(r);
            }
        }

        for (i = 0; i < found_filtered.size(); i++) {
            Rect r = found_filtered[i];
            r.x += cvRound(r.width * 0.1);
            r.width = cvRound(r.width * 0.8);
            r.y += cvRound(r.height * 0.07);
            r.height = cvRound(r.height * 0.8);
            rectangle(img, r.tl(), r.br(), Scalar(0, 255, 0), 3);
        }

        imshow("People Detection", img);

        int c = waitKey(0) & 255;
        if (c == 'q' || c == 'Q' || !f) {
            break;
        }
        waitKey(20);
    }

    if (f) {
        fclose(f);
    }

    return 0;
}
