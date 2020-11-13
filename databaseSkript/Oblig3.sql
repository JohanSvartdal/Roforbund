SELECT Fornavn, Etternavn, Navn
FROM bruker b
INNER JOIN klubber k
ON b.Klubb_id = k.Klubb_id
WHERE Rolle = 2;


SELECT * FROM bruker
ORDER BY Bruker_id
LIMIT 10;

SELECT * FROM klubber
ORDER BY Klubb_id
LIMIT 10;

SELECT * FROM ovelser
ORDER BY Ovelse_id
LIMIT 10;

SELECT * FROM resultater
ORDER BY Resultat_id
LIMIT 10;

SELECT * FROM tester
ORDER BY Test_id
LIMIT 10;