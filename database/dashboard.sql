create table conta(id int auto_increment unique, nome varchar(255) not null, idade int(2) not null);


insert into conta(nome, idade)
values ("Reginaldo", 22),
	   ("Gleyce", 20),
       ("Suelen", 19);

select * from conta;

update conta set idade = 23 where id = 1;
select * from conta;

delete from conta;