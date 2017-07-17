import argparse
from pymongo import MongoClient

parser = argparse.ArgumentParser()
parser.add_argument('-l', '--host', default='localhost', help='This will be option One')
parser.add_argument('-p', '--port', default='27017', help='This will be option One')
res = parser.parse_args()
port = int(res.port)
host = str(res.host)

client = MongoClient(host, port)
db = client.itc_homework
pipeline1 = [{"$unwind": "$exams"},{"$group":{"_id" : {"name":'$name',"itc":'$itc'},"avg_score":{"$avg":'$exams.score'}}}]
pipeline2 = [{"$unwind": "$exams"},{"$group":{"_id" : {"itc":"$itc","subject":'$exams.exam'},"max_score":{"$max":'$exams.score'},"min_score":{"$min":"$exams.score"},"exams_number":{"$sum":1}}}]

def func(pipeline):
    result = db.students.aggregate(pipeline)
    for doc in result:
        print(doc)

def main():
    print('Input 1 or 2')
    print('1 - [name][itc][average score]')
    print('2 - [itc][subject][max score][min score][exams number]')
    cin = raw_input()
    if cin == '1':
        func(pipeline1)
    elif cin == '2':
        func(pipeline2)
    else:
        print("wrong input")

if __name__ == "__main__":
    main()
