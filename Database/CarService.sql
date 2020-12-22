CREATE DATABASE CarService;

CREATE TABLE Detail
(
	id BIGSERIAL PRIMARY KEY,
	name CHARACTER VARYING(30) NOT NULL UNIQUE,
	price INTEGER CHECK(price > 0)
);

CREATE TABLE Office
(
	id BIGSERIAL PRIMARY KEY,
	city CHARACTER VARYING(30) NOT NULL,
	address CHARACTER VARYING(30) NOT NULL UNIQUE
);

CREATE TABLE Warehouse
(
	id BIGSERIAL PRIMARY KEY,
	office_id BIGINT,
	quantity INTEGER CHECK(quantity >= 0) DEFAULT 0,
	FOREIGN KEY (office_id) REFERENCES Office (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Detail_Warehouse
(
	id BIGSERIAL PRIMARY KEY,
	detail_id BIGINT,
	warehouse_id BIGINT,
	FOREIGN KEY (detail_id) REFERENCES Detail (id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (warehouse_id) REFERENCES Warehouse (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Customer
(
	id BIGSERIAL PRIMARY KEY,
	name CHARACTER VARYING(30) NOT NULL UNIQUE,
	password CHARACTER VARYING(255) NOT NULL,
	role CHARACTER VARYING(30)
);

INSERT INTO Detail VALUES (default, 'transmission', 100000);
INSERT INTO Detail VALUES (default, 'engine', 250000);
INSERT INTO Detail VALUES (default, 'wheel', 4000);
INSERT INTO Detail VALUES (default, 'door', 30000);
INSERT INTO Detail VALUES (default, 'windscreen', 40000);
INSERT INTO Detail VALUES (default, 'bumper', 10000);
INSERT INTO Detail VALUES (default, 'windshield wipers', 7000);
INSERT INTO Detail VALUES (default, 'headlights', 12000);
INSERT INTO Detail VALUES (default, 'taillights', 12000);
INSERT INTO Detail VALUES (default, 'silencer', 5000);
INSERT INTO Detail VALUES (default, 'seat', 20000);
INSERT INTO Detail VALUES (default, 'stereo', 17500);
INSERT INTO Detail VALUES (default, 'GPS', 15000);

INSERT INTO Office VALUES (default, 'Voronezh', '6 Lenin St');
INSERT INTO Office VALUES (default, 'Voronezh', '12 Kirov St');

INSERT INTO Warehouse VALUES (default, 1, 3);
INSERT INTO Warehouse VALUES (default, 1, 4);
INSERT INTO Warehouse VALUES (default, 1, 5);
INSERT INTO Warehouse VALUES (default, 1, 12);
INSERT INTO Warehouse VALUES (default, 1, 31);
INSERT INTO Warehouse VALUES (default, 1, 6);
INSERT INTO Warehouse VALUES (default, 1, 0);
INSERT INTO Warehouse VALUES (default, 1, 4);
INSERT INTO Warehouse VALUES (default, 1, 2);
INSERT INTO Warehouse VALUES (default, 1, 0);
INSERT INTO Warehouse VALUES (default, 1, 90);
INSERT INTO Warehouse VALUES (default, 1, 45);
INSERT INTO Warehouse VALUES (default, 1, 6);

INSERT INTO Warehouse VALUES (default, 2, 8);
INSERT INTO Warehouse VALUES (default, 2, 1);
INSERT INTO Warehouse VALUES (default, 2, 13);
INSERT INTO Warehouse VALUES (default, 2, 2);
INSERT INTO Warehouse VALUES (default, 2, 0);
INSERT INTO Warehouse VALUES (default, 2, 34);
INSERT INTO Warehouse VALUES (default, 2, 7);
INSERT INTO Warehouse VALUES (default, 2, 16);
INSERT INTO Warehouse VALUES (default, 2, 45);
INSERT INTO Warehouse VALUES (default, 2, 1);
INSERT INTO Warehouse VALUES (default, 2, 0);
INSERT INTO Warehouse VALUES (default, 2, 5);
INSERT INTO Warehouse VALUES (default, 2, 13);

INSERT INTO Detail_Warehouse VALUES (default, 1, 1);
INSERT INTO Detail_Warehouse VALUES (default, 2, 2);
INSERT INTO Detail_Warehouse VALUES (default, 3, 3);
INSERT INTO Detail_Warehouse VALUES (default, 4, 4);
INSERT INTO Detail_Warehouse VALUES (default, 5, 5);
INSERT INTO Detail_Warehouse VALUES (default, 6, 6);
INSERT INTO Detail_Warehouse VALUES (default, 7, 7);
INSERT INTO Detail_Warehouse VALUES (default, 8, 8);
INSERT INTO Detail_Warehouse VALUES (default, 9, 9);
INSERT INTO Detail_Warehouse VALUES (default, 10, 10);
INSERT INTO Detail_Warehouse VALUES (default, 11, 11);
INSERT INTO Detail_Warehouse VALUES (default, 12, 12);
INSERT INTO Detail_Warehouse VALUES (default, 13, 13);
INSERT INTO Detail_Warehouse VALUES (default, 1, 14);
INSERT INTO Detail_Warehouse VALUES (default, 2, 15);
INSERT INTO Detail_Warehouse VALUES (default, 3, 16);
INSERT INTO Detail_Warehouse VALUES (default, 4, 17);
INSERT INTO Detail_Warehouse VALUES (default, 5, 18);
INSERT INTO Detail_Warehouse VALUES (default, 6, 19);
INSERT INTO Detail_Warehouse VALUES (default, 7, 20);
INSERT INTO Detail_Warehouse VALUES (default, 8, 21);
INSERT INTO Detail_Warehouse VALUES (default, 9, 22);
INSERT INTO Detail_Warehouse VALUES (default, 10, 23);
INSERT INTO Detail_Warehouse VALUES (default, 11, 24);
INSERT INTO Detail_Warehouse VALUES (default, 12, 25);
INSERT INTO Detail_Warehouse VALUES (default, 13, 26);

INSERT INTO Customer VALUES (default, 'Bob', '$2a$10$0QmN73QFS6gVpGh5NQubGeQrHDaUgHLGcAYwGtH187aMY4yPBzFk2', 'ROLE_USER');
INSERT INTO Customer VALUES (default, 'Anna', '$2a$10$6h5RtvSYTgIcOJrS8abAbOhSRuPDHf7oObzPncjuaGkkNBCGpISzy', 'ROLE_ADMIN');

