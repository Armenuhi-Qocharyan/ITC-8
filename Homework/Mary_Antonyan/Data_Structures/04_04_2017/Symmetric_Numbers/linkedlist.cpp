#include "linkedlist.hpp"
#include <iostream>

namespace List {
    LinkedList::LinkedList()
        : head(nullptr)
        , length(0)
    {}

    LinkedList::LinkedList(const LinkedList& other) 
        : head(nullptr)
        , length(0) {
              Node* current = other.head;
              for (int i = 0; i < other.length; i++)
              {
                  insert(i, current->item);
                  current = current->next;
              }
    }

    LinkedList::~LinkedList() {
        while (0 != length) {
            remove(0);
        }
    }

    bool LinkedList::isEmpty() const {
        return length == 0;
    }

    int LinkedList::getLength() const {
        return length;
    }

    bool LinkedList::retrieve(const int index, int &item) const {
        if (index >= length || index < 0) {
            return false;
        }
        Node* current = head;
        for (int i = 0; i < index; i++) {
            current = current-> next;
        }
        item = current->item;
        return true;
    }

    void LinkedList::insert(int index, const int newItem) {
        Node* newNode = new Node;
        newNode->item = newItem;

        if (isEmpty() || index < 1) {
            newNode->next = head;
            head = newNode;
        } else {
            if (index > length) {
                index = length;
            }

            Node* current = head;
            for (int i = 0; i < index-1; i++) {
                current = current-> next;
            }

            newNode->next = current->next;
            current->next = newNode;
        }

        ++length;
    }

    void LinkedList::remove(const int index) {
        if (isEmpty() || index < 0 || index > length - 1) {
            return;
        }

        Node* oldNode = NULL;
        if (index == 0) {
            oldNode = head;
            head = head->next;
        } else {
            Node* current = head;
            for (int i = 0; i < index-1; i++) {
                current = current-> next;
            }
            oldNode = current->next;
            current->next = oldNode->next;
        }
        delete oldNode;
        --length;
    }

    void LinkedList::print() const {
        Node* current = head;
        for (int i = 0; i < length; ++i) {
            std::cout << current->item << " ";
            current = current->next;
        }
    }
}
