
show  tables;
select *,count(1)
from delivery
group by customer_id ;

# 此方案
select round(avg(datediff(d1.order_date,d1.customer_pref_delivery_date)=0)*100,2) as  immediate_percentage
from delivery d1
where d1.order_date=
    (select min(d2.order_date)
     from Delivery d2
     where d1.customer_id=d2.customer_id );




SET SESSION sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY,',''));
