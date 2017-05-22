#include <cmath>
#include "rectangle.hpp"
#include "point.hpp"


//Constructor
Rectangle::Rectangle(Point& leftTop, Point& rightBottom) 
    : leftTop(leftTop)
    , rightBottom(rightBottom)
{}

//Get-Methods
Point Rectangle::getLeftTop() const {
	return leftTop;
}

Point Rectangle::getRightBottom() const {
	return rightBottom;
}

//Method
bool Rectangle::isOverlap(Rectangle& rect) {
    return (getArea(rect) > 0);
}

bool Rectangle::isOverlap(Circle& circ) {
    double distTop = sqrt((circ.getCenter().getX() - leftTop.getX())*(circ.getCenter().getX() - leftTop.getX()) +
                     (circ.getCenter().getY() - leftTop.getY())*(circ.getCenter().getY() - leftTop.getY()));
    double distBottom = sqrt((circ.getCenter().getX() - rightBottom.getX())*(circ.getCenter().getX() - rightBottom.getX()) +
                        (circ.getCenter().getY() - rightBottom.getY())*(circ.getCenter().getY() - rightBottom.getY()));
    double radius = circ.getRadius();

    return (distTop <= radius || distBottom <= radius); 
}

//Destructor
Rectangle::~Rectangle() {}

//Private methods
double Rectangle::max(double a, double b) {
    return (a > b) ? a : b;
}

double Rectangle::min(double a, double b) {
    return (a < b) ? a : b;
}

double Rectangle::getArea(Rectangle& rect) {
    double xIntersectLeft = max(leftTop.getX(), rect.getLeftTop().getX());
    double yIntersectLeft = min(leftTop.getY(), rect.getLeftTop().getY());

    double xIntersectRight = min(rightBottom.getX(), rect.getRightBottom().getX());
    double yIntersectRight = max(rightBottom.getY(), rect.getRightBottom().getY());

    return (xIntersectRight - xIntersectLeft)*(yIntersectLeft - yIntersectRight);
}
