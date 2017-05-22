#ifndef NODE_HPP
#define NODE_HPP

namespace Chess {
    class Node {
        public:
            enum Chessman {noFigure, king, queen, knight, rook, bishop, pawn};
            enum Color {noColor, white, black};

            //Constructor
            Node();

            //Destructor
            ~Node();

            //Set-methods
            void setColor(const Color color);
            void setFigure(const Chessman figure);

            //Get-methods
            Color getColor() const;
            Chessman getFigure() const;

            private:
                Color mColor;
                Chessman mFigure;
    };
}

#endif
