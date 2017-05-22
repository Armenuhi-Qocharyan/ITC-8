#ifndef VECTOR_HPP
#define VECTOR_HPP

namespace Vect {
    class Vector {
        public: 
            //Constructors
            Vector();
            Vector(const Vector& other);
            
            //Destructor
            ~Vector();

            //Methods
            bool isEmpty() const;
            int getLength() const;
            bool find(const int index, int& item) const;
            void insert(int index, const int item);
            bool remove(const int index);
            void printVector() const;

        private:
            //Fields
            int* mArray;
            int mLength;
    };
}

#endif
