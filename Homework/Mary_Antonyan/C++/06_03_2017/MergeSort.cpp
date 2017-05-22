#include  <iostream>
#include <cstdlib>
#include <ctime>

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

int inline min(const int& a, const int& b) {
    return a < b ? a : b;
}

void mergeHelper(int* arr, int left, int right, int* temp) {
    if (right == left + 1) {
        return;
    } else {
        int length = right - left;
        int mid = length / 2;
        int leftPos = left;
        int rightPos = left + mid;

        mergeHelper(arr, left, left + mid, temp);
        mergeHelper(arr, left + mid, right, temp);

        for (int i = 0; i < length; ++i) {
            if (leftPos < left + mid && (rightPos == right || min(arr[leftPos], arr[rightPos]) == arr[leftPos])) {
                temp[i] = arr[leftPos];
                ++leftPos;
            } else {
                temp[i] = arr[rightPos];
                ++rightPos;
            }
        }

        for (int i = left; i < right; ++i) {
            arr[i] = temp[i - left];
        }
    }
}

bool mergeSort(int* arr, const int& size) {
    int* temp = new int[size];

    if (NULL != temp) {
        mergeHelper(arr, 0, size, temp);
        delete[] temp;
        return true;
    } else {
        return false;
    }
}

int main() {
    int size = 20;
    int* arr = createArray(size);
    printArray(arr, size);

    if(mergeSort(arr, size)) {
        std::cout << std::endl;
        printArray(arr, size);
    } else {
        std::cout << "Error: Invalid operation" << std::endl;
    }
    
    return 0;
}
