use sport;

insert into scheduleevent (`name`,description)values('Йога','Разнообразные упражнения. Ведет тренер Ефровинина Мария. Время Занятия - 35 мин.');
insert into scheduleevent (`name`,description)values('Плаванье','Можно занять дорожку в бассейне, консультации у тренера. Время Занятия - 45 мин.');

insert into `schedule` (dayofweek,starttime,fk_schedule_event_schedule) values(1,'09:00:00',1);
insert into `schedule` (dayofweek,starttime,fk_schedule_event_schedule) values(1,'18:00:00',1);
insert into `schedule` (dayofweek,starttime,fk_schedule_event_schedule) values(2,'13:30:00',1);
insert into `schedule` (dayofweek,starttime,fk_schedule_event_schedule) values(2,'19:30:00',1);
insert into `schedule` (dayofweek,starttime,fk_schedule_event_schedule) values(3,'09:00:00',2);
insert into `schedule` (dayofweek,starttime,fk_schedule_event_schedule) values(4,'18:00:00',2);
insert into `schedule` (dayofweek,starttime,fk_schedule_event_schedule) values(5,'13:30:00',2);
insert into `schedule` (dayofweek,starttime,fk_schedule_event_schedule) values(6,'19:30:00',2);


select * from scheduleevent sev
join `schedule` s on s.fk_schedule_event_schedule=sev.id;