def main():
    inputJson = raw_input("Input Json >> ")
    if inputJson[0] != '{' or inputJson[-1] != '}':
        print "Wrong JSON! "
        return
    inputJson = inputJson[1:-1]
    list = inputJson.split(',')
    json = {}
    for i in range(0,len(list)):
        key = list[i].split(':')[0]
        value = list[i].split(':')[1]
        json[key] = value 
    
    key = raw_input("Input KEY to get Value >> ")
    print json[key]

main()
