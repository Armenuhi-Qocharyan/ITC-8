file = open("people.txt", "r")
peopleList = file.readlines()
file.close()

def createDict():
    peopleDict = {}
    for people in peopleList:
        temp = people.split(" ")
        peopleDict[temp[0] + " " + temp[1]] = temp[2]
    return peopleDict

def findAgeByNameSurname(people):
    nameSurname = raw_input('Enter name and surname: ')
    age = people.get(nameSurname)
    if (age  == None):
        print nameSurname, "isn't List's member"
    else:
        return age

def findNameSurnameByAge(people):
    age = input('Enter age: ')
    listkeys = people.keys()
    listNames = []
    for i in range(0, len(listkeys)):
        peopleAge = int (people.get(listkeys[i]))
        if peopleAge == age:
            print listkeys[i], "is ", age, "years old"
            listNames.append(listkeys[i])
    return listNames

people = createDict()
print findAgeByNameSurname(people)
findNameSurnameByAge(people)

