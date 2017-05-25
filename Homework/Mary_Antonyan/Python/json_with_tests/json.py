import argparse

#Define the order of getting the arguments
parser = argparse.ArgumentParser(description='Processing Json-type string')
parser.add_argument('json', action='store', help='Enter json-formatted string')
parser.add_argument('key', action='store', help='Enter key to get value')
args = parser.parse_args()

#Get arguments given in command line
JSON = args.json
KEY = args.key

# Function checks the validity of json-formatted string
# param - string: String which must be checked
# return - boolean: returns if the string is valid json or not  
def isValid(json, keys, values):
    end = len(json) - 1

    # Empty json
    if json[0] == '{' and json[end] == '}' and end == 1:
        return True

    if json[0] != '{' or json[end] != '}':
        return False
    json = json[1:(end - 1)]

    end = len(json) - 1
    if json[end] != '"' and json[end] != '}' and json[end] != ']' and not(json[end].isdigit):
        return False
#    elif not(json[end].isdigit):
 #       json = json[:-1]

    #Function which gets Key or Value
    def getKeyOrValue(json, array, char):
        current = 0
        item = ""
        while current < len(json) and json[current] != char:
            item += json[current]
            current += 1
        json = json[(current + 1):]
        array.append(item)
        return json

    index = 0
    while index < len(json):
        index += 1
        if json[0] != '"':
            return False
        json = json[1:] 
        json = getKeyOrValue(json, keys, '"')

        if json[0] == ':':
            json = json[1:]    
            if json[0] == '"':
                json = json[1:]
                json = getKeyOrValue(json, values, '"')
                if len(json) == 0:
                    return True
                elif json[0] == ',':
                    json = json[1:]
                else:
                    return False
            else:
                json = getKeyOrValue(json, values, ',')
        else:
            return False
    return True

# Function checks if the keys in json are unique or not
# param - string: String which is json key and string which is checked json
# return - boolean: returns true if the keys are unique
def isUniqueKey(keys):
    for item in keys:
        if item == '':
            return False
    return len(keys) == len(set(keys))


# Function returns the value corresponding to the key in json
# param - string: String which is json key
#         dictionary: Json-formatted associative array
# return - mixed: returns the value associative with given key in json
def getValue(key, keys, values):
    current = 0
    while current < len(keys):
        if key == keys[current]:
            return values[current]
        current += 1
    return None


# Main function
# param - none
# return - mixed: returns the search result
def main():
    keys = []
    values = []
    if isValid(JSON, keys, values):
        if isUniqueKey(keys):
            return getValue(KEY, keys, values)
        else:
            print "Keys are not unique or there is empty key"
            return 1
    else:
        print "Is not valid json-type string"
        return 2


# Driver
# Gets result and prints it
if JSON == '':
    print "Empty Json string"
elif KEY == '':
    print "Empty key"
else:
    value = main()
    if value == None:
        print "There is no given key"
    elif value == '':
        print "Corresponding value to this key is empty"
    elif value != 1 and value != 2:
        print "key: " + KEY + "\nValue: " + value

