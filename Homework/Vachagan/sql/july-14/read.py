import sys
def main():
	from pymongo import MongoClient
	client = MongoClient(sys.argv[1], 27017)
	db = client.ITC
	posts = db.students
	import pprint
	myjson = posts.find_one()
	pprint.pprint(myjson)

if __name__ == "__main__":
    main()
