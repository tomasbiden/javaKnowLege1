


select round(count(*)/(select count(distinct player_id) from Activity ),2) as  fraction
from
    Activity  t1
where (t1.player_id,t1.event_date) in
      (
          select  t2.player_id, date_add(min(event_date),interval 1 day)
          from Activity t2
          group by t2.player_id
      )