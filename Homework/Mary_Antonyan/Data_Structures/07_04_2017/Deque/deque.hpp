#ifndef QUEUE_HPP
#define QUEUE_HPP

#include "linkedlist.hpp"

namespace DequeList {
    class Deque : private List::LinkedList {
        public:
            bool isEmpty() const;
            int getLength() const;
            bool retrieve(int index, int &item) const;
            void insertFront(const int newItem);
            void insertBack(const int newItem);
            void removeFront();
            void removeBack();
            void print() const;
            Deque();
            Deque(const Deque& other);
            virtual ~Deque();

        private:
            class Node {
                public:
                    int item;
                    Node* next;
            };
    };
}

#endif

