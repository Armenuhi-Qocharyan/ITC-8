#include <iostream>
#include "stack.h"

template <class T> 
Stack<T>::Stack() {
    arr = new T[20];
    m_top = -1;
    std::cout << "Object was created" << std::endl;
}

template <class T> 
Stack<T>::~Stack() {
    delete[] arr;
    std::cout << "Object was destroyed" << std::endl;
}

template <class T> 
void Stack<T>::push(T const& item) {
    arr[++m_top] = item;
}

template <class T> 
T Stack<T>::pop() {
    return arr[m_top--];    
}

template <class T> 
T Stack<T>::top() const {
    return arr[m_top];
}

template <class T> 
bool Stack<T>::isEmpty() const {
    return (-1 == m_top);
}


