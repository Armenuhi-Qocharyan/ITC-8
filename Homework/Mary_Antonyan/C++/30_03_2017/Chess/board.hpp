#ifndef BOARD_HPP
#define BOARD_HPP

#include "figure.hpp"

namespace Chess {
    static Chess::Figure*** board;
    void initBoard();
    void printBoard();
    void execute(const int fromRow, const int fromCol, 
                    const int toRow, const int toCol);
}

#endif
