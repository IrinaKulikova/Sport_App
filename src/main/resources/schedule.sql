use sport;

insert into scheduleevent (`name`,description)values('Йога','Різноманіні вправи. Веде тренер Ефросініна Марія. Час занняття - 35 мін.');
insert into scheduleevent (`name`,description)values('Плавання','Можно зайняти доріжку в басейні, консультаціі у тренера. Час заняття - 45 мін.');


insert into day (attribute,nameday) values(1,'Понеділок');
insert into day (attribute,nameday) values(2,'Вівторок');
insert into day (attribute,nameday) values(3,'Середа');
insert into day (attribute,nameday) values(4,'Четверг');
insert into day (attribute,nameday) values(5,'Пятниця');
insert into day (attribute,nameday) values(6,'Субота');
insert into day (attribute,nameday) values(7,'Неділя');


insert into `schedule` (dayid,starttime,event_schedule) values(1,'09:00:00',1);
insert into `schedule` (dayid,starttime,event_schedule) values(1,'18:00:00',1);
insert into `schedule` (dayid,starttime,event_schedule) values(2,'13:00:00',1);
insert into `schedule` (dayid,starttime,event_schedule) values(2,'14:00:00',1);
insert into `schedule` (dayid,starttime,event_schedule) values(3,'09:00:00',2);
insert into `schedule` (dayid,starttime,event_schedule) values(4,'18:00:00',2);
insert into `schedule` (dayid,starttime,event_schedule) values(5,'13:00:00',2);
insert into `schedule` (dayid,starttime,event_schedule) values(6,'10:00:00',2);



select * from scheduleevent sev
join `schedule` s on s.event_schedule=sev.id;