#include <iostream>

int board[10][10] = {
                    {1, 1, 0, 0, 0, 1, 0, 0, 0, 0}, 
                    {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                    {0, 1, 0, 0, 0, 0, 0, 1, 1, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, 
                    {1, 1, 0, 0, 0, 0, 0, 1, 1, 0}, 
                    {0, 1, 1, 0, 0, 0, 0, 0, 0, 0}, 
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                    {0, 0, 1, 1, 0, 0, 0, 0, 0, 0}, 
                    {0, 0, 1, 1, 0, 0, 0, 0, 0, 0}, 
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}; 

bool isShip(int i, int j, int iMin, int iMax, int jMin, 
            int jMax, int countOfOnes) {

    ++countOfOnes;
    if (0 == iMin && 0 == iMax && 0 == jMin && 0 == jMax) {
        iMin = i;
        iMax = i;
        jMin = j;
        jMax = j;
    } 

    board[i][j] = 0;
    if (10 > j + 1 && 1 == board[i][j + 1]) {
        if (j + 1 > jMax) {
            jMax = j + 1;
        }
        return isShip(i, j + 1, iMin, iMax, jMin, jMax, countOfOnes);
    }

    if (10 > i + 1 && 1 == board[i + 1][j]) {
        if (i + 1 > iMax) {
            iMax = i + 1;
        }
        return isShip(i + 1, j, iMin, iMax, jMin, jMax, countOfOnes);
    }

    if (0 <= j - 1 && 1 == board[i][j - 1]) {
        if (j - 1 < jMin) {
            jMin = j - 1;
        }
        return isShip(i, j - 1, iMin, iMax, jMin, jMax, countOfOnes);
    }

    if (0 <= i - 1 && 1 == board[i - 1][j]) {
        if (i - 1 > iMin) {
            iMin = i - 1;
        }
        return isShip(i - 1, j, iMin, iMax, jMin, jMax, countOfOnes);
    }
    return ((iMax - iMin + 1) * (jMax - jMin + 1) == countOfOnes);
}

void print() {
    std::cout << std::endl;
    for (int i = 0; i < 10; ++i) {
        for (int j = 0; j < 10; ++j) {
            std::cout << board[i][j] << " ";
        }
        std::cout << std::endl;
    }
    std::cout << std::endl;
}

int main() {
    int countOfShips = 0;
    int countOfOnes = 0;
    int iMin = 0;
    int iMax = 0;
    int jMin = 0;
    int jMax = 0;

    print();

    for (int i = 0; i < 10; ++i) {
        for (int j = 0; j < 10; ++j) {
            if (1 == board[i][j]) {
                if (isShip(i, j, iMin, iMax, jMin, jMax, countOfOnes)) {
                    ++countOfShips;
                }
            }
        }
    }

    std::cout << "Count of ships: " << countOfShips << std::endl;
    return 0;
}
