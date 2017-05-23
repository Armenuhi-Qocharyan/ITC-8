import argparse
import sys
parser = argparse.ArgumentParser()
parser.add_argument("-c")
args = parser.parse_args()
s=args.c

opr=''
for i in s:
    if i=="+" or i=="-" or i=="*" or i=="/":
        arr=s.split(i)
        opr=i
        break


#can't use not operator
if arr[0].isdigit() and arr[1].isdigit():
    print ''
else:
    sys.exit("Please input only numbers")

num1=int(arr[0])
num2=int(arr[1])

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
        '''
if opr=="+":
    sum(num1, num2)
else:
    if opr=="-":
        diff(num1, num2)
    elif opr=="*":
        mult(num1, num2)
    elif opr=="/":
        div(num1, num2)
    else:
        print "Wrong option"

'''
#use this but it's call all cases can't use break
result = {
    '+': sum(num1, num2),
    '-': diff(num1, num2),
    '*': mult(num1, num2),
    '/': div(num1,num2),
    }.get(opr, "Invalid operator")

print "%d %s %d = %d" % (num1, opr, num2, result)
