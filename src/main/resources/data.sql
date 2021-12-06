INSERT INTO airservice_db.aircompany (company_type, founded_at, name) VALUES
('type', '2000-09-13 10:42:19.236442', 'Qatar Airways'),
('type','2021-09-13 10:42:19.236442','Singapore Airlines'),
('type','2021-09-13 10:42:19.236442','Japan Airlines');
COMMIT;

INSERT INTO `airservice_db`.`airplane` (`created_at`, `factory_serial_number`, `flight_distance`, `fuel_capacity`, `name`, `number_of_flights`, `type`, `air_company_id`) VALUES
('2016-09-18', '365356f26e761b4', '4700', '3800', 'Zirka', '1', 'pass', '1'),
('2020-09-18', '2fbee2555cf72a3', '4700', '3800', 'Lastivka', '1', 'pass', '1'),
('2017-09-18', '2fbee177e1f72a3', '4700', '3800', 'Marta', '1', 'pass', '1'),
('2009-09-18', '2fbee177e15871b', '4700', '3800', 'Bella', '1', 'pass', '1'),
('2021-09-18', 'yu2fbee177f7237', '4700', '3800', 'Dolly', '1', 'pass', '1'),
('2013-09-18', '15f08774ecf72a3', '4700', '3800', 'Dolly_001', '1', 'pass', '1'),
('2012-09-18', 'yu2fbe55cf72a37', '4700', '3800', 'Jess', '1', 'pass', '1'),
('2011-09-18', '871bf08774e2555', '4700', '3800', 'Dereza', '1', 'pass', '1'),
('2020-09-13', 'yu76y3e4rfdfgtt', '4700', '3800', 'Veha', '1', 'pass', '1');
COMMIT;

INSERT INTO `airservice_db`.`flight` (`created_at`, `delay_started_at`, `departure_country`, `destination_country`, `distance`, `started_at`, `ended_at`, `estimated_flight_time`, `flight_status`, `air_company_id`, `airplane_id`)
VALUES
('2021-09-18', '2021-09-18', 'Ukraine', 'Finland', '8900', '2021-09-26 00:00:00.000000', '2021-09-28 00:00:00.000000', '22', 'COMPLETED', '1', '1'),
('2021-09-18', '2021-09-18', 'Germany', 'Finland', '8900', '2021-09-26 00:00:00.000000', '2021-09-28 00:00:00.000000', '22', 'COMPLETED', '1', '2'),
('2021-09-18', '2021-09-18', 'France', 'Finland', '8900',  '2021-09-26 00:00:00.000000', '2021-09-28 00:00:00.000000', '22', 'COMPLETED', '1', '3'),
('2021-09-18', '2021-09-18', 'Latvia', 'Finland', '8900',  '2021-09-27 01:00:00.000000', '2021-09-27 23:00:00.000000', '2', 'COMPLETED', '1', '4'),
('2021-09-18', '2021-09-18', 'Ukraine', 'Finland', '8900', '2021-09-28 00:00:00.000000', '2021-09-28 00:00:00.000000', '22', 'ACTIVE', '1', '5'),
('2021-09-18', '2021-09-18', 'Austria', 'Finland', '8900', '2021-09-28 00:00:00.000000', '2021-09-28 00:00:00.000000', '22', 'ACTIVE', '1', '6'),
('2021-09-18', '2021-09-18', 'Ukraine', 'Finland', '8900', '2021-09-28 00:00:00.000000', '2021-09-28 00:00:00.000000', '22', 'ACTIVE', '1', '7'),
('2021-09-18', '2021-09-18', 'Ukraine', 'Finland', '8900', '2021-09-28 00:00:00.000000', '2021-09-28 00:00:00.000000', '22', 'ACTIVE', '1', '8');
COMMIT;

