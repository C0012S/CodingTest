/*
Easy. #1050 - Actors and Directors Who Cooperated At Least Three Times

    Accepted  277.6K    Submissions  322.8K    Acceptance Rate  70.5%


    Table: ActorDirector
        +-------------+---------+
        | Column Name | Type    |
        +-------------+---------+
        | actor_id    | int     |
        | director_id | int     |
        | timestamp   | int     |
        +-------------+---------+

        timestamp is the primary key (column with unique values) for this table.


    Write a solution to find all the pairs where the actor has cooperated with the director at least three times.(actor_id, director_id)
    Return the result table in any order.
    The result format is in the following example.


    Example 1:
        Input:
            ActorDirector table:
                +-------------+-------------+-------------+
                | actor_id    | director_id | timestamp   |
                +-------------+-------------+-------------+
                | 1           | 1           | 0           |
                | 1           | 1           | 1           |
                | 1           | 1           | 2           |
                | 1           | 2           | 3           |
                | 1           | 2           | 4           |
                | 2           | 1           | 5           |
                | 2           | 1           | 6           |
                +-------------+-------------+-------------+

        Output:
            +-------------+-------------+
            | actor_id    | director_id |
            +-------------+-------------+
            | 1           | 1           |
            +-------------+-------------+

        Explanation: The only pair is (1, 1) where they cooperated exactly 3 times.
*/


/*
    Runtime
        408ms

    Beats
        86.47%

    Time Complexity
        O(NlogN)
*/


-- 정답

SELECT actor_id, director_id
FROM ActorDirector
GROUP BY actor_id, director_id
HAVING COUNT(*) >= 3;