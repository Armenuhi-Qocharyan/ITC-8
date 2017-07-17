import pymongo
from pymongo import MongoClient
import argparse

def insert(collection): 
    collection.insert({
        "name":"Nelli",
        "itc":"itc_8",
        "subjects":{
            "c++":8,
            "python":5
        }
    })
    collection.insert({
        "name":"Liana",
        "itc":"itc_8",
        "subjects":{
            "c++":9,
            "python":10
        }
    })
 
def print_students_avg(collection):
    all_students = collection.find()
    print " itc " + " name " + " avg "
    for student in all_students:
        print student["itc"] + " " + student["name"],
        scores = student["subjects"].values()
        print sum(scores) / float(len(scores))


def subject_min_max_score(collection):
    subjects = ["c++","python"]
    for subject in subjects:
        min_score = 10
        max_score = 0
        key = "subjects." + subject
        result = collection.find({key:{'$exists': True}})
        for item in result:
            score = item["subjects"].get(subject)
            if min_score > score:
                min_score = score 
            if max_score < score:
                max_score = score
        print subject,
        print "min = ",
        print min_score,
        print " max = ",
        print max_score

parser = argparse.ArgumentParser()
parser.add_argument("host", default = "localhost", help = "host", type = str) 
parser.add_argument("port", default = "27017", help = "port", type = int);
args = parser.parse_args()
client = MongoClient()
client = MongoClient(args.host, args.port)
db = client.itc
collection = db.students
insert(collection)
print_students_avg(collection)
subject_min_max_score(collection)
