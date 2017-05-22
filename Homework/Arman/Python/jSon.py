import sys

string = "{'a': 15, 'v': 154, 'ka': 487, 'ssd': 748, 'ba': 14, 'ze': 144, 'chka': 488, 'sdd': 458}"
print string
key = raw_input("Input key - ") 
length=len(string)


if string[0] != '{' or string[length-1] != '}':
    sys.exit("Please input correct string")

value=''


def isUnique():
    counter=0
    temp=string.split(',')
    for i in temp:
        if key in temp:
            counter+=1
    return counter < 1


if isUnique()==0:
    sys.exit("String is not unique")


if key in string:
    index=string.find(key)
    end=index+len(key)
    count1=0    #not added
    count2=0    #not added
    for i in range(end,length):
        if string[i]=="'":
            count1+=1
        elif string[i]==':':
            count2+=1
        elif string[i]!=' ':
            value=value+string[i]


temp=value.split(',')
value=temp[0]
length=len(value)
if value[0]=='{':
    value=value.split('{')
    value=value[1]
elif value[length-1]=='}':
    value=value.split('}')
    value=value[0]

print "value=" + value
