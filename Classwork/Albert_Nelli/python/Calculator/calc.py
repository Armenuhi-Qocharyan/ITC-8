import argparse

def summa(first, second):
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

def calculator(first_number, second_number , operator):
    switch = {
        '+': summa(first_number, second_number),        
        '-': sub(first_number, second_number),        
        '*': mul(first_number, second_number),        
        '/': div(first_number, second_number),        
    }
    return switch.get(operator, "invalid")

'''    if operator == '+':
    if operator == '+':
        return summa(first_number, second_number)
    elif operator == '-':
        return sub(first_number, second_number)
    elif operator == '*':
        return mul(first_number, second_number)
    elif operator == '/' and second_number != 0:
        return div(first_number, second_number)
    else:
        print "Incorrect operator "
operator = {
    '+': re,
    '-': 10**-2,
    '*': 10**-1,
    '/': 1,
}

first_number = input("enter a first number : ")
second_number = input("enter a second number : ")
operator = raw_input('enter operator + - * or / : ')
result = calculator(first_number, second_number, operator)
print "Result = ", result
'''
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
    print("The multiplication result of {} and {} is {}".format(args.num1,args.num2,(mul(args.num1,args.num2))))
else:
    print("Error:Requires an argument to perform an action")
