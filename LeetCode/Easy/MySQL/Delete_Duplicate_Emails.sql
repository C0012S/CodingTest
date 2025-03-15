/*
Easy. #196 - Delete Duplicate Emails

    Accepted  678.1K    Submissions  1.1M    Acceptance Rate  63.9%


    Table: Person
        +-------------+---------+
        | Column Name | Type    |
        +-------------+---------+
        | id          | int     |
        | email       | varchar |
        +-------------+---------+

        id is the primary key (column with unique values) for this table.
        Each row of this table contains an email. The emails will not contain uppercase letters.


    Write a solution to delete all duplicate emails, keeping only one unique email with the smallest .id
    For SQL users, please note that you are supposed to write a statement and not a one.DELETESELECT
    For Pandas users, please note that you are supposed to modify in place.Person
    After running your script, the answer shown is the table. The driver will first compile and run your piece of code and then show the table. The final order of the table does not matter.PersonPersonPerson
    The result format is in the following example.


    Example 1:
        Input:
            Person table:
                +----+------------------+
                | id | email            |
                +----+------------------+
                | 1  | john@example.com |
                | 2  | bob@example.com  |
                | 3  | john@example.com |
                +----+------------------+

            Output:
                +----+------------------+
                | id | email            |
                +----+------------------+
                | 1  | john@example.com |
                | 2  | bob@example.com  |
                +----+------------------+

            Explanation: john@example.com is repeated two times. We keep the row with the smallest Id = 1.
*/


/*
    Runtime
        1305ms

    Beats
        58.00%

    Time Complexity
        O(N^2)
*/


-- 정답

DELETE P
FROM Person P INNER JOIN Person R ON P.email = R.email
WHERE P.id > R.id;