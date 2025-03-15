DELETE P
FROM Person P INNER JOIN Person R ON P.email = R.email
WHERE P.id > R.id;