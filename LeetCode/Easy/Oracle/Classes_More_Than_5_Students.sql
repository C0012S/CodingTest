/*
Easy. #596 - Classes More Than 5 Students

    Accepted  595.4K    Submissions  994.7K    Acceptance Rate  59.9%


    Table: Courses
        +-------------+---------+
        | Column Name | Type    |
        +-------------+---------+
        | student     | varchar |
        | class       | varchar |
        +-------------+---------+

        (student, class) is the primary key (combination of columns with unique values) for this table.
        Each row of this table indicates the name of a student and the class in which they are enrolled.


    Write a solution to find all the classes that have at least five students.
    Return the result table in any order.
    The result format is in the following example.


    Example 1:
        Input:
            Courses table:
                +---------+----------+
                | student | class    |
                +---------+----------+
                | A       | Math     |
                | B       | English  |
                | C       | Math     |
                | D       | Biology  |
                | E       | Math     |
                | F       | Computer |
                | G       | Math     |
                | H       | Math     |
                | I       | Math     |
                +---------+----------+

        Output:
            +---------+
            | class   |
            +---------+
            | Math    |
            +---------+

        Explanation:
            - Math has 6 students, so we include it.
            - English has 1 student, so we do not include it.
            - Biology has 1 student, so we do not include it.
            - Computer has 1 student, so we do not include it.
*/


/*
    Runtime
        437ms

    Beats
        89.70%

    Time Complexity
        O(N)
*/


-- 정답 

SELECT class
FROM (SELECT class, COUNT(*) AS student_count
      FROM Courses
      GROUP BY class)
WHERE student_count >= 5;