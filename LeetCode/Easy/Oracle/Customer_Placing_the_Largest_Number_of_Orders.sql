/*
Easy. #586 - Customer Placing the Largest Number of Orders

    Accepted  327.9K    Submissions  508.3K    Acceptance Rate  64.5%


    Table: Orders
        +-----------------+----------+
        | Column Name     | Type     |
        +-----------------+----------+
        | order_number    | int      |
        | customer_number | int      |
        +-----------------+----------+

        order_number is the primary key (column with unique values) for this table.
        This table contains information about the order ID and the customer ID.


    Write a solution to find the for the customer who has placed the largest number of orders.customer_number
    The test cases are generated so that exactly one customer will have placed more orders than any other customer.
    The result format is in the following example.


    Example 1:
        Input:
            Orders table:
                +--------------+-----------------+
                | order_number | customer_number |
                +--------------+-----------------+
                | 1            | 1               |
                | 2            | 2               |
                | 3            | 3               |
                | 4            | 3               |
                +--------------+-----------------+

        Output:
            +-----------------+
            | customer_number |
            +-----------------+
            | 3               |
            +-----------------+


    Explanation:
        The customer with number 3 has two orders, which is greater than either customer 1 or 2 because each of them only has one order.
        So the result is customer_number 3.


    Follow up: What if more than one customer has the largest number of orders, can you find all the in this case?customer_number
*/


/*
    Runtime
        705ms

    Beats
        86.07%

    Time Complexity
        O(N^2)
*/


-- 정답

SELECT customer_number
FROM ORDERS
GROUP BY customer_number;
HAVING COUNT(customer_number) = (
            SELECT MAX(count_number)
            FROM (SELECT customer_number, COUNT(*) AS count_number
                    FROM Orders
                    GROUP BY customer_number)
       );