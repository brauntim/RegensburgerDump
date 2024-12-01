# Abgabe 8

create view hbf as
select b.bf_nr, b.bundesland, b.station, b.kat_vst as kategorie
from bahnhoefe b 
where b.station like '%Hbf' or b.station like '%Hauptbahnhof';
