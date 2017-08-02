import argparse
import sys, traceback #for use sys.exit(0)

def add(a, b) :
    return a + b
 
def sub(a, b) :
    return a - b
 
def div(a, b) :
    if 0 == b:
        print ("Incorrect value.\n")
        return -1
    return  a / b
 
def mult(a, b) :
    return a*b

def action(num1, num2, action) :
    switcher = {
        "+": add(num1, num2),
        "-": sub(num1, num2),
        "*": mult(num1, num2),
        "/": div(num1, num2),
    }
    return  switcher.get(action)

def Main():
    parser = argparse.ArgumentParser()
    parser.add_argument("act",default="+",help="Action calculate",action="store",type=str) 
    parser.add_argument("num1",help="Number1 ",type=int)
    parser.add_argument("num2",help="Number2 ",type=int)

    args = parser.parse_args()
    value = action(args.num1, args.num2, args.act)
    if -1 == value : 
        sys.exit()
    print ("{} + {} = {}".format(args.num1, args.num2, value))
 
if __name__ == '__main__' :
    Main()
