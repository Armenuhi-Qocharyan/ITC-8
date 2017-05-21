#include "vector.hpp"
#include <cmath>
#include <iostream>

//Constructors
Vect::Vector::Vector()
    : mArray(nullptr)
    , mLength(0)
{}

Vect::Vector::Vector(const Vector& other) {
    std::cout << other.mLength << "  ";
    int size = ceil(other.mLength * 0.1) * 10;
    std::cout << size << std::endl;

    mArray = new int[size];
    for (int i = 0; i < mLength; ++i) {
        mArray[i] = other.mArray[i];
    }
}

//Destructor
Vect::Vector::~Vector() {
    delete[] mArray;
    mArray = nullptr;
}

//Methods
bool Vect::Vector::isEmpty() const {
    return (0 == mLength);
}

int Vect::Vector::getLength() const {
    return mLength;
}

bool Vect::Vector::find(const int index, int& item) const {
    if (index >= mLength || 0 > index) {
        return false;
    }

    item = mArray[index];
    return true;
}

void Vect::Vector::insert(int index, const int item) {
    if (isEmpty() || 0 == (mLength % 10)) {
        int* tmp = new int[mLength + 10];
        for (int i = 0; i < mLength; ++i) {
            tmp[i] = mArray[i];
        }
        mArray = tmp;
    }
    
    if (index > mLength - 1) {
        index = mLength;
    }
    if (index < 0) {
        index = 0;
    }

    for (int i = mLength; i > index; --i) {
        mArray[i] = mArray[i - 1];
    }

    mArray[index] = item;
    ++mLength;
}

bool Vect::Vector::remove(const int index) {
    if (isEmpty()) {
        return false;
    }
        
    if (index >= mLength) {    
        mArray[mLength -  1] = 0;
    } else {
        for (int i = index; i < mLength; ++i) {
            mArray[i] = mArray[i + 1];
        }
    }

    --mLength;
    return true;
}

void Vect::Vector::printVector() const {
    std::cout << __FUNCTION__ << std::endl;
    for (int i = 0; i < mLength; ++i) {
        std::cout << mArray[i] << "  ";
    }
    std::cout << std::endl;
}
