
arrkey=[]       #List of keys
arrval=[]       #List of Values
length = 0



#This function checks the data
def check(arg,key,length):
    str1 = arg.split(':')
    if len(str1) != 2:
        print "Eror:Wrong input"
        exit(0)
    if str1[0][0] != '"' or str1[0][len(str1[0]) - 1] != '"':
        print "Eror:Wrong input"
        exit(0)
    str1[0] = str1[0][1:]
    str1[0] = str1[0][:-1]
    for i in range(length):
        if str1[0] == arrkey[i]:
            print "Eror:Keys are repeated"
            exit(0)
    arrkey.append(str1[0])
    arrval.append(str1[1])

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
l = len(string)
i = 0
first = ""
aposrt = 0
while i < (l - 1):
    i += 1
#    print i
    if string[i] == '"':
        if aposrt == 1:
            apostr = 0
            key1 = string[:i]
        else
            apostr += 1
    
    

'''
list = string.split(',')
l = len(list)
for i in range(l):
    check(list[i],key,length)
    length += 1
find(key, length)
print "Key not found"
'''
