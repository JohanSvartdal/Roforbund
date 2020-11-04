SELECT Fornavn, Etternavn, Navn
FROM bruker b
INNER JOIN klubber k
ON b.Klubb_id = k.Klubb_id
WHERE Rolle = 2;