def find (keys, values):
    inputkey=raw_input("Enter key to find value: ")
    length=len(keys)
    for i in range(0, length):
        if keys[i] == inputkey:
            print values[i]
            return
        print "Key not found"

def is_float(value):
    try:
        float(value)
        return 1
    except ValueError:
        return 0

def is_valid_value (value):
    if value[0] == '"' and value[len(value) - 1] == '"':
        return 1
    if value == "False":
        value = False
        return 1
    if value == "True":
        value = True
        return 1
    if value == "None":
        value = None
        return 1 
    if value.isdigit():
        value = int(value)
        return 1
    if is_float(value):
        value = float(value)
        return 1
    print "Incorrect value"
    return 0

def is_valid_key (key):
    if key == "":
        print "Incorrect key"
        return 0
    chars = set('{}[],')
    if any ((c in chars) for c in key):
        print "Incorrect key"
        return 0
    return 1

def is_valid_json(json):
    length = len(json)
    if (json[0] == '{' and json[length - 1] == '}'): 
                stack = []
                top = 0
                key = ""
                value = ""
                order = "key"
                keys = []
                values = []
                if length == 2:
                    return 1
                if json[1] != '"':
                    return 0
                for i in range(1, length):
                    if json[i] == '"':
                        if json[i - 1] == '\\' and order == "value":
                            value = value[0 : len(value) - 2]
                            value = value + '"'
                        else:
                            if order == "key":
                                if top == 0:
                                    stack.append('"')
                                    top = top + 1
                                else:
                                    if stack[top - 1] != '"':
                                        return 0
                                    else:
                                        del stack[top - 1]
                                        top = top - 1
                                        if json[i + 1] != ':':
                                            return 0
                                        if not is_valid_key(key):
                                            return 0
                                        order = "value"        
                                        keys.append(key)
                                        key = ""
                                         
                            else:
                                if top == 0:
                                    stack.append('"')
                                    top = top + 1
                                    value = value + '"'
                                else:
                                    if stack[top - 1] != '"':
                                        return 0;
                                    else:
                                        del stack[top - 1]
                                        top = top - 1
                                        if json[i + 1] != ',' and json[i + 1] != '}':
                                            return 0
                                            
                                        value = value + '"'
                    elif json[i] == ':':
                        if json[i - 1] != '"':
                            return 0
                        if json[i + 1] == '}':
                            return 0
                        order = "value"
                    elif json[i] == ',':
                        if top == 0 and order == "value":
                            if value[0] == '"' and value[len(value) - 1] == '"':
                                values.append(value)
                                value = ""
                                order = "key"

                            else:
                                                         
                                if not is_valid_value(value):
                                    return 0
                                values.append(value)
                                value = ""
                                order = "key"
                        elif top == 0 and order == "key":
                            return 0
                        elif top == 1 and stack[top - 1] == '"':
                            value = value + ','
                    elif json[i] == '}' and i == length - 1:
                        if top != 0:
                            return 0
                        if not is_valid_value(value):
                            return 0
                        values.append(value)
                        if len(keys) > len(set(keys)) or len(keys) != len(values):
                            return 0
                        find(keys,values)
                        return 1
                    else:
                        if order == "key":
                            key = key + json[i]
                           
                        else:
                            value = value + json[i]
                
                if len(keys) > len(set(keys)) or len(keys) != len(values):
                    return 0
                find(keys,values)
                return 1
    else:
        return 0

json = raw_input("Enter json : ") 
json = json.replace(" ","")
print json
if not is_valid_json(json):
    print "Incorrect json format"


