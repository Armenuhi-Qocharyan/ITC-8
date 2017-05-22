#import argparse

def summ(firstNumber, secondNumber):
    return firstNumber + secondNumber
def sub(firstNumber, secondNumber):
    return firstNumber - secondNumber
def mul(firstNumber, secondNumber):
    return firstNumber * secondNumber
def div(firstNumber, secondNumber):
    if (0 != secondNumber):
        return firstNumber / secondNumber
    else:
        print "Dividtion in Zeroi!"
        return "Invaled action"

def calculating(firstNumber, secondNumber, action):
    swicher = {
        '+': summ(firstNumber, secondNumber),
        '-': sub(firstNumber, secondNumber),
        '*': mul(firstNumber, secondNumber),
        '/': div(firstNumber, secondNumber),
    }
    return swicher.get(action, "Invaled Action")
check=1
while (0 != check):
    firstNumber = input('Enter first number: ')
    secondNumber = input('Enter second number: ') 
    action = raw_input('Enter action(+,-,*,/) : ')
    result = calculating(firstNumber, secondNumber, action)
    print firstNumber, action, secondNumber, "=", result
    check = input('For continue enter any key...For exit enter 0 -> ')
