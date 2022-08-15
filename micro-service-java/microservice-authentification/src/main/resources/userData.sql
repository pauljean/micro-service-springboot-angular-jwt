INSERT INTO users(id, email, name, password, username,actived) VALUES (1, 'user@gmail.com', 'user_name', '$2a$10$d8uhGZ59zEK7dXZEbx7/0e28HyxGD65VoZTEJ96U2iKQWvnOqxHee', 'user',true);
INSERT INTO users(id, email, name, password, username,actived) VALUES (2, 'manager@gmail.com', 'manager_name', '$2a$10$WyOpqA75aGwPHGD9PmlzYeNAoehb.E7ZR60FAhv25ojNXWWiUbJ8K', 'manager',true);
INSERT INTO users(id, email, name, password, username,actived) VALUES (3, 'admin@gmail.com', 'admin_name', '$2a$10$O6RvVfwwyqfEv7ssRYILbu9nphYglZOP0SiX7XAMEqS64Vk1BRRFy', 'admin',true);

INSERT INTO roles(id, name) VALUES(1, 'ROLE_USER');
INSERT INTO roles(id, name) VALUES(2, 'ROLE_PM');
INSERT INTO roles(id, name) VALUES(3, 'ROLE_ADMIN');

INSERT INTO user_roles(user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles(user_id, role_id) VALUES (3, 2);
INSERT INTO user_roles(user_id, role_id) VALUES (3, 3);