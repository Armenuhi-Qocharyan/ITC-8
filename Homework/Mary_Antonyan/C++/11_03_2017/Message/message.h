#ifndef MESSAGE_H
#define MESSAGE_H 1

#include <iostream>
#include <ctime>
#define log()\
    time_t now = time(0);\
    tm* ltm = localtime(&now);\
    int month = ltm->tm_mon;\
    switch (month) {\
        case 0: { std::cout << "Jan "; break; }\
        case 1: { std::cout << "Feb "; break; }\
        case 2: { std::cout << "Mar "; break; }\
        case 3: { std::cout << "Apr "; break; }\
        case 4: { std::cout << "May "; break; }\
        case 5: { std::cout << "Jun "; break; }\
        case 6: { std::cout << "Jul "; break; }\
        case 7: { std::cout << "Aug "; break; }\
        case 8: { std::cout << "Sep "; break; }\
        case 9: { std::cout << "Oct "; break; }\
        case 10: { std::cout << "Nov "; break; }\
        case 11: { std::cout << "Dec "; break; }\
    };\
    std::cout << ltm->tm_mday << " " << 1900 + ltm->tm_year;\
    std::cout << " - " << 1 + ltm->tm_hour << ":" << 1 + ltm->tm_min;\
    std::cout << ":" << 1 + ltm->tm_sec << " " << " : ";\
    std::cout << __FILE__ << ", line " << __LINE__;\
    std::cout << " - <My message>" << std::endl;

#endif

