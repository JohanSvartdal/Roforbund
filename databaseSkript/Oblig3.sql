SELECT Fornavn, Etternavn, Navn
FROM bruker b
INNER JOIN klubber k
ON b.Klubb_id = k.Klubb_id
WHERE Rolle = 2;

SELECT Fornavn, Etternavn, Navn
FROM klubber k
INNER JOIN bruker b
ON k.Klubb_id = b.Klubb_id
WHERE Rolle = 2;

SELECT Tid, Watt, KG, Repetisjoner, Fornavn
FROM bruker b
INNER JOIN resultater r
ON b.Bruker_id = r.Bruker_id
WHERE Test_id = 1;




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

SELECT Navn
FROM klubber
WHERE Klubb_id = 1;

SELECT