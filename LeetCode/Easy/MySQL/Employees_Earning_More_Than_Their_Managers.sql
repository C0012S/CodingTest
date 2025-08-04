/*
Easy. #181 - Employees Earning More Than Their Managers

    Accepted  877,584 / 1.2M    Acceptance Rate  71.8%


    Table: Employee
        +-------------+---------+
        | Column Name | Type    |
        +-------------+---------+
        | id          | int     |
        | name        | varchar |
        | salary      | int     |
        | managerId   | int     |
        +-------------+---------+

        id is the primary key (column with unique values) for this table.
        Each row of this table indicates the ID of an employee, their name, salary, and the ID of their manager.


    Write a solution to find the employees who earn more than their managers.
    Return the result table in any order.
    The result format is in the following example.


    Example 1:
        Input:
            Employee table:
                +----+-------+--------+-----------+
                | id | name  | salary | managerId |
                +----+-------+--------+-----------+
                | 1  | Joe   | 70000  | 3         |
                | 2  | Henry | 80000  | 4         |
                | 3  | Sam   | 60000  | Null      |
                | 4  | Max   | 90000  | Null      |
                +----+-------+--------+-----------+

        Output:
            +----------+
            | Employee |
            +----------+
            | Joe      |
            +----------+

        Explanation: Joe is the only employee who earns more than his manager.
*/


/*
    Runtime
        450ms

    Beats
        21.80%

    Time Complexity
        O(N)
*/


-- 정답

SELECT EMP.name AS Employee
FROM Employee EMP JOIN Employee MANAGER
                       ON EMP.managerId = MANAGER.id
WHERE EMP.salary > MANAGER.salary;