import pymongo
import argparse
import pprint
from pymongo import MongoClient

def getDB():
    parser = argparse.ArgumentParser()
    parser.add_argument("--host", default = "localhost", help = "host", type = str) 
    parser.add_argument("--port", default = "27017", help = "port", type = int);
    args = parser.parse_args()
    client = MongoClient(args.host, args.port)    
    client.studentsDb.studentsColl.drop()
    db = client.studentsDb
    return db

def addCollection(db):
    db.studentsColl.insert({"name" : "aaa","surname":"aaaaa","exams":[{"itc":1,"subject":"c++",   "score":7},{"itc":2,"subject":"c++","score":9}]})
    db.studentsColl.insert({"name" : "bbb","surname":"bbbbb","exams":[{"itc":3,"subject":"python","score":5}, {"itc":4,"subject":"python","score":8}]})
    db.studentsColl.insert({"name" : "ccc","surname":"ccccc","exams":[{"itc":5,"subject":"JS",    "score":6}, {"itc":6,"subject":"JS","score":3}]})

def nameItcAvg(db):
    print "NAME    |\t\tITC\t   | AVG |"
    print('--------------------------------------------------')
    for student in db.studentsColl.find({}, {"_id": 0, "name": 1, "exams.itc": 1, "exams.score": 1}) : 
        arrItc = []
        sumScore = 0
        for exame in student["exams"]:
            sumScore+=exame["score"]
            arrItc.append({"itc":exame["itc"]})
        print student["name"], "\t|", arrItc, "|", sumScore/float(len(exame)), "|"


def counts(name):
    count=0
    for i in arrSubject :
        if i["Subject"] == name:
            count+=1
    return count

arrSubject = []
def subjectMaxMin(db):
    print "|Subject|     MAX      |     MIN      |"
    print('--------------------------------------------------')
    c = []
    js = []
    py = []
    for student in db.studentsColl.find({}, {"_id": 0, "name": 1, "exams.subject": 1, "exams.score": 1}) : 
        for exame in student["exams"]:
            if exame["subject"] == "c++":
                c.append({"Score":exame["score"]})
            elif exame["subject"] == "JS":
                js.append({"Score":exame["score"]})
            elif exame["subject"] == "python":
                py.append({"Score":exame["score"]})
            
            arrSubject.append({"Subject":exame["subject"]})
    count = counts("c++")
    print arrSubject[0]["Subject"], "\t|", max(c), "|", min(c), "|"
    print arrSubject[count]["Subject"], "\t|", max(py), "|", min(py), "|"
    count += counts("python")
    print arrSubject[count]["Subject"], "\t|", max(js), "|", min(js), "|"

if __name__ == "__main__":
    db = getDB() 
    addCollection(db)
    print('--------------------------------------------------------')
    print nameItcAvg(db)
    print('--------------------------------------------------------')
    print subjectMaxMin(db)
