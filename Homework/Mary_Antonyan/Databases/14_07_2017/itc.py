#!/usr/bin/python
import pymongo
from pymongo import MongoClient
import argparse

def main() :
    # Get arguments
    parser = argparse.ArgumentParser(description = "Specify host and port number")
    parser.add_argument("host", action = "store")
    parser.add_argument("port", action = "store", type=int)

    host = parser.parse_args().host
    port = parser.parse_args().port

    # Connect to the host
    client = MongoClient(host, port)
    
    # Get database
    db = client["itc"]

    # Get collection
    exams = db["exams"]

    # Insert data into database
    insertData(exams)

def insertData(exams) :
    exams.insert(
            {
                "Name":"Nane",
                "Surname":"Hambardzumyan",
                "Exams":[{"Training":"ITC1", "Subject":"C++", "Score":"90"},
                    {"Training":"ITC1", "Subject":"Python", "Score":"95"},
                    {"Training":"ITC1", "Subject":"Linux", "Score":"100"}]
                })
    exams.insert(
            {
                "Name":"Mane",
                "Surname":"Hambardzumyan",
                "Exams":[{"Training":"ITC1", "Subject":"C++", "Score":"90"},
                    {"Training":"ITC1", "Subject":"Python", "Score":"95"},
                    {"Training":"ITC1", "Subject":"Linux", "Score":"100"}]
                })




if __name__ == "__main__":
    main()



