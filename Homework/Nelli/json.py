json = "{I:5,am:6,a:8,ro: ! }"

def is_valid_json(json):
    length = len(json)
    for i in range(1, length - 2):
        if json[i] == '{' or json[i] == '}':
            return 0
        if json[i] == '[' or json[i] == ']':
            return 0
    if json[0] == '{' and json[length - 1] == '}':
        return 1
    return 0
        
def is_valid_key(key):
    if key == '':
        return 0
    length = len(key)
    for i in range(0, length):
        if key[i] == '':
            return 0
        if key[i] == ',':
            return 0
        return 1

def get_keys_and_values(json):
    keys = []
    values = []
    i = 0
    arr1 = 0
    while (arr1 != -1):
        arr1 = json.find(',')
        arr = json.find(':')
        key = json[0 : arr]
        value = json[arr + 1  : arr1]
        if is_valid_key(key):
            print "key = ", key
            print "value =", value
            keys.append(key)
            values.append(value)
            i = i + 1
            json = json[arr1 + 1 : len(json)]
        else:
            print "Invalid key"
            return

if is_valid_json(json):
    get_keys_and_values(json[1 : len(json) - 1])
else:
    print "invalid"


