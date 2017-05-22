def sum (a,b):
    return a+b

def diff (a,b):
    return a-b

def mult (a,b):
    return a*b

def div (a,b):
    return a/b

a=input('input first number- ')
b=input('input second number- ')
act=raw_input('input action ')


if act=="+":
    print sum(a,b) 
else:
    if act=="-":
        print diff(a,b)
    else:
        if act=="*":
            print mult(a,b)
        else:
            if act=="/":
                print div(a,b)
            else:
                print "Wrong action"
