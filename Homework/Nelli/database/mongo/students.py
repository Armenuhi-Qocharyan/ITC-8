import pymongo
from pymongo import MongoClient
import argparse

def insert(collection): 
    collection.insert({
        "name":"Liana",
        "itc":"itc_8",
        "exams":{
            "subjects":["c++","python"],
            "score":9,
            "score":9
        }
    })
 
def print_students_avg(collection):
    pipeline = [{
        "$group":
        {
            "_id" : {"name":'$name',"itc":'$itc'},
            "avg" : {'$avg':'$exams.score'}
        }
    }]
    result = db.itc_8.aggregate(pipeline)
    for doc in result:
        print doc


parser = argparse.ArgumentParser()
parser.add_argument("--host", default = "localhost", help = "host", type = str) 
parser.add_argument("--port", default = "27017", help = "port", type = int);
args = parser.parse_args()
client = MongoClient(args.host, args.port)
db = client.students
collection = db.itc_8
insert(collection)
print_students_avg(collection)
