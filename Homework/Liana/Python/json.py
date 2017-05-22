def find (key, value):
    inputkey=raw_input("Enter key to find value: ")
    length=len(key)
    for i in range(0, length):
        if key[i] == inputkey:
            print value[i]

def check ():
    string = raw_input("Enter element: ")
    if string[:1] != "{" or string[-1:] != "}":
        print "Incorrect format"
        return
    else:
        string = string[:-1]
        string = string[1:]
    if string[-1:] == ",":
        print "Incorrect format"
        return
    else:
        string += ","

    key = ""
    value = ""
    a=0
    for i in string:
        a += 1
        if i == ":":
            key += string[:a]
            string = string[a:]
            a=0
        if i == ",":
            value += string[:a]
            string = string[a:]
            a=0
    key = key.split(':')
    value = value.split(',')
    key = key[:-1]
    value = value[:-1]
    if len(key) != len(value):
        print "Incorrect format"
        return
    find (key, value)
check()

