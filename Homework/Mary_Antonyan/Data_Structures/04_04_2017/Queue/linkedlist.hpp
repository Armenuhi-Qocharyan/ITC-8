#ifndef LINKEDLIST_HPP
#define LINKEDLIST_HPP

namespace List {
    class LinkedList {
        public:
            bool isEmpty() const;
            int getLength() const;
            bool retrieve(int index, int &item) const;
            void insert(const int index, const int newItem);
            void remove(const int index);
            void print() const;
            LinkedList();
            LinkedList(const LinkedList& orig);
            virtual ~LinkedList();

        private:
            class Node {
                public:
                    int item;
                    Node* next;
            };

            Node *head;
            int length;
    };
}

#endif

