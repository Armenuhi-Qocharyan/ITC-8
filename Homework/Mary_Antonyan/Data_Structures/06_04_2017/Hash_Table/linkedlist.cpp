#include "linkedlist.hpp"
#include <iostream>

namespace Hash {
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
                  insert(i, current->key, current->value);
                  current = current->next;
              }
    }

    LinkedList::~LinkedList() {
        while (0 != length) {
            remove(0);
        }
    }

    bool LinkedList::isEmpty() const {
        return  (0 == length);
    }

    int LinkedList::getLength() const {
        return length;
    }

    bool LinkedList::searchByKey(const int key) const {
        if (isEmpty()) {
            return false;
        }

        if (key == head->key) {
            return true;
        }

        Node* current = head->next;
        while (nullptr != current->next) {
            if (current->key == key) {
                return true;
            }
            current = current-> next;
        }
        return false;
    }

    bool LinkedList::searchByValue(const int value) const {
        if (isEmpty()) {
            return false;
        }

        Node* current = head;
        if (value == head->value) {
            return true;
        }

        while (nullptr != current->next) {
            if (current->value == value) {
                return true;
            }
            current = current-> next;
        }
        return false;
    }

    void LinkedList::insert(int index, const int key, const int value) {
        Node* newNode = new Node;
        newNode->key = key;
        newNode->value = value;

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
            for (int i = 0; i < index - 1; i++) {
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
            std::cout << current->key << " => " << current->value;
            current = current->next;
        }
    }
}
