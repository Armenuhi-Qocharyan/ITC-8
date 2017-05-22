#include "bishop.hpp"
#include "board.hpp"
#include <cmath>
#include <iostream>

//Constructor
Chess::Bishop::Bishop(const Chess::Figure::Chessman figure, 
                        const Chess::Figure::Color color, 
                        const int row, const int coloumn) 
    : Figure(figure, color, row, coloumn) 
{}

//Destuctor
Chess::Bishop::~Bishop() {}

//Method override
void Chess::Bishop::step(const int row, const int coloumn) {
    if (0 <= row && 8 > row && 0 <= coloumn && 8 > row) { 
        if (abs(row - coloumn) == abs(mRow - mColoumn) && 
            (Chess::board[row][coloumn] == nullptr || 
             Chess::board[row][coloumn]->getColor() != mColor)) {
            std::cout << "Move to [" << row << " , " << coloumn << "]\n";
            int tmpRow = mRow;
            int tmpCol = mColoumn;
            Chess::board[row][coloumn] = new Bishop(mFigure, mColor, row, coloumn);
            Chess::board[tmpRow][tmpCol] = nullptr;
        } else {
            std::cout << "Can't move to [" << row << " , " << coloumn << "]\n";
        }
    } else {
        std::cout << "Out of board" << std::endl;
    }
}
