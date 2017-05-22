#include <iostream>
#include <string>
#include "Stack.cpp"

void execute(Stack<int> valueStack, Stack<char> operStack) {
    std::cout <<  __FUNCTION__ << std::endl;
    int rightOperand = valueStack.pop();
    int leftOperand = valueStack.pop();
    char oper = operStack.pop();

    int result = 0;
    switch (oper) {
        case '+' : {
                       result = rightOperand + leftOperand;
                       break;
                   }
        case '-' : {
                       result = rightOperand - leftOperand;
                       break; 
                   }
        case '*' : {
                       result = rightOperand * leftOperand;
                       break;
                   }
        case ':' : {
                       result = rightOperand / leftOperand;
                       break;
                   }
    }
    valueStack.push(result);
    std::cout << oper << " " << valueStack.top() << std::endl;
}

bool causesEvaluation(const char& oper, const char& prevOper) {
    switch (oper) {
        case '+':
        case '-': return ('(' != prevOper);
        case '*':
        case ':': return ('*' == prevOper || ':' == prevOper);
        case ')': return true;
    }

    return false;
}


void inputOperation(const char& oper, Stack <int> valueStack, Stack<char> operStack) {
    std::cout <<  __FUNCTION__ << std::endl;
    while (!operStack.isEmpty() && causesEvaluation(oper, operStack.top())) {
        execute(valueStack, operStack);
    }

    operStack.push(oper);
}

int inputNumber(const std::string& exp, int pos, Stack<int> valueStack) {
    std::cout <<  __FUNCTION__ << std::endl;
    int value = 0;
    while (pos <= exp.length() && '0' <= exp[pos] && '9' >= exp[pos]) {
        std::cout << pos << " -> " << exp[pos] << std::endl;
        value = 10 * value + (exp[pos++] - '0');
    }
    std::cout << value << std::endl;
    valueStack.push(value); 
    std::cout << pos << std::endl;
    return pos;
}

void closingParenthes(Stack<int> valueStack, Stack<char> operStack) {
    std::cout <<  __FUNCTION__ << std::endl;
    while ('(' != operStack.top()) {
        execute(valueStack, operStack);
    }
    operStack.pop();
}

int evaluateExp(const std::string exp) {
    std::cout <<  __FUNCTION__ << std::endl;
    Stack<int>* vStack = new Stack<int>;
    Stack<char>* oStack = new Stack<char>;

    Stack<int> valueStack = *vStack;
    Stack<char> operStack = *oStack;

    operStack.push('(');
    int pos = 0;
    while (pos <= exp.length()) {
        std::cout << "WHILE " << pos << std::endl;
        if (pos == exp.length() || ')' == exp[pos]) {
            std::cout << "IF " << pos << std::endl;
            closingParenthes(valueStack, operStack);
            ++pos;
        } else if ('0' <= exp[pos] && '9' >= exp[pos]) {
            std::cout << "ELSE IF " << pos << std::endl;
            pos = inputNumber(exp, pos, valueStack);
            std::cout << "ELSE IF " << pos << std::endl;
        } else {
            std::cout << "ELSE " << pos << std::endl;
            inputOperation(exp[pos], valueStack, operStack);
            ++pos;
        } 
    }

    return valueStack.pop();
}


