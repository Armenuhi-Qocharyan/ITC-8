#ifndef ROOK_HPP
#define ROOK_HPP

#include "figure.hpp"

namespace Chess {
    class Rook : public Figure {
        public:
            //Constructor
            Rook(const Chess::Figure::Chessman figure, const Chess::Figure::Color color, 
                    const int row, const int coloumn);

            //Destructor
            ~Rook();

            //Method override
            void step(const int row, const int coloumn);
    };
}

#endif
