import math

#Enter first number
try:
    a = float(raw_input("Enter first number: "))
except ValueError:
    print "Not a number\n"
    exit()

#Enter operation
oper = raw_input("Enter operation: ")

#Check operation: if it is 'sqrt', second argument is not required
if oper == 'sqrt':
    if a >= 0:
        print math.sqrt(a)
        exit()
    else:
        print "Negative number\n"
        exit() 

#Enter second number
try:
    b = float(raw_input("Enter second number: "))
except ValueError: 
    print "Not a number\n"
    exit()

#Count expression value
if oper == '+':
    print a + b
elif oper == '-':
    print a - b
elif oper == '/':
    if b != 0:
        print a / b
    else:
        print "Division by zero"
elif oper == '*':
    print a * b
elif oper == 'pow':
    try:
        print math.pow(a, b)
    except ValueError:
        print "Can't get ", b, " power of ", a
        exit()
else:
    print 'Unknown operator'
