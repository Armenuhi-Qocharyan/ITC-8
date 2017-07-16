#!/usr/bin/python

import pprint
import argparse
import pymongo
from pymongo import MongoClient

def averageScore(students) :
    print("\n\nAverag Score : \n")
    for student in students.find({}, {"_id": 0, "name": 1, "surname": 1, "ITC": 1}) : 
        sumScore = 0
        exameCount = 0
        ITCs = student["ITC"]
        for ITC in ITCs :
            exameCount += len(ITC["exames"])
            for exame in ITC["exames"] :
                sumScore += exame["score"]
                
        print student["name"], "\t|", sumScore / exameCount

def averageScoreAndCountITC(students) :
    print("\n\nAveraje score and count of ITC : \n")
    subjects = []
    for student in students.find({}, {"_id": 0, "name": 1, "surname": 1, "ITC": 1}) :
        ITCs = student["ITC"]
        for ITC in ITCs :
            for exame in ITC["exames"] :
                if (len(subjects) == 0) :
                    subjects.append({"name": student["name"], "title": exame["title"], "sumScore": exame["score"], "ITCCount": 1})
                for subject in subjects :
                    if (subject["title"] != exame["title"] and subject["title"] == subjects[len(subjects) - 1]["title"] ) :
                        subjects.append({"name": student["name"], "title": exame["title"], "sumScore": exame["score"], "ITCCount": 1})
                    elif  subject["title"] == exame["title"] :
                        subject["sumScore"] += exame['score']
                        subject["ITCCount"] += 1

    for subject in subjects :
        print subject["name"], "\t|", subject["ITCCount"], "|", subject["title"], "\t\t|", subject["sumScore"] / subject["ITCCount"]

def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("host", help = "host", nargs = '?', default = "localhost", type = str) 
    parser.add_argument("port", help = "port", nargs = '?', default = 27017, type = int);
    args = parser.parse_args()
    print args

    client = MongoClient()
    client = MongoClient(args.host, args.port)
    studentDb = client.Student 
    students = studentDb.Students

    averageScore(students)   
    averageScoreAndCountITC(students) 

if(__name__) == "__main__":
    main()
        
