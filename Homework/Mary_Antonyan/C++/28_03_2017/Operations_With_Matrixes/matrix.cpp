#include "matrix.hpp"
#include <iostream>

//Constructors
//Default constructor
Matrixes::Matrix::Matrix() 
    : rows(0)
    , coloumns(0)
    , matrix(nullptr) 
{}

//Parametric constructor
Matrixes::Matrix::Matrix(const int rows, const int coloumns) 
    : rows(rows)
    , coloumns(coloumns) {

    this->matrix = new int*[rows];
    for (int i = 0; i < this->rows; ++i) {
        this->matrix[i] = new int[this->coloumns];
    }
}

//Copy constructor
Matrixes::Matrix::Matrix(const Matrixes::Matrix& other) 
    : rows(other.rows)
    , coloumns(other.coloumns) {
    this->matrix = new int*[rows];
    for (int i = 0; i < this->rows; ++i) {
        this->matrix[i] = new int[this->coloumns];
    }

    for (int i = 0; i < this->rows; ++i) {
        for (int j = 0; j < this->coloumns; ++j) {
            this->matrix[i][j] = other[i][j];
        }
    }
} 

//Move constructor
Matrixes::Matrix::Matrix(Matrixes::Matrix&& other) 
    : rows(other.rows)
    , coloumns(other.coloumns) 
    , matrix(other.matrix) {

    other.matrix = nullptr;
    other.rows = 0;
    other.coloumns = 0;
}

//Operator overloading
Matrixes::Matrix& Matrixes::Matrix::operator=(const Matrixes::Matrix& other) {
    if (this != &other) {
        if (this->rows != other.rows && this->coloumns != other.coloumns) {
            this->rows = other.rows;
            this->coloumns = other.coloumns;
            this->matrix = new int*[this->rows];
            for (int i = 0; i < this->rows; ++i) {
                matrix[i] = new int[this->coloumns];
            }
        }

        for (int i = 0; i < this->rows; ++i) {
            for (int j = 0; j < this->coloumns; ++j) {
                this->matrix[i][j] = other.matrix[i][j];
            }
        }
    }
    return *this;
}

//Move assignment
Matrixes::Matrix& Matrixes::Matrix::operator=(Matrixes::Matrix&& other) {
    if (this != &other) {
        this->rows = other.rows;
        this->coloumns = other.coloumns;
        this->matrix = other.matrix;

        other.rows = 0;
        other.coloumns = 0;
        other.matrix = nullptr;
    }
    return *this;
}

Matrixes::Matrix Matrixes::Matrix::operator+(const Matrixes::Matrix& other) const {
    if (this->rows != other.rows || this->coloumns != other.coloumns) {
        std::cout << "Error: operator+: Unequality of sizes\n";
        return *this;
    } 

    Matrixes::Matrix sum(rows, coloumns);
    for (int i = 0; i < this->rows; ++i) {
        for (int j = 0; j < this->coloumns; ++j) {
            sum.matrix[i][j] = this->matrix[i][j] + other.matrix[i][j];
        }
    }
    return std::move(sum);
}

Matrixes::Matrix Matrixes::Matrix::operator*(const Matrixes::Matrix& other) const {
    if (this->coloumns != other.rows) {
        std::cout << "Error: operator*: Unequality of sizes\n";
        return *this;
    }

    Matrixes::Matrix mult(this->rows, other.coloumns);
    for (int i = 0; i < this->rows; ++i) {
        for (int j = 0; j < other.coloumns; ++j) {
            mult.matrix[i][j] = 0;
            for (int k = 0; k < this->coloumns; ++k) {
                mult.matrix[i][j] += this->matrix[i][k] * other.matrix[k][j];
            }			 
        }
    }
    return std::move(mult);
}

Matrixes::Matrix Matrixes::Matrix::operator*(const int k) const {
    Matrixes::Matrix mult(this->rows, this->coloumns);

    for (int i = 0; i < this->rows; ++i) {
        for (int j = 0; j < this->coloumns; ++j) {
            mult.matrix[i][j] = k*this->matrix[i][j];
        }
    }
    return  std::move(mult);
}

Matrixes::Matrix Matrixes::Matrix::operator-(const Matrixes::Matrix& other) const {
    if (this->rows != other.rows || this->coloumns != other.coloumns) {
        std::cout << "Error: operator-: Unequality of sizes\n";
        return *this;
    }

    Matrixes::Matrix diff(rows, coloumns);
    for (int i = 0; i < this->rows; ++i) {
        for (int j = 0; j < this->coloumns; ++j) {
            diff.matrix[i][j] = this->matrix[i][j] - other.matrix[i][j];
        }
    }
    return std::move(diff);
}

int* const Matrixes::Matrix::operator[](const int i) const {
    return (0 <= i && i < rows) ? this->matrix[i] : this->matrix[0];
}

//Methods
int Matrixes::Matrix::getRows() const {
    return this->rows;
}

int Matrixes::Matrix::getColoumns() const {
    return this->coloumns;
}

//Destructor
Matrixes::Matrix::~Matrix() {
    if (nullptr != matrix) {
        for (int i = 0; i < this->rows; ++i) {
            delete [] matrix[i];
        }

        delete[] matrix;
    }
}
