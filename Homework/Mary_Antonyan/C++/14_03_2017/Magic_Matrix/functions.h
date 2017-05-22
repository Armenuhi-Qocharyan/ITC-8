#ifndef FUNCTIONS_H
#define FUNCTIONS_H 1

//Matrix manager functions
int** createMatrix(const int& size);
void printMatrix(int** matrix, const int& size);
void deleteMatrix(int** matrix, const int& size);

//GetSum-functions
int getRowSum(int** matrix, const int& size, const int& row);
int getColoumnSum(int** matrix, const int& size, const int& coloumn);
int getDiagonalSum(int** matrix, const int& size, const int& diagonal);

//Check-function
bool isUnique(int** matrix, const int& size);

//isMagic-functions
bool isMagicByRow(int** matrix, const int& size);
bool isMagicByColoumn(int** matrix, const int& size);
bool isMagicByColoumn(int** matrix, const int& size);
bool isMagic(int** matrix, const int& size);

#endif
