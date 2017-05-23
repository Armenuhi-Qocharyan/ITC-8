import argparse
import re
import sys

parser = argparse.ArgumentParser()
parser.add_argument("-c")
args = parser.parse_args()
s=args.c

def mysplit(mystr):
    return re.split("([+-/*])", mystr.replace(" ", ""))

arr=mysplit(s)
opr=''

if not(arr[0].isdigit() and arr[2].isdigit()):
    sys.exit("Please input only numbers")

num1=int(arr[0])
opr=arr[1]
num2=int(arr[2])

def sum (num1,num2):
    return num1+num2

def diff (num1,num2):
    return num1-num2 

def mult (num1,num2):
    return num1*num2

def div (num1,num2):
    if num2==0:
        sys.exit("Second number can't be 0")
    else:
        return num1/num2

result = {
    '+': sum(num1, num2),
    '-': diff(num1, num2),
    '*': mult(num1, num2),
    '/': div(num1,num2),
    }.get(opr, "Invalid operator")

print "%d %s %d = %d" % (num1, opr, num2, result)
