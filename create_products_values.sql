CREATE SEQUENCE products_id_seq;
CREATE TABLE products
(
  id integer NOT NULL DEFAULT nextval('products_id_seq') PRIMARY KEY,
  articule text,
  name text
);

INSERT INTO products (articule, name) VALUES('10001','Test name 1');
INSERT INTO products (articule, name) VALUES('10002','Test name 2');
INSERT INTO products (articule, name) VALUES('10003','Test name 3');
INSERT INTO products (articule, name) VALUES('10004','Test name 4');
INSERT INTO products (articule, name) VALUES('10005','Test name 5');