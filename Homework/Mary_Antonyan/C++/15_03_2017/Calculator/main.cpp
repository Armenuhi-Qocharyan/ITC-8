#include <iostream>
#include "function.h"

int main() {
    char flag;
    bool check = true;
    do {
        std::string str;
        std::cout << "Enter first operand: ";
        std::cin >> str;

        printResult(str, check);

        if (check) {
            std::cout << "Enter any character to continue" << std::endl;
            std::cout << "Enter Q to quit" << std::endl;
            std::cin >> flag;
        }
    } while (check && 'q' != flag && 'Q' != flag);
    return 0;
}
