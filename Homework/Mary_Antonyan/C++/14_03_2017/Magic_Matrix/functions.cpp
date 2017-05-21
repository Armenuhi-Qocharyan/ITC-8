#include <iostream>
#include "functions.h"

//Matrix manager functions
int** createMatrix(const int& size) {
    int** matrix = new int*[size];
    for (int i = 0; i < size; ++i) {
        matrix[i] = new int[size];
    }

    for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
            int elem;
            do {
                std::cout << "(0 < elem < 100) arr[" << i << "][" << j << "]= ";
                std::cin >> elem;
                if (std::cin.fail()) {
                    std::cout << "Error: Invalid input data" << std::endl;
                    return NULL;
                }
            } while (0 >= elem || 100 <= elem);
            matrix[i][j] = elem;
        }
    }
    return matrix;
}

void printMatrix(int** matrix, const int& size) {
    for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
            std::cout << matrix[i][j] << "\t";
        }
        std::cout << std::endl;
    }
}

void deleteMatrix(int** matrix, const int& size) {
    for (int i = 0; i < size; ++i) {
        delete[] matrix[i];
    }
    delete[] matrix;
}

//GetSum-functions
int getRowSum(int** matrix, const int& size, const int& row) {
    int sum = 0;
    for (int j = 0; j < size; ++j) {
        sum += matrix[row][j];
    }
    return sum;
}

int getColoumnSum(int** matrix, const int& size, const int& coloumn) {
    int sum = 0;
    for (int i = 0; i < size; ++i) {
        sum += matrix[i][coloumn];
    }
    return sum;
}

int getDiagonalSum(int** matrix, const int& size, const int& diagonal) {
    int sum = 0; 
    if (1 == diagonal) {
        for (int i = 0; i < size; ++i) {
            sum += matrix[i][i];
        }
    } else {
        for (int i = 0; i < size; ++i) {
            sum += matrix[i][size - 1 - i];
        }
    }
    return sum;
}

//Check-function
bool isUnique(int** matrix, const int& size) {
    for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
            for (int k = i; k < size; ++k) {
                for (int l = j + 1; l < size; ++l) {
                    if (matrix[i][j] == matrix[k][l]) {
                        return false;
                    }
                }
            }
        }
    }
    return true;    
} 

//isMagic-functions
bool isMagicByRow(int** matrix, const int& size) {
    int sum = getRowSum(matrix, size, 0);
    for (int i = 1; i < size; ++i) {
        if (getRowSum(matrix, size, i) != sum) {
            return false;
        }
    }
    return true;
}

bool isMagicByColoumn(int** matrix, const int& size) {
    int sum = getColoumnSum(matrix, size, 0);
    for (int i = 1; i < size; ++i) {
        if (getColoumnSum(matrix, size, i) != sum) {
            return false;
        }
    }
    return true;
}

bool isMagicByDiagonal(int** matrix, const int& size) {
    return (getDiagonalSum(matrix, size, 1) == getDiagonalSum(matrix, size, 2));
}

bool isMagic(int** matrix, const int& size) {
    return (isUnique(matrix, size) && isMagicByRow(matrix, size) && 
            isMagicByColoumn(matrix, size) && isMagicByDiagonal(matrix, size)); 
}

