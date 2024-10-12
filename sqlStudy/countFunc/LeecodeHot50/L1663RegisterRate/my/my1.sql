

select contest_id,round(count(user_id)/(select count(user_id)from Users),2)*100 as percentage
from Register
group by contest_id
order by percentage desc