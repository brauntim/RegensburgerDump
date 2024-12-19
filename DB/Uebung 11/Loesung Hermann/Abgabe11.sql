-- Lösung für den Johannes
create or replace function fakultaet(n INT)
returns INT as $$
declare
    result INT := 1;
BEGIN 
    if n < 0 then
        raise notice 'Die Fakultät einer negativen Zahl ist nicht definiert.';
    elsif n = 0 then
        return result;
    else
        for i in 1.. n loop
            result := reslt * i;
        end loop;
        return result;
    end if;
END;
$$
LANGUAGE plpgsql;



-- Meine Lösung 

create or replace function fakultaet(n INT) 
returns INT as $$
declare 
	result INT := 1;
begin 
	if n < 0 then 
        raise exception 'fak of a negative number is not possible';
        elsif n = 0 then
        raise notice 'fak of % is %', n, result;
        return result;
	else
		while n > 1
		loop
			result :=  result * n;
			n := n - 1;
		end loop;
		raise notice 'fak of % is %', n, result;
		return result;
	end if;
end $$ language plpgsql;

-- als Beispielsaufruf

select fakultaet(5);
