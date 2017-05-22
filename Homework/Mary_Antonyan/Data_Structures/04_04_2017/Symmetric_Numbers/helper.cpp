#include "helper.hpp"
#include "stack.hpp"
#include <iostream>

namespace List { 
    int setNumber() {
        int number = 0;
        do {
            if (isValid(number)) {
                break;
            }
        } while (true);
        return number;
    }

    bool isValid(int& number) {
        std::cout << "Enter number: ";
        std::cin >> number;
        if (std::cin.fail()) {
            std::cout << "Error: Invalid input data" << std::endl;
            exit(0);
        }

        if (0 > number) {
            return false;
        }
        return true;
    }

    int getLength(int number) {
        int length = 0;
        while (0 < number) {
            number /= 10;
            ++length; 
        }
        return length;
    } 

    bool isSymmetric(int number) {
        Stack stack;
        int length = getLength(number);
        int digit = 0;
        for (int i = 0; i < length / 2; ++i) { 
            digit = number % 10;
            number /= 10;
            stack.push(digit);
        }

        if (0 != length % 2) {
            stack.push(number % 10);
        }

        for (int i = 0; i <= length / 2; ++i) {
            digit = number % 10;
            number /= 10;
            if (stack.top() == digit) {
                stack.pop();
            } else {
                return false; 
            }
        }
        return stack.isEmpty();
    }

    void printInfo(const int number, bool isSym) {
        if (isSym) {
            std::cout << number << " is symmetric" << std::endl;
        } else {
            std::cout << number << " is not symmetric" << std::endl;
        }
    }
}
