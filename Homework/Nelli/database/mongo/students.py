import pymongo
from pymongo import MongoClient
import argparse

def insert(collection): 
    collection.insert({
        "name":"Nelli",
        "itc":"itc_8",
        "exams":{
            "exam1":{
                "subject":"c++",
                "score":7
            },
            "exam2":{
                "subject":"python",
                "score":7
            }
        }
    })

def print_items(collection,pipeline): 
    result = collection.aggregate(pipeline)
    for item in result:
        print item['_id'],
        print item['avg'],
        print item['min'],
        print item['max']

def print_students_avg(collection):
    pipeline = [{
        "$group":
        {
            "_id" : {"itc":'$itc',"student":'$name'},
            "avg1" : {'$avg':'$exams.exam1.score'},
            "avg2" : {'$avg':'$exams.exam2.score'},
        }
    }]
    result = collection.aggregate(pipeline)
    for item in result:
        print item['_id'],
        print (item['avg1']+item['avg2'])/2


def print_subjects_min_max(collection):
    pipeline1 = [{
        "$group":
        {
            "_id" : {"itc":'$itc',"subject":'$exams.exam1.subject'},
            "avg" : {'$avg':'$exams.exam1.score'},
            "min" : {'$min':'$exams.exam1.score'},
            "max" : {'$max':'$exams.exam1.score'}
        }
    }]
    pipeline2 = [{
        "$group":
        {
            "_id" : {"itc":'$itc',"subject":'$exams.exam2.subject'},
            "avg" : {'$avg':'$exams.exam2.score'},
            "min" : {'$min':'$exams.exam2.score'},
            "max" : {'$max':'$exams.exam2.score'}
        }
    }]
    print_items(collection,pipeline1)
    print_items(collection,pipeline2)


parser = argparse.ArgumentParser()
parser.add_argument("--host", default = "localhost", help = "host", type = str) 
parser.add_argument("--port", default = "27017", help = "port", type = int);
args = parser.parse_args()
client = MongoClient(args.host, args.port)
db = client.students
collection = db.itc_1
insert(collection)
print "Task 1 print students avg"
print_students_avg(collection)
print "Task 2 print subjects avg min and max score"
print_subjects_min_max(collection)
