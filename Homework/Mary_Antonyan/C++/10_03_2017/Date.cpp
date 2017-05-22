#include <iostream> 
#include <string>

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

bool checkDay(const int& year, const std::string& month, const int& day) {
    if ("January" == month || "March" == month || "May" == month ||
            "July" == month || "August" == month || "October" == month ||
            "December" == month) {
        if (0 >= day || 31 < day) {
            std::cout << "Error: no matches for DAY" << std::endl;
            return false;
        }
    } else if ("April" == month || "June" == month || "September" == month || "November" == month) {
        if (0 >= day || 30 < day) {
            std::cout << "Error: no matches for DAY" << std::endl;
            return false;
        }
    } else if ("February" == month) {
        if (0 == year % 4) {    
            if (0 >= day || 29 < day) {
                std::cout << "Error: no matches for DAY" << std::endl;
                return false;
            }
        } else {
            if (0 >= day || 28 < day) {
                std::cout << "Error: no matches for DAY" << std::endl;
                return false;
            }
        }
    }
    return true;
}

bool exist(const int& year, const std::string& month, const int& day) {
    return (checkMonth(month) && checkDay(year, month, day));
}

int dayofweek(int year, int month, int day)
{
        int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
        year -= month < 3;
        return ( year + year/4 - year/100 + year/400 + t[month-1] + day) % 7;
}

void manager(int year, std::string month, int day, int days) {

    std::string arr[12] {"January", "February", "March", "April", "May", 
        "June", "July", "August", "September", 
        "October", "November", "December"};
    int i;
    for (i = 0; i < 12; ++i) {
        if (arr[i] == month) {
            break;
        }
    }

    if (365 <= days) {
        if (4 <= year % 4 + (days % 365) / 365) {
            days -= (year % 4 + (days % 365) / 365) / 4;
        }
    }

    days += day;
    for (; 31 < days; ++i) {
        if (i == 11) {
            i = -1;
            ++year;
        }

        if (0 == i || 2 == i || 4 == i || 6 == i || 7 == i || 9 == i || 11 == i) {
            days -= 31;
        } else if (1 == i) {
            days -= 28;
        } else {
            days -= 30;
        }
    }

    std::string dayOfWeek;
    switch (dayofweek(year, i, days)) {
        case 0 : {
                     dayOfWeek = "Sunday";
                     break;
                 }
        case 1 : {
                     dayOfWeek = "Monday";
                     break;
                 }
        case 2 : {
                     dayOfWeek = "Tuesday";
                     break;
                 }
        case 3 : {
                     dayOfWeek = "Wednesday";
                     break;
                 }
        case 4 : {
                     dayOfWeek = "Thursday";
                     break;
                 }
        case 5 : { 
                     dayOfWeek = "Friday";
                     break;
                 }
        case 6 : { 
                     dayOfWeek = "Saturday";
                     break;
                 }
    }

    std::cout << days << " " << arr[i] << " " << year << " " << dayOfWeek << std::endl;
}


int main() {
    int year;
    do {
        std::cout << "Enter year: ";
        std::cin >> year;
    } while (0 >= year);

    std::string month;
    int day;
    do {
        std::cout << "Enter month: ";
        std::cin >> month;

        std::cout << "Enter day: ";
        std::cin >> day;
        std::cout << std::endl;
    } while (!exist(year, month, day));

    int days;
    do {
        std::cout << "Enter number of days: ";
        std::cin >> days;
    } while (0 >= days);

    manager(year, month, day, days);
    return 0;
}
























