def ReadFile(workfile):
    try:
        mylist=list()
        myfile=open(workfile, "r")
        #print myfile.readline(2)
        for line in myfile:  
            line=line.split(',')
            if len(line) == 3:
                line[2] = line[2].rstrip('\n')
                mydict={line[0]:[line[1],line[2]],line[2]:[line[0],line[1]],line[1]:[line[0],line[2]]}
                mylist.append(mydict)
            else:
                print "Incorrect file format"
                return None
        return mylist
    except IOError:
        print "Error: File does not appear to exist."
        return None

def searchbyage (mylist):
    key = raw_input("Enter age/name/surname to find name/surname: ")
    for i in range(0,len(mylist)):
        if mylist[i].get(key) != None:
            print key +": " + mylist[i].get(key)[0] +" "+mylist[i].get(key)[1] 
#wk=raw_input("inpput workfile name: ")
#mylist =ReadFile(wk)
#searchbyage(mylist)
