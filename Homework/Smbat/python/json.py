inputJson = raw_input("Input Json >> ")
if inputJson[0] != '{' or inputJson[-1] != '}':
    print "Wrong JSON! "
inputJson = inputJson[1:-1]
list = inputJson.split(',')
json = {}
for i in range(0,len(list)):
    json[list[i].split(':')[0]] = list[i].split(':')[1] 
print json['two']
