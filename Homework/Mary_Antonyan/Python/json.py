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
def isValid(json, start):
    print "Function isValid\n"
    return True
    
# Function returns json-like dictionary in the reult of processing json string
# param - string: Checked json string
# return - dictionary: returns associative array with keys and values
def getDictionary(json):
    print "Function getDictionary\n"
    return

# Function checks if the keys in json are unique or not
# param - string: String which is json key and string which is checked json
# return - boolean: returns true if the keys are unique
def isUniqueKey(key, dictionary):
    print "Function isUniqueKey\n"
    return True


# Function returns the value corresponding to the key in json
# param - string: String which is json key
#         dictionary: Json-formatted associative array
# return - mixed: returns the value associative with given key in json
def getValue(key, dictionary):
    print "Function getValue\n"
    return "value"

# Main function
# param - none
# return - mixed: returns the search result
def main():
    if isValid(json, 0):
        dictionary = getDictionary(json)
        if isUniqueKey(key, dictionary):
            return getValue(key, dictionary)
        else:
            print "Keys are not unique"
            return None
    else:
        print "Is not valid json-type string"
        return None

# Driver
# Gets result and prints it
value = main()
if value != None:
    print "key: " + key + "\nValue: " + value
