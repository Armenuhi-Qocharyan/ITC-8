import pymongo
import argparse
import pprint
from pymongo import MongoClient

def getDB():
    parser = argparse.ArgumentParser()
    parser.add_argument("host", default = "localhost", help = "host", type = str) 
    parser.add_argument("port", default = "27017", help = "port", type = int);
    args = parser.parse_args()
    client = MongoClient('localhost', 27017)    
    client.studentsDb.studentsColl.drop()
    db = client.studentsDb
    return db

def addCollection(db):
    db.studentsColl.insert({"name" : "aaa","surname":"aaaaa","exams":[{"itc":1,"subject":"c++",   "score":7},{"itc":2,"subject":"c++","score":9}]})
    db.studentsColl.insert({"name" : "bbb","surname":"bbbbb","exams":[{"itc":3,"subject":"python","score":5}, {"itc":4,"subject":"python","score":8}]})
    db.studentsColl.insert({"name" : "ccc","surname":"ccccc","exams":[{"itc":5,"subject":"JS",    "score":6}, {"itc":6,"subject":"JS","score":3}]})

def nameItcScore(db):
    for student in db.studentsColl.find({},{"_id":0, "name":1, "exams.itc":1,"exams.score":1}):
        print student


    for i in db.sales.aggregate([{"$group":{"$exams.subject":"$name","avgAmount":{ "$avg": "$exams.score" }}}]):
        print i

if __name__ == "__main__":
        db = getDB() 
        addCollection(db)
        nameItcScore(db)

