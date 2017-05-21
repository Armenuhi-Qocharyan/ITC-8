#include "functions.hpp"

Point setPoint(std::string message) {
    double x;
    do {
        std::cout << message << ": Enter x: ";
        std::cin >> x;
    } while (std::cin.fail());

    double y;
    do {
        std::cout << message << ": Enter y: ";
        std::cin >> y;
    } while (std::cin.fail());

    Point point(x, y);
    return point;
}

Rectangle setRectangle() {
    std::cout << "\n-----Rectangle-----\n\n";
    Point leftTop = setPoint("Left Top Point");
    Point rightBottom = setPoint("Right Bottom Point");
    Rectangle rectangle(leftTop, rightBottom);
    return rectangle;   
}

Circle setCircle() {
    std::cout << "\n-----Circle-----\n\n";
    Point center = setPoint("Circle center");
    double radius;
    do {
        std::cout << "Enter radius: ";
        std::cin >> radius;
    } while (std::cin.fail());
    Circle circle(center, radius);
    return circle;
}
