#include "node.hpp"

//Constructor
Chess::Node::Node()
    : mFigure(noFigure)
    , mColor(noColor)
{}

//Destructor
Chess::Node::~Node() {}

//Set-methods
void Chess::Node::setColor(const Chess::Node::Color color) {
    mColor = color;
}

void Chess::Node::setFigure(const Chess::Node::Chessman figure) {
    mFigure = figure;
}

//Get-methods
Chess::Node::Color Chess::Node::getColor() const {
    return mColor;
}

Chess::Node::Chessman Chess::Node::getFigure() const {
    return mFigure;
}
