#include "functions.hpp"

int main()
{
    
    Rectangle rect1 = setRectangle();
    Rectangle rect2 = setRectangle();
 
    std::cout << std::endl;
    if (rect1.isOverlap(rect2)) {
        std::cout << "Rectangle - Rectangle : YES" << std::endl;
    } else {
        std::cout << "Rectangle - Rectangle : NO" << std::endl;
    }   

    Circle circle = setCircle();
    
    std::cout << std::endl;
    if (rect1.isOverlap(circle)) {
        std::cout << "Rectangle - Circle : YES" << std::endl;
    } else {
        std::cout << "Rectangle - Circle : NO" << std::endl;
    }   
    return 0;
}



