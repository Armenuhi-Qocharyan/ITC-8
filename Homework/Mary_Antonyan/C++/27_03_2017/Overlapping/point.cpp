#include "point.hpp"

//Constructor
Point::Point(double x, double y) 
    : x(x)
    , y(y)
{}

//Get-Methods
double Point::getX() const {
    return x;
}

double Point::getY() const {
    return y;
}

//Destructor
Point::~Point() {}
