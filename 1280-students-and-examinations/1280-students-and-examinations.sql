# Write your MySQL query statement below
select st.student_id, st.student_name, sub.subject_name, count(ex.subject_name) as attended_exams
from Students st
join Subjects sub
left join Examinations ex
on st.student_id = ex.student_id and sub.subject_name = ex.subject_name
group by student_id, student_name, subject_name
order by student_id, subject_name