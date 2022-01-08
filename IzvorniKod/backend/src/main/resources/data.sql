INSERT INTO myuser(id, user_Name, photo, password_Hash, name, surname, phone_Number, email, role, confirmed) VALUES (104, 'dispatcher', '/user4photo', '$2a$12$RFv9B3TthXaQ/3MdjZFzxuigjmcP518d3mcvR9RKo9H4dufMWR0Iy', 'user4name', 'user4surname', '091', 'user4mail', 'dispatcher', true);
INSERT INTO myuser(id, user_Name, photo, password_Hash, name, surname, phone_Number, email, role, confirmed) VALUES (105, 'admin', '/user5photo', '$2a$12$RFv9B3TthXaQ/3MdjZFzxuigjmcP518d3mcvR9RKo9H4dufMWR0Iy', 'user5name', 'user5surname', '091', 'user5mail', 'admin', true);

INSERT INTO location(id, name, x, y) VALUES (106, 'lokacija1', 1, 1);
INSERT INTO location(id, name, x, y) VALUES (107, 'lokacija2', 2, 2);

INSERT INTO action(id, description, urgency, location_id) VALUES (108, 'fraeru se pimpek odlomio', 1, 106);
INSERT INTO action(id, description, urgency, location_id) VALUES (109, 'upucani lik', 2, 107);