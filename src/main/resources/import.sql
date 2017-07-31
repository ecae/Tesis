INSERT INTO user (id, username, password, firstname, lastname, email, cellphone, dni, enabled, LASTPASSWORDRESETDATE, created_at, updated_at, deleted_at) VALUES (1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', "942052431" ,"72617398" , 1, STR_TO_DATE('01-01-2016', '%d-%m-%Y'), null, null, null);
INSERT INTO user (id, username, password, firstname, lastname, email, cellphone, dni, enabled, LASTPASSWORDRESETDATE, created_at, updated_at, deleted_at) VALUES (2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com', "942052433" ,"72617396" , 1, STR_TO_DATE('01-01-2016','%d-%m-%Y'), null, null, null);
INSERT INTO user (id, username, password, firstname, lastname, email, cellphone, dni, enabled, LASTPASSWORDRESETDATE, created_at, updated_at, deleted_at) VALUES (3, 'disabled', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'disabled@user.com', "942052434" ,"72617393" , 0, STR_TO_DATE('01-01-2016','%d-%m-%Y'), null, null, null);

INSERT INTO authority (id, name, created_at, updated_at, deleted_at) VALUES (1, 'ROLE_USER', null, null, null);
INSERT INTO authority (id, name, created_at, updated_at, deleted_at) VALUES (2, 'ROLE_ADMIN', null, null, null);

INSERT INTO user_authority (user_id, authority_id) VALUES (1, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (1, 2);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (3, 1);
