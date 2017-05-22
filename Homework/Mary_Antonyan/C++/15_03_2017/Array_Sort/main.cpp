#include <iostream>
#include "sortarray.h"

int main() {
    int size;
    do {
        std::cout << "Enter size of array: ";
        std::cin >> size;
        if (std::cin.fail()) {
            std::cout << "Error: Invalid input data\n";
            return -1;
        }
    } while (1 >= size );

    int* arr = createArr(size);
    std::cout << "\n---Initial Array---\n";
    printArr(arr, size);

    int variant;
    do {
        std::cout << "\nChoose variant of sorting\n1 - Sort in ascending order";        std::cout << "\n2 - Sort in descending order" << std::endl;
        std::cin >> variant;
        if (std::cin.fail()) {
            std::cout << "Error: Invalid input data\n";
            return -1;
        }
    } while (1 > variant || 2 < variant);
    
    void (*func)(int* arr, const int& size);
    if (1 == variant) {
        func = &sortAscending;
    } else {
        func = &sortDescending;
    }

    sort(arr, size, func);
    std::cout << "\n---Sorted Array---\n";
    printArr(arr, size);

    delete[] arr;
    return 0;
}
