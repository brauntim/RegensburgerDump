-- Aufgabe 1

CREATE OR REPLACE FUNCTION factorial(_number INT) RETURNS INT AS
    $$
    DECLARE
        _result INT := 1;
    BEGIN
        IF _number < 0 THEN
            RAISE EXCEPTION 'Fakultätsberechnung ist für negative Werte nicht möglich';
        END IF;

        FOR _i IN 1.._number LOOP _result = _result * _i; END LOOP;

        RETURN _result;
    END
    $$ LANGUAGE PLPGSQL;


SELECT factorial(12);
-- Der Wert von 13! ist zu groß, um ihn in einer Integer-Variable zu speichern,
-- daher entsteht eine Integer out of Range Exception



-- Aufgabe 2

CREATE OR REPLACE PROCEDURE kontakte_vorbereiten(_anzahl INT) AS
    $$
    BEGIN
         DROP TABLE IF EXISTS kontakte_es11;

         CREATE TABLE kontakte_es11 (
             name VARCHAR(200) PRIMARY KEY,
             handynummer VARCHAR(20),
             gesucht INT NOT NULL DEFAULT 0
         );

         IF _anzahl < 0 THEN
             RAISE EXCEPTION 'Ungültige Anzahl';
         END IF;

         FOR _i IN 1.._anzahl LOOP
            INSERT INTO kontakte_es11 (name, handynummer) VALUES ('Dummy'||_i, '100'||_i);
        END LOOP;
    END
    $$ LANGUAGE PLPGSQL;

CALL kontakte_vorbereiten(1000000);

SELECT COUNT(*) FROM kontakte_es11;
SELECT * FROM kontakte_es11;