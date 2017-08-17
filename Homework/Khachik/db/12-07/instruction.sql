/*Task 1: Get data from table 'exams'  in following format - [subject] [max score] [min score] [average score]*/

select title, MAX(score) as MAX, MIN(score) as MIN, AVG(score) as AVG from exams, students,subject where students.id=exams.student_id and  subject.id=exams.subject_id group by title;

/*Task 2: Get data from table 'exams'  in following format - [name] [average score] [exams count] (will be sorted by count).*/

select name, AVG(score) as AVG, COUNT(score) as COUNT from exams, students where students.id=exams.student_id group by name order by COUNT DESC;
