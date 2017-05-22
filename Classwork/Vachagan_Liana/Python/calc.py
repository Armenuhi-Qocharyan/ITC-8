import argparse

def add(a,b):
    val = a+b
    return val
def sub(a,b):
    val=a-b
    return val
def div(a,b):
    if b == 0:
        print ("Incorrect")
        return
    val = a/b
    return val
def multi(a,b):
    val = a*b
    return val
def Main():
    parser = argparse.ArgumentParser()

    group = parser.add_mutually_exclusive_group()
    group.add_argument("-a","--fadd",help="Performs addition",action="store_true")
    group.add_argument("-s","--fsub",help="Performs subtraction",action="store_true")
    group.add_argument("-d","--fdiv",help="Performs division",action="store_true")
    group.add_argument("-m","--fmulti",help="Performs multiplication",action="store_true")
    
    parser.add_argument("num1",help="Number1 to calculate",type=int)
    parser.add_argument("num2",help="Number2 to calculate",type=int)
    args = parser.parse_args()

    if args.fadd:
        print("The addition result of {} and {} is {}".format(args.num1,args.num2,(add(args.num1,args.num2))))
    elif args.fsub:
        print("The subtraction result of {} and {} is {}".format(args.num1,args.num2,(sub(args.num1,args.num2))))
    elif args.fdiv:
        print("The division result of {} and {} is {}".format(args.num1,args.num2,(div(args.num1,args.num2))))
    elif args.fmulti:
        print("The multiplication result of {} and {} is {}".format(args.num1,args.num2,(multi(args.num1,args.num2))))
    else:
        print("Error:Requires an argument to perform an action")
Main()
