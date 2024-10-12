select  `time` ,DB7_8
from  iotkit.device_property_17247496374800yafeng100000000007f
where  `time` > '2024-09-15 16:55:00.365'
order by  `time`  asc
limit  10000;




select   _wstart, _wend ,avg(DB7_8) as avg_count1 ,max(DB7_8), min(DB7_8) , max(DB7_8)-min(DB7_8) as  used
from  iotkit.device_property_17247496374800yafeng100000000007f
where  DB7_8>0
    INTERVAL(1d)
                order by _wstart desc limit 100;