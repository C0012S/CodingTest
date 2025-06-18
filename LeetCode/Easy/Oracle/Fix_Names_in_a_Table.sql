/*
Easy. #1667 - Fix Names in a Table

    Accepted  357,142 / 586.2K    Acceptance Rate  60.9%


    Table: Users
        +----------------+---------+
        | Column Name    | Type    |
        +----------------+---------+
        | user_id        | int     |
        | name           | varchar |
        +----------------+---------+

        user_id is the primary key (column with unique values) for this table.
        This table contains the ID and the name of the user. The name consists of only lowercase and uppercase characters.


    Write a solution to fix the names so that only the first character is uppercase and the rest are lowercase.
    Return the result table ordered by user_id.
    The result format is in the following example.


    Example 1:
        Input:
            Users table:
                +---------+-------+
                | user_id | name  |
                +---------+-------+
                | 1       | aLice |
                | 2       | bOB   |
                +---------+-------+

        Output:
            +---------+-------+
            | user_id | name  |
            +---------+-------+
            | 1       | Alice |
            | 2       | Bob   |
            +---------+-------+
*/


/*
    Runtime
        549ms

    Beats
        61.31%
*/


-- 정답

SELECT user_id, UPPER(SUBSTR(name, 1, 1)) || LOWER(SUBSTR(name, 2)) AS name
FROM Users
ORDER BY user_id;