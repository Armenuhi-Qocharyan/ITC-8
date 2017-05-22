#include "queue.hpp"
#include <iostream>
#include <cmath>
#include <ctime>


int main() {
    unsigned int size = 20;
    QueueList::Queue queue;

    srand(time(0));
    int item = 0;
    for (int i = 0; i < size; ++i) {
        item = 10 + rand() % 20;
        std::cout << "Current item: " << item << std::endl;
        queue.insert(item);
    }
    
    std::cout << "\n\n-----INIT QUE-----\n";
    queue.print();

    for (int i = 0; i < size - 5; ++i) {
        queue.remove();
    }

    std::cout << "\n\n-----TEMP QUE-----\n";
    queue.print();

    for (int i = 0; i < 7; ++i) {
        if (queue.isEmpty()) {
            std::cout << "\nQue is empty and this call " <<
                        "for function <remove> is ignored"; 
        } else {
            std::cout << "\n\n-----Last removes-----\n\n";
            queue.print(); 
        }
        queue.remove();
    }
    std::cout << std::endl;
    return 0;
}
