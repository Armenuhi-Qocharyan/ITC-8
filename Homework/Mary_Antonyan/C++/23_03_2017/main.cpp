#include "functions.hpp"

int main() {
    int numberOfPairs;
    do {
        std::cout << "Enter number of pairs: ";
        std::cin >> numberOfPairs;
        std::cin.ignore(5, '\n');
        std::cin.clear();
    } while (std::cin.fail() || 0 >= numberOfPairs);
    
    int** list = setData(numberOfPairs);
    print(list, numberOfPairs);

    if (isGroup(list, numberOfPairs)) {
        std::cout << "Is a group" << std::endl;
    } else {
        std::cout << "Is not a group" << std::endl;
    }
    return 0;
}
