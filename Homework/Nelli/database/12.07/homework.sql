create view avg_count_exams_student as select students.name as name ,avg(exams.score) as avg ,count(subject_id) as count from exams,students where student_id=students.id group by student_id order by avg;

create view min_max_score as select subjects.title as title ,min(exams.score) as min , max(exams.score) as max, avg(exams.score) as avg from exams,subjects where subject_id=subjects.id group by subject_id;
