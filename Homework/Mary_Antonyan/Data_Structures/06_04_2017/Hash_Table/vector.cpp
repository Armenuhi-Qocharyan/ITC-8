#include "vector.hpp"
#include <cmath>
#include <iostream>

namespace Hash {
    //Constructors
    Vector::Vector()
        : mArray(nullptr)
        , mLength(10)
    {
        mArray = new LinkedList[mLength];
    }

    Vector::Vector(const Vector& other) 
        : mArray(nullptr)
        , mLength(10) {
        
        mLength = other.mLength;
        mArray = new LinkedList[other.mLength];
        for (int i = 0; i < mLength; ++i) {
            mArray[i] = other.mArray[i];
        }
    }

    //Destructor
    Vector::~Vector() {
        delete[] mArray;
        mArray = nullptr;
    }

    //Methods
    bool Vector::isEmpty() const {
        return (0 == mLength);
    }

    int Vector::getLength() const {
        return mLength;
    }

    bool Vector::searchByKey(const int index, const int key) const {
        if (index >= mLength || 0 > index) {
            return false;
        }

        if (mArray[index].searchByKey(key)) {
            return true;
        }
        return false;
    }

    bool Vector::searchByValue(const int index, const int value) const {
        if (index >= mLength || 0 > index) {
            return false;
        }

        if (mArray[index].searchByValue(value)) {
            return true;
        }
        return false;
    }  

    void Vector::insert(int index, const int key, const int value) {
        if (index > mLength - 1) {
            index = mLength;
        }

        if (index < 0) {
            index = 0;
        }

        ++mLength;
        mArray[index].insert(0, key, value);
    }

    bool Vector::remove(const int index) {
        if (isEmpty()) {
            return false;
        }
        mArray[index].remove(0);
        --mLength;
        return true;
    }

    void Vector::print() const {
        for (int i = 0; i < mLength; ++i) {
            mArray[i].print();
        }
    }
    
    LinkedList Vector::operator[](const int index) const {
        return mArray[index];
    }  
} 
