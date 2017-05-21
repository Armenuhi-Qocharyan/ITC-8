#include "hanoi.hpp"

static int moves = 0;

void Hanoi(const int& number, const char& pole1, 
           const char& pole2, const char& pole3) {
    ++moves;
    if (0 >= number) {
        std::cout << "Error: Received nonpositive number" << std::endl;
        return;
    } else if (64 < number) {
        std::cout << "Error: Received too big number" << std::endl;
        return;
    } else if (1 == number) {
        std::cout << "Move disc " << number << " from ";
        std::cout << pole1 << " to " << pole3 << std::endl;
    } else {  
        Hanoi(number - 1, pole1, pole3, pole2);
        std::cout << "Move disc " << number << " from ";
        std::cout << pole1 << " to " << pole3 << std::endl;
        Hanoi(number - 1, pole2, pole1, pole3);
    }
}

int getMoves() {
    return moves;
}

