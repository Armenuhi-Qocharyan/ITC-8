#ifndef PAWN_HPP
#define PAWN_HPP

#include "figure.hpp"

namespace Chess {
    class Pawn : public Figure {
        public:
            //Constructor
            Pawn(const Chess::Figure::Chessman figure, const Chess::Figure::Color color, 
                    const int row, const int coloumn);

            //Destructor
            ~Pawn();

            //Method override
            void step(const int row, const int coloumn);
    };
}

#endif
