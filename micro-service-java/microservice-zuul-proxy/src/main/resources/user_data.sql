

---create database
--- les tables seront crées par les entities hibernate



---- insert data into database


INSERT INTO microservice.users(id, email, name, password, username) VALUES (1, 'user@gmail.com', 'user_name', '$2a$10$d8uhGZ59zEK7dXZEbx7/0e28HyxGD65VoZTEJ96U2iKQWvnOqxHee', 'user');
INSERT INTO microservice.users(id, email, name, password, username) VALUES (2, 'manager@gmail.com', 'manager_name', '$2a$10$WyOpqA75aGwPHGD9PmlzYeNAoehb.E7ZR60FAhv25ojNXWWiUbJ8K', 'manager');
INSERT INTO microservice.users(id, email, name, password, username) VALUES (3, 'admin@gmail.com', 'admin_name', '$2a$10$O6RvVfwwyqfEv7ssRYILbu9nphYglZOP0SiX7XAMEqS64Vk1BRRFy', 'admin');

INSERT INTO microservice.roles(id, name) VALUES(1, 'ROLE_USER');
INSERT INTO microservice.roles(id, name) VALUES(2, 'ROLE_PM');
INSERT INTO microservice.roles(id, name) VALUES(3, 'ROLE_ADMIN');

INSERT INTO microservice.user_roles(user_id, role_id) VALUES (1, 1);
INSERT INTO microservice.user_roles(user_id, role_id) VALUES (3, 2);
INSERT INTO microservice.user_roles(user_id, role_id) VALUES (3, 3);



INSERT INTO microservice.produit(id, nom, categorie, prix) VALUES (1, 'Andrew Mike', 'Develop', '99.225');
INSERT INTO microservice.produit(id, nom, categorie, prix) VALUES (2, 'John Doe', 'Design', '89.241');
INSERT INTO microservice.produit(id, nom, categorie, prix) VALUES (3, 'Alex Mike', 'Design', '92.144');

INSERT INTO microservice.produit(id, nom, categorie, prix) VALUES (4, 'Mike Monday', 'Marketing', '49.990');
INSERT INTO microservice.produit(id, nom, categorie, prix) VALUES (5, 'Paul Dickens', 'Communication', '69.201');
INSERT INTO microservice.produit(id, nom, categorie, prix) VALUES (6, 'Dongmo Miaffo', 'Architecte', '99.99');

INSERT INTO microservice.produit(id, nom, categorie, prix) VALUES (7, 'user@gmail.com', 'user_name', '100');
INSERT INTO microservice.produit(id, nom, categorie, prix) VALUES (8, 'manager@gmail.com', 'manager_name', '100.30');
INSERT INTO microservice.produit(id, nom, categorie, prix) VALUES (9, 'admin@gmail.com', 'admin_name', '98.25');
