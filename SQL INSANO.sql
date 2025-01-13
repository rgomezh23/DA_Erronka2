INSERT INTO erabiltzaileak (username, pasahitza, rola, sortze_data, eguneratze_data, ezabatze_data)
VALUES 
('Ikasle', 'ikasle', 'IK', NOW(), NULL, NULL);

INSERT INTO erabiltzaileak (username, pasahitza, rola, sortze_data, eguneratze_data, ezabatze_data)
VALUES 
('Irakasle', 'irakasle', 'IR', NOW(), NULL, NULL);

INSERT INTO kategoriak (id, izena) 
VALUES
(1, 'Cuidado del cabello'),
(2, 'Herramientas de estilismo'),
(3, 'Equipos eléctricos'),
(4, 'Productos de peinado'),
(5, 'Coloración');

INSERT INTO produktuak (izena, deskribapena, id_kategoria, marka, stock, stock_alerta, sortze_data, eguneratze_data, ezabatze_data) 
VALUES
('Champú Hidratante', 'Champú para cabello seco con aloe vera.', 1, 'Loreal', 50, 10, NOW(), NOW(), NULL),
('Acondicionador Reparador', 'Acondicionador para cabello dañado.', 1, 'Kerastase', 40, 8, NOW(), NOW(), NULL),
('Tijeras de Corte Profesional', 'Tijeras de acero inoxidable para estilistas.', 2, 'Wahl', 20, 5, NOW(), NOW(), NULL),
('Secador de Pelo', 'Secador con tecnología iónica para evitar el encrespamiento.', 3, 'Dyson', 15, 3, NOW(), NOW(), NULL),
('Laca de Fijación', 'Laca extra fuerte para peinados duraderos.', 4, 'Tresemme', 60, 15, NOW(), NOW(), NULL),
('Plancha de Pelo', 'Plancha de cerámica con ajuste de temperatura.', 3, 'Remington', 10, 2, NOW(), NOW(), NULL),
('Aceite Capilar', 'Aceite de argán para nutrir el cabello.', 1, 'Moroccanoil', 30, 6, NOW(), NOW(), NULL),
('Cepillo Desenredante', 'Cepillo con cerdas flexibles para todo tipo de cabello.', 2, 'Tangle Teezer', 25, 5, NOW(), NOW(), NULL),
('Espuma Voluminizadora', 'Espuma para dar volumen al cabello.', 4, 'Schwarzkopf', 35, 7, NOW(), NOW(), NULL),
('Coloración Permanente', 'Tinte para el cabello con cobertura total de canas.', 5, 'Garnier', 50, 10, NOW(), NOW(), NULL);

INSERT INTO kolore_historialak (id_bezeroa, id_produktua, data, kantitatea, bolumena, oharrak, sortze_data, eguneratze_data, ezabatze_data)
VALUES 
(1, 1, '2024-01-01', 10, '500ml', 'Pedido de inicio de año', '2024-01-01 10:00:00', NULL, NULL),
(2, 2, '2024-02-15', 5, '1L', 'Pedido regular', '2024-02-15 14:30:00', NULL, NULL),
(3, 3, '2024-03-20', 20, '750ml', 'Pedido especial', '2024-03-20 08:45:00', NULL, NULL),
(4, 1, '2024-04-10', 8, '300ml', 'Pedido urgente', '2024-04-10 11:15:00', NULL, NULL),
(5, 2, '2024-05-05', 15, '2L', 'Promoción', '2024-05-05 16:00:00', NULL, NULL);


INSERT INTO produktu_mugimenduak (id_produktua, id_langilea, data, kopurua, sortze_data, eguneratze_data, ezabatze_data)
VALUES 
(1, 1, '2024-01-05 09:30:00', 5, '2024-01-05 09:30:00', NULL, NULL),
(2, 2, '2024-02-10 12:15:00', 10, '2024-02-10 12:15:00', NULL, NULL),
(3, 3, '2024-03-18 15:45:00', 20, '2024-03-18 15:45:00', NULL, NULL),
(4, 1, '2024-04-01 08:00:00', 7, '2024-04-01 08:00:00', NULL, NULL),
(5, 2, '2024-05-15 14:00:00', 25, '2024-05-15 14:00:00', NULL, NULL);


INSERT INTO materialak (etiketa, izena, sortze_data, eguneratze_data)
VALUES
('Pelu', 'Tijeras de corte', NOW(), NOW()),
('Pelu', 'Secador de pelo', NOW(), NOW()),
('Pelu', 'Peine de acero', NOW(), NOW()),
('Pelu', 'Plancha de pelo', NOW(), NOW()),
('Pelu', 'Corte de pelo para niños', NOW(), NOW());

INSERT INTO taldeak (kodea, izena) VALUES
('1', 'Equipo 1'),
('2', 'Equipo 2'),
('3', 'Equipo 3'),
('4', 'Equipo 4');


INSERT INTO langileak (id, izena, kodea, abizenak, sortze_data, eguneratze_data, ezabatze_data) VALUES
(1, 'Oier', '2', 'Garcia', NOW(), NOW(), NULL),
(2, 'Nora', '2', 'Elyadri', NOW(), NOW(), NULL),
(3, 'Alba', '2', 'Gonzalez', NOW(), NOW(), NULL),
(4, 'Raúl', '2', 'Gómez', NOW(), NOW(), NULL);


INSERT INTO material_maileguak (id_materiala, id_langilea, hasiera_data, amaiera_data, sortze_data, eguneratze_data)
VALUES
(1, 1, NOW(), NULL, NOW(), NOW()),  -- Tijeras de corte prestadas al empleado 1
(2, 2, NOW(), NULL, NOW(), NOW()),  -- Secador de pelo prestado al empleado 2
(3, 3, NOW(), NULL, NOW(), NOW()),  -- Peine de acero prestado al empleado 3
(4, 1, NOW(), NULL, NOW(), NOW()),  -- Plancha de pelo prestada al empleado 1
(5, 2, NOW(), NULL, NOW(), NOW());  -- Corte de pelo para niños prestado al empleado 2

INSERT INTO bezero_fitxak (izena, abizena, telefonoa, azal_sentikorra, sortze_data, eguneratze_data, ezabatze_data)
VALUES
('Ane', 'Etxebarria', '600123456', 'E', '2025-01-10 10:00:00', '2025-01-10 10:30:00', NULL),
('Iker', 'Aranburu', '601234567', 'B', '2025-01-11 11:00:00', '2025-01-11 11:30:00', NULL),
('Maite', 'Mendia', '602345678', 'E', '2025-01-12 12:00:00', '2025-01-12 12:30:00', NULL),
('Jon', 'Elizalde', '603456789', 'B', '2025-01-13 13:00:00', NULL, NULL),
('Irati', 'Zabala', '604567890', 'E', '2025-01-14 14:00:00', '2025-01-14 14:30:00', '2025-01-15 15:00:00');

