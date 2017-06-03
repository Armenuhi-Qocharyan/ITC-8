import argparse
def Main():
    parser = argparse.ArgumentParser()

    parser.add_argument("jsonstr",help="string json",type=str,nargs='+')
#    parser.add_argument("value",help="string value",type=str)
    args = parser.parse_args()
    #print args.jsonstr
    mydict={}
    for i in args.jsonstr:
        if i != None:
            print i
            i=i.replace("{","")
            i=i.replace(",","")
            i=i.replace("}","")
            mydict[i.split(':')[0]]=i.split(':')[1]
#            tmp= len(args.jsonstr)
    print mydict['key']

    #last=len(args.jsonstr(len(args.jsonstr)))
#    print len(args.jsonstr[len(args.jsonstr)-1])
#    print args.jsonstr[len(args.jsonstr)-1][len(args.jsonstr[len(args.jsonstr)-1])-1]
#    print args.jsonstr[0].split('"')
#    if args.jsonstr[0][0] == '{' and args.jsonstr[len(args.jsonstr)-1][len(args.jsonstr[len(args.jsonstr)-1])-1] == '}':
#        print "pakagcer@ normal en"
#    if args.jsonstr[0].split('key',)[0] == args.jsonstr[len(args.jsonstr)-0].split('key',)[0]:
#        print "pakagcer@ verji u skzbi normal en"

#    key=raw_input("input key")
#    value=raw_input("input value")
#    node={key:value}
#    print(node)
#    myList=[]
#    myList.append(node)
#    for p in myList: 
#        print(p)
#    tmp=raw_input("you want exit y/n\n")
#    if tmp != 'y':
#        Main()
Main()
