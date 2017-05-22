#include <string>
#include <sstream>
#include "function.h"
#include "my_assert.h"
#include "limits.h"

//Operations for int
int operations::sum(const int& a, const int& b) {
    my_assert((a + b) <= INT_MAX);
    return a + b;
}

int operations::diff(const int& a, const int& b) {
    my_assert((a - b) >= INT_MIN);
    return a - b;
}

int operations::mult(const int& a, const int& b) {
    my_assert((a * b) <= INT_MAX);
    return a * b;
}

int operations::div(const int& a, const int& b) {
    my_assert(0 != b);
    return a / b;
} 

int operations::mod(const int& a, const int& b) {
    my_assert(0 != b);
    return a % b;
}

//Operations for double
double operations::sum(const double& a, const double& b) {
    my_assert((a + b) <= DBL_MAX);
    return a + b;
}

double operations::diff(const double& a, const double& b) {
    my_assert((a - b) >= DBL_MIN);
    return a - b;
}

double operations::mult(const double& a, const double& b) {
    my_assert((a * b) <= DBL_MAX);
    return a * b;
}

double operations::div(const double& a, const double& b) {
    my_assert(0.0 != b);
    return a / b;
}

//Operation for string
std::string operations::sum(const std::string& a, const std::string& b) {
    my_assert("" != a);
    my_assert("" != b);
    return a + b;
}

//Input-functions
int input(const int& a, bool& check) {
    std::string op;
    do {
    std::cout << "Enter operation: ";
    std::cin >> op;
    } while ("+" != op && "-" != op && "*" != op && "/" != op && "%" != op);
    
    int b;
    std::cout << "Enter second operand: ";
    std::cin >> b;
    if (std::cin.fail()) {
        std::cout << "Error: Invalid input data\n";
        check = false;
        return 0;
    }

    switch (op[0]) {
        case '+' : return operations::sum(a, b);
        case '-' : return operations::diff(a, b);
        case '*' : return operations::mult(a, b);
        case '/' : {
                       if (0 == b) {
                           std::cout << "Error: division by zero\n";
                           check = false;
                           return 0;
                       } else {
                           return operations::div(a, b); 
                       }
                   }
        case '%' : {
                       if (0 == b) {
                           std::cout << "Error: division by zero\n";
                           check = false;
                           return 0;
                       } else {
                           return operations::mod(a, b);
                       }
                   }
    }
}

double input(const double& a, bool& check) {
    std::string op;
    do {
    std::cout << "Enter operation: ";
    std::cin >> op;
    } while ("+" != op && "-" != op && "*" != op && "/" != op && "%" != op);
    
    double b;
    std::cout << "Enter second operand: ";
    std::cin >> b;
    if (std::cin.fail()) {
        std::cout << "Error: Invalid input data\n";
        check = false;
        return 0.0;
    }

    switch (op[0]) {
        case '+' : return operations::sum(a, b);
        case '-' : return operations::diff(a, b);
        case '*' : return operations::mult(a, b);
        case '/' : {
                       if (0.0 == b) {
                           std::cout << "Error: division by zero\n";
                           check = false;
                           return 0.0;
                       } else {
                           return operations::div(a, b); 
                       }
                   }
    }
}

std::string input(const std::string& a, bool& check) {
    std::string b;
    std::cout << "Enter second string: ";
    std::cin >> b;

    if ("" != a && "" != b) {
        return operations::sum(a, b);
    } else {
        check = false;
        return " ";
    }
}

//Output-function
void printResult(const std::string& str, bool& check) {
    std::stringstream ss(str);
    int i;
    double d;

    if (str.find(".") != -1) {
        if (!(ss >> d).fail()) {
            check = true;
            double res = input(d, check);
            if (check) {
                std::cout << res << std::endl;
            }
        } else {
            check = true;
            std::string res = input(str, check);
            if (check) {
                std::cout << res << std::endl;
            }
        }
    } else if (!(ss >> i).fail())  {
        check = true;
        int res = input(i, check);
        if (check) {
            std::cout << res << std::endl;
        }
    } else {
        check = true;
        std::string res = input(str, check);
        if (check) {
            std::cout << res << std::endl;
        }
    }
}
