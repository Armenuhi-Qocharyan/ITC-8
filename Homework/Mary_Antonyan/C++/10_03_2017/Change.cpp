#include <iostream>
#include <string> 

unsigned int getFirstPart(double money) {
    return (unsigned int)money;
}

unsigned int getSecondPart(double money) {
    unsigned int res = 0;
    double epsilion = 0.0001;
    money -= getFirstPart(money);
    while (epsilion < money) {
        money *= 10;
        res = res * 10 + getFirstPart(money);
        money -= getFirstPart(money);
        std::cout << "Money: " << money << "\tResult: " << res << std::endl;
    }
    return res;
}

std::string Miavor(const int& number) {
    switch (number) {
        case 1 : { return "Mek "; }
        case 2 : { return "Erku "; }
        case 3 : { return "Ereq "; }
        case 4 : { return "Chors "; }
        case 5 : { return "Hing "; }
        case 6 : { return "Vec "; }
        case 7 : { return "Yot "; }
        case 8 : { return "Ut "; }
        case 9 : { return "Iny "; }
    }
}

std::string Tasnavor(const int& number) {
    switch (number) { 
        case 1 : { return " Tasn"; }
        case 2 : { return " Qsan"; }
        case 3 : { return " Eresun"; }
        case 4 : { return " Qarasun"; }
        case 5 : { return " Hisun"; }
        case 6 : { return " Vatsun"; }
        case 7 : { return " Yotanasun"; }
        case 8 : { return " Utsun"; }
        case 9 : { return " Innsun"; }
    }
}

std::string miniTranslate(const int& number) {
    std::string result = "";
    if (0 < number / 100) {
        std::string haryur = Miavor(number / 100);
        result += haryur; 
        result += " haryur";
    }

    if (0 < (number - (number / 100) * 100) / 10) {
        std::string tasnavor = Tasnavor((number - (number / 100) * 100) / 10);        
        result += tasnavor;
    }

    if (0 < number % 10) {
        std::string miavor = Miavor(number % 10);
        result += miavor;
    }

    return result;
} 

std::string translateHelper(int money) {
    int divider = 1000000000;
    std::string result = "";
    for (int i = 0; i < 4; ++i) {
        if (0 < money / divider) {
            result += miniTranslate(money / divider); 
            switch (i) {
                case 0 : { 
                             result += " Miliard ";
                             break;
                         }
                case 1 : {
                            result += " Million ";
                            break;
                         }
                case 2 : {
                            result += " Hazar ";
                            break;
                         }
            }
            money %= divider; 
        }
        divider /= 1000;
    }

    return result;
}

std::string translate(double money) {
    unsigned int first = getFirstPart(money);
    unsigned int second = getSecondPart(money);
    std::cout << first << "\t" << second << std::endl;

    std::string result = "";
    if (0 < first) {
        result += translateHelper(first) + " dram ";
    } 
    if (0 < second) {
        result += translateHelper(10*second) + " luma";
    }
    return result;
}

int main() {
    double money;
    do {
        std::cout << "Enter money: ";
        std::cin >> money;
    } while (0 >= money);

    std::string result = translate(money);
    std::cout << result << std::endl;
    return 0;
}
