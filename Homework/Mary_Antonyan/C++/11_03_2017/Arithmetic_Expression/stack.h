#ifndef STACK_H
#define STACK_H 1

template <class T>
class Stack { 
    private: 
    T* arr;
    int m_top;

    public: 
    Stack();
    ~Stack();
    void push(T const&); 
    T pop();             
    T top() const;            
    bool isEmpty() const;
};

#endif
