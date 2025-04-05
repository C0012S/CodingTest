/*
Easy. #619 - Biggest Single Number

    Accepted  357.7K    Submissions  519.1K    Acceptance Rate  68.9%


    Table: MyNumbers
        +-------------+------+
        | Column Name | Type |
        +-------------+------+
        | num         | int  |
        +-------------+------+

        This table may contain duplicates (In other words, there is no primary key for this table in SQL).
        Each row of this table contains an integer.


    A single number is a number that appeared only once in the table.MyNumbers
    Find the largest single number. If there is no single number, report .null
    The result format is in the following example.


    Example 1:
        Input:
            MyNumbers table:
                +-----+
                | num |
                +-----+
                | 8   |
                | 8   |
                | 3   |
                | 3   |
                | 1   |
                | 4   |
                | 5   |
                | 6   |
                +-----+

        Output:
            +-----+
            | num |
            +-----+
            | 6   |
            +-----+

        Explanation: The single numbers are 1, 4, 5, and 6.
            Since 6 is the largest single number, we return it.


    Example 2:
        Input:
            MyNumbers table:
                +-----+
                | num |
                +-----+
                | 8   |
                | 8   |
                | 7   |
                | 7   |
                | 3   |
                | 3   |
                | 3   |
                +-----+

        Output:
            +------+
            | num  |
            +------+
            | null |
            +------+

        Explanation: There are no single numbers in the input table so we return null.
*/


/*
    Runtime
        576ms

    Beats
        78.82%

    Time Complexity
        O(Nlogn)
*/


-- 정답

SELECT MAX(num) as num
FROM (SELECT num FROM MyNumbers
      GROUP BY num
      HAVING COUNT(*) = 1);