#include "execute.hpp"
#include "matrix.hpp"
#include "friends.hpp"
#include <iostream>

void Matrixes::execute(Matrixes::Matrix& matrix1, Matrixes::Matrix& matrix2) {
    char oper = '+';
    do {
        std::cout << "Press Q to quit" << std::endl;
        std::cout << "Enter operation: ";
        std::cin >> oper;
        std::cin.ignore(10000000, '\n');

        switch (oper) {
            case '+' : {   
                           if (matrix1.getRows() == matrix2.getRows() && matrix1.getColoumns() == matrix2.getColoumns()) {
                               Matrixes::Matrix sum = matrix1 + matrix2;
                               std::cout << "\n-----SUM-----\n\n" << sum;
                           } else {
                               std::cout << "Unequal sizes" << std::endl;
                           }
                           break;
                       }
            case '-' : {
                           if (matrix1.getRows() == matrix2.getRows() && matrix1.getColoumns() == matrix2.getColoumns()) { 
                               Matrixes::Matrix diff = matrix1 - matrix2;
                               std::cout << "\n-----DIFF-----\n\n" << diff;
                           } else {
                               std::cout << "Unequal sizes" << std::endl;
                           }
                           break;
                       }
            case '*' : {
                           if (matrix1.getRows() == matrix2.getColoumns()) {
                               Matrixes::Matrix prod = matrix1 * matrix2;
                               std::cout << "\n-----PRODUCT-----\n\n" << prod;
                           } else {
                               std::cout << "Unequal sizes" << std::endl;
                           }
                           break;
                       }
            case '=' : {
                           matrix1 = matrix2;
                           std::cout << "\n-----ASSIGNMENT-----\n\n" << matrix1;
                           break;
                       }
            case 'Q' : case 'q' : {
                                      return;    
                                  }
            default : {
                          std::cout << "Invalid operation" << std::endl;
                      }
            std::cout << std::endl;
        }
    } while (true);
}
