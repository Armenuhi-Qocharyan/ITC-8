#!/usr/bin/python
import webbrowser
import sys

def readFromMongo(host, port):
	from pymongo import MongoClient
        client = MongoClient(host, int(port))
        db = client.ITC
        mystr = db.students.aggregate([{"$group": {"_id" : "$exam.subject", "myscore": {"$push": "$exam.score"} } }, {"$unwind":"$myscore"},{"$unwind":"$myscore"},{"$unwind": "$_id"},{"$group" :{"_id": "$_id","max": {"$max": "$myscore"},"min": {"$min": "$myscore"},"avg":{"$avg": "$myscore"}}}])
	return mystr

def main():

	mystr = readFromMongo(sys.argv[1],sys.argv[2])
	myfile = open('index.html','w')
	first = '<!DOCTYPE html><html><head><style>td {border-style: solid;}</style></head><body><table>'
	last = '</table></body></html>'
	mybody = '';
  	for item in list(mystr):
        	mybody += "<tr><td>"+str(item.get("_id"))+"</td><td>"+str(item.get("max"))+"</td><td>"+str(item.get("min"))+"</td><td>"+str(item.get("avg"))+"</td></tr>"                 
	mystr = first + mybody + last
	print(mystr)     	
	myfile.write(mystr)
	webbrowser.open('index.html')

if __name__ == "__main__":
	main()
