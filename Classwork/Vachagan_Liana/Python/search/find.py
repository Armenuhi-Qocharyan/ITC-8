import read

wk=raw_input("inpput workfile name: ")
mylist =read.ReadFile(wk)
if mylist != None:
    read.searchbyage(mylist)

