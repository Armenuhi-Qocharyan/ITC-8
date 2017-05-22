#ifndef KING_HPP
#define KING_HPP

#include "figure.hpp"

namespace Chess {
    class King : public Figure {
        public:
            //Constructor
            King(const Chess::Figure::Chessman figure, const Chess::Figure::Color color, 
                    const int row, const int coloumn);

            //Destructor
            ~King();

            //Method override
            void step(const int row, const int coloumn);
    };
}

#endif

