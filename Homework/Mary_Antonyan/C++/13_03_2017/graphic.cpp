#include <iostream>
#include "graphic.h"

void drawLine(const unsigned int& length) {
    for (int i = 0; i < length; ++i) {
        std::cout << '*';
    }
    std::cout << std::endl;
}

void drawTriangle(const unsigned int& side) {
    unsigned int space = 2 * (side - 1) + 1;
    for (int i = 0; i < side; ++i) {
        for (int j = 0; j <= space / 2 - i; ++j) {
            std::cout << ' ';
        }
        for (int j = 0; j <= 2 * i; ++j) {
            if (0 == j || 2 * i == j || side - 1 == i) {
                std::cout << '*';
            } else {
                std::cout << ' ';
            }
        }
        std::cout << std::endl;
    }
}

void drawRectangle(const unsigned int& width, const unsigned int& height) {
    for (int i = 0; i < height; ++i) {
        for (int j = 0; j < width; ++j) {
            if (0 == i || height - 1 == i || 0 == j || width - 1 == j) {
                std::cout << " *";
            } else {
                std::cout << "  ";
            }
        }
        std::cout << std::endl;
    }
}

void drawSquare(const unsigned int& side) {
    drawRectangle(side, side);
}

void manager() {
    int variant = 0;
    while (true) {
        do {
            std::cout << "Choose variant:\n1 - Line\n2 - Triangle\n";
            std::cout << "3 - Rectangle\n4 - Square\n5 - Presss to exit" << std::endl;
            std::cin >> variant;
            if (std::cin.fail()) {
                std::cout << "Error: invalid input data" << std::endl;
                return;
            }
        } while (0 >= variant || 6 <= variant);

        if (5 == variant) {
            break;
        }

        switch (variant) {
            case 1 : { 
                         int length;
                         do {
                             std::cout << "Enter length for line: ";
                             std::cin >> length;
                             if (std::cin.fail()) {
                                std::cout << "Error: invalid input data" << std::endl;
                                return;
                             }
                         } while (1 >= length || 140 < length);
                         drawLine(length);
                         break;
                     }
            case 2 : {
                         int side;
                         do {
                             std::cout << "Enter side for isosceles triangle: ";
                             std::cin >> side;
                             if (std::cin.fail()) {
                                std::cout << "Error: invalid input data" << std::endl;
                                return;
                             }
                         } while (2 >= side || 65 < side);
                         drawTriangle(side);
                         break;
                     }
            case 3 : {
                         int width;
                         int height;
                         do {
                             std::cout << "Enter width for rectangle: ";
                             std::cin >> width;       
                             if (std::cin.fail()) {
                                std::cout << "Error: invalid input data" << std::endl;
                                return;
                             }
                             std::cout << "Enter height for rectangle: ";
                             std::cin >> height; 
                             if (std::cin.fail()) {
                                std::cout << "Error: invalid input data" << std::endl;
                                return;
                             }
                         } while (2 >= width || 140 < width || 2 >= height) ;
                         drawRectangle(width, height);
                         break;
                     }
            case 4 : {
                         int sqSide;
                         do {
                             std::cout << "Enter side for square: ";
                             std::cin >> sqSide;
                             if (std::cin.fail()) {
                                std::cout << "Error: invalid input data" << std::endl;
                                return;
                             }
                         } while (2 >= sqSide || 140 < sqSide);
                         drawSquare(sqSide);
                     }
        }
    }    
}
