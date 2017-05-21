#ifndef MATRIX_HPP
#define MATRIX_HPP

#include <iostream>

namespace Matrixes {
    class Matrix {
        public:
            //Constructors
            Matrix();                       //Default Constructor
            Matrix(const int, const int);   //Parametric Constructor
            Matrix(const Matrix&);          //Copy Constructor
            Matrix(Matrix&&);               //Move Constructor


            //Operator overloading
            Matrix& operator=(const Matrix&);
            Matrix& operator=(Matrix&&);                //move assignment
            Matrix operator-(const Matrix&) const;
            Matrix operator+(const Matrix&) const;
            Matrix operator*(const Matrix&) const;      //Multiply matrixes
            Matrix operator*(const int k) const;        //Multiply by number
            int* const operator[](const int i) const; 

            //Methods
            int getRows() const;
            int getColoumns() const;

            //Destructor
            ~Matrix();

        private:
            int rows;
            int coloumns;
            int** matrix;

            friend std::ostream& operator<<(std::ostream&, const Matrix&);
            friend std::istream& operator>>(std::istream&, Matrix&);
    };
}

#endif
