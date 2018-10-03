use sport;

insert into scheduleevent (`name`,description)values('Йога','Разнообразные упражнения. Ведет тренер Ефровинина Мария. Время Занятия - 35 мин.');
insert into scheduleevent (`name`,description)values('Плаванье','Можно занять дорожку в бассейне, консультации у тренера. Время Занятия - 45 мин.');


insert into day (attribute,nameday) values(1,'Понедельник');
insert into day (attribute,nameday) values(2,'Вторник');
insert into day (attribute,nameday) values(3,'Среда');
insert into day (attribute,nameday) values(4,'Четверг');
insert into day (attribute,nameday) values(5,'Пятница');
insert into day (attribute,nameday) values(6,'Суббота');
insert into day (attribute,nameday) values(7,'Воскресенье');


insert into `schedule` (dayid,starttime,event_schedule) values(1,'09:00:00',1);
insert into `schedule` (dayid,starttime,event_schedule) values(1,'18:00:00',1);
insert into `schedule` (dayid,starttime,event_schedule) values(2,'13:30:00',1);
insert into `schedule` (dayid,starttime,event_schedule) values(2,'19:30:00',1);
insert into `schedule` (dayid,starttime,event_schedule) values(3,'09:00:00',2);
insert into `schedule` (dayid,starttime,event_schedule) values(4,'18:00:00',2);
insert into `schedule` (dayid,starttime,event_schedule) values(5,'13:30:00',2);
insert into `schedule` (dayid,starttime,event_schedule) values(6,'19:30:00',2);



select * from scheduleevent sev
join `schedule` s on s.event_schedule=sev.id;