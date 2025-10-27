/*
Medium. #176 - Second Highest Salary

    Accepted  1,300,624 / 2.9M    Acceptance Rate  45.1%


    Table: Employee
        +-------------+------+
        | Column Name | Type |
        +-------------+------+
        | id          | int  |
        | salary      | int  |
        +-------------+------+

        id is the primary key (column with unique values) for this table.
        Each row of this table contains information about the salary of an employee.


    Write a solution to find the second highest distinct salary from the Employee table. If there is no second highest salary, return null (return None in Pandas).
    The result format is in the following example.


    Example 1:
        Input:
            Employee table:
                +----+--------+
                | id | salary |
                +----+--------+
                | 1  | 100    |
                | 2  | 200    |
                | 3  | 300    |
                +----+--------+

        Output:
            +---------------------+
            | SecondHighestSalary |
            +---------------------+
            | 200                 |
            +---------------------+


    Example 2:
        Input:
            Employee table:
                +----+--------+
                | id | salary |
                +----+--------+
                | 1  | 100    |
                +----+--------+

        Output:
            +---------------------+
            | SecondHighestSalary |
            +---------------------+
            | null                |
            +---------------------+
*/


/*
    Runtime
        400ms

    Beats
        41.71%

    Time Complexity
        O(Nlogn)
*/


-- 정답

WITH EMP AS (
    SELECT DENSE_RANK() OVER (ORDER BY salary DESC) AS RNK, salary
    FROM Employee
)

SELECT MAX(EMP.salary) AS SecondHighestSalary
FROM EMP
WHERE EMP.RNK = 2;