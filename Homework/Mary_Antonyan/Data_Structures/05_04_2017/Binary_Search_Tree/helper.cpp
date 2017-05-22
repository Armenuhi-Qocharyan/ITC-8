#include "helper.hpp"
#include <iostream>

int Utils::setValue(const char* message) {
    int value = 0;
    std::cout << "Enter number to " << message << " in binary tree: ";
    std::cin >> value;
    if (std::cin.fail()) {
        error();
    }
    return value;
}

char Utils::setFlag() {
    char flag = 'c';
    std::cout << "Press Q to quit\nPress any key to continue: ";
    std::cin >> flag;
    if (std::cin.fail()) {
        std::cin.ignore(1000, '\n');
        error();
    }
    return flag;
}

void Utils::error() {
    std::cout << "Error: Invalid input data" << std::endl;
    exit(0);
}

void Utils::printInfo(const Tree::BinaryTree& searchTree, const int& value) {
    if (searchTree.find(value)) {
        std::cout << "Founded " << value << " in binary search tree\n"; 
    } else {
        std::cout << "There is no " << value << " in binary search tree\n";
    }
}
