# Write your MySQL query statement below
select customer_id, count(customer_id) as count_no_trans
from Visits v
left outer join Transactions t
on (v.visit_id = t.visit_id)
where transaction_id IS NULL
group by customer_id;