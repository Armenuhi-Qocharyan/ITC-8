#ifndef HELPER_HPP
#define HELPER_HPP

#include "binarytree.hpp"

namespace Utils {
    void error();
    int setValue(const char* message);
    char setFlag();
    void printInfo(const Tree::BinaryTree& searchTree, const int& value);
}

#endif
