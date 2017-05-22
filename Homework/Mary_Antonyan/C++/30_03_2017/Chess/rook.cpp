#include "rook.hpp"
#include "board.hpp"
#include <iostream>

//Constructor
Chess::Rook::Rook(const Chess::Figure::Chessman figure, 
                    const Chess::Figure::Color color, 
                    const int row, const int coloumn) 
    : Figure(figure, color, row, coloumn)
{}

//Destructor
Chess::Rook::~Rook() {}

//Method override
void Chess::Rook::step(const int row, const int coloumn) {
    if (0 <= row && 8 > row && 0 <= coloumn && 8 > row) {
        if ((row == mRow || coloumn == mColoumn) &&
            (Chess::board[row][coloumn] == nullptr ||
             Chess::board[row][coloumn]->getColor() != mColor)) {
            std::cout << "Move to [" << row << " , " << coloumn << "]\n";
            int tmpRow = mRow;
            int tmpCol = mColoumn;
            Chess::board[row][coloumn]= new Rook(mFigure, mColor, row, coloumn);
            Chess::board[tmpRow][tmpCol] = nullptr;
        } else {
            std::cout << "Can't move to [" << row << " , " << coloumn << "]\n";
        }
    } else {
        std::cout << "Out of board" << std::endl;
    }
}
