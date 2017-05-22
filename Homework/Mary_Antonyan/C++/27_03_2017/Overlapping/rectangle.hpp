#ifndef RECTANGLE_HPP
#define RECTANGLE_HPP

#include "point.hpp"
#include "circle.hpp"

class Rectangle {
    private:
	Point leftTop;	
	Point rightBottom;	
    public:
        //Constructor
	Rectangle(Point&, Point&);

        //Get-Methods
	Point getLeftTop() const;
	Point getRightBottom() const;

        //Methods
        bool isOverlap(Rectangle&);
        bool isOverlap(Circle&);

        //Destructor
        ~Rectangle();

    private:
        //Private methods
        double max(double, double);
        double min(double, double);
        double getArea(Rectangle&);
};

#endif
