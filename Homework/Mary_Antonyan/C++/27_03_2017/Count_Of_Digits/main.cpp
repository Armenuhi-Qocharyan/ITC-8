#include "functions.hpp"

int main() {
    int number;
    do {
        std::cout << "Enter number: ";
        std::cin >> number;
        if (std::cin.fail()) {
            std::cout << "Error: Invalid input data" << std::endl;
            std::cin.ignore(1000);
            return 0;
        }
    } while (0 >= number);

    int size = 10;
    int* arr = getResult(number, size);
    if (NULL != arr) {
        printArr(arr, size);
        delete[] arr;
    }

    return 0;
}
