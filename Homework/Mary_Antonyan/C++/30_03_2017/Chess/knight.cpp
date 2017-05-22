#include "knight.hpp"
#include "board.hpp"
#include <iostream>

//Constructor
Chess::Knight::Knight(const Chess::Figure::Chessman figure, 
                        const Chess::Figure::Color color,
                        const int row, const int coloumn) 
    : Figure(figure, color, row, coloumn)
{}

//Destructor
Chess::Knight::~Knight() {}

//Method override
void Chess::Knight::step(const int row, const int coloumn) {
    if (0 <= row && 8 > row && 0 <= coloumn && 8 > coloumn) {
        if ((((row == mRow - 2 || row == mRow + 2) && 
            (coloumn == mColoumn - 1 || coloumn == mColoumn + 1)) ||
            ((row == mRow - 1 || row == mRow + 1) && 
            (coloumn == mColoumn - 2 || coloumn == mColoumn + 2))) &&
            (Chess::board[row][coloumn] == nullptr ||
             Chess::board[row][coloumn]->getColor()!= mColor)) {
            std::cout << "Move to [" << row << " , " << coloumn << "]\n";
            int tmpRow = mRow;
            int tmpCol = mColoumn;
            Chess::board[row][coloumn] = new Knight(mFigure, mColor, row, coloumn);
            Chess::board[tmpRow][tmpCol] = nullptr;
        } else {
            std::cout << "Can't move to [" << row << " , " << coloumn << "]\n";
        }
    } else {
        std::cout << "Out of board" << std::endl;
    }
}
