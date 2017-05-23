json = '{"key":"5l","key1":[52]}'

def is_number(value):
    for i in range(0, len(value)):
        if value[i] < '0' or value[i] > '9':
            return 0
    return 1

def check_value(prew_index, top, json):
    if json[prew_index] == '[':
        array = json[prew_index : top]
        for i in range(0, len(array)):
            if array[i] >= '0' and array[i] <= '9' or array[i] == ',':
                return 1
            return 0
    elif json[prew_index] == '{':
        json = json[prew_index : top]
        return is_valid_json(json)
    elif json[prew_index] == '"':
        return 1
    else:
        return 0


def is_uniq_keys(keys):
    length = len(keys)
    for i in range(1, length):
        if keys[i] == keys[i - 1]:
            return 0
    return 1

def find_value_by_key(keys, values):
    inputkey = raw_input("Enter key to find value: ")
    length = len(keys)
    for i in range(0, length):
        if keys[i] == inputkey:
            print values[i]
            return
    print "can't find key"

def get_value(json):
    start = 0
    end = 0
    value = ""
    for i in range(len(json)):
	 if json[i] == '[':
            start = i
            json = json[start + 1 : len(json)]
            end = json.find(']')
            value = "[" + json[start : end] + "]"
            break
	 if json[i] == '{':
            start = i
            json = json[start + 1 : len(json)]
            end = json.find('}')
            value = "{" + json[start : end] + "}"
            break
         if json[i] == '"':
            start = i
            json = json[start + 1 : len(json)]
            end = json.find('"')
            value = '"' + json[start : end] + '"'
            break
         else:
            start = 0;
            end = json.find(',')
            value = json[start : end]
            if not is_number(value):
                value = ""
                return 0
            break
    return value
        


def is_valid_json(json):
    values = []
    keys = []
    length = len(json)
    if json[0] == '{' and json[length - 1] == '}':
        if length == 2:
            return 0
        prew_index = -1
        top = 0
        stack = []
        stack.append('')
        for i in range(1, length - 1):
            if json[i] == '{' or json[i] == '[':
                top = top + 1
                stack.append(json[i])
            elif json[i] == '}':
                if stack[top] == '{':
                    top = top - 1
                    del stack[top]
                else:
                    return 0
            elif json[i] == ']':
                if stack[top] == '[':
                    top = top - 1
                    del stack[top]
                else:
                    return 0
        if top== 0:
            return 1
        return 0
        
def is_valid_key(key):
    if key == '':
        return 0
    length = len(key)
    if key[0] == '"' and key[length - 1] == '"':
        for i in range(0, length):
            if key[i] == ' ':
                return 0
            if key[i] == ',':
                return 0
        return 1
    return 0

def get_keys_and_values(json):
    keys = []
    values = []
    i = 0
    index1 = 0
    while (index1 != -1 or index != -1):
        if json == '':
            break
        index1 = json.find(',')
        index = json.find(':')
        key = json[0 : index]
        if index1 == -1 and index != -1:
            index1 = len(json)
        elif index1 != -1 and index == -1:
            return 0
        value = get_value(json[index + 1:])
        if value == 0:
            return -1
        if is_valid_key(key):
            print "key = ", key[1 : len(key) - 1]
            print "value =", value
            keys.append(key[1 : len(key) - 1])
            values.append(value)
            i = i + 1
            json = json[index1 + 1 : len(json)]
        else:
            print "Invalid key "
            return 0
    if is_uniq_keys(keys):
        print "Keys are uniq"
        find_value_by_key(keys, values)
    else:
        print "Keys are not uniq please try again"
    return
if is_valid_json(json):
    get_keys_and_values(json[1 : len(json) - 1])
else:
    print "incorrect format!!!"


