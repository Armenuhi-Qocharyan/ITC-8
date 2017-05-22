#include "board.hpp"
#include "king.hpp"
#include "queen.hpp"
#include "knight.hpp"
#include "rook.hpp"
#include "bishop.hpp"
#include "pawn.hpp"
#include <iostream>

int main() {
    Chess::initBoard();
    Chess::printBoard();

    int fromRow = 0;
    int fromCol = 0;
    int toRow = 0;
    int toCol = 0;
    char flag = 'c';

    do {
        std::cout << "Enter coordinates for figure which you want to move\n";
        std::cout << "Row: ";
        std::cin >> fromRow;
        if (std::cin.fail()) {
            std::cin.ignore(1000, '\n');
            std::cout << "Error: Inavlid input\n";
            continue;
        }

        std::cout << "Coloumn: ";
        std::cin >> fromCol;
        if (std::cin.fail()) {
            std::cin.ignore(1000, '\n');
            std::cout << "Error: Inavlid input\n";
            continue;
        }

        std::cout << "Enter coordinate to move figure\n";
        std::cout << "Row: ";
        std::cin >> toRow;
        if (std::cin.fail()) {
            std::cin.ignore(1000, '\n');
            std::cout << "Error: Inavlid input\n";
            continue;
        }

        std::cout << "Coloumn: ";
        std::cin >> toCol;
        if (std::cin.fail()) {
            std::cin.ignore(1000, '\n');
            std::cout << "Error: Inavlid input\n";
            continue;
        }

        Chess::execute(fromRow, fromCol, toRow, toCol);
        std::cout << "Press Q to quit";
        std::cin >> flag;
        std::cin.ignore(1000, '\n');
    } while ('q' != flag && 'Q' != flag);
    return 0;
}
