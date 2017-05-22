#ifndef POINT_HPP
#define POINT_HPP

#include <iostream>

class Point {
    private:
        double x;
	double y;

    public:
        //Constructor
	Point(double, double);

        //Get-Methods
	double getX() const;
	double getY() const;

        //Destructor
        ~Point();
};

#endif



