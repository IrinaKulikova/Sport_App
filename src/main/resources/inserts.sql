INSERT INTO sport.contact_type (name) VALUES ('email');
INSERT INTO sport.contact_type (name) VALUES ('phone');
INSERT INTO sport.filial (building, caption, city, country, indexCity, street) VALUES ('101', 'Gym1', 'Dnipro', 'Ukraine', '49000', 'Yavornitskogo');
INSERT INTO sport.contact (data, fk_contact_type, fk_filial) VALUES ('+380666666666', 2, 1);
INSERT INTO sport.contact (data, fk_contact_type, fk_filial) VALUES ('+380505555555', 2, 1);
INSERT INTO sport.contact (data, fk_contact_type, fk_filial) VALUES ('gym@gmail.com', 1, 1);
INSERT INTO sport.news (title, date, description, imageURL) VALUES ('Участвуй в марафоне, получи бесплптную тенеровку', '2018-07-21 13:06:15' , 'Это будет третий марафон, который пройдет в 2018 году совместно с Чемпионатом Украины по марафону среди взрослых.
Вместе с элитой украинского спорта каждый любитель сможет пробежать одну из дистанций:42 км, 21 км, 10 км, 5 км, миля и эстафеты. Трасса марафона проходит в один круг и включает в себя живописную набережную, которая самая длинная в Европе.
Именно ровная трасса, без перепадов высоты в один круг так понравилась участникам первого экомарафона и позволит вам устанавливать рекорды в 2018 году.',
'https://saycheese.com.ua/wp-content/uploads/2018/04/Harkovskij-marafon-2-1200x630.jpg');
INSERT INTO sport.news (title, date, description, imageURL) VALUES ('Мы поддержал забег Intersport Run Ukraine', '2018-03-01 10:00:20', 'В центре столицы, на Крещатике, состоялся спортивный фестиваль INTERSPORT FEST UA. Кульминацией события стали беговые соревнования INTERSPORT RUN UA. Мероприятие посвящено Дню физической культуры и спорта Украины',
'https://www.sportlife.ua/sites/default/files/styles/colorbox/public/1_36.jpg?itok=txyNGBMZ');
INSERT INTO sport.administrator (login, password) VALUES ('admin','admin');
INSERT INTO sport.administrator (login, password) VALUES ('1admin1','admin2');
