#ifndef LINKEDLIST_HPP
#define LINKEDLIST_HPP

namespace Hash {
    class LinkedList {
        public:
            bool isEmpty() const;
            int getLength() const;
            bool searchByKey(const int key) const;
            bool searchByValue(const int value) const;
            void insert(const int index, const int key, const int value);
            void remove(const int index);
            void print() const;
            LinkedList();
            LinkedList(const LinkedList& orig);
            virtual ~LinkedList();

        private:
            class Node {
                public:
                    int key;
                    int value;
                    Node* next;
            };

            Node *head;
            int length;
    };
}

#endif

