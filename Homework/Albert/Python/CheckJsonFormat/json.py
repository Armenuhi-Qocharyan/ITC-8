def checkRepeatingKey(keys):
    length=len(keys)
    if length == 1:
        return 1
    for i in range(0, length):
        for j in range(i+1, length):
            if keys[i] == keys[j]:
                print "Key repeated.Invalid json format"
                return 0
    else:
        return 1

def checkCountKeyEqualCountValue(keys, values):
    keyIndex=0
    for i in keys:
        if i == '':
            print "Empty key.Incorrect json format"
            return 0
        else:
            while keyIndex < len(i):
                if i[keyIndex] == " ":        
                    print "key contain space.Incorrect json format"
                    return 0
                keyIndex += 1
    for i in values:
        if i == '':
            print "Empty Value...Incorrect json format"
            return 0
    if len(keys) != len(values):
        print "Incorrect json format"
        return 0
    return 1


def checkKeyValid(keys):
    length=len(keys)
    for i in range(0, length):
        if keys[i][:1] != '"' or keys[i][-1:] != '"':
            print "Invalid json format(key is incorrect)"
            return 0
        else:
            keys[i] = keys[i][1:]
            keys[i] = keys[i][:-1]
    else:
            return 1


def checkValueValid(values):
    length=len(values)
    j=0
    floatIndex=0
    for i in range(0, length):
        if values[i] == "true" or values[i] == "false" or values[i] == "null":
            return 1
        if values[i][:1] == '"' and values[i][-1:] == '"': 
            values[i] = values[i][1:]
            values[i] = values[i][:-1]
            return 1
        else:
            while j < len(values[i]):
                if values[i][j] == '.':
                    if j > 0 and j < len(values[i])-1:
                        if floatIndex > 0:
                            print "Incorrect json format(value is incorrect float number)"
                            return 0
                        j += 1
                        floatIndex += 1
                    else:
                        print "Incorrect json format(value is incorrect float number)"
                        return 0
                
                if values[i][j].isdigit() == 0:
                    print "Incorrect json format(value is incorrect)"
                    return 0
                j += 1
            j=0
    else:
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
            return None

def checkJsonFormat():
    string = raw_input("Enter string: ")
    if string[:1] != "{" or string[-1:] != "}" or string[-2:] == ",":
        print "Incorrect json format"
        return
    else:
        if len(string) == 2:
            print "Correct json format.But json is empty!"
            return 0
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

    if checkKeyValid(key) == 0 or checkValueValid(value) == 0:
        return 0
    
    if checkCountKeyEqualCountValue(key, value) == 0:
        return 0

    choose = 1
    if checkRepeatingKey(key) == 1:
        while choose != 0:
            try:
                choose=input("Press 0 - Exit, Press any number - Find key: ")
            except Exception:
                print "Enter only number! Programm exit"
                return 0
            finally:
                pass
            if choose == 0:
                return 0
            else:
                findKey(key, value)
    else:
        return 0

checkJsonFormat()
