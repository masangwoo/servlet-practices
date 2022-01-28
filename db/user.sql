show tables;
desc user;

-- insert
insert into user values(null,'관리자', 'admin@mysite.com','1234','male', now());

-- select1(login)
select no, name from user where email='admin@mysite.com' and password='1234';
select * from user;
-- select2(update profile)
select no, name from user where email='admin@mysite.com' and password='1234';
-- update
update user set name="", gender = '' where no='';
update user set name="", gender = '', password='' where no='';