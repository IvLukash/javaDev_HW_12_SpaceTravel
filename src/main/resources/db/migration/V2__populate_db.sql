INSERT INTO client (name) VALUES
('Cristiano Ronaldo'),
('Paolo Maldini'),
('Robert Levandovsky'),
('Lionel Messi'),
('Alessandro Nesta'),
('Michael Owen'),
('Frank Lampard'),
('Raul Gonzales'),
('Tony Kroos'),
('David Beckham');

INSERT INTO planet (id, name) VALUES
('VEN', 'Venus'),
('EAR', 'Earth'),
('MARS', 'Mars'),
('JUP', 'Jupiter'),
('SAT', 'Saturn');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
(1, 'EAR', 'JUP'),
(3, 'MARS', 'SAT'),
(5, 'EAR', 'MARS'),
(8, 'VEN', 'EAR'),
(10, 'SAT', 'JUP'),
(3, 'SAT', 'MARS'),
(4, 'JUP', 'EAR'),
(4, 'EAR', 'MARS'),
(6, 'VEN', 'MARS'),
(9, 'JUP', 'EAR');