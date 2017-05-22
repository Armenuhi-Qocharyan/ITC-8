#include <iostream>
#include <ctime>
#include <cstdlib>

int* createArray(const int& size) {
    int* arr = new int[size];
    srand(time(0));
    for (int i = 0; i < size; ++i) {
        arr[i] = rand() % 100;
    }
    return arr;
}
    
void printArray(const int* arr, const int& size) {
    for (int i = 0; i < size; ++i) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
}

void swap(int& a, int& b) {
    a = a + b;
    b = a - b;
    a = a - b;
}

void bubbleSort(int* arr, const int& size) {
    for (int i = 0; i < size; ++i) {
        for (int j = i + 1; j < size; ++j) {
            if (arr[i] > arr[j]) {
                swap(arr[i], arr[j]);
            }
        }
    }
}

int main() {
    int size = 20;
    int* arr = createArray(size);
    printArray(arr, size);

    bubbleSort(arr, size);
    printArray(arr, size);
    return 0;
}
