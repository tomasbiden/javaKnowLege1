
/*


 */
use leecode_join_on;
select sign.user_id,if(user_conf_count is null,0,if(user_out_count is null ,1 ,  round(user_conf_count/(user_conf_count+user_out_count),2))) as confirmation_rate
from
    Signups sign
        left join
    (
        select conf.user_id,count(*) as user_conf_count from Confirmations  conf
        where conf.action="confirmed"
        group by user_id
    )  t_conf
    on sign.user_id= t_conf.user_id

        left join
    (
        select conf.user_id,count(*) as user_out_count from Confirmations  conf
        where conf.action="timeout"
        group by user_id
    )  t_out
    on  sign.user_id=t_out.user_id
select * from  confirmations;

select *,avg(action) from confirmations as conf;
select *,avg(action='confirmed') from confirmations as conf;


