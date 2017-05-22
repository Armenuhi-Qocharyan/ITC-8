#include <iostream>
#include <string>
#include "function.h"

std::string getLetter(bool& flag) {
    std::string letter;
    std::cout << "Press 0 to exit\n";
    do {
        std::cout << "Enter any letter: ";
        std::cin >> letter;
        if (letter.length() > 1){
            std::cout << "Error: Invalid input data" << std::endl;
            flag = false;
            break;
        }
        if ("0" == letter) {
            flag = false;
            break;
        }
    } while(("a" > letter && "Z" < letter) || "A" > letter || "z" < letter);
    return letter;
}

void checkLetter(const std::string& letter) {
    if ("a" == letter || "A" == letter ||
            "e" == letter || "E" == letter ||
            "i" == letter || "I" == letter ||
            "o" == letter || "O" == letter ||
            "u" == letter || "U" == letter ||
            "Y" == letter || "Y" == letter) {
        std::cout << "Letter  is vowel!\n" << std::endl;
    } else { 
        std::cout << "Letter  is sonant!\n" << std::endl;
    }
}
