INSERT INTO sport.contact_type (name) VALUES ('email');
INSERT INTO sport.contact_type (name) VALUES ('phone');

INSERT INTO sport.filiation (building, caption, city, country, index_city, street) VALUES ('101', 'Hercules', 'Dnipro', 'Ukraine', '49000', 'Yavornitskogo');
INSERT INTO sport.filiation (building, caption, city, country, index_city, street) VALUES ('5', 'Barbie', 'Kyev', 'Ukraine', '44000', 'Metrostroevskaya');

INSERT INTO sport.contact (data, contact_type_id, filiation_id) VALUES ('+380666666666', 2, 1);
INSERT INTO sport.contact (data, contact_type_id, filiation_id) VALUES ('+380505555555', 2, 1);
INSERT INTO sport.contact (data, contact_type_id, filiation_id) VALUES ('hercules@gmail.com', 1, 1);
INSERT INTO sport.contact (data, contact_type_id, filiation_id) VALUES ('barbie@gmail.com', 1, 2);
INSERT INTO sport.contact (data, contact_type_id, filiation_id) VALUES ('+380505555555', 2, 2);

INSERT INTO sport.news (title, date, description, image_url) VALUES ('Fifa’s treatment of Women’s World Cup final keeps ‘virus’ contained', '2018-07-21 13:06:15' , 'Back in the summer, 19-year-old Venezuelan international Deyna Castellanos was permitted to interview Gianni Infantino, with the result posted on the Women’s World Cup social media channels. “Next year in France, we will see the greatest, greatest, greatest Women’s World Cup ever,” promised the Fifa president. “We will have a country that celebrates women’s football – and this virus of women’s football will spread from France, over the whole world.”',
'https://saycheese.com.ua/wp-content/uploads/2018/04/Harkovskij-marafon-2-1200x630.jpg');
INSERT INTO sport.news (title, date, description, image_url) VALUES ('Why did Tim Howard and a Yankees owner buy non-league Dagenham & Redbridge?', '2018-03-01 10:00:20', 'A seven-strong consortium involving former USA and Everton goalkeeper Tim Howard and New York Yankees shareholder Peter Freund completed a takeover of English fifth-tier outfit Dagenham & Redbridge last month. It was the second episode of American investors entering the National League in just over a year.',
'https://www.sportlife.ua/sites/default/files/styles/colorbox/public/1_36.jpg?itok=txyNGBMZ');

INSERT INTO sport.administrator (admin_hash, login, email) VALUES ('d029e071a4f849edd107efcb9e5b9701d1bce3789b3ec44ee185834dd0d4fcf3006234d74070b1f6','admin', 'lesha@ukr.net');

INSERT INTO sport.user (email, first_name, last_name, phone, user_hash) VALUES ('petya@mail.com','Petya','Ribkin','+380(97)222-33-44','d029e071a4f849edd107efcb9e5b9701d1bce3789b3ec44ee185834dd0d4fcf3006234d74070b1f6');	
INSERT INTO sport.user (email, first_name, last_name, phone, user_hash) VALUES ('masha@mail.com','Masha','Pirojkova','+380(66)333-22-11','d029e071a4f849edd107efcb9e5b9701d1bce3789b3ec44ee185834dd0d4fcf3006234d74070b1f6');	

INSERT INTO sport.card (expiration_date, issue_date, pin_code, user, description) VALUES ('2/10/2018','2/11/2018','2345','1', 'swimming');	
INSERT INTO sport.card (expiration_date, issue_date, pin_code, user, description) VALUES ('8/12/2017','2/2/2018','1111','2', 'step');

INSERT INTO sport.training_type (`name`,description) VALUES ('Yoga','Various exercises. Coached by Efrovinina Maria. Time Classes - 35 min.');
INSERT INTO sport.training_type (`name`,description) VALUES ('Swimming','It is possible to take a track in the pool, consulting with the coach. Lesson time - 45 min.');

INSERT INTO sport.`day` (name) VALUES ('Monday'),('Tuesday'),('Wednesday'),('Thursday'),('Friday'),('Saturday'),('Sunday');

INSERT INTO sport.`training` (day, time, training_type_id, filiation_id) VALUES (1,'09:00:00',1,1), (1,'18:00:00',1,2),(2,'13:00:00',1,1),(2,'19:00:00',1,1),
																(3,'09:00:00',2,2), (4,'18:00:00',2,2), (5,'13:00:00',2,1), (6,'10:00:00',2,1);