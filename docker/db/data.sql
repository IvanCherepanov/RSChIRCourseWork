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

INSERT INTO pet_type (pet_type_name) VALUES (1, 'Собака');
INSERT INTO pet_type VALUES (2,'Кошка');
INSERT INTO pet_type VALUES (3,'Грызуны');
INSERT INTO pet_type VALUES (4,'Рыбы');
INSERT INTO pet_type VALUES (5,'Змея');
INSERT INTO pet_type VALUES (6,'Птицы');
INSERT INTO pet_type VALUES (7,'Котята');
INSERT INTO pet_type VALUES (8, 'Щенки');
INSERT INTO pet_type VALUES (9,'Кролики');
INSERT INTO pet_type VALUES (10,'Черепахи');
INSERT INTO pet_type VALUES (11,'Прочее');

INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (1, 908, 'Веда фитомины от аллергии для кошек', 'Фитокомплекс, входящий в состав корма, снижает предрасположенность к аллергическим заболеваниям, а также выраженность аллергических реакций – зуда, расчесов, мокнущих язв, высыпаний, непереносимость пищевых компонентов, реакции на различные бытовые и лекарственные раздражители, повышенную чувствительность кожи', 2, 2, 3, 'https://6kcmxu3d7l.a.trbcdn.net/upload/files-new/2f/98/68/463453_400x400.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (2, 214, 'Royal Canin паучи паучи кусочки в соусе для Мейн-куна старше 15 месяцев', 'Влажный корм для мейн куна Royal Canin Maine Coon стоит купить каждому хозяину, желающему обеспечить здоровье костей и суставов своего питомца.', 8, 2, 2, 'https://6kcmxu3d7l.a.trbcdn.net/upload/files-new/10/0e/df/622066_400x400.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (3, 100, 'Duis eu massa', 'incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex', 4, 2, 19, 'https://6kcmxu3d7l.a.trbcdn.net/upload/files-new/47/11/7d/553215_400x400.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (4, 1704, 'Eukanuba паучи для собак говядина в соусе', 'Влажный корм для собак с говядиной способствует поддержанию здоровой кишечной микрофлоры за счет пребиотиков и клетчатки. Включает в себя аппетитный соус.', 4, 1, 2, 'https://i.pinimg.com/originals/e6/be/f3/e6bef3835ff4658d296dc2b06434bf8a.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (5, 32, 'Bonsy лосьон для очистки ушей кошек и собак', 'Лосьон для ушей Bonsy - эффективное гигиеническое средство для обработки ушной раковины и наружного слухового прохода у животных. Натуральные компоненты мягко и бережно очищают уши животного, обладают противовоспалительными свойствами. ', 2, 1, 14, 'https://6kcmxu3d7l.a.trbcdn.net/upload/files-new/a0/2e/a8/569465_400x400.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (6, 1444, 'Tappi амуниция поводок круглый "Альтаис" зеленый, 120 см', 'Поводки Tappi изготовлены из капрона круглого плетения, они не боятся грязи, воды и атмосферных воздействий. Поводки оснащены прочной стальной фурнитурой, которая обеспечивает дополнительную безопасность Вашего питомца.', 8, 1, 11, 'https://6kcmxu3d7l.a.trbcdn.net/upload/files-new/76/20/51/608968_400x400.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (7, 300, 'Donec ut', 'molestie gravida', 2, 4, 12, 'https://6kcmxu3d7l.a.trbcdn.net/upload/files-new/d4/0c/c9/466223_400x400.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (8, 310, 'AQUACONS кондиционер для воды "Чистая вода", 50 мл', 'Кондиционер АКВАКОНС "Чистая вода" предназначен для создания и поддержания безопасной, здоровой среды в аквариуме, за счет устранения мутности аквариумной воды любого происхождения (массовое развитие бактерий, мельчайшие частицы ила, одноклеточные водоросли, "цветение воды" и др.)', 4, 4, 12, 'https://6kcmxu3d7l.a.trbcdn.net/upload/files-new/d4/0c/c9/466223_400x400.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (9, 320, 'ЗООМИР грунтоочиститель аквариумный', 'В процессе очистки грунта удаляются частицы остатков кормов и продуктов жизнедеятельности рыб, в результате разложения которых в аквариуме накапливаются токсичные вещества. Кроме того, рыхление грунта и его перемешивание улучшают газообмен у корней растений.', 8, 4, 12, 'https://6kcmxu3d7l.a.trbcdn.net/upload/files-new/56/bc/b2/601951_400x400.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (10, 330, 'Tetra (оборудование) картридж с углем Tetratec ЕasyCrystal Pack С 10', 'Для кристально прозрачной, здоровой воды
Инновационный фильтрующий картридж: аккуратная замена - руки остаются сухими
Механическая очистка: двусторонняя фильтрующая губка для надёжного удаления мельчайших частичек грязи. Белая сторона для предварительной фильтрации, зелёная сторона для тщательной тонкой фильтрации ', 8, 4, 12, 'https://6kcmxu3d7l.a.trbcdn.net/upload/files-new/7f/1c/79/483827_400x400.jpg');

INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (11, 908, 'Aenean eu consectetur', 'fdgfd', 2, 2, 3, 'https://6kcmxu3d7l.a.trbcdn.net/upload/files-new/47/11/7d/553215_400x400.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (12, 214, 'Duis euismod velit', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor', 1, 1, 2, 'https://i.pinimg.com/originals/e6/be/f3/e6bef3835ff4658d296dc2b06434bf8a.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (13, 100, 'Duis eu massa', 'incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex', 3, 2, 19, 'https://6kcmxu3d7l.a.trbcdn.net/upload/files-new/47/11/7d/553215_400x400.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (14, 2144, 'Donec nibh', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor', 1, 1, 2, 'https://i.pinimg.com/originals/e6/be/f3/e6bef3835ff4658d296dc2b06434bf8a.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (15, 32, 'Praesent lacinia', 'Mauris', 9, 3, 14, 'https://bugaga.ru/uploads/posts/2013-06/1372187505_vodnye-peyzazhi-1.jpg');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (16, 1444, 'Morbi sed', 'Mauris', 1, 6, 11, 'https://images.unsplash.com/photo-1644344776267-ca730737973b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (17, 300, 'Donec ut', 'molestie gravida', 1, 1, 12, 'https://images.unsplash.com/photo-1682621034494-2242e054972c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=363&q=80');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (18, 310, 'Mauris id', 'consectetur nunc', 1, 1, 12, 'https://images.unsplash.com/photo-1682621034494-2242e054972c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=363&q=80');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (19, 320, 'Nam auctor', 'lacus sapien', 1, 1, 12, 'https://images.unsplash.com/photo-1682621034494-2242e054972c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=363&q=80');
INSERT INTO item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
VALUES (20, 330, 'Nulla tincidunt', 'turpis nec sapie', 1, 1, 12, 'https://images.unsplash.com/photo-1682621034494-2242e054972c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=363&q=80');

insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (21, 856, 'Yellowishwhite Bladderwort', 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', 1, 1, 23, 'https://ae04.alicdn.com/kf/Sacab74888ca94de695eafc30cf6562b8O/-.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (22, 218, 'Carolina Bugbane', 'Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', 8, 1, 4, 'https://ae04.alicdn.com/kf/Sacab74888ca94de695eafc30cf6562b8O/-.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (23, 242, 'Fountain Fern', 'Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.', 7, 1, 32, 'https://ae04.alicdn.com/kf/Sacab74888ca94de695eafc30cf6562b8O/-.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (24, 702, 'Rattlesnakemaster', 'Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', 3, 1, 19, 'https://ae04.alicdn.com/kf/Sacab74888ca94de695eafc30cf6562b8O/-.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (25, 913, 'Lundell''s Nailwort', 'Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.', 6, 1, 1, 'https://ae04.alicdn.com/kf/Sacab74888ca94de695eafc30cf6562b8O/-.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (26, 576, 'Silverleaf Milkvetch', 'Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', 6, 1, 20, 'https://ae04.alicdn.com/kf/Sacab74888ca94de695eafc30cf6562b8O/-.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (27, 638, 'Congo Coffee', 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.', 4, 1, 35, 'https://www.belykrolik.ru/media/catalog/product_images/7570824_1_schleich-nabor-aksessuarov-dlya-figurok-korm-dlya-sobak-i-kotov-tsvet-bezhevyij-krasnyij-sinij.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (28, 750, 'Polar Milkvetch', 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.', 6, 1, 5, 'https://www.belykrolik.ru/media/catalog/product_images/7570824_1_schleich-nabor-aksessuarov-dlya-figurok-korm-dlya-sobak-i-kotov-tsvet-bezhevyij-krasnyij-sinij.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (29, 996, 'Podunk Ragwort', 'Sed ante. Vivamus tortor. Duis mattis egestas metus.', 11, 1, 21, 'https://www.belykrolik.ru/media/catalog/product_images/7570824_1_schleich-nabor-aksessuarov-dlya-figurok-korm-dlya-sobak-i-kotov-tsvet-bezhevyij-krasnyij-sinij.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (30, 339, 'Contura Creek Sandmat', 'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.', 9, 1, 36, 'https://www.belykrolik.ru/media/catalog/product_images/7570824_1_schleich-nabor-aksessuarov-dlya-figurok-korm-dlya-sobak-i-kotov-tsvet-bezhevyij-krasnyij-sinij.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (31, 816, 'Nesaea', 'Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.', 4, 1, 22, 'https://www.belykrolik.ru/media/catalog/product_images/7570824_1_schleich-nabor-aksessuarov-dlya-figurok-korm-dlya-sobak-i-kotov-tsvet-bezhevyij-krasnyij-sinij.jpg');

insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (32, 438, 'Mapleleaf Oak', 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.', 11, 2, 20, 'https://cdn.100sp.ru/pictures/181518973');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (33, 624, 'Tufted Penstemon', 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', 2, 2, 12, 'https://cdn.100sp.ru/pictures/181518973');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (34, 609, 'Meadow Thistle', 'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.', 5, 2, 12, 'https://cdn2.static1-sima-land.com/items/1442422/0/700-nw.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
 values (35, 699, 'Fountainbush', 'Fusce consequat. Nulla nisl. Nunc nisl.', 4, 2, 3, 'https://cdn2.static1-sima-land.com/items/1442422/0/700-nw.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (36, 328, 'Scribble Lichen', 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.', 9, 2, 39, 'https://cdn1.ozone.ru/s3/multimedia-j/6481502935.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (37, 411, 'Wingstem Spurry', 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 5, 2, 4, 'https://cdn1.ozone.ru/s3/multimedia-j/6481502935.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (38, 153, 'Rim Lichen', 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', 7, 2, 7, 'https://ae04.alicdn.com/kf/HTB1uXpqr7omBKNjSZFqq6xtqVXaG/-.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (39, 365, 'Punchberry', 'Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', 8, 2, 13, 'https://ae04.alicdn.com/kf/HTB1uXpqr7omBKNjSZFqq6xtqVXaG/-.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (40, 595, 'American Trailplant', 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', 8, 2, 14, 'https://cdn1.ozone.ru/s3/multimedia-k/6465161960.jpg');

insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (41, 294, 'Whitetinge Sedge', 'Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', 9, 4, 13, 'https://cdn1.ozone.ru/s3/multimedia-s/6095918176.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (42, 562, 'Himalayan Mayapple', 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.', 6, 4, 14, 'https://cdn1.ozone.ru/s3/multimedia-s/6095918176.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (43, 366, 'Shrubby Mayweed', 'Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 8, 4, 1, 'https://cdn1.ozone.ru/s3/multimedia-s/6095918176.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (44, 278, 'Earth Lichen', 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', 4, 4, 10, 'https://www.v063.ru/upload/iblock/0b3/mag3.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (45, 242, 'Rattan''s Beardtongue', 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.', 2, 4, 36, 'https://www.v063.ru/upload/iblock/0b3/mag3.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (46, 525, 'Perfoliate Baby''s-breath', 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', 3, 4, 8, 'https://www.v063.ru/upload/iblock/0b3/mag3.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (47, 766, 'Manyspore Rinodina Lichen', 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.', 7, 4, 3, 'https://avatars.mds.yandex.net/get-altay/2384894/2a000001719d2cf7404ac51b02432d8079e3/XXXL');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (48, 381, 'Mountain Ragwort', 'Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.', 2, 4, 35, 'https://avatars.mds.yandex.net/get-altay/2384894/2a000001719d2cf7404ac51b02432d8079e3/XXXL');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (49, 577, 'California Desert-thorn', 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', 1, 4, 10, 'https://cdn1.ozone.ru/multimedia/1013957818.jpg');
insert into item (id, cost, item_name, description, item_type_id, pet_type_id, brand_type_id, image_item)
values (50, 506, 'Bluejoint', 'Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', 7, 4, 24, 'https://cdn1.ozone.ru/multimedia/1013957818.jpg');

