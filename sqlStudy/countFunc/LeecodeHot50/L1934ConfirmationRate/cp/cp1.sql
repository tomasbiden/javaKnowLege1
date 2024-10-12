
SELECT
    s.user_id,
    ROUND(IFNULL(AVG(c.action='confirmed'), 0), 2) AS confirmation_rate
FROM
    Signups AS s
        LEFT JOIN
    Confirmations AS c
    ON
        s.user_id = c.user_id
GROUP BY
    s.user_id

#  round(sum(case when action = 'confirmed' then 1 else 0 end)/count(*),2) as confirmation_rate
#  这里的逻辑不错

