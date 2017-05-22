#ifndef STACK_HPP
#define STACK_HPP

#include "linkedlist.hpp"

namespace List {
    class Stack : private LinkedList {
        public:
            void push(const int);
            void pop();
            bool isEmpty() const;
            int top() const;
            int getLength() const;
            void print() const;
            Stack();
            Stack(const Stack&);
            ~Stack();
    };
}

#endif
