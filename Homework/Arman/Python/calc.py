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

a=int(arr[0])
b=int(arr[1])

def sum (a,b):
    print "%d + %d = %d " % (a, b,a+b)

def diff (a,b):
    print "%d - %d = %d " % (a, b, a-b)

def mult (a,b):
    print "%d * %d = %d " % (a, b, a*b)

def div (a,b):
    if b==0:
        sys.exit("Second number can't be 0")
    else:
        print "%d / %d = %d " % (a, b, a/b)

if opr=="+":
    sum(a, b)
else:
    if opr=="-":
        diff(a, b)
    elif opr=="*":
        mult(a, b)
    elif opr=="/":
        div(a, b)
    else:
        print "Wrong option"

'''
#use this but it's call all cases can' use break
opr = {
        '+': sum(a, b),
        '-': diff(a, b),
        '*': mult(a, b),
        '/': div(a,b),
}
'''
