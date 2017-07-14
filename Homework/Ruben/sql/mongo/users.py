import pymongo
from pymongo import MongoClient
client = MongoClient('localhost', 27017)
client.User.Student.drop()
client.User.Student.insert({"Name":"Ruben", "ITC":8, "Exams":{"a":{"Subject":"C++", "Score":6}, "b":{"Subject": "Python", "Score":8}}})
client.User.Student.insert({"Name":"Vachagan", "ITC":8, "Exams":{"a":{"Subject":"C++", "Score":8}, "b":{"Subject": "Python", "Score":10}}})
client.User.Student.insert({"Name":"Smbat", "ITC":7, "Exams":{"a":{"Subject":"C++", "Score":8}, "b": {"Subject": "Python", "Score":9}}})
import pprint
pipe1 = [{"$group":{"_id":"$Name", "AVG":{"$avg": "$Exams.a.Score"}}}]
print("Avg Scores")
pprint.pprint(list(client.User.Student.aggregate(pipe1)))
pipe2 = [{"$group":{"_id":"$Exams.a.Subject", "MIN":{"$min": "$Exams.a.Score"}}}]
pipe3 = [{"$group":{"_id":"$Exams.b.Subject", "MIN":{"$min": "$Exams.b.Score"}}}]
print("MIN Scores")
pprint.pprint(list(client.User.Student.aggregate(pipe2)))
pprint.pprint(list(client.User.Student.aggregate(pipe3)))
