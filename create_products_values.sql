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

/* CREATE users table */

CREATE SEQUENCE users_id_seq;
CREATE TABLE users
(
  id integer NOT NULL DEFAULT nextval('users_id_seq'),
  email text,
  password character varying(255) NOT NULL,
  name character varying(100) NOT NULL,
  position text,
  phone text,
  date timestamp without time zone,
  enabled boolean,
  CONSTRAINT users_pkey PRIMARY KEY (id)
);


/* CREATE user_roles table */

CREATE SEQUENCE user_roles_user_role_id_seq;
CREATE TABLE user_roles
(
  user_role_id integer NOT NULL DEFAULT nextval('user_roles_user_role_id_seq'),
  user_id integer NOT NULL,
  authority character varying(45) NOT NULL,
  CONSTRAINT user_roles_pkey PRIMARY KEY (user_role_id),
  CONSTRAINT user_roles_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES public.users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE persistent_logins ( 
  username varchar(100) not null, 
  series varchar(64) primary key, 
  token varchar(64) not null, 
  last_used timestamp not null
);