#ifndef HASHTABLE_HPP
#define HASHTABLE_HPP

#include "vector.hpp"
#include <string>

namespace Hash {
    class HashTable {
        public:
            //Methods
            void insert(const int key, const int value);
            bool remove(const int key);
            bool containsKey(const int key) const;
            bool containsValue(const int value) const;
            int getNumberOfItems() const;
            void print() const;

            //Constructors
            HashTable();
            HashTable(const HashTable& other);

            //Destructor
            ~HashTable();

        private:
            //Fields
            int mNumber;
            int mLength;
            Vector mVector;

            //Method
            int getHash(const int key) const;
            int getHash(const std::string& key) const;
    };
} 

#endif
