#!/usr/bin/python
import re

def searchData(key) :
    dataFile = open('people.txt','r')

    for line in dataFile :
        if  key  in line  : 
            pattern=r'[^'+ key+']\w+'
            if ( key.isdigit() == 1 ) :
                pattern += '\D'
            else :
                pattern += '\d'
            print re.findall(pattern,line)
    
def main() :    
    key=raw_input("Enter age or name surname : ")
    searchData(key)

if ( __name__ == "__main__") :
    main()
