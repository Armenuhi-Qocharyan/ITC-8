#ifndef ASSERT_H
#define ASSERT_H 1

#include <iostream>
#define my_assert(x)\
    if (!(x)) {\
        std:: cout << "error in " << __FUNCTION__;\
        std::cout << ", line " << __LINE__;\
        std::cout << " , condition: " << #x << std::endl;\
    }

#endif
