#include <cstdlib>
#include <ctime>
#include <iomanip>
#include "functions.hpp"

int* generateMedals(const int& size) {
    int* arr = new int[size];
    srand(time(0));
    for (int i = 0; i < size; ++i) {
        arr[i] = 7 + rand() % 10;
    }
    return arr;
}

void swap(int& a, int& b) {
    a = a + b;
    b = a - b;
    a = a - b;
}

void swap(std::string& a, std::string& b) {
    std::string tmp = a;
    a = b;
    b = tmp;
}

void sortTable(std::string* countries, int* gold, int* silver, int* bronze, 
        int* total, const int& count) {
    for (int i = 0; i < count; ++i) {
        for (int j = 0; j < count; ++j) {
            if (total[i] > total[j]) {
                swap(countries[i], countries[j]);
                swap(gold[i], gold[j]);
                swap(silver[i], silver[j]);
                swap(bronze[i], bronze[j]);
                swap(total[i], total[j]);
            }
        }
    }
}

void printLine() { 
    for (int j = 0; 45 > j; ++j) {
        std::cout << '-';
    }
}

void printTable(std::string* countries, int* gold, int* silver, int* bronze, 
        int* total, const int& count) {
    std::cout << "\n\n";
    printLine();

    std::cout << std::endl;
    std::cout << std::setw(9) << "|   NOC  ";
    std::cout << std::setw(8) << "| GOLD";
    std::cout << std::setw(9) << "| SILVER";
    std::cout << std::setw(10) << "| BRONZE ";
    std::cout << std::setw(9) << "| TOTAL |" << std::endl;

    printLine();
    for (int i = 0; i < count; ++i) {
        std::cout << "\n|" << std::setw(10) << countries[i];
        std::cout << "|" << std::setw(6) << gold[i];
        std::cout << "|" << std::setw(8) << silver[i];
        std::cout << "|" << std::setw(8) << bronze[i];
        std::cout << "|" << std::setw(7) << total[i] << "|";
        std::cout << std::endl;
        printLine();
    }  
    std::cout << "\n\n\n";
}

int* getTotal(int* gold, int* silver, int* bronze, const int& count) {
    int* arr = new int[count];
    for (int i = 0; i < count; ++i) {
        arr[i] = gold[i] + silver[i] + bronze[i];
    }
    return arr;
}
