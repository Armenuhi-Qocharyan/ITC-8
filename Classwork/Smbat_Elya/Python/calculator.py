def sum(var1, var2):
    return var1 + var2
def sub(var1, var2):
    return var1 - var2
def mul(var1, var2):
    return var1 * var2
def div(var1, var2):
    return var1 / var2

import argparse
parser = argparse.ArgumentParser()
parser.add_argument("-c", type=str)
args = parser.parse_args()
list=args.c.split(',')
print list[0]
firstValue=int(list[0])
action=list[1]
secondValue=int(list[2])

check=1
if action == "+":
    result = sum(firstValue, secondValue)
if action == "-":
    result = sub(firstValue, secondValue)
if action == "*":
    result = mul(firstValue, secondValue)
if action == "/":
    if 0 == secondValue:
        print "INVALED VALUE, DIV BY ZERO\nStart agein"
    result = div(firstValue, secondValue)
if action != "+" and action != "-" and action != "*" and action != "/": 
    print('INVALED ACTION\nStart agein')
print firstValue, action, secondValue, "=", result
