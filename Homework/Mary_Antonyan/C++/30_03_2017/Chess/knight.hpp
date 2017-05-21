#ifndef KNIGHT_HPP
#define KNIGHT_HPP

#include "figure.hpp"

namespace Chess {
    class Knight : public Figure {
        public:
            //Constructor
            Knight(const Chess::Figure::Chessman figure, const Chess::Figure::Color color, 
                    const int row, const int coloumn);

            //Destructor
            ~Knight();

            //Method override
            void step(const int row, const int coloumn);
    };
}

#endif
