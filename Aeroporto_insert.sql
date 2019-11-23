insert into cidade values 
	(4554, 'Argentina', 'Buenos Aieres'),
	(1236, 'Brasil', 'Rio de Janeiro'),
	(1687, 'Brasil', 'Porto Alegre'),
	(1594, 'Brasil', 'Brasília');

insert into aeroporto values
	('444555666', 'Aeroporto Santos Dumont'),
	('123456789', 'Aeroporto Salgado Filho'),
	('555666993', 'Aeroporto de Guarulhos'),
	('032150154', 'Aeroporto de Brasília');

insert into voo values
	(0260),
	(1251),
	(0142),
	(3054);

insert into companhia_aerea values
	('12345678', 'LATAM', '321165432', '98724542', 'latam@gmail.com'),
	('35435435', 'Azul', '321335013', '31243655', 'azul@gmail.com'),
	('39334535', 'GOL', '968636344', '99886563', 'gol@gmail.com'),
	('01384130', 'QATAR Airlines', '711654987', '34565494', 'qairlines@gmail.com');


insert into aviao values
	(54654, 'Boing 547', 200, 0260),
	(78989, 'Boing 767', 250, 1251),
	(13245, 'Boing 737', 150, 0142),
	(45321, 'Airbus 787', 300, 3054);

insert into funcionarios values
	(005, 'Anita', 'T', 'Hall', '987654321123', 'Português', 'F', 'Piloto', '39334535'),
	(132, 'Janice', 'A', 'Rodriguez', '135525113314', 'Espanhol', 'F', 'Comissária', '39334535'),
	(023, 'Charles', 'F', 'Corona', '357946351236', 'Português', 'M', 'Piloto', '12345678'),
	(425, 'James', 'K', 'Garza', '456324143141', 'Português', 'M', 'Comissário', '01384130'),
	(321, 'Tia', 'C', 'Gaines', '376491372763', 'Inglês', 'F', 'Comissário', '12345678'),
	(056, 'James', 'K', 'Garza', '313545211236', 'Alemão', 'M', 'Piloto', '01384130'),
	(686, 'Robert ', 'A', 'Thomas', '322103354546', 'Português', 'M', 'Piloto', '35435435'),
	(785, 'Joseph', 'E', 'Lui', '111222333444', 'Português', 'M', 'Comissário', '35435435');

insert into piloto values 
	(183462, 2000, 005),
	(236520, 5000, 023),
	(315482, 4000, 056),
	(365312, 7000, 686);

insert into comissario values
	(301412, 132),
	(103640, 425),
	(976839, 321),
	(897635, 785);

insert into passageiro values
	('Terrence', 'D', 'Sheehan', '12345678-XX', 29, 0260),
	('John', 'S', 'Corn', '32156541-BR', 55, 0260),
	('Mildred', 'D', 'Shute', '26423469-AR', 37, 0260),
	('Jerry', 'S', 'McGuire', '13543713-US', 61, 1251),
	('Daniel', 'M', 'Cowans', '39548437-BR', 79, 0142),
	('Mary', 'K', 'Riley', '54764631-EU', 75, 3054);	

insert into trecho values 
	(1234, 0260, 54654, 183462, 301412),
	(4635, 1251, 78989, 236520, 103640),
	(6556, 0142, 13245, 315482, 976839),
	(9835, 3054, 45321, 365312, 897635);

