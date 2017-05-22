#include "sortedlist.hpp"
#include "rectangle.hpp"
#include <iostream> 
#include <cstdlib>
#include <ctime>

void initList(const unsigned int, List::SortedList*);

int main() {
    unsigned int length = 15;
    List::SortedList list;
    std::cout << "\n-----INITIAL LIST-----\n";
    initList(length, &list);

    std::cout << "\n\n-----SORTED LIST-----\n";
    list.printList();

    return 0;
}

void initList(const unsigned int length, List::SortedList* list) {
    srand(time(0));
    int value = 0;

    for (int i = 0; i < length; ++i) {
        value = 5 + rand() % 100;
        std::cout << value << "  ";
        List::Rectangle rect(value);
        list->insert(rect);
    }
}
