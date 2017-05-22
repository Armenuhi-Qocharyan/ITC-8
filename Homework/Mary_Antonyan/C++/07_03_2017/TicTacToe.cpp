#include <iostream>
#include <string>

char** createTable() {
    char** table = new char*[3];
    for (int i = 0; i < 3; ++i) {
        table[i] = new char[3];
    }

    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            table[i][j] = '-';
        }
    }
    return table;
}

int checkTable(char** table) {
    if (('x' == table[0][0] && 'x' == table[0][1] && 'x' == table[0][2]) ||
    	('x' == table[1][0] && 'x' == table[1][1] && 'x' == table[1][2]) ||
    	('x' == table[2][0] && 'x' == table[2][1] && 'x' == table[2][2]) ||
    	('x' == table[0][0] && 'x' == table[1][0] && 'x' == table[2][0]) ||	
		('x' == table[0][1] && 'x' == table[1][1] && 'x' == table[2][1]) ||
		('x' == table[0][2] && 'x' == table[1][2] && 'x' == table[2][2]) || 
        ('x' == table[0][0] && 'x' == table[1][1] && 'x' == table[2][2]) ||
        ('x' == table[0][2] && 'x' == table[1][1] && 'x' == table[2][0])) {
        return 1;
    }

    if (('o' == table[0][0] && 'o' == table[0][1] && 'o' == table[0][2]) ||               
        ('o' == table[1][0] && 'o' == table[1][1] && 'o' == table[1][2]) ||
		('o' == table[2][0] && 'o' == table[2][1] && 'o' == table[2][2]) ||
		('o' == table[0][0] && 'o' == table[1][0] && 'o' == table[2][0]) || 
		('o' == table[0][1] && 'o' == table[1][1] && 'o' == table[2][1]) ||
		('o' == table[0][2] && 'o' == table[1][2] && 'o' == table[2][2]) ||
		('o' == table[0][0] && 'o' == table[1][1] && 'o' == table[2][2]) ||
		('o' == table[0][2] && 'o' == table[1][1] && 'o' == table[2][0])) { 
        return 2;
    }
    return 0;
}

void printTable(char** table) {
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            std::cout << table[i][j] << "\t";
        }
        std::cout << std::endl;
    }
}

bool isFull(char** table) {
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            if ('-' == table[i][j]) {
                return false;
            }
        }
    }
    return true;
}

void fillTable(char** table, std::string xName, std::string oName) {
    int turn = 1;
    int i, j;
    while (!isFull(table)) {
        if (1 == turn) {
            std::cout << "X_" << xName << ": ";
        } else {
            std::cout << "O_" << oName << ": ";
        }

        do {
            std::cout << "i: ";
            std::cin >> i;
            std::cout << "j: ";
            std::cin >> j;
        } while ( 0 > i || 2 < i || 0 > j || 2 < j || '-' != table[i][j]);

        if (1 == turn) {
            table[i][j] = 'x';
            turn = 2;
        } else {
            table[i][j] = 'o';
            turn = 1;
        }

        printTable(table);
        if (1 == checkTable(table)) {
            std::cout <<  xName << " won!" << std::endl;
            return;
        } else if (2 == checkTable(table)) {
            std::cout << oName << " won!" << std::endl;
            return;
        }

    }
    std::cout << "Nobody won! :)" << std::endl;
}

int main() {
    std::string xName;
    std::cout << "Enter your name X: ";
    std::cin >> xName;

    std::string oName;
    std::cout << "Enter your name O: ";
    std::cin >> oName;

    char** table = createTable();
    fillTable(table, xName, oName);
    return 0;
}
