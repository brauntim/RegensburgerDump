-- Aufgabe 2

CREATE TABLE freundschaften (
    person1 VARCHAR(50),
    person2 VARCHAR(50),
    PRIMARY KEY (person1, person2)
);


CREATE OR REPLACE FUNCTION umgekehrte_freundschaft() RETURNS TRIGGER AS
    $$
    BEGIN
        INSERT INTO freundschaften (person1, person2) VALUES (NEW.person2, NEW.person1);
        RETURN NEW;
    END;
    $$ LANGUAGE PLPGSQL;


CREATE OR REPLACE TRIGGER freundschaften_trigger AFTER INSERT ON freundschaften
    FOR EACH ROW WHEN (pg_trigger_depth() < 1) EXECUTE PROCEDURE umgekehrte_freundschaft();


INSERT INTO freundschaften (person1, person2) VALUES ('Peter', 'Manfred');

SELECT * FROM freundschaften;
TRUNCATE TABLE freundschaften;