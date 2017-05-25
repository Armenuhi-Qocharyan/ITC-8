def readInFile():
    file = open("text.txt","r")
    myDict = {}
    for line in file:
        line = line.split(",")
        key =int(line[1][:-1])
        myDict.update({key:line[0]})
    file.close()
    findValue(myDict)

def findValue(myDict):
    findKey = input("Enter key to find value: ")
    for key,val in myDict.items():
        if findKey == key:
            print key,val
            return val
    else:
            print "Key not found"
            return None

if __name__ == '__main__':
    readInFile()

