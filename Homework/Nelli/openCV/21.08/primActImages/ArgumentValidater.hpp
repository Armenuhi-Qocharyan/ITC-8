#include <opencv2/opencv.hpp>

class ArgumentValidater() {
    public:
        ArgumentValidater()=delete; 
        ArgumentValidater(int argc, char** argv);
       ~ArgumentValidater(); 
        bool validate()const; 
        cv:String getVideoPath()const; 
        cv:String getKeepImagesPath()const; 
        bool isShowEnable()const;  
    private:
        cv:String keys; 
        const int mArgc;
        const char** mArgv; 
        cv:String mVideoPath;
        cv:String mKeepImagesPath;
        bool mShow;
        cv:CommandLineParser mParser;
}
