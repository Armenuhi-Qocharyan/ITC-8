#include "execute.hpp"
#include <iostream>

int main() {
    Matrixes::Matrix matrix1;
    std::cin >> matrix1;

    if (std::cin.fail()) {
        return 0;
    }

    std::cout << std::endl;
    Matrixes::Matrix matrix2;
    std::cin >> matrix2;

    std::cout << "\n-----MATRIX 1-----\n\n";
    std::cout << matrix1;

    std::cout << "\n-----MATRIX 2-----\n\n";
    std::cout << matrix2;

    //std::cout << std::endl << matrix1[1][1] << std::endl; //-It works!!!

    Matrixes::execute(matrix1, matrix2);
    return 0;
}

