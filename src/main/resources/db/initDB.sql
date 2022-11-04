--DROP TABLE IF EXISTS pet_type;
CREATE TABLE IF NOT EXISTS pet_type
(
    id    SERIAL NOT NULL PRIMARY KEY ,
    pet_type_name  VARCHAR(256) NOT NULL
    );

--DROP TABLE IF EXISTS item_type;
CREATE TABLE IF NOT EXISTS item_type
(
    id    SERIAL NOT NULL PRIMARY KEY ,
    item_type_name  VARCHAR(256) NOT NULL
    );

--DROP TABLE IF EXISTS brand_type;
CREATE TABLE IF NOT EXISTS brand_type
(
    id    SERIAL NOT NULL PRIMARY KEY ,
    item_brand_name  VARCHAR(256) NOT NULL,
    sale_in_procent INTEGER
    );

--DROP TABLE IF EXISTS item;
CREATE TABLE IF NOT EXISTS item
(
    id    SERIAL NOT NULL PRIMARY KEY ,
    cost INTEGER,
    item_name  VARCHAR(256) NOT NULL,
    description VARCHAR(256) NOT NULL,
    item_type_id INTEGER,
    pet_type_id INTEGER,
    brand_type_id INTEGER,
    image_item VARCHAR(256),
    FOREIGN KEY (item_type_id) REFERENCES item_type (id) ON DELETE CASCADE,
    FOREIGN KEY (pet_type_id) REFERENCES pet_type (id) ON DELETE CASCADE,
    FOREIGN KEY (brand_type_id) REFERENCES brand_type (id) ON DELETE CASCADE
    );

--DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users
(
    id SERIAL PRIMARY KEY ,
    username VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL,
    email VARCHAR(256) NOT NULL,
    role VARCHAR(256) NOT NULL
    );

--DROP TABLE IF EXISTS shopping_basket;
CREATE TABLE IF NOT EXISTS shopping_basket
(
    id SERIAL PRIMARY KEY ,
    user_id INTEGER,
    item_id INTEGER,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES item (id) ON DELETE CASCADE,
    amount INTEGER
    );

--DROP TABLE IF EXISTS orders;
CREATE TABLE IF NOT EXISTS orders
(
    id SERIAL PRIMARY KEY ,
    user_id INTEGER,
    order_time TIMESTAMP ,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    cost_order INTEGER
    );

--DROP TABLE IF EXISTS order_details;
CREATE TABLE IF NOT EXISTS order_details
(
    id SERIAL PRIMARY KEY ,
    order_id INTEGER,
    item_id INTEGER,
    FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES item (id) ON DELETE CASCADE,
    amount INTEGER
    );