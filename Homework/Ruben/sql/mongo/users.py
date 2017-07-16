import argparse
import pymongo
import pprint
from pymongo import MongoClient

parser = argparse.ArgumentParser()
parser.add_argument('--host', nargs='*',  default='[[localhost]]', help='Enter host')
parser.add_argument('--port', nargs='*', type=int,  default='[[27017]]', help='Enter port')
args = parser.parse_args()
host = args.host
port = args.port

client = MongoClient(host[0], port[0])
client.User.Student.drop()
client.User.Student.insert({"Name":"Ruben", "ITC":8, "Exams":{"a":{"Subject":"C++", "Score":6}, "b":{"Subject": "Python", "Score":8}}})
client.User.Student.insert({"Name":"Vachagan", "ITC":8, "Exams":{"a":{"Subject":"C++", "Score":8}, "b":{"Subject": "Python", "Score":10}}})
client.User.Student.insert({"Name":"Smbat", "ITC":7, "Exams":{"a":{"Subject":"C++", "Score":8}, "b":{"Subject": "Python", "Score":9}}})
pipe1 = [{"$group":{"_id" : {"Name":'$Name',"ITC":'$ITC'},"AVG":{"$avg":'$Exams.a.Score'}}}]
pipe2 = [{"$group":{"_id":{"ITC":"$ITC", "Subject":"$Exams.a.Subject"}, "MIN":{"$min": "$Exams.a.Score"}, "MAX":{"$max":"$Exams.a.Score"}, "Count":{"$sum":1}}}]

print("Avg Scores")
pprint.pprint(list(client.User.Student.aggregate(pipe1)))
print("MIN and MAX Scores")
pprint.pprint(list(client.User.Student.aggregate(pipe2)))
