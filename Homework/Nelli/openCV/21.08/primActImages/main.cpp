#include <opencv2/opencv.hpp>
#include <iostream>
using namespace std;
using namespace cv;
int main(int argc, char** argv) {
 const String keys =
        "{help h usage ? |      | print this message   }"
        "{@image1        |      | image1 for compare   }"
        "{@image2        |      | image2 for compare   }"
        "{@repeat        |1     | number               }"
        "{path           |.     | path to file         }"
        "{fps            | -1.0 | fps for output video }"
        "{N count        |100   | count of objects     }"
        "{ts timestamp   |      | use time stamp       }"
        ;
CommandLineParser parser(argc, argv, keys);
parser.about("Application name v1.0.0");
if (parser.has("help"))
{
    parser.printMessage();
    return 0;
}
int N = parser.get<int>("N");
double fps = parser.get<double>("fps");
String path = parser.get<String>("path");
String img1 = parser.get<String>(0);
String img2 = parser.get<String>(1);
int repeat = parser.get<int>(2);
if (!parser.check())
{
    parser.printErrors();
    return 0;
}
}
