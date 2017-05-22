#include "functions.hpp"

//Init array and fill with 0s
int* initArr(int size) {
    if (0 >= size) {
        return NULL;
    }

    int* arr = new int[size];
    for (int i = 0; i < size; ++i) {
        arr[i] = 0;
    }
    return arr;
}

//Print array in a special way
void printArr(int* arr, int size) {
    if (0 >= size) {
        return;
    }

    for (int i = 0; i < size; ++i) {
        if (0 < arr[i]) {
            std::cout << i << " - " << arr[i] << " x" << std::endl;
        }
    }
}

//Get digits from each number
void getDigits(int num, int* arr) {
    if (0 > num) {
        return;
    } 

    int digit;
    do {
        digit = num % 10;
        num /= 10;
        ++arr[digit];
    } while (0 < num);
}

//Get digits for numbers from 0 to num
int* getResult(int num, int size) {
    if (0 > num) {
        return NULL;
    }

    int* arr = initArr(size);
    if (NULL == arr) {
        return NULL;
    }

    for (int i = 0; i <= num; ++i) {
        getDigits(i, arr);
    }

    return arr;
}
