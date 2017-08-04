import argparse

def add(num1,num2):
    print num1+num2
    return
def sub(num1,num2):
    print num1-num2
    return
def div(num1,num2):
    if num2 == 0:
        print ("Incorrect")
        return
    print num1/num2
    return 
def multi(num1,num2):
    print num1*num2
    return

parser = argparse.ArgumentParser()

parser.add_argument("num1",help="Number1 to calculate",type=int, action='store')
parser.add_argument("num2",help="Number2 to calculate",type=int, action='store')
parser.add_argument("operator",help="Operation to do with numbers(x for mult)",type=str, action='store')
args = parser.parse_args()
num1=args.num1
num2=args.num2
operator = args.operator

def switch(x):
    return {
            "+" : add,
            "-" : sub,
            "x" : multi,
            "/" : div,
    }[x](num1,num2)

switch(operator)
