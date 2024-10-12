# Write your MySQL query statement below
# 1661.每台机器的进程平均运行时间
select    a.machine_id ,    round(avg( b.timestamp-a.timestamp),3) as processing_time
from  Activity a
          inner join  Activity b
                      on  a.machine_id=b.machine_id and a.process_id =b.process_id
                          and a.activity_type="start"
                          and b.activity_type="end"
group by machine_id