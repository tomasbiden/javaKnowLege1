


show databases;
use study_process_record_1;
show tables;

#  查询超过7天 未做的题目
select problem_id,  now(),last_attempted_time,now()-last_attempted_time
from leecode_sql_hot50
 where  now()-last_attempted_time >86400*7 ;