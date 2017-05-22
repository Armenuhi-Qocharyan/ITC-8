#ifndef VECTOR_HPP
#define VECTOR_HPP

#include "linkedlist.hpp"

namespace Hash {
    class Vector {
        public: 
            //Methods
            bool isEmpty() const;
            int getLength() const;
            bool searchByKey(const int index, const int key) const;
            bool searchByValue(const int index, const int value) const;
            void insert(int index, const int key, const int value);
            bool remove(const int index);
            void print() const;

            //Operator
            LinkedList operator[](const int index) const;

            //Constructors
            Vector();
            Vector(const Vector& other);
            
            //Destructor
            ~Vector();

        private:
            //Fields
            LinkedList* mArray;
            int mLength;
    };
}

#endif
