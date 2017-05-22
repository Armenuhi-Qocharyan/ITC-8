#include <iostream>
#include "functions.h"

int main() {
    int size;
    do {
        std::cout << "Enter size of matrix: ";
        std::cin >> size;
        if (std::cin.fail()) {
            std::cout << "Error: Invalid input data" << std::endl;
            return -1;
        }
    } while (1 >= size);

    int** matrix = createMatrix(size);
    if (NULL != matrix) {
        if (isMagic(matrix, size)) {
            std::cout << "Matrix is magic" << std::endl;
        } else {
            std::cout << "Matrix is not magic" << std::endl;
        }

        deleteMatrix(matrix, size);
    } else {
        std::cout << "Error: NULL for int** matrix was genereated" << std::endl;
    }
    return 0;
}
