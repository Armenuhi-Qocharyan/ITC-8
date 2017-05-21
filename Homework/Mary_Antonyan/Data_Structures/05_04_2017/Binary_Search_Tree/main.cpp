#include "binarytree.hpp"
#include "helper.hpp"
#include <iostream>

int main() {
    Tree::BinaryTree searchTree;
    int value = 0;
    char flag = 'c';

    do {
        value = Utils::setValue("insert");
        searchTree.insert(value);
        flag = Utils::setFlag();
        std::cout << std::endl;
    } while ('q' != flag && 'Q' != flag);

    searchTree.traverse();
    std::cout << std::endl;

    do {
        value = Utils::setValue("find");
        Utils::printInfo(searchTree, value);
        flag = Utils::setFlag();
        std::cout << std::endl;
    } while ('q' != flag && 'Q' != flag);

    return 0;
}
