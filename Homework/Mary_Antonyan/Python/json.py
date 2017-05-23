import argparse

#Define the order of getting the arguments
parser = argparse.ArgumentParser(description='Processing Json-type string')
parser.add_argument('json', action='store', help='Enter json-formatted string')
parser.add_argument('key', action='store', help='Enter key to get value')
args = parser.parse_args()

#Get arguments given in command line
json = args.json
key = args.key

# Function checks the validity of json-formatted string
# param - string: String which must be checked
# return - boolean: returns if the string is valid json or not  
def isValid(json, keys, values):
    end = len(json) - 1
    if json[0] != '{' or json[end] != '}':
        return False
    json = json[1:(end - 1)]
    if json[0] != '"':
        return False
    json = json[1:]
    checkHelper(json, keys, values)
    return True


# Function checks the json validity and creates lists
# param - string: Json string
# return - None
def checkHelper(json, keys, values):
    current = 0
    key = ""
    value = ""
    while (current < len(json) and json[current] != '"'):
        key += json[current]
    json = json[(current + 1):]
    keys.append(json[current])

    current = 1
    if json[0] == ':':
        while json[current] != ',':
            value += json[current]
        json = json[(current + 2):]
        values.append(json[current])
        

# Function checks if the keys in json are unique or not
# param - string: String which is json key and string which is checked json
# return - boolean: returns true if the keys are unique
def isUniqueKey(key, keys):
    print "Function isUniqueKey\n"
    for item in keys:
        if key == item:
            return False
    return True


# Function returns the value corresponding to the key in json
# param - string: String which is json key
#         dictionary: Json-formatted associative array
# return - mixed: returns the value associative with given key in json
def getValue(key, keys, values):
    print "Function getValue\n"
    current = 0
    while current < len(keys):
        if key == keys[current]
        return values[current]
    return None


# Main function
# param - none
# return - mixed: returns the search result
def main(json):
    keys = []
    values = []
    if isValid(json, keys, values):
        if isUniqueKey(key, keys):
            return getValue(key, keys, values)
        else:
            print "Keys are not unique"
            return None
    else:
        print "Is not valid json-type string"
        return None


# Driver
# Gets result and prints it
value = main(json)
if value != None:
    print "key: " + key + "\nValue: " + value
