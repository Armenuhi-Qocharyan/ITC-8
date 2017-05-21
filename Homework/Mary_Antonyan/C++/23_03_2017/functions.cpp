#include "functions.hpp"

int** setData(int numberOfPairs) {
    int** list = new int*[numberOfPairs];
    for (int i = 0; i < numberOfPairs; ++i) {
        list[i] = new int[2];
    }

    std::cout << "Enter pairs: \n";
    for (int i = 0; i < numberOfPairs; ++i) {
        for (int j = 0; j < 2; ++j) {
            do {
                std::cout << "Pair " << i + 1<<  " . " << j + 1 << ": ";
                std::cin >> list[i][j];
                std::cin.clear();
                std::cin.ignore(5, '\n');
            } while (std::cin.fail() || 0 > list[i][j]);
        }
    }
    return list;
}

int getNumber(int** list, int numberOfPairs, int elem) {
    int count = 0;
    for (int i = 0; i < numberOfPairs; ++i) {
        for (int j = 0; j < numberOfPairs; ++j) {
            if (list[i][j] == elem) {
                ++count;
            }
        }
    }
    return count;
}

bool isGroup(int** list, int numberOfPairs) {
    if (2 >= numberOfPairs) {
        return false;
    }

    for (int i = 0; i < numberOfPairs; ++i) {
        if (list[i][0] == list[i][1]) {
            return false;
        }
    }

    int num1;
    int num2;
    for (int i = 0; i < numberOfPairs; ++i) {
        num1 = getNumber(list, numberOfPairs, list[i][0]);
        num2 = getNumber(list, numberOfPairs, list[i][1]);
        if (1 >= num1 || 1 >= num2 || num1 != num2) {
            return false;
        }
    }
    return true;
}

void print(int** list, int numberOfPairs) {
    std::cout << std::endl;
    for (int i = 0; i < numberOfPairs; ++i) {
        for (int j = 0;  j < 2; ++j) {
            std::cout << list[i][j] << "  ";
        }
        std::cout << std::endl;
    }
    std::cout << std::endl;
}
