import pymongo
import argparse
import pprint
from pymongo import MongoClient

def getDB():
    parser = argparse.ArgumentParser()
    parser.add_argument("--host", default = "localhost", help = "host", type = str) 
    parser.add_argument("--port", default = "27017", help = "port", type = int);
    args = parser.parse_args()
    client = MongoClient('localhost', 27017)    
    client.studentsDb.studentsColl.drop()
    db = client.studentsDb
    return db

def addCollection(db):
    db.studentsColl.insert({"name" : "aaa","test":"1","surname":"aaaaa","exams":[{"itc":1,"subject":"c++",   "score":7},{"itc":2,"subject":"c++","score":9}]})
    db.studentsColl.insert({"name" : "bbb","test":"3","surname":"bbbbb","exams":[{"itc":3,"subject":"python","score":5}, {"itc":4,"subject":"python","score":8}]})
    db.studentsColl.insert({"name" : "ccc","test":"3","surname":"ccccc","exams":[{"itc":5,"subject":"JS","score":6}, {"itc":5,"subject":"c++","score":7}, {"itc":6,"subject":"JS","score":8}]})

def nameItcScore(db):
    for i in db.studentsColl.aggregate([{"$unwind":"$exams"},{"$group": {"_id":{"name":"$name","itc":"$exams.itc"}, "avg":{"$avg": "$exams.score"}}}]):
        print i

if __name__ == "__main__":
        db = getDB() 
        addCollection(db)
        nameItcScore(db)

