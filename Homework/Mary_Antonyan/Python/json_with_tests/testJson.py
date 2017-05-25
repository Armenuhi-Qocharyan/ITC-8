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
