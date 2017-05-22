#run $python calculatorUseArgParse.py --action number1 number2
#                                     --add 5 5

import argparse

def add(first, second):
    return first + second

def sub(first, second):
    return first - second

def mul(first, second):
    return first * second

def div(first, second):
    if second != 0 :
        return first / second
    else:
        print "Division on 0 "
        return


def Main():
    parser = argparse.ArgumentParser()
 
    group = parser.add_mutually_exclusive_group()
    group.add_argument("-a","--add",help="Addition 2 numbers",action="store_true")
    group.add_argument("-s","--sub",help="Subtraction 2 numbers",action="store_true")
    group.add_argument("-d","--div",help="Division 2 number",action="store_true")
    group.add_argument("-m","--multi",help="Multiplication 2 number",action="store_true")
 
    parser.add_argument("first",help="Number1 to calculate",type=float)
    parser.add_argument("second",help="Number2 to calculate",type=float)
 
    args = parser.parse_args()
     
    if args.add:
        print("{} + {} = {}".format(args.first,args.second,(add(args.first,args.second))))
    elif args.sub:
        print("{} - {} = {}".format(args.first,args.second,(sub(args.first,args.second))))
    elif args.div:
        print("{} / {} = {}".format(args.first,args.second,(div(args.first,args.second))))
    elif args.mul:
        print("{} * {} = {}".format(args.first,args.second,(mul(args.first,args.second))))
    else:
        print("Error:Requires an argument to perform an action")
 
if __name__ == '__main__':
    Main()
