#include "circle.hpp"

//Constructor
Circle::Circle(Point& center, double radius) 
    : center(center)
    , radius(radius)
{}

//Get-Methods
Point Circle::getCenter() const {
    return center;
}

double Circle::getRadius() const {
    return radius;
}

//Destructor
Circle::~Circle() {}
