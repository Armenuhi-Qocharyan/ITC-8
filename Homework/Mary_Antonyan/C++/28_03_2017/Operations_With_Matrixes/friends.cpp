#include "friends.hpp"
#include <iostream>
#include <sstream>
#include <cstddef>
#include <limits>

std::ostream& Matrixes::operator<<(std::ostream& stream, const Matrixes::Matrix& obj) {
    for (int i = 0; i < obj.rows; ++i) {
        for (int j = 0; j < obj.coloumns; ++j) {
            stream << obj.matrix[i][j] << "  ";
        }
        stream << "\n";
    }
    return stream;
}

std::istream& Matrixes::operator>>(std::istream& stream, Matrixes::Matrix& obj) {
    bool valid = true;
    do {
        valid = true;
        std::cout << "Enter number of rows for matrix: ";
        stream >> obj.rows;
        if (std::cin.fail()) {
            valid = false;
            std::cin.clear();
            std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
        }
    } while (obj.rows < 1 || !valid);

    do {
        valid = true;
        std::cout << "Enter number of coloumns for matrix: ";
        stream >> obj.coloumns;
        if (std::cin.fail()) {
            valid = false;
            std::cin.clear();
            std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
        }
    } while (obj.coloumns < 1 || !valid);

    if (nullptr == obj.matrix) {
        obj.matrix = new int*[obj.rows];
        for (int i = 0; i < obj.rows; ++i) {
            obj.matrix[i] = new int[obj.coloumns];
        }
    }

    for (int i = 0; i < obj.rows; ++i) {
        for (int j = 0; j < obj.coloumns; ++j) {
            do {
                valid = true;
                std::cout << "matrix[" << i << "][" << j << "]= ";
                stream >> obj.matrix[i][j];
                if (std::cin.fail()) {
                    valid = false;
                    std::cin.clear();
                    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
                }
            } while (!valid);
        }
    }
    return stream;  
}
