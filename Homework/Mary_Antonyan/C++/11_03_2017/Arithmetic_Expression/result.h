#ifndef RESULT_H
#define RESULT_H 1

#include <string>
#include "stack.h"

void execute(Stack<int> valueStack, Stack<char> operStack);
void inputOperation(char oper, Stack <int> valueStack, Stack<char> operStack);
int inputNumber(std::string exp, int pos, Stack<int> valueStack);
void closingParenthes(Stack<int> valueStack, Stack<char> operStack);
int evaluateExp(const std::string exp);

#endif
