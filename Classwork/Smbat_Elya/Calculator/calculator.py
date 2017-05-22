#import argparse

def sum(var1, var2):
    return var1 + var2
def sub(var1, var2):
    return var1 - var2
def mul(var1, var2):
    return var1 * var2
def div(var1, var2):
    return var1 / var2
check=1
while (0 != check):
    firstValue = input('Enter first value: ')
    action = raw_input('Enter action(+,-,*,/) : ')
    secondValue = input('Enter second value: ') 
    if action == "+":
        result = sum(firstValue, secondValue)
    if action == "-":
        result = sub(firstValue, secondValue)
    if action == "*":
        result = mul(firstValue, secondValue)
    if action == "/":
        if 0 == secondValue:
            print "INVALED VALUE, DIV BY ZERO\nStart agein"
            continue
        result = div(firstValue, secondValue)
    if action != "+" and action != "-" and action != "*" and action != "/": 
        print('INVALED ACTION\nStart agein')
        continue
    print firstValue, action, secondValue, "=", result
    check = input('For continue enter any key...For exit enter 0 -> ')
