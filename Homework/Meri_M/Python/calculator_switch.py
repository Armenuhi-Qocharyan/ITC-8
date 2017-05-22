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

def mult(a,b):
    return a*b

def Main():
    num1 = input("Enter first number: ")
    num2 = input("Enter second number: ")
    choice = raw_input("Enter choice('+' / '-' / '*' / '/'):")

    swicher = {
        '+': add(num1, num2),
        '-': sub(num1, num2),
        '*': mult(num1, num2),
        '/': div(num1, num2),
    }
    print(swicher.get(choice, "Invaled Action"))

if __name__ == '__main__':
    Main()



