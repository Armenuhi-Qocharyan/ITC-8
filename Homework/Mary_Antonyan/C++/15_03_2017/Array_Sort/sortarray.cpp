#include <iostream>
#include <cstdlib>
#include <ctime>
#include "sortarray.h"

//Array managment-functions
int* createArr(const int& size) {
    int* arr = new int[size];
    srand(time(0));
    for (int i = 0; i < size; ++i) {
        arr[i] = rand() % 100;
    }
    return arr;
}

void printArr(int* arr, const int& size) {
    for (int i = 0; i < size; ++i) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
}

//Sort-functions
void sortAscending(int* arr, const int& size) {
    for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
            if (arr[i] < arr[j]) {
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];
            }
        }
    }
}

void sortDescending(int* arr, const int& size) {
    for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
            if (arr[i] > arr[j]) {
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];
            }
        }
    }
}

void sort(int* arr, const int& size, void function(int*, const int&)) {
    function(arr, size);
}

