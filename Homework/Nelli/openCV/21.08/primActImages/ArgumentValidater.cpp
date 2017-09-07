#include "ArgumentValidater.hpp"

ArgumentValidater::ArgumentValidater(int argc, char** argv):
mArgc(argc), mArgv(argv){
    this.keys = 
        "{videopath v    |.     | path to video file         }"
        "{keep ki        | -1.0 | forder path to keep images }"
        "{show           |      | show video or not          }";
    mParser = cv::CommandLineParser parser(mArgc, mArgv, keys); 
}

ArgumentValidater::~ArgumentValidater() {

} 

bool ArgumentValidater::validate()const {
    mVideoPath = parser.get<cv::String>("videopath");
    mKeepImagesPath = parser.get<cv::String>("keep");
    if (!parser.check()) {
        parser.printErrors();
        return false;
    }
    return true;
} 

cv:String ArgumentValidater::getVideoPath()const {
    return mVideoPath;
} 

cv:String ArgumentValidater::getKeepImagesPath()const {
    return mKeepImagesPath;
} 

bool ArgumentValidater::isShowEnable()const {
    return mParser.has("show");
} 