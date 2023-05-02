insert into brand_type (item_brand_name, sale_in_procent) values ('It', 23);
insert into brand_type (item_brand_name, sale_in_procent) values ('Treeflex', 24);
insert into brand_type (item_brand_name, sale_in_procent) values ('Matsoft', 48);
insert into brand_type (item_brand_name, sale_in_procent) values ('Home Ing', 17);
insert into brand_type (item_brand_name, sale_in_procent) values ('Namfix', 20);
insert into brand_type (item_brand_name, sale_in_procent) values ('Home Ing', 50);
insert into brand_type (item_brand_name, sale_in_procent) values ('Alpha', 9);
insert into brand_type (item_brand_name, sale_in_procent) values ('Bitwolf', 6);
insert into brand_type (item_brand_name, sale_in_procent) values ('Konklux', 27);
insert into brand_type (item_brand_name, sale_in_procent) values ('Opela', 26);
insert into brand_type (item_brand_name, sale_in_procent) values ('Keylex', 24);
insert into brand_type (item_brand_name, sale_in_procent) values ('Voltsillam', 35);
insert into brand_type (item_brand_name, sale_in_procent) values ('It', 26);
insert into brand_type (item_brand_name, sale_in_procent) values ('Opela', 19);
insert into brand_type (item_brand_name, sale_in_procent) values ('Tin', 42);
insert into brand_type (item_brand_name, sale_in_procent) values ('Kanlam', 48);
insert into brand_type (item_brand_name, sale_in_procent) values ('Otcom', 46);
insert into brand_type (item_brand_name, sale_in_procent) values ('Ventosanzap', 57);
insert into brand_type (item_brand_name, sale_in_procent) values ('Prodder', 57);
insert into brand_type (item_brand_name, sale_in_procent) values ('Cookley', 47);
insert into brand_type (item_brand_name, sale_in_procent) values ('Keylex', 46);
insert into brand_type (item_brand_name, sale_in_procent) values ('Fintone', 32);
insert into brand_type (item_brand_name, sale_in_procent) values ('Tin', 9);
insert into brand_type (item_brand_name, sale_in_procent) values ('Flowdesk', 35);
insert into brand_type (item_brand_name, sale_in_procent) values ('Tampflex', 7);
insert into brand_type (item_brand_name, sale_in_procent) values ('Duobam', 31);
insert into brand_type (item_brand_name, sale_in_procent) values ('Ronstring', 38);
insert into brand_type (item_brand_name, sale_in_procent) values ('Veribet', 52);
insert into brand_type (item_brand_name, sale_in_procent) values ('Konklux', 16);
insert into brand_type (item_brand_name, sale_in_procent) values ('Zaam-Dox', 55);
insert into brand_type (item_brand_name, sale_in_procent) values ('Zontrax', 44);
insert into brand_type (item_brand_name, sale_in_procent) values ('Vagram', 36);
insert into brand_type (item_brand_name, sale_in_procent) values ('Andalax', 44);
insert into brand_type (item_brand_name, sale_in_procent) values ('Zamit', 33);
insert into brand_type (item_brand_name, sale_in_procent) values ('Bytecard', 46);
insert into brand_type (item_brand_name, sale_in_procent) values ('Solarbreeze', 44);
insert into brand_type (item_brand_name, sale_in_procent) values ('Andalax', 58);
insert into brand_type (item_brand_name, sale_in_procent) values ('Y-find', 29);
insert into brand_type (item_brand_name, sale_in_procent) values ('Overhold', 30);
insert into brand_type (item_brand_name, sale_in_procent) values ('Cardguard', 26);

INSERT INTO item_type (item_type_name) VALUES ('Корм');
INSERT INTO item_type (item_type_name) VALUES ('Лекарство');
INSERT INTO item_type  (item_type_name) VALUES ('Оборудование');
INSERT INTO item_type (item_type_name) VALUES ('Игрушка');
INSERT INTO item_type  (item_type_name) VALUES ('Гигиена');
INSERT INTO item_type (item_type_name) VALUES ('Прочее');
INSERT INTO item_type  (item_type_name) VALUES ('Экспериментальные корма');
INSERT INTO item_type  (item_type_name) VALUES ('Консервы');
INSERT INTO item_type  (item_type_name) VALUES ('Наполнители');
INSERT INTO item_type  (item_type_name) VALUES ('Витамины');
INSERT INTO item_type  (item_type_name) VALUES ('Премиум');

INSERT INTO pet_type (pet_type_name) VALUES ('Собака');
INSERT INTO pet_type VALUES (2,'Кошка');
INSERT INTO pet_type VALUES (3,'Грызуны');
INSERT INTO pet_type VALUES (4,'Рыбы');
INSERT INTO pet_type VALUES (5,'Змея');
INSERT INTO pet_type VALUES (6,'Птицы');
INSERT INTO pet_type VALUES (7,'Котята');
INSERT INTO pet_type VALUES (8, 'Щенки');
INSERT INTO pet_type VALUES (9,'Временное');

INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (2, 908, 'Объект1', 'fdgfd', 2, 2, 3, 'https://6kcmxu3d7l.a.trbcdn.net/upload/files-new/47/11/7d/553215_400x400.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (1, 214, 'Объект', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor', 1, 1, 2, 'https://i.pinimg.com/originals/e6/be/f3/e6bef3835ff4658d296dc2b06434bf8a.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (4, 100, 'Объект3', 'incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex', 3, 2, 19, 'https://6kcmxu3d7l.a.trbcdn.net/upload/files-new/47/11/7d/553215_400x400.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (5, 2144, 'Объект', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor', 1, 1, 2, 'https://i.pinimg.com/originals/e6/be/f3/e6bef3835ff4658d296dc2b06434bf8a.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (7, 32, 'Объект11', 'uytu', 9, 3, 14, 'https://bugaga.ru/uploads/posts/2013-06/1372187505_vodnye-peyzazhi-1.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (9, 1222444, 'gfd', 'fg', 1, 6, 11, 'https://images.unsplash.com/photo-1644344776267-ca730737973b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (10, 300, 'bgfnhgndh', 'qwqwqwqw', 1, 1, 12, 'https://images.unsplash.com/photo-1682621034494-2242e054972c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=363&q=80');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (11, 300, 'bgfnhgndh', 'qwqwqwqw', 1, 1, 12, 'https://images.unsplash.com/photo-1682621034494-2242e054972c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=363&q=80');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (12, 300, 'bgfnhgndh', 'qwqwqwqw', 1, 1, 12, 'https://images.unsplash.com/photo-1682621034494-2242e054972c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=363&q=80');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (13, 300, 'bgfnhgndh', 'qwqwqwqw', 1, 1, 12, 'https://images.unsplash.com/photo-1682621034494-2242e054972c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=363&q=80');
