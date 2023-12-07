Insert into `user_entity` (id, email, is_active, password, username)
values (1,'maikimn@abv.bg' , 1, '40b8c1eea216cc7babec8f132663e0109da46e8059c3b662782640a9dfe181a12d1090e51fdd56eb0f7a23af6f1d4001', 'm1kl3'),
 (2,'maiki03@abv.bg' , 1, '40b8c1eea216cc7babec8f132663e0109da46e8059c3b662782640a9dfe181a12d1090e51fdd56eb0f7a23af6f1d4001', 'mik');

INSERT INTO user_role () VALUES (1, 'ADMIN'), (2, 'USER');

INSERT INTO user_entity_roles (user_entity_id, roles_id) VALUES (1, 1), (1, 2), (2, 2);