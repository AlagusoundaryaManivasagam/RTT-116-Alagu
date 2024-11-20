select d.name as 'Department name', count(*) as 'Number of courses'
from department d, course c
where d.id = c.deptId
group by c.deptId
order by count(*) asc, d.name asc;
-- ---------=================================================================

select * from studentCourse;

select courseId, count(studentId) as Number_of_students
from studentCourse
group by courseId;

select c.name as 'Course Name', t.Number_of_students as 'Number of students'
from course c,(select courseId, count(studentId) as Number_of_students
from studentCourse
group by courseId) t
where c.id = t.courseId
order by t.Number_of_students desc, c.name asc;

-- ================================================================================
select distinct courseId 
from facultyCourse;

select name 
from course
where id not in (select distinct courseId 
from facultyCourse);
-- ==============================================================================

select c.name as 'CourseNames',count(sc.studentId) as 'Number of Students'
from course c,studentCourse sc
where c.id not in (select courseId from facultyCourse)
and c.id = sc.courseId
group by sc.courseId
order by count(sc.studentId) desc, c.name asc;
-- =================================================================================
-- 6
select * from studentCourse;

select count(distinct studentId) , year(startDate)
from studentCourse
group by year(startDate)
order by year(startDate) asc, count(distinct studentId) desc;

-- this id not right
select count(studentId) as Students, Year
from (select studentId, min(year) as Year
from(select studentId, year(startDate) as year from studentCourse) as t
group by studentId) as d
group by Year
order by Year asc, count(studentId) desc;
-- ==================================================================================
 -- 7 
 select * 
 from studentCourse 
 where month(startDate) = 8;
 
 select startDate as 'Start Date', count(distinct studentId) as 'Total Number of Students'
 from (select * 
 from studentCourse 
 where month(startDate) = 8) as t
 group by startDate;
 -- =====================================================================================
 -- 8
 -- this does not work
 select firstname as 'First Name', lastname as 'Last Name', count(sc.studentId) as 'Number of Courses'
from student s
left join studentCourse sc on s.id = sc.studentId
group by sc.studentId
order By count(sc.studentId) desc, firstname asc, lastname asc;

-- this works
 select firstname as 'First Name', lastname as 'Last Name', count(sc.studentId) as 'Number of Courses'
from student s, studentCourse sc 
where s.id = sc.studentId
group by sc.studentId
order By count(sc.studentId) desc, firstname asc, lastname asc;

-- both missed a point count of courses from their major
select s.id, s.firstname, s.lastname, s.majorId 
from student s
order by s.id;

select sc.studentId, deptId, count(deptId) as number
from studentcourse sc
left join course c on sc.courseId = c.id
group by sc.studentId, deptId; 

-- working
select a.firstname as 'First Name', a.lastname as 'Last Name', b.number as 'Number of Courses'
from 
(select id, firstname, lastname, majorId 
from student 
order by id) a
left join (select sc.studentId, deptId, count(deptId) as number
from studentcourse sc
left join course c on sc.courseId = c.id
group by sc.studentId, deptId) b
on a.id = b.studentId
and a.majorId = b.deptId
order by b.number desc, a.firstname, a.lastname;
-- ================================================================================================
-- 9
-- wrong because progress lee tha 50 was averaged
select s.firstname as 'First Name', s.lastname as 'Last Name', round(avg(sc.progress),1) as 'Average Progress'
from student s
left join studentCourse sc
 on s.id = sc.studentId
 where sc.progress<50
 group by s.id
 order by  round(avg(sc.progress),1) desc, s.firstname, s.lastname ;
 
 -- progress is averaged first then less than 50 is displayed wrong
 select s.firstname as 'First Name', s.lastname as 'Last Name', round(avg(sc.progress),1) as 'Average Progress'
from student s
left join studentCourse sc
 on s.id = sc.studentId
 where avg(sc.progress)< 50.0
 group by s.id
 order by  round(avg(sc.progress),1) desc, s.firstname, s.lastname ;
 
 select s.firstname as 'First Name', s.lastname as 'Last Name', round(avg(sc.progress),1) as 'Average Progress'
from student s
left join studentCourse sc
 on s.id = sc.studentId
  group by s.id
  having round(avg(sc.progress),1)<50
  order by  round(avg(sc.progress),1) desc, s.firstname, s.lastname ;
-- =======================================================================================================
-- 9
select c.name as 'Course Name', round(avg(sc.progress), 1) as 'Average Progress'
from course c, studentCourse sc
where c.id = sc.courseId
group by courseId
order by round(avg(sc.progress),1) desc, c.name ;  
-- =======================================================================================================
-- 10
select c.name as 'Course Name', round(avg(sc.progress), 1) as 'Average Progress'
from course c, studentCourse sc
where c.id = sc.courseId
group by courseId
order by round(avg(sc.progress),1) desc, c.name 
limit 1;  
-- =========================================================================================================
-- 12
select * 
from faculty f
left join 
facultycourse fc on f.id = fc.facultyId
left join 
course c on fc.courseId = c.id;

select f.firstname as 'First Name', f.lastname as 'Last Name', round(avg(sc.progress),1) as 'Average Progress'
from faculty f
left join 
facultycourse fc on f.id = fc.facultyId
left join 
course c on fc.courseId = c.id
left join 
studentCourse sc
on c.id = sc.courseId
group by f.id
order by round(avg(sc.progress),1) desc, f.firstname, f.lastname;
-- =================================================================================
-- 13
-- this works but not the expected answer
select s.firstname as 'First Name', s.lastname as 'Last Name',
case 
when min(sc.progress)< 40 then 'F'
when min(sc.progress)< 50 then 'D'
when min(sc.progress)< 60 then 'C'
when min(sc.progress)< 70 then 'B'
when min(sc.progress)>= 70 then 'A'
end as 'Minimum Grade',

case 
when max(sc.progress)< 40 then 'F'
when max(sc.progress)< 50 then 'D'
when max(sc.progress)< 60 then 'C'
when max(sc.progress)< 70 then 'B'
when max(sc.progress)>= 70 then 'A'
end as 'Maximum Grade'

from student s, studentcourse sc
where s.id = sc.studentId
group by s.id
order by 'Minimum Grade' desc, 'Maximum Grade' desc, s.firstname, s.lastname; 

-- trying the same with left join
select s.firstname as 'First Name', s.lastname as 'Last Name',
case 
when min(sc.progress)< 40 then 'F'
when min(sc.progress)< 50 then 'D'
when min(sc.progress)< 60 then 'C'
when min(sc.progress)< 70 then 'B'
when min(sc.progress)>= 70 then 'A'
end as 'Minimum Grade' ,

case 
when max(sc.progress)< 40 then 'F'
when max(sc.progress)< 50 then 'D'
when max(sc.progress)< 60 then 'C'
when max(sc.progress)< 70 then 'B'
when max(sc.progress)>= 70 then 'A'
end as 'Maximum Grade' 

from student s
left join
studentcourse sc
on s.id = sc.studentId
group by s.id
order by `Minimum Grade` desc, `Maximum Grade` desc,  s.firstname, s.lastname; 