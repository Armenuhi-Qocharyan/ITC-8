#ifndef FUNCTIONS_HPP
#define FUNCTIONS_HPP

#include <iostream>

//Init array and fill with 0s
int* initArr(int size);

//Print array with specific way
void printArr(int* arr, int size);

//Get digits from each number
void getDigits(int num, int* arr);

//Get digits for numbers from 0 to num
int* getResult(int num, int size);

#endif
