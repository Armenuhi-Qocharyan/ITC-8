#include <iostream>

int main() {
    int rows;
    int item = 1;

    do {
	std:: cout << "Enter number of rows: ";
    	std:: cin >> rows;
    } while (0 >= rows || 10 <= rows);

    for (int i = 0; i < rows; ++i) {
        for(int j = 1; j <= rows - i; ++j) {
            std::cout << "  ";
	}

        for(int j = 0; j <= i; ++j) {
            if ( 0 == j || 0 == i) {
                item = 1;
	    } else {
                item = item * (i - j + 1) / j;
	    }
            std::cout << item << "   ";
        }
        std::cout << std::endl;
    }
    return 0;
}
