INSERT INTO tb_user (name, document, email, role, password) VALUES ('Alex', '1234', 'alex@gmail.com', 'ROLE_ADMIN', '123')
INSERT INTO tb_user (name, document, email, role, password) VALUES ('Maria', '5678', 'maria@gmail.com', 'ROLE_USER', '456')
INSERT INTO tb_user (name, document, email, role, password) VALUES ('Bob', '7896', 'bob@gmail.com', 'ROLE_ADMIN', '587')

INSERT INTO tb_room (name) VALUES ('Sala 1')
INSERT INTO tb_room (name) VALUES ('Sala 2')
INSERT INTO tb_room (name) VALUES ('Sala 3')
INSERT INTO tb_room (name) VALUES ('Sala 4')
INSERT INTO tb_room (name) VALUES ('Sala 5')
INSERT INTO tb_room (name) VALUES ('Sala 6')


INSERT INTO tb_schedule (scheduled_date, user_id, room_id) VALUES ('2024-10-18','1','3')
INSERT INTO tb_schedule (scheduled_date, user_id, room_id) VALUES ('2024-11-05','2','5')
INSERT INTO tb_schedule (scheduled_date, user_id, room_id) VALUES ('2024-12-12','3','1')



