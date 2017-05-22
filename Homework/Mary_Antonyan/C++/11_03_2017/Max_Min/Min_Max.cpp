#include <iostream>
#include <string>
#include "pre.h"

int main() {
    int a;
    std::cout << "Enter a: ";
    std::cin >> a;

    int b;
    std::cout << "Enter b: ";
    std::cin >> b;
    if (std::cin.fail()) {
        std::cout << "Error: Invalid input data" << std::endl;
        return -1;
    }

    std::string str;
    std::cout << "Enter function name: ";
    std::cin >> str;

    if ("maximum" == str) {
        int mx = max(a, b);
        std::cout << mx << std::endl;
    } else if ("minimum" == str) {
        int mn = min(a ,b);
        std::cout << mn << std::endl;
    } else {
        std::cout << "Error: unknown function name" << std::endl;
    }
    
    return 0;
}
