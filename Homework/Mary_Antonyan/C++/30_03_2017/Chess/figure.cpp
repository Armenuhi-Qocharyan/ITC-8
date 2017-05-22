#include "figure.hpp"

//Constructor
Chess::Figure::Figure(Chess::Figure::Chessman figure, 
                        Chess::Figure::Color color, 
                        const int row, const int coloumn) 
    : mFigure(figure)
    , mColor(color) 
{
    setRow(row);
    setColoumn(coloumn);        
}

//Destructor
Chess::Figure::~Figure() {}

//Set-methods
void Chess::Figure::setFigure(const Chess::Figure::Chessman figure) {
    mFigure = figure;
}

void Chess::Figure::setColor(const Chess::Figure::Color color) {
    mColor = color;
}

void Chess::Figure::setRow(const int row) {
    mRow = (0 <= row && 8 > row) ? row : 0;
}

void Chess::Figure::setColoumn(const int coloumn) {
    mColoumn = (0 <= coloumn && 8 > coloumn) ? coloumn : 0;
}

//Get-methods
Chess::Figure::Chessman Chess::Figure::getFigure() const {
    return mFigure;
}

Chess::Figure::Color Chess::Figure::getColor() const {
    return mColor;
}

int Chess::Figure::getRow() const {
    return mRow;
}

int Chess::Figure::getColoumn() const {
    return mColoumn;
}
