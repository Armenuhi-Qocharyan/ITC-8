#ifndef BISHOP_HPP
#define BISHOP_HPP

#include "figure.hpp"

namespace Chess {
    class Bishop : public Figure {
        public:
            //Constructor
            Bishop(const Chess::Figure::Chessman figure, const Chess::Figure::Color color, 
                    const int row, const int coloumn);
            
            //Destuctor
            ~Bishop();

            //Method override
            void step(const int row, const int coloumn);
    };
}

#endif
