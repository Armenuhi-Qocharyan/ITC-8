#include <iostream>
#include <string>

bool contain(std::string** table, const int& days, const std::string& month, const std::string day, int& index) {
    for (int i = 0; i < days; ++i) {
        if (*(*(table + 1) + i) == month && *(*(table + 2) + i) == day) {
            index = i;
            return true;
        }
    }
    return false;
}

bool checkMonth(const std::string& month) {
    if ("January" != month && "February" != month && "March" != month &&
        "April" != month && "May" != month && "June" != month &&
        "July" != month && "August" != month && "September" != month &&
        "October" != month && "November" != month && "December" != month) {
        std::cout << "Error no matches for MONTH" << std::endl;
        return false;
    }
    return true;
}

bool checkDay(const std::string& month, const std::string& day) {
    if ("January" == month || "March" == month || "May" == month ||
            "July" == month || "August" == month || "October" == month ||
            "December" == month) {
        if ("1" != day && "2" != day && "3" != day && "4" != day && "5" != day &&
                "6" != day && "7" != day && "8" != day && "9" != day && "10" != day &&
                "11" != day && "12" != day && "13" != day && "14" != day && "15" != day &&
                "16" != day && "17" != day && "18" != day && "19" != day && "20" != day &&
                "21" != day && "22" != day && "23" != day && "24" != day && "25" != day &&
                "26" != day && "27" != day && "28" != day && "29" != day && "30" != day &&
                "31" != day) {
            std::cout << "Error: no matches for DAY" << std::endl;
            return false;
        }
    } else if ("April" == month || "June" == month || "September" == month || "November" == month) {
        if ("1" != day && "2" != day && "3" != day && "4" != day && "5" != day &&
                "6" != day && "7" != day && "8" != day && "9" != day && "10" != day &&
                "11" != day && "12" != day && "13" != day && "14" != day && "15" != day &&
                "16" != day && "17" != day && "18" != day && "19" != day && "20" != day &&
                "21" != day && "22" != day && "23" != day && "24" != day && "25" != day &&
                "26" != day && "27" != day && "28" != day && "29" != day && "30" != day) {
            std::cout << "Error: no matches for DAY" << std::endl;
            return false;
        }
    } else if ("February" == month) {
        if ("1" != day && "2" != day && "3" != day && "4" != day && "5" != day &&
                "6" != day && "7" != day && "8" != day && "9" != day && "10" != day &&
                "11" != day && "12" != day && "13" != day && "14" != day && "15" != day &&
                "16" != day && "17" != day && "18" != day && "19" != day && "20" != day &&
                "21" != day && "22" != day && "23" != day && "24" != day && "25" != day &&  
                "26" != day && "27" != day && "28" != day) {
            std::cout << "Error: no matches for DAY" << std::endl;
            return false;
        }
    }
    return true;
}

bool exist(const std::string& month, const std::string& day) {
    return (checkMonth(month) && checkDay(month, day));
}

std::string** createTable(const int& days) {
    std::string** table = new std::string*[3];
    for (int i = 0; 3 > i; ++i) {
    table[i] = new std::string[days];
    }

    int index = 0;
    for (int i = 0; i < days; ++i) {
        std::cout << "Enter name: ";
        std::cin >> *(*table + i);

        std::string day;
        std::string month;
        do {
            std::cout << "Enter month(i.g. March): ";
            std::cin >> month;
            *(*(table + 1) + i) = month;

            std::cout << "Enter day(i.g. 9 or 15): ";
            std::cin >> day;
            *(*(table + 2) + i) = day;
        } while (!exist(month, day) || contain(table, i, month, day, index));
    }
    return table;
}

void findName(std::string** table, const int& days, const std::string& month, const std::string& day) {
    int index = 0;
    if (contain(table, days, month, day, index)) {
        std::cout << *(*table + index) << std::endl;
        return;
    }
}

void findDate(std::string** table, const int& days, const std::string& name) {
    for (int i = 0; i < days; ++i) {
        if (*(*table + i) == name) {
            std::cout << *(*(table + 1) + i) << " " << *(*(table + 2) + i) << std::endl;
        }
    }
}

void manager(std::string** table, const int& days, const int& variant) {
    if (1 == variant) {
        std::string month;
        std::string day;
        do {
            std::cout << "Enter month: ";
            std::cin >> month;

            std::cout << "Enter day: ";
            std::cin >> day;
            std::cout << std::endl;
            findName(table, days, month, day);
        } while (!exist(month, day));
    } else if (2 == variant) {
        std::string name;
        std::cout << "Enter name: ";
        std::cin >> name;
        std::cout << std::endl;
        findDate(table, days, name);
    }
}

void showTable(std::string** table, const int& days) {
    for (int i = 0; i < days; ++i) {
        std::cout << *(*table + i) << "\t" << *(*(table + 1) + i) << "\t" << *(*(table + 2) + i) << std::endl;
    }
}

void deleteTable(std::string** table, const int& days) {
    for (int i = 0; 3 > i; ++i) {
        delete[] *(table + i);
    }
    delete[] table;
}

