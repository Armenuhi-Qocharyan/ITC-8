#!/usr/bin/python
import argparse 
print "Input number"
var1 = input('Input your first number: ')
var2 = input('Input your second number: ')
opr = raw_input("Input operation with them: ")


def calculate(opr, var1, var2):
    if opr == "+":
        print "%d + %d = %d " % (var1, var2, var1 + var2)
    elif opr == "-":
        print "%d - %d = %d " % (var1, var2, var1 - var2)
    elif opr == "/":
        print "%d / %d = %d " % (var1, var2, var1 / var2)
    elif opr == "*":
        print "%d * %d = %d " % (var1, var2, var1 * var2)
    else:
        print "incorrect operation"
    return

calculate(opr,var1,var2)






