DROP TABLE product IF EXISTS;
CREATE TABLE IF NOT EXISTS product (id bigserial, title VARCHAR(255), price int, PRIMARY KEY (id));
INSERT INTO product (title, price) VALUES ('Milk', 23), ('Keck', 44), ('Coconut', 80);
