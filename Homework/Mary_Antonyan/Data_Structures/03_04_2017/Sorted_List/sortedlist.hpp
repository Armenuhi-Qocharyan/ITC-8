#ifndef SORTED_LIST_HPP
#define SORTED_LIST_HPP

#include "rectangle.hpp"

namespace List {
    class SortedList {
        public:
            //Constructors
            SortedList();
            SortedList(const SortedList& other);
        
            //Destructor
            ~SortedList();

            //Methods
            bool isEmpty() const;
            int getLength() const;
            bool find(const int index, Rectangle& value) const;
            void insert(const Rectangle& value);
            bool remove(const int index);
            void printList() const;

        private:
            class Node {
                public:
                    Rectangle value;
                    Node* next;
            };

            //Fields
            Node* head;
            int length;
    };
}

#endif
