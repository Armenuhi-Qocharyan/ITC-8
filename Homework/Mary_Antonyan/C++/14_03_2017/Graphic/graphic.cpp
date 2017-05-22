#include <iostream>
#include "graphic.h"

static unsigned int line = 0;
static unsigned int triangle = 0;
static unsigned int rectangle = 0;
static unsigned int square = 0;

void drawLine(const unsigned int& length) {
    ++line;
    for (unsigned int i = 0; i < length; ++i) {
        std::cout << '*';
    }
    std::cout << std::endl;
}

void drawTriangle(const unsigned int& side) {
    ++triangle;
    unsigned int space = 2 * (side - 1) + 1;
    for (unsigned int i = 0; i < side; ++i) {
        for (unsigned int j = 0; j <= space / 2 - i; ++j) {
            std::cout << ' ';
        }
        for (unsigned int j = 0; j <= 2 * i; ++j) {
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
    ++rectangle;
    for (unsigned int i = 0; i < height; ++i) {
        for (unsigned int j = 0; j < width; ++j) {
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
    ++square;
    drawRectangle(side, side);
}

unsigned int getLine() {
    return line;
}

unsigned int getTriangle() {
    return triangle;
}

unsigned int getRectangle() {
    return rectangle;
}

unsigned int getSquare() {
    return square;
}

void manager() {
    unsigned int variant = 0;
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
                         unsigned int length;
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
                         unsigned int side;
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
                         unsigned int width;
                         unsigned int height;
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
                         unsigned int sqSide;
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
    drawColoumns();
}

void drawColoumns() {
    unsigned int arr[4] = {getLine(), getTriangle(), getRectangle() - getSquare(), getSquare()};
    std::cout << "\nFUNCTION CALL STATISTICS\n\n";

    unsigned int sum = 0;
    for (unsigned int j = 0; j < 4; ++j) {
        sum += arr[j];
    }

    if (0 == sum) {
        std::cout << "No Function Call" << std::endl;
        return;
    }

    for (unsigned int i = 0; i < 4; ++i) {
        std::cout << "|";
        for (unsigned int j = 0; j < arr[i]; ++j) {
            std::cout << "#";
        }

        switch (i){
            case 0 : { 
                         std::cout << "\tLine ";
                         break;
                     }
            case 1 : { 
                         std::cout << "\tTriangle ";
                         break;
                     }
            case 2 : { 
                         std::cout << "\tRectangle ";
                         break;
                     }
            case 3 : { 
                         std::cout << "\tSquare ";
                         break;             
                     }
        }

            if (arr[i] == sum) {
                std::cout << "100 %" << std::endl; 
            } else if (0 == arr[0]) {
                std::cout << " \t \t0 %" << std::endl; 
            } else {
                std::cout << arr[i]  * 100 / sum << " % " << std::endl;
            }
    }
}

