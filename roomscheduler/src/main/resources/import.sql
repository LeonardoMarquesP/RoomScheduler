INSERT INTO tb_user (name, document, email, password) VALUES ('Alex' , '1234', 'alex@gmail.com' , '123')
INSERT INTO tb_user (name, document, email, password) VALUES ('Maria', '5678', 'maria@gmail.com', '456')
INSERT INTO tb_user (name, document, email, password) VALUES ('Bob'  , '7896', 'bob@gmail.com'  , '587')

INSERT INTO tb_role (authority) VALUES('ROLE_ADMIN')
INSERT INTO tb_role (authority) VALUES('ROLE_USER')

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);


INSERT INTO tb_room (name) VALUES ('Sala 1')
INSERT INTO tb_room (name) VALUES ('Sala 2')
INSERT INTO tb_room (name) VALUES ('Sala 3')
INSERT INTO tb_room (name) VALUES ('Sala 4')
INSERT INTO tb_room (name) VALUES ('Sala 5')
INSERT INTO tb_room (name) VALUES ('Sala 6')


INSERT INTO tb_schedule (scheduled_date, user_id, room_id) VALUES ('2024-10-18','1','3')
INSERT INTO tb_schedule (scheduled_date, user_id, room_id) VALUES ('2024-11-05','2','5')
INSERT INTO tb_schedule (scheduled_date, user_id, room_id) VALUES ('2024-12-12','3','1')


