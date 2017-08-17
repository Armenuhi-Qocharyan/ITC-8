#This program simulates the operation of an json

arrkey=[]       #List of keys
arrval=[]       #List of Values
bracket=[]
length = 0
boolian = 1
#This function checks the data
def check(arg,key,length):
    str1 = arg.split(':', 1)
    if len(str1) != 2:
        print "Eror:Wrong input"
        return 0
    if str1[0][0] != '"' or str1[0][len(str1[0]) - 1] != '"':
        print "Eror:Invalid key"
        return 0
    str1[0] = str1[0][1:]
    str1[0] = str1[0][:-1]
    if str1[1][0] != '"' and str1[1][0] != "{" and str1[1][0] !="[":
        for i in range(len(str1[1]) - 1):
            if not isinstance( str1[1][i], int ):
                print "Error:Wrong value(value is not valid)"
                return 0
    if str1[1][0] == '"':
        if str1[1][len(str1[0]) - 1] != '"':
            print "Error:Invalid value"
            return 0
        str1[1] = str1[1][1:]
        str1[1] = str1[1][:-1]
    if str1[1][0] == "{" or str1[1][0] == "[":
        for i in range(len(str1[1])):
            if str1[1][i] == "{" or str1[1][i] == "[":
                bracket.append(str1[1][i])
            if str1[1][i] == "}" or str1[1][i] == "]":
                if str1[1][i] == "}" and bracket[len(bracket) - 1] != "{": 
                    print "Error:Wrong brackets in value"
                    return 0
                if str1[1][i] == "]" and bracket[len(bracket) - 1] != "[": 
                    print "Error:Wrong brackets in value"
                    return 0
                bracket.pop()
        if len(bracket) != 0:
            print "Error: Wrong barckets in value"
            return 0
    for i in range(length):
        if str1[0] == arrkey[i]:
            print "Eror:Keys are repeated"
            return 0
    arrkey.append(str1[0])
    arrval.append(str1[1])
    return 1

#This function findes value by key
def find(key, length):
    for i in range(length):
        if key == arrkey[i]:
            print "Value - " + arrval[i]
            exit(0)

string = raw_input('Input your json: ')
key = raw_input('input key: ')
string = string.replace(" ", "")
if string[0] != "{" or string[len(string) - 1] != "}":
    print "Eror:Wrong input (Check brackets)"
    exit(0)
string = string[1:]
string = string[:-1]
list = string.split(',')
l = len(list)
for i in range(l):
    if not check(list[i],key,length):
        boolian = 0
    length += 1
if boolian != 0:
    find(key, length)
    print "Key not found"
