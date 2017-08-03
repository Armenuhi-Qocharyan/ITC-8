
select exams.itc,students.name, avg(exams.score) from students,exams where student_id = students.id group by exams.itc,students.name order by itc,avg;

select students.name,subjects.title, avg(exams.score),exams.itc from students,exams,subjects where subject_id = subjects.id and student_id = students.id group by subjects.title,students.name,exams.itc order by itc,name,avg;

select subjects.title, avg(exams.score), max(exams.score),min(exams.score),count(exams.student_id),exams.itc from students,exams,subjects where subject_id = subjects.id and student_id = students.id group by subjects.title,exams.itc order by itc,avg;
