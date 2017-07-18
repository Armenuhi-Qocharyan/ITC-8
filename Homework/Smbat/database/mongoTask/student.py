import argparse
from pymongo import MongoClient

def getDB():
    parser = argparse.ArgumentParser()
    parser.add_argument("--host", default = "localhost", help = "type --host <host>", type = str) 
    parser.add_argument("--port", default = 27017, help = "type --port <port>", type = int);

    args = parser.parse_args()
    host = args.host
    port = args.port

    client = MongoClient(host, port)
    client.studentsDb.studentsColl.drop()
    db = client.studentsDb
    return db

def addCollection(db):
    db.studentsColl.insert({"name" : "aaa","surname":"aaaaa","exams":[{"itc":1,"subject":"c++",   "score":7},{"itc":2,"subject":"c++","score":9}]})
    db.studentsColl.insert({"name" : "bbb","surname":"bbbbb","exams":[{"itc":3,"subject":"python","score":5}, {"itc":4,"subject":"python","score":8}]})
    db.studentsColl.insert({"name" : "ccc","surname":"ccccc","exams":[{"itc":5,"subject":"JS","score":6}, {"itc":5,"subject":"c++","score":7}, {"itc":6,"subject":"JS","score":8}]})
    db.studentsColl.insert({"name" : "ddd","surname":"ddddd","exams":[{"itc":1,"subject":"JS","score":4}, {"itc":5,"subject":"c++","score":7}, {"itc":6,"subject":"python","score":8}]})

def nameItcScore(db):
    for result in db.studentsColl.aggregate([{"$unwind":"$exams"},{"$group": {"_id":{"name":"$name","itc":"$exams.itc"}, "avg":{"$avg": "$exams.score"}}}]):
        print result

def studentSubject(db):
    for result in db.studentsColl.aggregate([{"$unwind":"$exams"},{"$group": {"_id":{"name":"$name","surname":"$surname","subject":"$exams.subject"}, "maxScore":{"$max":"$exams.score"}, "minScore":{"$min":"$exams.score"},"countItc":{"$sum":1}}}]):
        print result

def itcSubjectMax(db):
    for result in db.studentsColl.aggregate([{"$unwind":"$exams"},{"$group": {"_id":{"itc":"$exams.itc", "subject":"$exams.subject"}, "max":{"$max": "$exams.score"}, "studentCount":{"$sum":1}}}]):
        print result

if __name__ == "__main__":
    db = getDB() 
    addCollection(db)
    nameItcScore(db)
    print ""
    studentSubject(db)
    print ""
    itcSubjectMax(db)
