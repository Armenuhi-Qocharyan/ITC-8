#!/usr/bin/python

def getString( begin, end, string ) :
    return string[begin:end]
    
def isEnd( begin, string ) :
    return string.find("\"", begin + 1)
         

jsonString = raw_input("Enter json string \n example: \n   { \"Name\": \"Armen\", \"Age\": \"30\", },\n")
list1 = []
dictr={} 

brIndex = 0 #bracket index
strIndex = 0 #string index
isCorect = 1

while ( strIndex != len(jsonString) ) :
    if ( ( jsonString[strIndex] == "{" or jsonString[strIndex] == "[" ) ) :
        list1.insert(brIndex, jsonString[strIndex])
        brIndex += 1
    elif ( (brIndex > 0) and ( jsonString[strIndex] == "}" and list1[brIndex - 1] == "{" ) or ( jsonString[strIndex] == "]" and list1[brIndex - 1] == "[") ) :
        if ( ( strIndex + 1 ) < len(jsonString) ) and jsonString[strIndex + 1] == ',' :
            list1.pop()
            brIndex -= 1
            strIndex += 1

    elif (jsonString[strIndex] == "\"" ) :
        begin = strIndex
        end = isEnd(begin, jsonString)
        if ( end != -1 and ( ( end + 1) < len(jsonString) ) and jsonString[end + 1] == ":" ) :
            key = getString(begin + 1, end, jsonString)

        elif ( jsonString[end + 1] == "," and key != "") :
            value = getString(begin + 1, end, jsonString)
            dictr.setdefault(key, value)
        else :        
            isCorect = 0
            break
        strIndex = end + 1
     
    elif ( jsonString[strIndex] != " ") :
        isCorect = 0
        break
    strIndex += 1



if len(list1) != 0 or isCorect == 0:
    print ("This string is not json !!!")
else :
    print ("This string is corenct")

key = raw_input("pleas enter key : ")
print dictr[key])

