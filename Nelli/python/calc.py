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

first_number = input("enter a first number : ")
second_number = input("enter a second number : ")
operator = raw_input('enter operator + - * or / : ')
result = calculator(first_number, second_number, operator)
print "Result = ", result

