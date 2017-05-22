#include "board.hpp"
#include "figure.hpp"
#include "king.hpp"
#include "queen.hpp"
#include "knight.hpp"
#include "rook.hpp"
#include "bishop.hpp"
#include "pawn.hpp"
#include <iostream>

void Chess::initBoard() {
    Chess::board = new Chess::Figure**[8];
    for (int i = 0; i < 8; ++i) {
        Chess::board[i] = new Chess::Figure*[8];
    }

    for (int j = 0; j < 8; ++j) {
        Chess::board[1][j] = new Chess::Pawn(Chess::Figure::Chessman::pawn, Chess::Figure::Color::black, 1, j);
        Chess::board[6][j] = new Chess::Pawn(Chess::Figure::Chessman::pawn, Chess::Figure::Color::white, 6, j);
    }

    Chess::Figure::Color color = Chess::Figure::Color::black;
    for (int i = 0; i < 8; ++i) {
        for (int j = 0; j < 8; ++j) {
            if (0 == i || 7 == i) {
                switch (j) {
                    case 0 : case 7 : { 
                                          Chess::board[i][j] = new Chess::Rook(Chess::Figure::Chessman::rook, color, i, j);
                                          break;
                                      } 
                    case 1 : case 6 : { 
                                          Chess::board[i][j] = new Chess::Knight(Chess::Figure::Chessman::knight, color, i, j);
                                          break;
                                      }
                    case 2 : case 5 : { 
                                          Chess::board[i][j] = new Chess::Bishop(Chess::Figure::Chessman::bishop, color, i, j);
                                          break;
                                      }

                    case 3 : { 
                                 Chess::board[i][j] = new Chess::Queen(Chess::Figure::Chessman::queen, color, i, j);
                                 break;
                             }
                    case 4 : { 
                                 Chess::board[i][j] = new Chess::King(Chess::Figure::Chessman::king, color, i, j);
                                 break;
                             }
                }
            } else if (1 != i && 6 != i) {
                Chess::board[i][j] = nullptr;
            }
        }
        color = Chess::Figure::Color::white;
    }
}

void Chess::printBoard() {
    for (int i = 0; i < 8; ++i) {
        for (int j = 0; j < 8; ++j) {
            std::cout << "+----";
        }
        std::cout << "+" << std::endl << "|";

        for (int j = 0; j < 8; ++j) {
            if (nullptr == Chess::board[i][j]) {
                std::cout << "    |";
            } else {
                switch (Chess::board[i][j]->getFigure()) {
                    case Chess::Figure::Chessman::king : {
                                                             if (Chess::board[i][j]->getColor() == Chess::Figure::Color::white) {
                                                                 std::cout << " WK |";
                                                             } else if (Chess::board[i][j]->getColor() == Chess::Figure::Color::black) {
                                                                 std::cout << " BK |";
                                                             }
                                                             break;
                                                         }
                    case Chess::Figure::Chessman::queen : {
                                                              if (Chess::board[i][j]->getColor() == Chess::Figure::Color::white) {
                                                                  std::cout << " WQ |";
                                                              } else if (Chess::board[i][j]->getColor() == Chess::Figure::Color::black) {
                                                                  std::cout << " BQ |";
                                                              }
                                                              break;
                                                          }
                    case Chess::Figure::Chessman::knight : {
                                                               if (Chess::board[i][j]->getColor() == Chess::Figure::Color::white) {
                                                                   std::cout << " Wk |";
                                                               } else if (Chess::board[i][j]->getColor() == Chess::Figure::Color::black) {
                                                                   std::cout << " Bk |";
                                                               }
                                                               break;
                                                           }
                    case Chess::Figure::Chessman::rook : {
                                                             if (Chess::board[i][j]->getColor() == Chess::Figure::Color::white) {
                                                                 std::cout << " WR |";
                                                             } else if (Chess::board[i][j]->getColor() == Chess::Figure::Color::black) {
                                                                 std::cout << " BR |";
                                                             }
                                                             break;
                                                         }
                    case Chess::Figure::Chessman::bishop : {
                                                               if (Chess::board[i][j]->getColor() == Chess::Figure::Color::white) {
                                                                   std::cout << " WB |";
                                                               } else if (Chess::board[i][j]->getColor() == Chess::Figure::Color::black) {
                                                                   std::cout << " BB |";
                                                               }
                                                               break;
                                                           }
                    case Chess::Figure::Chessman::pawn : {
                                                             if (Chess::board[i][j]->getColor() == Chess::Figure::Color::white) {
                                                                 std::cout << " WP |";
                                                             } else if (Chess::board[i][j]->getColor() == Chess::Figure::Color::black) {
                                                                 std::cout << " BP |";
                                                             }
                                                             break;
                                                         }
                }
            }
        }
        std::cout << std::endl;
    }

    for (int j = 0; j < 8; ++j) {
        std::cout << "+----"; 
    }
    std::cout << "+" << std::endl;
}

void Chess::execute(const int fromRow, const int fromCol, 
        const int toRow, const int toCol) {
    if (nullptr != Chess::board[fromRow][fromCol]) {
        Chess::board[fromRow][fromCol]->step(toRow, toCol);
        Chess::printBoard();
    } else {
        std::cout << "Node is empty" << std::endl;
    }
}

