-- Aufgabe 11.2

create or replace procedure kontakte_vorbereiten(anzahl INT) as 
$$
declare i INT;
begin
    drop table if exists kontakte;
    create table kontakte (
        name VARCHAR(200) primary key, handynummer VARCHAR(20),
        gesucht INT not null default 0
    );
    for i in 1..anzahl loop
        insert into kontakte(name, handynummer) values
        ('Peter' || i, '0151-' || i);
    end loop;
    if anzahl < 0 then
        raise exception 'Ungütlige Anzahl';
    end if;
end
$$
language plpgsql;

call kontakte_vorbereiten(100000);

select * from kontakte;
