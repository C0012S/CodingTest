/*
Medium. #180 - Consecutive Numbers

    Accepted  646,262 / 1.4M    Acceptance Rate  47.0%


    Table: Logs
        +-------------+---------+
        | Column Name | Type    |
        +-------------+---------+
        | id          | int     |
        | num         | varchar |
        +-------------+---------+

        In SQL, id is the primary key for this table.
        id is an autoincrement column starting from 1.


    Find all numbers that appear at least three times consecutively.
    Return the result table in any order.
    The result format is in the following example.


    Example 1:
        Input:
            Logs table:
                +----+-----+
                | id | num |
                +----+-----+
                | 1  | 1   |
                | 2  | 1   |
                | 3  | 1   |
                | 4  | 2   |
                | 5  | 1   |
                | 6  | 2   |
                | 7  | 2   |
                +----+-----+

        Output:
            +-----------------+
            | ConsecutiveNums |
            +-----------------+
            | 1               |
            +-----------------+

        Explanation: 1 is the only number that appears consecutively for at least three times.
*/


/*
    Runtime
        1038ms

    Beats
        5.82%

    Time Complexity
        O(N)
*/


-- 정답

SELECT DISTINCT L1.num AS ConsecutiveNums
FROM Logs L1
         JOIN Logs L2
              ON L1.id = L2.id - 1 AND L1.num = L2.num
         JOIN Logs L3
              ON L2.id = L3.id - 1 AND L2.num = L3.num;