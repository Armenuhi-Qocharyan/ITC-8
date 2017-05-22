#include "stack.hpp"

namespace List {
    Stack::Stack() : LinkedList() {}

    Stack::Stack(const Stack& other) : LinkedList(other) {}

    Stack::~Stack() {}

    void Stack::push(const int item) {
        insert(0, item);
    }

    void Stack::pop() {
        remove(0);
    }

    bool Stack::isEmpty() const {
        return LinkedList::isEmpty();
    }

    int Stack::top() const {
        int top = 0;
        bool t = retrieve(0, top);
        return top;
    }

    int Stack::getLength() const {
        return LinkedList::getLength();
    }

    void Stack::print() const {
        LinkedList::print();
    }
}
