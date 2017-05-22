#include "rectangle.hpp"
#include <iostream>

//Constructors
List::Rectangle::Rectangle() 
    : mArea(0) 
{}

List::Rectangle::Rectangle(const int area) 
    : mArea(area) 
{}

//Destructor
List::Rectangle::~Rectangle() {}

//Methods
int List::Rectangle::getArea() const {
    return mArea;
}

void List::Rectangle::setArea(const int area) {
    mArea = (0 <= area) ? area : 0;
}
