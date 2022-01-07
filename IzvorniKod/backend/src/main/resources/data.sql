INSERT INTO myuser(id, user_Name, photo, password_Hash, name, surname, phone_Number, email, role, confirmed) VALUES (101, 'policeman', '/user1photo', '$2a$12$RFv9B3TthXaQ/3MdjZFzxuigjmcP518d3mcvR9RKo9H4dufMWR0Iy', 'user1name', 'user1surname', '091', 'user1mail', 'policeman', true);
INSERT INTO myuser(id, user_Name, photo, password_Hash, name, surname, phone_Number, email, role, confirmed) VALUES (102, 'dispatcher', '/user2photo', '$2a$12$RFv9B3TthXaQ/3MdjZFzxuigjmcP518d3mcvR9RKo9H4dufMWR0Iy', 'user2name', 'user2surname', '091', 'user2mail', 'dispatcher', true);
INSERT INTO myuser(id, user_Name, photo, password_Hash, name, surname, phone_Number, email, role, confirmed) VALUES (103, 'admin', '/user3photo', '$2a$12$RFv9B3TthXaQ/3MdjZFzxuigjmcP518d3mcvR9RKo9H4dufMWR0Iy', 'user3name', 'user3surname', '091', 'user3mail', 'admin', true);
INSERT INTO myuser(id, user_Name, photo, password_Hash, name, surname, phone_Number, email, role, confirmed) VALUES (104, 'fireman', '/user4photo', '$2a$12$RFv9B3TthXaQ/3MdjZFzxuigjmcP518d3mcvR9RKo9H4dufMWR0Iy', 'user4name', 'user4surname', '091', 'user4mail', 'fireman', true);
INSERT INTO myuser(id, user_Name, photo, password_Hash, name, surname, phone_Number, email, role, confirmed) VALUES (105, 'doctor', '/user5photo', '$2a$12$RFv9B3TthXaQ/3MdjZFzxuigjmcP518d3mcvR9RKo9H4dufMWR0Iy', 'user5name', 'user5surname', '091', 'user5mail', 'doctor', true);

INSERT INTO location(id, name, x, y) VALUES (101, 'imeLokacije1', 1, 1);
INSERT INTO location(id, name, x, y) VALUES (102, 'imeLokacije2', 2, 2);

INSERT INTO action(id, description, urgency, location_id) VALUES (101, 'opis1', 1, 101);
INSERT INTO action(id, description, urgency, location_id) VALUES (102, 'opis2', 2, 102);

INSERT INTO station(id, director_id, location_id, name, type) VALUES (101, 101, 101, 'imeStanice1', 0);
INSERT INTO station(id, director_id, location_id, name, type) VALUES (102, 104, 102, 'imeStanice2', 1);