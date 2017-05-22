#include "vector.hpp"
#include <iostream> 
#include <cmath>
#include <ctime>

void initVector(const int length, Vect::Vector& vector);

int main() {
    unsigned int length = 15;
    Vect::Vector vector;

    initVector(length, vector);
    std::cout << "\n-----VECTOR-----\n";
    vector.printVector();

    return 0;
}

void initVector(const int length, Vect::Vector& vector) {
    srand(time(0));
    int item = 0;
    int index = 0;
    for (int i = 0; i < length; ++i) {
        item = 10 - rand() % 20;
        index = rand() % length;
        std::cout << "Index: " << index << "\tItem: " << item << std::endl; 
        vector.insert(index, item);
    }
}
