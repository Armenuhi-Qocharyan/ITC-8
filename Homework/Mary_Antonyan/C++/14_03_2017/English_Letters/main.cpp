#include <iostream>
#include <string>
#include "function.h"

int main() {
    std::string letter;
    bool flag = true;
    do {
        letter = getLetter(flag);
        if (flag) {
        checkLetter(letter);
        }
    } while ("0" != letter && flag);
    return 0;
}

