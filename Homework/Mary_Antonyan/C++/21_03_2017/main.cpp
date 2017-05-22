#include "soldier.hpp"
#include "functions.hpp"

int main() {
    Soldier armenian;
    Soldier azeri;
    if (setData(armenian, "armenian") && setData(azeri, "azeri")) {
        armenian.fight(azeri);
    }

    return 0;
}

