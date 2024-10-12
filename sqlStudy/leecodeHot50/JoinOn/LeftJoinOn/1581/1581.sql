
show databases ;
show  tables ;

select   customer_id,count(customer_id) as count_no_trans from  Visits
                                                                    left  join   Transactions on  Visits.Visit_id=Transactions.visit_id
where Transactions.visit_id is null
group by customer_id;

--  进店却未进行过交易的顾客


