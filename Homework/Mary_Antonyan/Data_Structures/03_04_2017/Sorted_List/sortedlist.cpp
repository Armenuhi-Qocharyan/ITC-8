#include "sortedlist.hpp"
#include <iostream>

//Constructors
List::SortedList::SortedList() 
    : head(nullptr)
    , length(0)
{}

List::SortedList::SortedList(const SortedList& other) 
    : head(nullptr)
    , length(0) {
    
    Node* current = other.head;
    for (int i = 0; i < other.length; ++i) {
        insert(current->value);
        current = current->next;
    }
}

//Destructor
List::SortedList::~SortedList() {
    while (0 != length) {
        remove(0);
    }
}

//Methods
bool List::SortedList::isEmpty() const {
    return (0 == length);
}

int List::SortedList::getLength() const {
    return length;
}

bool List::SortedList::find(const int index, Rectangle& value) const {
    if (index >= length || 0 > index) {
        return false;
    }

    Node* current = head;
    for (int i = 0; i < index; ++i) {
        current = current->next;
    }
    value = current->next->value;
    return true;
}

void List::SortedList::insert(const Rectangle& value) {
    Node* newNode = new Node;
    newNode->value.setArea(value.getArea());

    if (isEmpty() || value.getArea() <= head->value.getArea()) {
        newNode->next = head;
        head = newNode;
    } else {
        Node* current = head;
        while (nullptr != current->next && current->next->value.getArea() < value.getArea()) {
            current = current->next;
        } 
        newNode->next = current->next;
        current->next = newNode;
    }

    ++length;
}

bool List::SortedList::remove(const int index) {
    if (isEmpty() || index < 0 || index > length - 1) {
        return false;
    }

    Node* oldNode = head;
    if (0 == index) {
        head = head->next;
    } else {
        Node* current = head;
        for (int i = 0; i < index; ++i) {
            oldNode = current->next;
        } 
        current->next = oldNode->next;
    }

    delete oldNode;
    --length;

    return true;
}

void List::SortedList::printList() const {
    Node* current = head;
    while (nullptr != current->next) {
        std::cout << current->value.getArea() << " -> ";
        current = current->next;
    }    
    std::cout << current->value.getArea() << std::endl;
}
