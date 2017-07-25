import argparse
from pymongo import MongoClient

parser = argparse.ArgumentParser()
parser.add_argument('--host', dest = 'host',
    default = 'localhost')
parser.add_argument('--port', dest = 'port',
    default = 27017)
arguments = parser.parse_args()


client = MongoClient(arguments.host, arguments.port)
db = client.student
col = db.student

def getStudentAvg():
    scores = col.aggregate([{
        "$unwind": "$ITC"
    }, {
        "$unwind": "$ITC.number"
    }, {
        "$project": {
            "_id": 0,
            "ITC": "$ITC.number",
            "name": "$name",
            "avg": {
                "$avg": "$ITC.exams.score"
            }
        }
    }])
    print "\nstudents scores average\n"
    for score in scores:
        print score;


def getSubjectMinMaxAvg():
    results = col.aggregate([{
        "$unwind": "$ITC"
    }, {
        "$unwind": "$ITC.exams"
    }, {
        "$group": {
            "_id": "$ITC.exams.subject",
            "average": {
                "$avg": "$ITC.exams.score"
            },
            "minimum": {
                "$min": "$ITC.exams.score"
            },
            "maximum": {
                "$max": "$ITC.exams.score"
            }
        }
    }, {
        "$project": {
            "_id": 0,
            "subject": "$_id",
            "average": "$average",
            "minimum": "$minimum",
            "maximum": "$maximum"
        }
    }])

    print "\nsubjects min max scores and average\n"
    for result in results:
        print result
def main ():

    getSubjectMinMaxAvg();
    getStudentAvg();


if __name__ == '__main__': main()
