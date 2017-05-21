#include <iostream>
#include <string>
#include "functions.cpp"

int main() {
    int days;
    do {
	std::cout << "Enter number of days: ";
	std::cin >> days;
	if (std::cin.fail()) {
	    std::cout << "Error: Invalid input data" << std::endl;
	    return -1;
	}
    } while (1 > days); 	

    std::string** table = createTable(days);
    
    int variant;
    char input;
    do {
        do {
            std::cout << "Enter search variant(1 or 2): ";
            std::cin >> variant;
        } while (1 != variant && 2 != variant);

        manager(table, days,variant);
        std::cout << "\n**********\n" << std::endl;
        showTable(table, days);
        std::cout << "\n**********\n" << std::endl;	
        std::cout << "Press (e) to exit, enter any character to continue";
        std::cin >> input;
    } while ('c' != input);

    deleteTable(table, days);
    return 0;
}
