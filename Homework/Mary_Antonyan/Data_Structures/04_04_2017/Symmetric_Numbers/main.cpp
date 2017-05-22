#include "stack.hpp"
#include "helper.hpp"

int main() {
    int number = List::setNumber();
    List::printInfo(number, List::isSymmetric(number));

    return 0;
}
