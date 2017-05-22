#include "functions.hpp"

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

bool setData(Soldier& soldier, const std::string& nationality) {
    std::string name;
    do {
        std::cout << "Enter name for " << nationality << " soldier: ";
        std::cin >> name;
        std::cin.ignore(50, '\n');
    } while (!check(name));

    std::string weapon;
    std::cout << "Enter type of weapon: ";
    std::cin >> weapon;
    std::cin.ignore(10, '\n');

    int cartridge;
    do {
        std::cout << "Enter number of cartridges: ";
        std::cin >> cartridge;
        if (std::cin.fail()) {
            std::cout << "Error: Invalid input data" << std::endl;
            return false;
        }
    } while (0 > cartridge);

    int reserved;
    do {
        std::cout << "Enter number of reserved cartridges: ";
        std::cin >> reserved;
        if (std::cin.fail()) {
            std::cout << "Error: Invalid input data" << std::endl;
            return false;
        }
    } while (0 > reserved);

    char is;
    do {
        std::cout << "Is soldier protected? y / n : ";
        std::cin >> is;
        std::cin.ignore(10, '\n');
    } while ('y' != is && 'n' != is);

    bool isProtected = ('y' == is);

    soldier.setName(name);
    soldier.setWeapon(weapon);
    soldier.setCartridge(cartridge);
    soldier.setReserved(reserved);
    soldier.setIsProtected(isProtected);

    std::cout << "\n\n";
    return true;
}

