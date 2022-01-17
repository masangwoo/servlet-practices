show tables;
desc guestbook;

-- insert
insert into guestbook values(null,'마상우' , '1234', 'ㅎㅇ',now());

-- select
select no, name, date_format(reg_date,'%Y/%m/%d %H:%i:%s') as reg_date, message from guestbook order by no desc;

select * from guestbook;

-- delete
delete from guestbook where no=1 and password = '1234';