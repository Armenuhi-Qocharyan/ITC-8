#ifndef QUEEN_HPP
#define QUENN_HPP

#include "figure.hpp"

namespace Chess {
    class Queen : public Figure {
        public:
        //Constructor
        Queen(const Chess::Figure::Chessman figure, const Chess::Figure::Color color, 
                const int row, const int coloumn);    

        //Destructor
        ~Queen();

        //Method override
        void step(const int row, const int coloumn);
    };
}
#endif
