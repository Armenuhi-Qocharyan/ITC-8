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

num1=input("enter first number: ")
num2=input("enter second number: ")
while 1:
    oper=raw_input("enter operator: ")
    if oper == "+" or oper == "-" or oper == "*" or oper == "/":
        break
    else:
        print "Incorrect operator: try again"
def switch(x):
    return {
            '+' : add,
            '-' : sub,
            '*' : multi,
            '/' : div,
    }[x](num1,num2)
switch(oper)
