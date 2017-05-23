def isValedJson(jsonTxt):
    length = len(jsonTxt)
    if jsonTxt[0] != "{" or jsonTxt[-1] != "}": 
        print "1.This string isn't json format!"
        return
    else:
     # cat { and } from jsonTxt string 
        jsonTxt = jsonTxt[1:-1]
        for index in jsonTxt:
            if index == ":": 
                i = 0
                key = ""
                while (jsonTxt != index):
                    key += jsonTxt[i] 
                    if jsonTxt[i] == " ":
                        print "2.This string isn't json format!"
                        return 
                    i += 1
                length = len(jsonTxt)
                jsonTxt = jsonTxt[i + 1:length + 1]
            if index != " ":
                print "4.This string isn't json format!"
                return 
            else:
                index = jsonTxt[1:length-1]
            if index != "'":
                print "5.This string isn't json format!"
                return
            else:
                j = 1
                value = ""
                while (jsonTxt[j] != "'"):
                    value += jsonTxt[j] 
                    j += 1
                length = len(jsonTxt)
                jsonTxt = jsonTxt[j + 1 : length]
            if jsonTxt[0] != ",":
                print "6.This string isn't json format!"
                return
            else:
                jsonTxt = jsonTxt[1:length-1]
   
jsonText = raw_input("Enter string with json format: ")
isValedJson(jsonText)
