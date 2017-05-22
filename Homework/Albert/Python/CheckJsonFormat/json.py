#correct format {a:1,b:2,c:3}

def findKey(keys, values):
    key=raw_input("Enter key: ")
    length=len(keys)
    for i in range(0, length):
        if keys[i] == key:
            print values[i]
            return values[i]
    else:
            print "Value not found"
            return

def checkJsonFormat ():
    string = raw_input("Enter string: ")
    if string[:1] != "{" or string[-1:] != "}" or string[-2:] == ",":
        print "Incorrect json format"
        return
    else:
        string = string[1:]
        string = string[:-1]
        string += ","

    key = ""
    value = ""
    index=0
    for i in string:
        index += 1
        if i == ":":
            key += string[:index]
            string = string[index:]
            index=0
        if i == ",":
            value += string[:index]
            string = string[index:]
            index=0
    key = key.split(':')
    value = value.split(',')
    key = key[:-1]
    value = value[:-1]
    if len(key) != len(value):
        print "Incorrect json format"
        return

    choose=1

    while choose != 0:
        choose=input("Press 0 - Exit, Press any key - find key: ")
        if choose == 0:
            return
        else:
            findKey(key, value)
    
checkJsonFormat()

