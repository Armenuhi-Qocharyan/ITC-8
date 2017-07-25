--Task1: Show students name, info for itc and avg score.

create view nameItcAvg as select students.name,students.itc,avg(exams.score) from students,subjects,exams where studentsId=students.id and subjectsId=subjects.id group by name,itc order by name;

/*
name |  itc  |         avg         
------+-------+---------------------
 aaa  | itc-1 | 20.0000000000000000
 bbb  | itc-2 | 19.0000000000000000
 ccc  | itc-3 | 18.0000000000000000
 ddd  | itc-4 | 17.0000000000000000
 xxx  | itc-5 | 50.0000000000000000
*/


--Task2: Show student name, subject title, avg and how many times participated in itc.

create view nameSubjectAvgCountOfItc as select students.name, subjects.title,avg(exams.score),count(itc) as Count_Of_ITC from students,subjects,exams where studentsId=students.id and subjectsId=subjects.id group by name,title order by name;

/*
name |   title    |         avg         | count_of_itc 
------+------------+---------------------+--------------
 aaa  | C++        | 10.0000000000000000 |            1
 aaa  | JavaScript | 20.0000000000000000 |            1
 aaa  | Python     | 30.0000000000000000 |            1
 bbb  | C++        |  9.0000000000000000 |            1
 bbb  | JavaScript | 19.0000000000000000 |            1
 bbb  | Python     | 29.0000000000000000 |            1
 ccc  | C++        |  8.0000000000000000 |            1
 ccc  | JavaScript | 18.0000000000000000 |            1
 ccc  | Python     | 28.0000000000000000 |            1
 ddd  | C++        |  7.0000000000000000 |            1
 ddd  | JavaScript | 17.0000000000000000 |            1
 ddd  | Python     | 27.0000000000000000 |            1
 xxx  | bash       | 50.0000000000000000 |            1
*/


--Task 3: Show itc, what subjects were,max and min score from this subject. 

create view itcSubjectMaxMin as select students.itc, subjects.title, max(exams.score),min(exams.score) from students,subjects,exams where studentsId=students.id and subjectsId=subjects.id group by itc,title order by itc;

/*
  itc  |   title    | max | min 
-------+------------+-----+-----
 itc-1 | C++        |  10 |  10
 itc-1 | JavaScript |  20 |  20
 itc-1 | Python     |  30 |  30
 itc-2 | C++        |   9 |   9
 itc-2 | JavaScript |  19 |  19
 itc-2 | Python     |  29 |  29
 itc-3 | C++        |   8 |   8
 itc-3 | JavaScript |  18 |  18
 itc-3 | Python     |  28 |  28
 itc-4 | C++        |   7 |   7
 itc-4 | JavaScript |  17 |  17
 itc-4 | Python     |  27 |  27
 itc-5 | bash       |  50 |  50
*/
