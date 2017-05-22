#To calculate you must write so $python calc.py --calc=2,+,6
import argparse
parser = argparse.ArgumentParser()
parser.add_argument("--calc",type=str, help="Sum of two numbers")
args = parser.parse_args()
list=args.calc.split(',')
a=int(list[0])
b=int(list[2])


def sum (a,b):
    return a+b

def diff (a,b):
    return a-b

def mult (a,b):
    return a*b

def div (a,b):
    return a/b

act=list[1]

if act=="+":
    print sum(a,b) 
else:
    if act=="-":
        print diff(a,b)
    elif act=="*":
        print mult(a,b)
    elif act=="/":
        print div(a,b)
    else:
        print "Wrong action"
