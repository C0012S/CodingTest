/*
Easy. #610 - Triangle Judgement

    Accepted  305.9K    Submissions  417.1K    Acceptance Rate  73.3%


    Table: Triangle
        +-------------+------+
        | Column Name | Type |
        +-------------+------+
        | x           | int  |
        | y           | int  |
        | z           | int  |
        +-------------+------+

        In SQL, (x, y, z) is the primary key column for this table.
        Each row of this table contains the lengths of three line segments.


    Report for every three line segments whether they can form a triangle.
    Return the result table in any order.
    The result format is in the following example.


    Example 1:
        Input:
            Triangle table:
                +----+----+----+
                | x  | y  | z  |
                +----+----+----+
                | 13 | 15 | 30 |
                | 10 | 20 | 15 |
                +----+----+----+

        Output:
            +----+----+----+----------+
            | x  | y  | z  | triangle |
            +----+----+----+----------+
            | 13 | 15 | 30 | No       |
            | 10 | 20 | 15 | Yes      |
            +----+----+----+----------+
*/


/*
    Runtime
        378ms

    Beats
        92.27%

    Time Complexity
        O(N)
*/


-- 정답

SELECT x, y, z,
       CASE WHEN (x + y > z) AND (x + z > y) AND (y + z > x) THEN 'Yes'
            ELSE 'No'
       END AS triangle
FROM triangle;