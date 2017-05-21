#include "functions.hpp"

int main() {
    std::string countries[13] = {"Italy", "Canada", "USA", "China", 
                                "Denmark", "Russia", "Brazil", 
                                "Germany", "France", "Spain", 
                                "Japan", "Hungary", "Australia"};

    int count = 13;
    int* gold = generateMedals(count);
    int* silver = generateMedals(count);
    int* bronze = generateMedals(count);
    int* total = getTotal(gold, silver, bronze, count);

    sortTable(countries, gold, silver, bronze, total, count);
    printTable(countries, gold, silver, bronze, total, count);

    return 0;
}

