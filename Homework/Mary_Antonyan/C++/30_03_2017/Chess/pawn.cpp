#include "pawn.hpp"
#include "board.hpp"
#include <iostream>

//Constructor
Chess::Pawn::Pawn(const Chess::Figure::Chessman figure, 
                    const Chess::Figure::Color color, 
                    const int row, const int coloumn) 
    : Figure(figure, color, row, coloumn)
{}

//Destructor
Chess::Pawn::~Pawn() {}

//Method override
void Chess::Pawn::step(const int row, const int coloumn) {
    if (0 <= row && 8 > row && 0 <= coloumn && 8 > row) { 
        if ((((mColor == Chess::Figure::Color::white && mRow == 1) || 
           (mColor == Chess::Figure::Color::black && mRow == 6)) && row == mRow + 2) || 
           (row == mRow + 1 && coloumn == mColoumn && 
            Chess::board[row][coloumn] == nullptr) || 
            (((coloumn == mColoumn + 1 || coloumn == mColoumn -1) && 
             Chess::board[row][coloumn]->getColor() != mColor && 
             Chess::board[row][coloumn] != nullptr))) {
            std::cout << "Move to [" << row << " , " << coloumn << "]\n";
            int tmpRow = mRow;
            int tmpCol = mColoumn;
            Chess::board[row][coloumn] = new Pawn(mFigure, mColor, row, coloumn);
            Chess::board[tmpRow][tmpCol] = nullptr;
        } else {
            std::cout << "Can't move to [" << row << " , " << coloumn << "]\n";
        }
    } else {
        std::cout << "Out of board" << std::endl;
    }
}
