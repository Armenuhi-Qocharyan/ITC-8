#ifndef CIRCLE_HPP
#define CIRCLE_HPP

#include "point.hpp"

class Circle {
    private:
        Point center;
        double radius;
    public:
        //Constructor
        Circle(Point&, double);

        //Get-Methods
        Point getCenter() const;
        double getRadius() const;

        //Destructor
        ~Circle();
};

#endif
