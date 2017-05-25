import re

s=[]

def push(value):
    s.append(value)

def pop():
    s.pop()

key=[]
value=[]

def checkSyntax(json):
    json.replace(" ", "")
    if len(json)==2:
        return 1
    if not checkBrackets(json):
        return 0
    else:
        arr=re.split(r', (?=(?:"[^"]*?(?: [^"]*)*))|, (?=[^",]+(?:,|$))', json)
        length=len(arr)
        for i in range(0,length):
            obj = re.search(r'"(.*)":"(.*)"|"(.*)":[(.*)]|"(.*)":{(.*)}|"(.*)":\d+', arr[i])
            if obj:
                key.append(obj.group(1))
                value.append(obj.group(2))
            else:
                return 0
    return json

def checkBrackets(json):
    length = len(json)
    if json[0] == '{' and json[length - 1] == '}' or json[0]=='[' and json[length - 1]==']':
        top = 0
        push('')
        for i in range(1, length - 1):
            if json[i] == '{' or json[i] == '[':
                top += 1
                push(json[i])
            elif json[i] == '}':
                if s[top] == '{':
                    top -= 1
                    pop()
                else:
                    return 0
            elif json[i] == ']':
                if s[top] == '[':
                    top -= 1
                    pop()
                else:
                    return 0
        if top==0:
            return 1
        return 0
    else:
        return 0

def isUnique():
    keyLen = len(key)
    for i in range(0, keyLen):
        for j in range(i + 1, keyLen):
            if key[i] == key[j]:
                return 0
    return 1

def main():
    JSON=raw_input("Input json - ")
    if JSON=='':
        print "No json object"
        return
    if JSON==0 or JSON==1:
        print "Syntax error"
        return
    newJson=checkSyntax(JSON)
    if newJson==0:
        print "Syntax error:"
        return
    if not isUnique():
        print "Keys arn't unique:"
        return
    tempKey=raw_input("input key - ")
    keyLen=len(key)
    for i in range(0, keyLen):
        if tempKey==key[i]:
            print "value = " + value[i]
            return
    print "No such key:"

main()
