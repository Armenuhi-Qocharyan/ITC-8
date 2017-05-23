#find key by value
def find (key, value):
    inputkey=raw_input("Enter key to find value: ")
    length=len(key)
    for i in range(0, length):
        if key[i] == inputkey:
            print value[i]
            return
    print "can't find key"

#check and correct inputed string
def checkString ():
    string = raw_input("Enter element: ")
    if string[:1] != "{" or string[-1:] != "}":
        print "Incorrect format: input will start and end with symbols '{' '}'"
        return
    string = string[:-1]
    string = string[1:]
    if string[:1] != '"':
        print "Incorrect format"
        return
    if string[-1:] == ",":
        print "Incorrect format: last ',' shouldn't be"
        return
    string += ","
    check(string)

#check syntax and add key and value
def check (string):
    key = ""
    value = ""
    i = 0
    while i < len(string):
        if string[i] == ":":
            if string[i-1] == ' ':
                string = string[:i-1] + string[i:]
                i = i-1
            if string[i+1] == ' ':
                string = string[:i+1] + string[i+2:]
            if string[i-1] != '"':
                print "Incorrect brackets "
                return
            key += string[:i+1]
            string = string[i+1:]
            i=0
            continue
            
        if string[i] == ',':
            if string[i-1] != '"':
                if string[:i].isdigit():
                    value += string[:i+1]
                    string = string[i+1:]
                    i=0
                    continue
                else:
                    print "Incorrect value"
                    return
            if i+1 < len(string) and string[i+1] == ' ':
                string = string[:i+1] + string[i+2:]

            if i+1 < len(string) and string[i+1] != '"':
                print "Incorrect brackets "
                return
            value += string[:i+1]
            string = string[i+1:]
            i = 0
            continue
        i = i + 1
    correctKeyValue(key, value)

#correct and check key and value
def correctKeyValue(key, value):
    key = key.replace('"', "")
    value = value.replace('"', "")
    if ' ' in key:
        print "Incorrect: used space in key"
        return
    key = key.split(':')
    value = value.split(',')
    key = key[:-1]
    value = value[:-1]
    if len(key) != len(value) or len(key) > len(set(key)):
        print "Incorrect key or value"
        return
    find (key, value)
checkString()
