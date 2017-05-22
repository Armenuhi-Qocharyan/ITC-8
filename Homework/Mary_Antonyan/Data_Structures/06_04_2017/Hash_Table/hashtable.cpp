#include "hashtable.hpp"
#include "linkedlist.hpp"
#include <string>
#include <iostream>

namespace Hash {
    //Methods
    void HashTable::insert(const int key, const int value) {
        int hash = getHash(key);
        if (!containsKey(key)) {
            mVector[hash].insert(0, key, value);
            ++mNumber;
        } else {
            std::cout << "This key already exists" << std::endl;
        }
    }

    bool HashTable::containsKey(const int key) const {
        int hash = getHash(key);
        return mVector[hash].searchByKey(key);     
    }

    bool HashTable::containsValue(const int value) const {
        int hash = getHash(value);
        return mVector[hash].searchByValue(value);     
    }

    int HashTable::getNumberOfItems() const {
        return mNumber;
    }

    void HashTable::print() const {
        mVector.print();
    }

    //Constructors
    HashTable::HashTable()
        : mVector()
        , mNumber(0)
        , mLength(10)
    {}

    HashTable::HashTable(const HashTable& other) 
        : mVector(other.mVector)
        , mNumber(0)
        , mLength(10) {
    
        mLength = other.mLength;
        for (int i = 0; i < mLength; ++i) {
            mNumber += other.mVector[i].getLength();    
        }
        mVector = other.mVector;
    }

    //Destructor
    HashTable::~HashTable() {}

    //Private method
    int  HashTable::getHash(const int key) const {
        int result = key;
        int constant = 23;
        result = (result * 17 + constant) % mLength;
        return result;
    }

    int HashTable::getHash(const std::string& key) const {
	int sum = 0;
	char symbol = key[0];
	int i = 0;
	while ('\0' != key[i]) {
	    sum += (int)symbol;
	    ++i;
	    symbol = key[i];
        }

        int result = sum;
        int constant = 23;
        result = (result * 17 + constant) % mLength;
        return result;
   }
}
