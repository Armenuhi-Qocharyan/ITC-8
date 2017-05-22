import argparse
import sys, traceback #for use sys.exit(0)

def add(a,b):
    return a+b
 
def sub(a,b):
    return a-b
 
def div(a,b):
    if 0 == b:
        print ("Incorrect value.\n")
        sys.exit(0)
    return  a/b
 
def multi(a,b):
    val = a*b
    return val
 
def Main():
    parser = argparse.ArgumentParser()
 
    group = parser.add_mutually_exclusive_group()
    group.add_argument("--add",help="Performs addition",action="store_true")
    group.add_argument("--sub",help="Performs subtraction",action="store_true")
    group.add_argument("--div",help="Performs division",action="store_true")
    group.add_argument("--multi",help="Performs multiplication",action="store_true")
 
    parser.add_argument("num1",help="Number1 to calculate",type=int)
    parser.add_argument("num2",help="Number2 to calculate",type=int)
 
    args = parser.parse_args()
     
    if args.add:
        print("{} + {} = {}".format(args.num1,args.num2,(add(args.num1,args.num2))))
    elif args.sub:
        print("{} - {} = {}".format(args.num1,args.num2,(sub(args.num1,args.num2))))
    elif args.div:
        print("{} / {} = {}".format(args.num1,args.num2,(div(args.num1,args.num2))))
    elif args.multi:
        print("{} * {} = {}".format(args.num1,args.num2,(multi(args.num1,args.num2))))
    else:
        print("Error:Requires an argument to perform an action")
 
if __name__ == '__main__':
    Main()
