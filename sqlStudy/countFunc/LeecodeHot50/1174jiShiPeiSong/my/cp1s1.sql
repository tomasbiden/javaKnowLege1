
show  tables
select round(avg(datediff(d1.order_date,d1.customer_pref_delivery_date)=0)*100,2) as  immediate_percentage
from delivery d1
where (d1.customer_id, d1.order_date) in
(
    select  d2.customer_id, min(d2.order_date)
    from  delivery d2
    group by  d2.customer_id
    )
    ;