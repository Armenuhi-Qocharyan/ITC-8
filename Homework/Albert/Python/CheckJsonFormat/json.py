#correct format {a:1,b:2,c:3}

def checkRepeatingKey(keys):
    length=len(keys)
    if length == 1:
        return 1
    for i in range(0, length):
        for j in range(i+1, length):
            if keys[i] == keys[j]:
                print "Key repeated...Invalid json format"
                return 0
    else:
        return 1

def checkCountKeyEqualCountValue(keys, values):
    for i in keys:
        if i == '':
            print "Empty key...Incorrect json format"
            return 0
    for i in values:
        if i == '':
            print "Empty Value...Incorrect json format"
            return 0
    if len(keys) != len(values):
        print "Incorrect json format"
        return 0
    return 1


def findKey(keys, values):
    key=raw_input("Enter key: ")
    lengthKeys=len(keys)
    for i in range(0, lengthKeys):
        if keys[i] == key:
            print "value = ", values[i]
            return values[i]
    else:
            print "Value not found"
            return

def checkJsonFormat():
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

    if checkCountKeyEqualCountValue(key, value) == 0:
        return

    choose = 1
    if checkRepeatingKey(key) == 1:
        while choose != 0:
            choose=input("Press 0 - Exit, Press any key - find key: ")
            if choose == 0:
                return
            else:
                findKey(key, value)
    else:
        return

checkJsonFormat()
