def validation(json):
    if json[0] != '{' and json[0] != '[':
        return 0
    scobes = ''
    chakert = 0
    verchaket = 0
    for i in range(0, len(json)):
        if chakert == 0:
            if json[i] == '{' or  json[i] == '[':
                scobes = scobes + json[i]
            elif (json[i] == '}' and scobes[-1] == '{') or (json[i] == ']' and scobes[-1] == '['):
                scobes = scobes[:-1]
            elif (json[i] == '}' and scobes[-1] != '{') or (json[i] == ']' and scobes[-1] != '['):
                return 0 
            elif json[i] == '"':
                chakert = 1
        else:
            print json[i]
            if json[i] == '"':
                chakert = 0
                if verchaket == 0 and json[i+1] == ':':
                    verchaket = 1
                    i++

            elif json[i].isalpha() == False and json[i].isdigit() == False:
                print "In chakert Wrong Simbool"
                return 0
    return 1

def main():
    inputJson = raw_input("Input Json >> ")
    print validation(inputJson)
    return

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
