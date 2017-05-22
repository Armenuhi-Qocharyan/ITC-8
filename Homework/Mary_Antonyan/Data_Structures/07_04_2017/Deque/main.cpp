#include "deque.hpp"
#include <iostream>
#include <cmath>
#include <ctime>


int main() {
    DequeList::Deque deque;
    int size = 20;

    srand(time(0));
    int item = 0;
    for (int i = 0; i < size; ++i) {
        item = 10 + rand() % 20;
        std::cout << "Current item: " << item << std::endl;
        deque.insertFront(item);
    }
    
    std::cout << "\n\n-----INIT DEQUE-----\n";
    deque.print();

    for (int i = 0; i < size / 2; ++i) {
        deque.removeBack();
    }

    std::cout << "\n\n-----TEMP DEQUE-----\n";
    deque.print();

    for (int i = 0; i < size / 2; ++i) {
        deque.removeBack();
    }

    std::cout << "\n\n-----FINAL DEQUE-----\n";
    deque.print();

    std::cout << std::endl;
    return 0;
}
