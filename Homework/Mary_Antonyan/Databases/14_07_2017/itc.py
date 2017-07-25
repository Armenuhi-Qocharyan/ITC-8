#!/usr/bin/python
import argparse
import pymongo
from pprint import pprint
from pymongo import MongoClient

def insertData(exams) :
    exams.insert({
        "Name":"Nane", 
        "Surname":"Hambardzumyan", 
        "Exams": [
            {
                "Training":"ITC1", 
                "Subject":"C++", 
                "Score":90
                },
            {
                "Training":"ITC1",
                "Subject":"Python",
                "Score":95
                },
            {
                "Training":"ITC1", 
                "Subject":"Linux", 
                "Score":100
                }]
            })

def query(doc, criteria) :
    pprint(list(doc.aggregate(criteria)))

def main() :
    # Get arguments
    parser = argparse.ArgumentParser(description = "Specify host and port number")
    parser.add_argument("host", action = "store", default = "localhost")
    parser.add_argument("port", action = "store", default = 27017, type=int)

    host = parser.parse_args().host
    port = parser.parse_args().port

    # Connect to the host
    client = MongoClient(host, port)

    # Get database
    db = client["itc"]

    # Empty collection to avoid data replication
    db.exams.drop()

    # Get collection
    exams = db["exams"]

    # Insert data into database
    insertData(exams)

    # First select criteria
    firstSelectCriteria = [{"$unwind":"$Exams"},
            {"$group" : { "_id" : { "ITC" : "$Exams.Training", "Name" : "$Name", "Surname" : "$Surname"}, "Average" : {"$avg" : "$Exams.Score"}}}]

    # Second select criteria
    secondSelectCriteria = [{"$unwind":"$Exams"}, {"$group": {"_id": {"Name":"$Name", "Surname":"$Surname"}, "Max":{"$max":"$Exams.Score"}, "Min":{"$min":"$Exams.Score"}}}]

    # Get the results of the queries
    print "\n\nQuery 1: Get average of each student for each training:"
    query(exams, firstSelectCriteria)

    print "\n\nQuery 2: Get max and min scores of each subject for each student:"
    query(exams, secondSelectCriteria)

if __name__ == "__main__" :
    main()
