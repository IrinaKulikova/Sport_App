INSERT INTO sport.contact_type (name) VALUES ('email');
INSERT INTO sport.contact_type (name) VALUES ('phone');
INSERT INTO sport.filial (building, caption, city, country, index_city, street) VALUES ('101', 'Gym1', 'Dnipro', 'Ukraine', '49000', 'Yavornitskogo');
INSERT INTO sport.contact (data, contact_type_id, filial_id) VALUES ('+380666666666', 2, 1);
INSERT INTO sport.contact (data, contact_type_id, filial_id) VALUES ('+380505555555', 2, 1);
INSERT INTO sport.contact (data, contact_type_id, filial_id) VALUES ('gym@gmail.com', 1, 1);
INSERT INTO sport.news (title, date, description, image_url) VALUES ('Участвуй в марафоне, получи бесплптную тенеровку', '2018-07-21 13:06:15' , 'Это будет третий марафон, который пройдет в 2018 году совместно с Чемпионатом Украины по марафону среди взрослых.
Вместе с элитой украинского спорта каждый любитель сможет пробежать одну из дистанций:42 км, 21 км, 10 км, 5 км, миля и эстафеты. Трасса марафона проходит в один круг и включает в себя живописную набережную, которая самая длинная в Европе.
Именно ровная трасса, без перепадов высоты в один круг так понравилась участникам первого экомарафона и позволит вам устанавливать рекорды в 2018 году.',
'https://saycheese.com.ua/wp-content/uploads/2018/04/Harkovskij-marafon-2-1200x630.jpg');
INSERT INTO sport.news (title, date, description, image_url) VALUES ('Мы поддержал забег Intersport Run Ukraine', '2018-03-01 10:00:20', 'В центре столицы, на Крещатике, состоялся спортивный фестиваль INTERSPORT FEST UA. Кульминацией события стали беговые соревнования INTERSPORT RUN UA. Мероприятие посвящено Дню физической культуры и спорта Украины',
'https://www.sportlife.ua/sites/default/files/styles/colorbox/public/1_36.jpg?itok=txyNGBMZ');
INSERT INTO sport.administrator (admin_hash, login) VALUES ('d029e071a4f849edd107efcb9e5b9701d1bce3789b3ec44ee185834dd0d4fcf3006234d74070b1f6','admin');
INSERT INTO sport.user (email, first_name, last_name, phone, user_hash) VALUES ('petya@mail.com','Petya','Ribkin','+380(97)222-33-44','d029e071a4f849edd107efcb9e5b9701d1bce3789b3ec44ee185834dd0d4fcf3006234d74070b1f6');
INSERT INTO sport.card (expiration_date, issue_date, pin_code, card_user_id) VALUES ('2/10/2018','2/11/2018','2345','1');
INSERT INTO sport.card (expiration_date, issue_date, pin_code, card_user_id) VALUES ('2/10/2018','2/12/2018','2121','1');