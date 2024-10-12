show databases;


-- 创建数据库
CREATE DATABASE study_process_record_1;

-- 使用数据库
USE study_process_record_1;

# drop  table  leecode_sql_1;
-- 创建表
CREATE TABLE leecode_sql_1
(
    problem_id          INT PRIMARY KEY,
    title               VARCHAR(255),
    type                VARCHAR(255),
    importance          INT,
    difficulty          INT,
    last_pass           BOOLEAN,
    last_attempted_time DATETIME,
    pass_count          INT,
    error_count         INT,
    pass_history        VARCHAR(255) comment '数组格式，做题通过与否记录',
    date_records    VARCHAR(255) comment '数组格式，做题的时间记录',
    used_time           VARCHAR(255) comment '数组格式,每次的解题用时',
    solve_evaluate      VARCHAR(255)  comment '做题情况记录，每次做的怎么样'

);
