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

#first = input("Enter first number  : ")
#second = input("Enter second number: ")
#operator = raw_input("Enter choice(+ - * or /): ")

'''
switch = {
    '+': add(first, second),
    '-': sub(first, second),
    '*': mul(first, second),
    '/': div(first, second),
}
'''
#print "Result = ",(switch.get(operator, "Invaled Action"))
