#include "hanoi.hpp"

int main() {
    int number;
    do {
        std::cout << "Enter the number of discs: ";
        std::cin >> number;
        if (std::cin.fail()) {
            std::cout << "Error: Invalid input data" << std::endl;
            return -1;
        }
    } while (0 >= number || 64 < number);

    char pole1 = 'A';
    char pole2;
    char pole3;
    do {
        std::cin.ignore(1000, '\n'); 
        std::cout << "On which you pole you want to collect? B or C?\n";
        std::cin >> pole3;
    } while ('B' != pole3 && 'C' != pole3);

    if ('B' == pole3) {
        pole2 = 'C';
    } else {
        pole2 = 'B';
    }

    Hanoi(number, pole1, pole2, pole3);
    std::cout << "It took " << getMoves() << " moves. " << std::endl;
    return 0;
}
