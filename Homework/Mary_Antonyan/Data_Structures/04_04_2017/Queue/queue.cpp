#include "queue.hpp"
#include "linkedlist.hpp"
#include <iostream>

namespace QueueList {
    Queue::Queue()
        : List::LinkedList()
        , tail(nullptr)
    {}

    Queue::Queue(const Queue& other) 
        : List::LinkedList(other)
        , tail(nullptr)
    {}

    Queue::~Queue() {}

    bool Queue::isEmpty() const {
        return List::LinkedList::isEmpty();
    }

    int Queue::getLength() const {
        return List::LinkedList::getLength();
    }

    bool Queue::retrieve(const int index, int &item) const {
        return List::LinkedList::retrieve(index, item);
    }

    void Queue::insert(const int newItem) {
        List::LinkedList::insert(0, newItem);
    }

    void Queue::remove() {
        List::LinkedList::remove(getLength() - 1);
    }

    void Queue::print() const {
        List::LinkedList::print();
    }
}
