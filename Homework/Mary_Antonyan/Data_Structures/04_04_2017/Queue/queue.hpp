#ifndef QUEUE_HPP
#define QUEUE_HPP

#include "linkedlist.hpp"

namespace QueueList {
    class Queue : private List::LinkedList {
        public:
            bool isEmpty() const;
            int getLength() const;
            bool retrieve(int index, int &item) const;
            void insert(const int newItem);
            void remove();
            void print() const;
            Queue();
            Queue(const Queue& other);
            virtual ~Queue();

        private:
            class Node {
                public:
                    int item;
                    Node* next;
            };

            Node* tail;
    };
}

#endif

