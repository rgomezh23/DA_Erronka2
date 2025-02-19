SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: '3wag2e2'
--
DROP TABLE produktu_mugimenduak;
DROP TABLE kolore_historialak;
DROP TABLE bezero_fitxak;
DROP TABLE produktuak;
DROP TABLE kategoriak;
DROP TABLE ticket_lerroak;
DROP TABLE zerbitzuak;
DROP TABLE hitzorduak;
DROP TABLE material_maileguak;
DROP TABLE materialak;
DROP TABLE txandak;
DROP TABLE langileak;
DROP TABLE ordutegiak;
DROP TABLE taldeak;
DROP TABLE erabiltzaileak;

CREATE TABLE erabiltzaileak (
	username VARCHAR(15),
	pasahitza VARCHAR(100),
	rola VARCHAR(2),
	sortze_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    eguneratze_data DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ezabatze_data DATETIME,
	CONSTRAINT PK_erabiltzaileak PRIMARY KEY(username),
	CONSTRAINT CK_erabiltzaileak_rola CHECK (rola IN ('IK','IR'))
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE taldeak (
	kodea VARCHAR(5),
	izena VARCHAR(100),
	sortze_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    eguneratze_data DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ezabatze_data DATETIME,
	CONSTRAINT PK_taldeak PRIMARY KEY(kodea)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE ordutegiak (
	id INT AUTO_INCREMENT,
	kodea VARCHAR(5) NOT NULL,
	eguna INT(1) NOT NULL,
	hasiera_data DATE NOT NULL,
	amaiera_data DATE NOT NULL,
	hasiera_ordua TIME NOT NULL,
	amaiera_ordua TIME NOT NULL,
	sortze_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    eguneratze_data DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ezabatze_data DATETIME,
	CONSTRAINT PK_ordutegiak PRIMARY KEY(id),
	CONSTRAINT FK_ordutegiak_taldeak FOREIGN KEY (kodea) REFERENCES taldeak(kodea),
	CONSTRAINT CK_ordutegiak_eguna CHECK (eguna BETWEEN 1 AND 5)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE langileak (
	id INT AUTO_INCREMENT,
	izena VARCHAR(30) NOT NULL,
	kodea VARCHAR(5) NOT NULL,
	abizenak VARCHAR(100) NOT NULL,	
	sortze_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    eguneratze_data DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ezabatze_data DATETIME,
	CONSTRAINT PK_langileak PRIMARY KEY(id),
	CONSTRAINT FK_langileak_taldeak FOREIGN KEY (kodea) REFERENCES taldeak(kodea)	
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE txandak (
	id INT AUTO_INCREMENT,
	mota VARCHAR(1) NOT NULL,
	data DATE NOT NULL,
	id_langilea INT NOT NULL,
	sortze_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    eguneratze_data DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ezabatze_data DATETIME,
	CONSTRAINT PK_txandak PRIMARY KEY(id),
	CONSTRAINT FK_txandak_langileak FOREIGN KEY (id_langilea) REFERENCES langileak(id),
	CONSTRAINT CK_txandak_mota CHECK (mota in ('G','M'))
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE materialak (
	id INT AUTO_INCREMENT,
	etiketa VARCHAR(10) NOT NULL,
	izena VARCHAR(100) NOT NULL,	
	sortze_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    eguneratze_data DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ezabatze_data DATETIME,
	CONSTRAINT PK_materialak PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE material_maileguak (
	id INT AUTO_INCREMENT,
	id_materiala INT NOT NULL,
	id_langilea INT NOT NULL,	
	hasiera_data DATETIME NOT NULL,
	amaiera_data DATETIME,	
	sortze_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    eguneratze_data DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ezabatze_data DATETIME,
	CONSTRAINT PK_material_maileguak PRIMARY KEY(id),
	CONSTRAINT FK_material_maileguak_langileak FOREIGN KEY (id_langilea) REFERENCES langileak(id),
	CONSTRAINT FK_material_maileguak_materialak FOREIGN KEY (id_materiala) REFERENCES materialak(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE hitzorduak (
	id INT AUTO_INCREMENT,
	eserlekua INT NOT NULL,
	data DATE NOT NULL,
	hasiera_ordua TIME NOT NULL,
	amaiera_ordua TIME NOT NULL,
	hasiera_ordua_erreala TIME,
	amaiera_ordua_erreala TIME,
	izena VARCHAR(100) NOT NULL,
	telefonoa VARCHAR(9),
	deskribapena VARCHAR(250),
	etxekoa CHAR(1) NOT NULL,
	prezio_totala DECIMAL(10,2),
	id_langilea INT,		
	sortze_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    eguneratze_data DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ezabatze_data DATETIME,
	CONSTRAINT PK_hitzorduak PRIMARY KEY(id),
	CONSTRAINT FK_hitzorduak_langileak FOREIGN KEY (id_langilea) REFERENCES langileak(id),
	CONSTRAINT CK_hitzorduak_etxekoa CHECK(etxekoa in ('E','K'))
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE zerbitzuak (
	id INT AUTO_INCREMENT,
	izena VARCHAR(100) NOT NULL,
	etxeko_prezioa DECIMAL(10,2) NOT NULL,
	kanpoko_prezioa DECIMAL(10,2) NOT NULL,		
	sortze_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    eguneratze_data DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ezabatze_data DATETIME,
	CONSTRAINT PK_zerbitzuak PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE ticket_lerroak (
	id INT AUTO_INCREMENT,
	id_hitzordua INT NOT NULL,		
	id_zerbitzua INT NOT NULL,
	prezioa DECIMAL(10,2) NOT NULL,
	sortze_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    eguneratze_data DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ezabatze_data DATETIME,
	CONSTRAINT PK_ticket_lerroak PRIMARY KEY(id),
	CONSTRAINT FK_ticket_lerroak_hitzorduak FOREIGN KEY (id_hitzordua) REFERENCES hitzorduak(id),
	CONSTRAINT FK_ticket_lerroak_zerbitzuak FOREIGN KEY (id_zerbitzua) REFERENCES zerbitzuak(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE kategoriak (
	id INT AUTO_INCREMENT,
	izena VARCHAR(100) NOT NULL,
	sortze_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    eguneratze_data DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ezabatze_data DATETIME,
	CONSTRAINT PK_kategoriak PRIMARY KEY(id)	
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE produktuak (
	id INT AUTO_INCREMENT,
	izena VARCHAR(100) NOT NULL,
	deskribapena VARCHAR(250),
	id_kategoria INT NOT NULL,
	marka VARCHAR(50) NOT NULL,
	stock INT NOT NULL,
	stock_alerta INT NOT NULL,	
	sortze_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    eguneratze_data DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ezabatze_data DATETIME,
	CONSTRAINT PK_produktuak PRIMARY KEY(id),
	CONSTRAINT FK_produktuak_kategoriak FOREIGN KEY (id_kategoria) REFERENCES kategoriak(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE bezero_fitxak (
	id INT AUTO_INCREMENT,
	izena VARCHAR(100) NOT NULL,
	abizena VARCHAR(200) NOT NULL,
	telefonoa VARCHAR(9),
	azal_sentikorra CHAR(1) DEFAULT 'E',	
	sortze_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    eguneratze_data DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ezabatze_data DATETIME,
	CONSTRAINT PK_bezero_fitxak PRIMARY KEY(id),
	CONSTRAINT CK_bezero_fitxak_azala CHECK (azal_sentikorra IN ('B','E'))
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE kolore_historialak (
	id INT AUTO_INCREMENT,
	id_bezeroa INT not null,
	id_produktua INT not null,
	data DATE not null,
	kantitatea INT,
	bolumena VARCHAR(100),
	oharrak VARCHAR(250),	
	sortze_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    eguneratze_data DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ezabatze_data DATETIME,
	CONSTRAINT PK_kolore_historialak PRIMARY KEY(id),
	CONSTRAINT FK_kolore_historialak_produktuak FOREIGN KEY (id_produktua) REFERENCES produktuak(id),
	CONSTRAINT FK_kolore_historialak_bezeroak FOREIGN KEY (id_bezeroa) REFERENCES bezero_fitxak(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE produktu_mugimenduak (
	id INT AUTO_INCREMENT,
	id_produktua INT NOT NULL,
	id_langilea INT NOT NULL,	
	data DATETIME NOT NULL,
	kopurua INT NOT NULL,	
	sortze_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    eguneratze_data DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ezabatze_data DATETIME,
	CONSTRAINT PK_produktu_mugimenduak PRIMARY KEY(id),
	CONSTRAINT FK_produktu_mugimenduak_produktuak FOREIGN KEY (id_produktua) REFERENCES produktuak(id),
	CONSTRAINT FK_produktu_mugimenduak_langileak FOREIGN KEY (id_langilea) REFERENCES langileak(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;







-- 1

-- Insertar datos en la tabla 'erabiltzaileak'
INSERT INTO erabiltzaileak (username, pasahitza, rola) VALUES 
('admin', 'admin123', 'IK'),
('user1', 'user123', 'IR'),
('user2', 'user234', 'IR');

-- Insertar datos en la tabla 'taldeak'
INSERT INTO taldeak (kodea, izena) VALUES 
('TAL01', 'Talde A'),
('TAL02', 'Talde B'),
('TAL03', 'Talde C');

-- Insertar datos en la tabla 'ordutegiak'
INSERT INTO ordutegiak (kodea, eguna, hasiera_data, amaiera_data, hasiera_ordua, amaiera_ordua) VALUES 
('TAL01', 1, '2023-10-01', '2023-10-01', '08:00:00', '16:00:00'),
('TAL02', 2, '2023-10-02', '2023-10-02', '09:00:00', '17:00:00'),
('TAL03', 3, '2023-10-03', '2023-10-03', '10:00:00', '18:00:00');

-- Insertar datos en la tabla 'langileak'
INSERT INTO langileak (izena, kodea, abizenak) VALUES 
('Juan', 'TAL01', 'Perez'),
('Maria', 'TAL02', 'Gomez'),
('Carlos', 'TAL03', 'Lopez');

-- Insertar datos en la tabla 'txandak'
INSERT INTO txandak (mota, data, id_langilea) VALUES 
('G', '2023-10-01', 1),
('M', '2023-10-02', 2),
('G', '2023-10-03', 3);

-- Insertar datos en la tabla 'materialak'
INSERT INTO materialak (etiketa, izena) VALUES 
('MAT001', 'Material A'),
('MAT002', 'Material B'),
('MAT003', 'Material C');

-- Insertar datos en la tabla 'material_maileguak'
INSERT INTO material_maileguak (id_materiala, id_langilea, hasiera_data, amaiera_data) VALUES 
(1, 1, '2023-10-01 08:00:00', '2023-10-01 16:00:00'),
(2, 2, '2023-10-02 09:00:00', '2023-10-02 17:00:00'),
(3, 3, '2023-10-03 10:00:00', '2023-10-03 18:00:00');

-- Insertar datos en la tabla 'hitzorduak'
INSERT INTO hitzorduak (eserlekua, data, hasiera_ordua, amaiera_ordua, izena, telefonoa, etxekoa, prezio_totala, id_langilea) VALUES 
(1, '2023-10-01', '10:00:00', '11:00:00', 'Cliente 1', '123456789', 'E', 50.00, 1),
(2, '2023-10-02', '11:00:00', '12:00:00', 'Cliente 2', '987654321', 'K', 60.00, 2),
(3, '2023-10-03', '12:00:00', '13:00:00', 'Cliente 3', '123123123', 'E', 70.00, 3);

-- Insertar datos en la tabla 'zerbitzuak'
INSERT INTO zerbitzuak (izena, etxeko_prezioa, kanpoko_prezioa) VALUES 
('Servicio A', 50.00, 60.00),
('Servicio B', 60.00, 70.00),
('Servicio C', 70.00, 80.00);

-- Insertar datos en la tabla 'ticket_lerroak'
INSERT INTO ticket_lerroak (id_hitzordua, id_zerbitzua, prezioa) VALUES 
(1, 1, 50.00),
(2, 2, 60.00),
(3, 3, 70.00);

-- Insertar datos en la tabla 'kategoriak'
INSERT INTO kategoriak (izena) VALUES 
('Categoria A'),
('Categoria B'),
('Categoria C');

-- Insertar datos en la tabla 'produktuak'
INSERT INTO produktuak (izena, deskribapena, id_kategoria, marka, stock, stock_alerta) VALUES 
('Producto A', 'Descripción A', 1, 'Marca A', 100, 10),
('Producto B', 'Descripción B', 2, 'Marca B', 200, 20),
('Producto C', 'Descripción C', 3, 'Marca C', 300, 30);

-- Insertar datos en la tabla 'bezero_fitxak'
INSERT INTO bezero_fitxak (izena, abizena, telefonoa, azal_sentikorra) VALUES 
('Cliente 1', 'Apellido 1', '123456789', 'E'),
('Cliente 2', 'Apellido 2', '987654321', 'B'),
('Cliente 3', 'Apellido 3', '123123123', 'E');

-- Insertar datos en la tabla 'kolore_historialak'
INSERT INTO kolore_historialak (id_bezeroa, id_produktua, data, kantitatea, bolumena, oharrak) VALUES 
(1, 1, '2023-10-01', 1, '100ml', 'Nota A'),
(2, 2, '2023-10-02', 2, '200ml', 'Nota B'),
(3, 3, '2023-10-03', 3, '300ml', 'Nota C');

-- Insertar datos en la tabla 'produktu_mugimenduak'
INSERT INTO produktu_mugimenduak (id_produktua, id_langilea, data, kopurua) VALUES 
(1, 1, '2023-10-01 08:00:00', 10),
(2, 2, '2023-10-02 09:00:00', 20),
(3, 3, '2023-10-03 10:00:00', 30);


-- Insertar datos masivos en la tabla 'erabiltzaileak'
INSERT INTO erabiltzaileak (username, pasahitza, rola) VALUES 
('user3', 'user345', 'IR'),
('user4', 'user456', 'IR'),
('user5', 'user567', 'IR'),
('user6', 'user678', 'IR'),
('user7', 'user789', 'IR'),
('user8', 'user890', 'IR'),
('user9', 'user901', 'IR'),
('user10', 'user012', 'IR');

-- Insertar datos masivos en la tabla 'taldeak'
INSERT INTO taldeak (kodea, izena) VALUES 
('TAL04', 'Talde D'),
('TAL05', 'Talde E'),
('TAL06', 'Talde F'),
('TAL07', 'Talde G'),
('TAL08', 'Talde H'),
('TAL09', 'Talde I'),
('TAL10', 'Talde J');

-- Insertar datos masivos en la tabla 'ordutegiak'
INSERT INTO ordutegiak (kodea, eguna, hasiera_data, amaiera_data, hasiera_ordua, amaiera_ordua) VALUES 
('TAL04', 4, '2023-10-04', '2023-10-04', '08:00:00', '16:00:00'),
('TAL05', 5, '2023-10-05', '2023-10-05', '09:00:00', '17:00:00'),
('TAL06', 1, '2023-10-06', '2023-10-06', '10:00:00', '18:00:00'),
('TAL07', 2, '2023-10-07', '2023-10-07', '08:00:00', '16:00:00'),
('TAL08', 3, '2023-10-08', '2023-10-08', '09:00:00', '17:00:00'),
('TAL09', 4, '2023-10-09', '2023-10-09', '10:00:00', '18:00:00'),
('TAL10', 5, '2023-10-10', '2023-10-10', '08:00:00', '16:00:00');

-- Insertar datos masivos en la tabla 'langileak'
INSERT INTO langileak (izena, kodea, abizenak) VALUES 
('Ana', 'TAL04', 'Martinez'),
('Luis', 'TAL05', 'Fernandez'),
('Sofia', 'TAL06', 'Diaz'),
('Pedro', 'TAL07', 'Sanchez'),
('Laura', 'TAL08', 'Romero'),
('Miguel', 'TAL09', 'Torres'),
('Elena', 'TAL10', 'Ruiz');

-- Insertar datos masivos en la tabla 'txandak'
INSERT INTO txandak (mota, data, id_langilea) VALUES 
('M', '2023-10-04', 4),
('G', '2023-10-05', 5),
('M', '2023-10-06', 6),
('G', '2023-10-07', 7),
('M', '2023-10-08', 8),
('G', '2023-10-09', 9),
('M', '2023-10-10', 10);

-- Insertar datos masivos en la tabla 'materialak'
INSERT INTO materialak (etiketa, izena) VALUES 
('MAT004', 'Material D'),
('MAT005', 'Material E'),
('MAT006', 'Material F'),
('MAT007', 'Material G'),
('MAT008', 'Material H'),
('MAT009', 'Material I'),
('MAT010', 'Material J');

-- Insertar datos masivos en la tabla 'material_maileguak'
INSERT INTO material_maileguak (id_materiala, id_langilea, hasiera_data, amaiera_data) VALUES 
(4, 4, '2023-10-04 08:00:00', '2023-10-04 16:00:00'),
(5, 5, '2023-10-05 09:00:00', '2023-10-05 17:00:00'),
(6, 6, '2023-10-06 10:00:00', '2023-10-06 18:00:00'),
(7, 7, '2023-10-07 08:00:00', '2023-10-07 16:00:00'),
(8, 8, '2023-10-08 09:00:00', '2023-10-08 17:00:00'),
(9, 9, '2023-10-09 10:00:00', '2023-10-09 18:00:00'),
(10, 10, '2023-10-10 08:00:00', '2023-10-10 16:00:00');

-- Insertar datos masivos en la tabla 'hitzorduak'
INSERT INTO hitzorduak (eserlekua, data, hasiera_ordua, amaiera_ordua, izena, telefonoa, etxekoa, prezio_totala, id_langilea) VALUES 
(4, '2023-10-04', '10:00:00', '11:00:00', 'Cliente 4', '111111111', 'E', 80.00, 4),
(5, '2023-10-05', '11:00:00', '12:00:00', 'Cliente 5', '222222222', 'K', 90.00, 5),
(6, '2023-10-06', '12:00:00', '13:00:00', 'Cliente 6', '333333333', 'E', 100.00, 6),
(7, '2023-10-07', '13:00:00', '14:00:00', 'Cliente 7', '444444444', 'K', 110.00, 7),
(8, '2023-10-08', '14:00:00', '15:00:00', 'Cliente 8', '555555555', 'E', 120.00, 8),
(9, '2023-10-09', '15:00:00', '16:00:00', 'Cliente 9', '666666666', 'K', 130.00, 9),
(10, '2023-10-10', '16:00:00', '17:00:00', 'Cliente 10', '777777777', 'E', 140.00, 10);

-- Insertar datos masivos en la tabla 'zerbitzuak'
INSERT INTO zerbitzuak (izena, etxeko_prezioa, kanpoko_prezioa) VALUES 
('Servicio D', 80.00, 90.00),
('Servicio E', 90.00, 100.00),
('Servicio F', 100.00, 110.00),
('Servicio G', 110.00, 120.00),
('Servicio H', 120.00, 130.00),
('Servicio I', 130.00, 140.00),
('Servicio J', 140.00, 150.00);

-- Insertar datos masivos en la tabla 'ticket_lerroak'
INSERT INTO ticket_lerroak (id_hitzordua, id_zerbitzua, prezioa) VALUES 
(4, 4, 80.00),
(5, 5, 90.00),
(6, 6, 100.00),
(7, 7, 110.00),
(8, 8, 120.00),
(9, 9, 130.00),
(10, 10, 140.00);

-- Insertar datos masivos en la tabla 'kategoriak'
INSERT INTO kategoriak (izena) VALUES 
('Categoria D'),
('Categoria E'),
('Categoria F'),
('Categoria G'),
('Categoria H'),
('Categoria I'),
('Categoria J');

-- Insertar datos masivos en la tabla 'produktuak'
INSERT INTO produktuak (izena, deskribapena, id_kategoria, marka, stock, stock_alerta) VALUES 
('Producto D', 'Descripción D', 4, 'Marca D', 400, 40),
('Producto E', 'Descripción E', 5, 'Marca E', 500, 50),
('Producto F', 'Descripción F', 6, 'Marca F', 600, 60),
('Producto G', 'Descripción G', 7, 'Marca G', 700, 70),
('Producto H', 'Descripción H', 8, 'Marca H', 800, 80),
('Producto I', 'Descripción I', 9, 'Marca I', 900, 90),
('Producto J', 'Descripción J', 10, 'Marca J', 1000, 100);

-- Insertar datos masivos en la tabla 'bezero_fitxak'
INSERT INTO bezero_fitxak (izena, abizena, telefonoa, azal_sentikorra) VALUES 
('Cliente 4', 'Apellido 4', '111111111', 'E'),
('Cliente 5', 'Apellido 5', '222222222', 'B'),
('Cliente 6', 'Apellido 6', '333333333', 'E'),
('Cliente 7', 'Apellido 7', '444444444', 'B'),
('Cliente 8', 'Apellido 8', '555555555', 'E'),
('Cliente 9', 'Apellido 9', '666666666', 'B'),
('Cliente 10', 'Apellido 10', '777777777', 'E');

-- Insertar datos masivos en la tabla 'kolore_historialak'
INSERT INTO kolore_historialak (id_bezeroa, id_produktua, data, kantitatea, bolumena, oharrak) VALUES 
(4, 4, '2023-10-04', 4, '400ml', 'Nota D'),
(5, 5, '2023-10-05', 5, '500ml', 'Nota E'),
(6, 6, '2023-10-06', 6, '600ml', 'Nota F'),
(7, 7, '2023-10-07', 7, '700ml', 'Nota G'),
(8, 8, '2023-10-08', 8, '800ml', 'Nota H'),
(9, 9, '2023-10-09', 9, '900ml', 'Nota I'),
(10, 10, '2023-10-10', 10, '1000ml', 'Nota J');

-- Insertar datos masivos en la tabla 'produktu_mugimenduak'
INSERT INTO produktu_mugimenduak (id_produktua, id_langilea, data, kopurua) VALUES 
(4, 4, '2023-10-04 08:00:00', 40),
(5, 5, '2023-10-05 09:00:00', 50),
(6, 6, '2023-10-06 10:00:00', 60),
(7, 7, '2023-10-07 08:00:00', 70),
(8, 8, '2023-10-08 09:00:00', 80),
(9, 9, '2023-10-09 10:00:00', 90),
(10, 10, '2023-10-10 08:00:00', 100);



-- Insertar más datos en la tabla 'erabiltzaileak'
INSERT INTO erabiltzaileak (username, pasahitza, rola) VALUES 
('user11', 'user111', 'IR'),
('user12', 'user222', 'IR'),
('user13', 'user333', 'IR'),
('user14', 'user444', 'IR'),
('user15', 'user555', 'IR'),
('user16', 'user666', 'IR'),
('user17', 'user777', 'IR'),
('user18', 'user888', 'IR'),
('user19', 'user999', 'IR'),
('user20', 'user000', 'IR');

-- Insertar más datos en la tabla 'taldeak'
INSERT INTO taldeak (kodea, izena) VALUES 
('TAL11', 'Talde K'),
('TAL12', 'Talde L'),
('TAL13', 'Talde M'),
('TAL14', 'Talde N'),
('TAL15', 'Talde O'),
('TAL16', 'Talde P'),
('TAL17', 'Talde Q'),
('TAL18', 'Talde R'),
('TAL19', 'Talde S'),
('TAL20', 'Talde T');

-- Insertar más datos en la tabla 'ordutegiak'
INSERT INTO ordutegiak (kodea, eguna, hasiera_data, amaiera_data, hasiera_ordua, amaiera_ordua) VALUES 
('TAL11', 1, '2023-10-11', '2023-10-11', '08:00:00', '16:00:00'),
('TAL12', 2, '2023-10-12', '2023-10-12', '09:00:00', '17:00:00'),
('TAL13', 3, '2023-10-13', '2023-10-13', '10:00:00', '18:00:00'),
('TAL14', 4, '2023-10-14', '2023-10-14', '08:00:00', '16:00:00'),
('TAL15', 5, '2023-10-15', '2023-10-15', '09:00:00', '17:00:00'),
('TAL16', 1, '2023-10-16', '2023-10-16', '10:00:00', '18:00:00'),
('TAL17', 2, '2023-10-17', '2023-10-17', '08:00:00', '16:00:00'),
('TAL18', 3, '2023-10-18', '2023-10-18', '09:00:00', '17:00:00'),
('TAL19', 4, '2023-10-19', '2023-10-19', '10:00:00', '18:00:00'),
('TAL20', 5, '2023-10-20', '2023-10-20', '08:00:00', '16:00:00');

-- Insertar más datos en la tabla 'langileak'
INSERT INTO langileak (izena, kodea, abizenak) VALUES 
('Pablo', 'TAL11', 'Garcia'),
('Lucia', 'TAL12', 'Hernandez'),
('Diego', 'TAL13', 'Jimenez'),
('Carmen', 'TAL14', 'Moreno'),
('Jorge', 'TAL15', 'Navarro'),
('Sara', 'TAL16', 'Ortega'),
('Raul', 'TAL17', 'Pascual'),
('Marta', 'TAL18', 'Quintero'),
('Alberto', 'TAL19', 'Reyes'),
('Isabel', 'TAL20', 'Soto');

-- Insertar más datos en la tabla 'txandak'
INSERT INTO txandak (mota, data, id_langilea) VALUES 
('G', '2023-10-11', 11),
('M', '2023-10-12', 12),
('G', '2023-10-13', 13),
('M', '2023-10-14', 14),
('G', '2023-10-15', 15),
('M', '2023-10-16', 16),
('G', '2023-10-17', 17),
('M', '2023-10-18', 18),
('G', '2023-10-19', 19),
('M', '2023-10-20', 20);

-- Insertar más datos en la tabla 'materialak'
INSERT INTO materialak (etiketa, izena) VALUES 
('MAT011', 'Material K'),
('MAT012', 'Material L'),
('MAT013', 'Material M'),
('MAT014', 'Material N'),
('MAT015', 'Material O'),
('MAT016', 'Material P'),
('MAT017', 'Material Q'),
('MAT018', 'Material R'),
('MAT019', 'Material S'),
('MAT020', 'Material T');

-- Insertar más datos en la tabla 'material_maileguak'
INSERT INTO material_maileguak (id_materiala, id_langilea, hasiera_data, amaiera_data) VALUES 
(11, 11, '2023-10-11 08:00:00', '2023-10-11 16:00:00'),
(12, 12, '2023-10-12 09:00:00', '2023-10-12 17:00:00'),
(13, 13, '2023-10-13 10:00:00', '2023-10-13 18:00:00'),
(14, 14, '2023-10-14 08:00:00', '2023-10-14 16:00:00'),
(15, 15, '2023-10-15 09:00:00', '2023-10-15 17:00:00'),
(16, 16, '2023-10-16 10:00:00', '2023-10-16 18:00:00'),
(17, 17, '2023-10-17 08:00:00', '2023-10-17 16:00:00'),
(18, 18, '2023-10-18 09:00:00', '2023-10-18 17:00:00'),
(19, 19, '2023-10-19 10:00:00', '2023-10-19 18:00:00'),
(20, 20, '2023-10-20 08:00:00', '2023-10-20 16:00:00');

-- Insertar más datos en la tabla 'hitzorduak'
INSERT INTO hitzorduak (eserlekua, data, hasiera_ordua, amaiera_ordua, izena, telefonoa, etxekoa, prezio_totala, id_langilea) VALUES 
(11, '2023-10-11', '10:00:00', '11:00:00', 'Cliente 11', '888888888', 'E', 150.00, 11),
(12, '2023-10-12', '11:00:00', '12:00:00', 'Cliente 12', '999999999', 'K', 160.00, 12),
(13, '2023-10-13', '12:00:00', '13:00:00', 'Cliente 13', '101010101', 'E', 170.00, 13),
(14, '2023-10-14', '13:00:00', '14:00:00', 'Cliente 14', '121212121', 'K', 180.00, 14),
(15, '2023-10-15', '14:00:00', '15:00:00', 'Cliente 15', '131313131', 'E', 190.00, 15),
(16, '2023-10-16', '15:00:00', '16:00:00', 'Cliente 16', '141414141', 'K', 200.00, 16),
(17, '2023-10-17', '16:00:00', '17:00:00', 'Cliente 17', '151515151', 'E', 210.00, 17),
(18, '2023-10-18', '17:00:00', '18:00:00', 'Cliente 18', '161616161', 'K', 220.00, 18),
(19, '2023-10-19', '18:00:00', '19:00:00', 'Cliente 19', '171717171', 'E', 230.00, 19),
(20, '2023-10-20', '19:00:00', '20:00:00', 'Cliente 20', '181818181', 'K', 240.00, 20);

-- Insertar más datos en la tabla 'zerbitzuak'
INSERT INTO zerbitzuak (izena, etxeko_prezioa, kanpoko_prezioa) VALUES 
('Servicio K', 150.00, 160.00),
('Servicio L', 160.00, 170.00),
('Servicio M', 170.00, 180.00),
('Servicio N', 180.00, 190.00),
('Servicio O', 190.00, 200.00),
('Servicio P', 200.00, 210.00),
('Servicio Q', 210.00, 220.00),
('Servicio R', 220.00, 230.00),
('Servicio S', 230.00, 240.00),
('Servicio T', 240.00, 250.00);

-- Insertar más datos en la tabla 'ticket_lerroak'
INSERT INTO ticket_lerroak (id_hitzordua, id_zerbitzua, prezioa) VALUES 
(11, 11, 150.00),
(12, 12, 160.00),
(13, 13, 170.00),
(14, 14, 180.00),
(15, 15, 190.00),
(16, 16, 200.00),
(17, 17, 210.00),
(18, 18, 220.00),
(19, 19, 230.00),
(20, 20, 240.00);

-- Insertar más datos en la tabla 'kategoriak'
INSERT INTO kategoriak (izena) VALUES 
('Categoria K'),
('Categoria L'),
('Categoria M'),
('Categoria N'),
('Categoria O'),
('Categoria P'),
('Categoria Q'),
('Categoria R'),
('Categoria S'),
('Categoria T');

-- Insertar más datos en la tabla 'produktuak'
INSERT INTO produktuak (izena, deskribapena, id_kategoria, marka, stock, stock_alerta) VALUES 
('Producto K', 'Descripción K', 11, 'Marca K', 1100, 110),
('Producto L', 'Descripción L', 12, 'Marca L', 1200, 120),
('Producto M', 'Descripción M', 13, 'Marca M', 1300, 130),
('Producto N', 'Descripción N', 14, 'Marca N', 1400, 140),
('Producto O', 'Descripción O', 15, 'Marca O', 1500, 150),
('Producto P', 'Descripción P', 16, 'Marca P', 1600, 160),
('Producto Q', 'Descripción Q', 17, 'Marca Q', 1700, 170),
('Producto R', 'Descripción R', 18, 'Marca R', 1800, 180),
('Producto S', 'Descripción S', 19, 'Marca S', 1900, 190),
('Producto T', 'Descripción T', 20, 'Marca T', 2000, 200);

-- Insertar más datos en la tabla 'bezero_fitxak'
INSERT INTO bezero_fitxak (izena, abizena, telefonoa, azal_sentikorra) VALUES 
('Cliente 11', 'Apellido 11', '888888888', 'E'),
('Cliente 12', 'Apellido 12', '999999999', 'B'),
('Cliente 13', 'Apellido 13', '101010101', 'E'),
('Cliente 14', 'Apellido 14', '121212121', 'B'),
('Cliente 15', 'Apellido 15', '131313131', 'E'),
('Cliente 16', 'Apellido 16', '141414141', 'B'),
('Cliente 17', 'Apellido 17', '151515151', 'E'),
('Cliente 18', 'Apellido 18', '161616161', 'B'),
('Cliente 19', 'Apellido 19', '171717171', 'E'),
('Cliente 20', 'Apellido 20', '181818181', 'B');

-- Insertar más datos en la tabla 'kolore_historialak'
INSERT INTO kolore_historialak (id_bezeroa, id_produktua, data, kantitatea, bolumena, oharrak) VALUES 
(11, 11, '2023-10-11', 11, '1100ml', 'Nota K'),
(12, 12, '2023-10-12', 12, '1200ml', 'Nota L'),
(13, 13, '2023-10-13', 13, '1300ml', 'Nota M'),
(14, 14, '2023-10-14', 14, '1400ml', 'Nota N'),
(15, 15, '2023-10-15', 15, '1500ml', 'Nota O'),
(16, 16, '2023-10-16', 16, '1600ml', 'Nota P'),
(17, 17, '2023-10-17', 17, '1700ml', 'Nota Q'),
(18, 18, '2023-10-18', 18, '1800ml', 'Nota R'),
(19, 19, '2023-10-19', 19, '1900ml', 'Nota S'),
(20, 20, '2023-10-20', 20, '2000ml', 'Nota T');

-- Insertar más datos en la tabla 'produktu_mugimenduak'
INSERT INTO produktu_mugimenduak (id_produktua, id_langilea, data, kopurua) VALUES 
(11, 11, '2023-10-11 08:00:00', 110),
(12, 12, '2023-10-12 09:00:00', 120),
(13, 13, '2023-10-13 10:00:00', 130),
(14, 14, '2023-10-14 08:00:00', 140),
(15, 15, '2023-10-15 09:00:00', 150),
(16, 16, '2023-10-16 10:00:00', 160),
(17, 17, '2023-10-17 08:00:00', 170),
(18, 18, '2023-10-18 09:00:00', 180),
(19, 19, '2023-10-19 10:00:00', 190),
(20, 20, '2023-10-20 08:00:00', 200);


COMMIT;