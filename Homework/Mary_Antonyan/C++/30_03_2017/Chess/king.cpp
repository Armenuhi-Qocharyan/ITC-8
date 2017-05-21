#include "king.hpp"
#include "board.hpp"
#include <iostream>

//Constructor
Chess::King::King(const Chess::Figure::Chessman figure, 
                    const Chess::Figure::Color color, 
                    const int row, const int coloumn) 
    : Figure(figure, color, row, coloumn)
{}

//Destructor
Chess::King::~King() {}

//Method override
void Chess::King::step(const int row, const int coloumn) {
    if (0 <= row && 8 > row && 0 <= coloumn && 8 > coloumn) { 
        if ((row == mRow - 1 || row == mRow + 1 || row == mRow) && 
            (coloumn == mRow - 1 || coloumn == mRow + 1 || coloumn == mColoumn) &&
            (Chess::board[row][coloumn] == nullptr || 
             Chess::board[row][coloumn]->getColor() != mColor)) {
            std::cout << "Move to [" << row << " , " << coloumn << "]\n";
            int tmpRow = mRow;
            int tmpCol = mColoumn;
            Chess::board[row][coloumn] = new King(mFigure, mColor, row, coloumn);
            Chess::board[tmpRow][tmpCol] = nullptr;
        } else {
            std::cout << "Can't move to [" << row << " , " << coloumn << "]\n";
        }
    } else {
        std::cout << "Out of board" << std::endl;
    }
}
