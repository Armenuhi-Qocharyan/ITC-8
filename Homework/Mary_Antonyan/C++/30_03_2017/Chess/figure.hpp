#ifndef FIGURE_HPP
#define FIGURE_HPP

namespace Chess {
    class Figure {
        public:
            enum Chessman {king, queen, knight, rook, bishop, pawn};
            enum Color {white, black};

            //Constructor
            Figure(Chess::Figure::Chessman figure, Chess::Figure::Color color, 
                    const int row, const int coloumn);

            //Destructor
            virtual ~Figure();

            //Pure virtual method
            virtual void step(const int, const int) = 0;

            //Set-methods
            void setFigure(const Chess::Figure::Chessman figure);
            void setColor(const Chess::Figure::Color color);
            void setRow(const int row);
            void setColoumn(const int coloumn);

            //Get-methods
            Chess::Figure::Chessman getFigure() const;
            Chess::Figure::Color getColor() const;
            int getRow() const;
            int getColoumn() const;

        protected:
            Chess::Figure::Chessman mFigure;
            Chess::Figure::Color mColor;
            int mRow;
            int mColoumn;
    };
}

#endif
