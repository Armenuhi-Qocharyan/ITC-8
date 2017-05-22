#include "deque.hpp"
#include "linkedlist.hpp"
#include <iostream>

namespace DequeList {
    Deque::Deque()
        : List::LinkedList()
    {}

    Deque::Deque(const Deque& other) 
        : List::LinkedList(other)
    {}

    Deque::~Deque() {}

    bool Deque::isEmpty() const {
        return List::LinkedList::isEmpty();
    }

    int Deque::getLength() const {
        return List::LinkedList::getLength();
    }

    bool Deque::retrieve(const int index, int &item) const {
        return List::LinkedList::retrieve(index, item);
    }

    void Deque::insertFront(const int newItem) {
        List::LinkedList::insert(0, newItem);
    }

    void Deque::insertBack(const int newItem) {
        List::LinkedList::insert(getLength() - 1, newItem);
    }

    void Deque::removeFront() {
        List::LinkedList::remove(0);
    }

    void Deque::removeBack() {
        List::LinkedList::remove(getLength() - 1);
    }

    void Deque::print() const {
        List::LinkedList::print();
    }
}
