import argparse

parser = argparse.ArgumentParser(description='json load and print')
parser.add_argument('-i','--inputstring', '-s', '--string', help='Input String in JSON format',required=True)
args = parser.parse_args()
b = []
inp = args.inputstring
print len(inp)
key=''
a = []
key_list = []
value_list =[]
for i in inp:
    if i == '{':
        b.append(i)
    elif i == '}':
        b.pop()
    elif i == ':':
        a.append(i)
        key_list.append(key)
        key=''
    elif i == ',':
        if a[-1] == ':':
            a.pop()
            value_list.append(key)
            key = ''
        else:
            print "dont valid"
            exit()
    else:
        key+=i
print a
print b
print key_list
print value_list
