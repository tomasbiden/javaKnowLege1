
show databases ;
use leecode_join_on;

select * from students

select  *
from  students stu
          left join subjects  sub
                    on  stu.student_id is not null
          left join Examinations  exa
                     on stu.student_id=exa.student_id && sub.subject_name=exa.subject_name
group by  stu.student_id,sub.subject_name;

select  stu.student_id,stu.student_name,sub.subject_name,count(exa.student_id) as attended_exams
from  students stu
          left join subjects  sub
                    on  stu.student_id is not null
          left join Examinations  exa
                    on stu.student_id=exa.student_id && sub.subject_name=exa.subject_name
group by  stu.student_id,sub.subject_name
order by  stu.student_id,sub.subject_name;



# 正确代码
select  stu.student_id,stu.student_name,sub.subject_name,count(exa.student_id) as attended_exams
from  students stu
          left join subjects  sub
                    on  stu.student_id is not null
          left join Examinations  exa
                    on stu.student_id=exa.student_id && sub.subject_name=exa.subject_name
where sub.subject_name is not null
group by  stu.student_id,sub.subject_name
order by  stu.student_id,sub.subject_name;
select  * from  students;
select  * ,avg(student_name='Alice')from  students;










SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

select * from students stu
group by  stu.student_id;

SELECT @@GLOBAL.sql_mode;

