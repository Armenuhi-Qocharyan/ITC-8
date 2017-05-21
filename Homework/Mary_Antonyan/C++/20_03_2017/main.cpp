#include "soldier.hpp"

bool check(const std::string&);

int main() {
    std::string name;
    std::string weapon;

    do {
        std::cout << "Enter name for armenian soldier: ";
        std::cin >> name;
        std::cin.ignore(50, '\n');
    } while (!check(name));

    std::cout << "Enter type of weapon: ";
    std::cin >> weapon;
    std::cin.ignore(10, '\n');
    Soldier armenian;
    armenian.setName(name);
    armenian.setWeapon(weapon);

    do {
    std::cout << "\nEnter name for azeri soldier: ";
    std::cin >> name;
    std::cin.ignore(50, '\n');
    } while (!check(name));

    std::cout << "Enter type of weapon: ";
    std::cin >> weapon;
    std::cin.ignore(50, '\n');
    Soldier azeri(name, weapon);

    armenian.fight(azeri);

    return 0;
}

bool check(const std::string& str) {
    if (2 >= str.length()) {
        return false;
    }
    for (int i = 0; i < str.length(); ++i) {
        if (!isalpha(str[i])) {
            return false;
        }
    }
    return true;
}
