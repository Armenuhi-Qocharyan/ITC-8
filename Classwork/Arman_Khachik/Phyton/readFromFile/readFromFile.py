import re

def getContact(contact, b):
    f=open("data.txt","r")
    noContact=True
    for i in f:
        s=i.split(" ")
        s[2] = s[2][:-1]
        if s[b]==contact:
            print s[0] + " " + s[1] + " " + s[2]
            noContact=False

    return noContact        

def start():
    temp=raw_input("Input name or age - ")
    isNumber=re.search("\d+",temp)
    
    if isNumber:
        b=2
        a=getContact(temp,b)
    else:
        b=0
        a=getContact(temp,b)
    
    if a:
        print "No such contact"

start()
