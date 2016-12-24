CREATE TABLE IF NOT EXISTS `Usuario`(
	`NDI` INTEGER PRIMARY KEY,
	`nombre` TEXT NOT NULL, 
	`apellidos` TEXT NOT NULL, 
	`telefono` VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS `Zona` ( 
	`codigo` INTEGER NOT NULL PRIMARY KEY, 
	`nombre` TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS `Servicio` ( 
	`id_servicio` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`no_medidor` INTEGER, 
	`ndi_usuario` INTEGER, 
	`id_zona` INTEGER NOT NULL,
	`calle` TEXT NOT NULL,
	`no_calle` VARCHAR(10),
	`usamedidor` VARCHAR(2) NOT NULL,
	`estado` VARCHAR(10),
	`mes` INTEGER,
	`anio` INTEGER,
	'notas' TEXT,
	FOREIGN KEY(ndi_usuario) REFERENCES Usuario(NDI),
	FOREIGN KEY(id_zona) REFERENCES Zona(codigo)
 );

CREATE TABLE IF NOT EXISTS `Recibo_sin_medidor` (
	`id_recibo` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`id_servicio` INTEGER NOT NULL,
	`mes` INTEGER,
	`anio` INTEGER,  
	`monto` INTEGER,  
	`estado` VARCHAR(6),		
	FOREIGN KEY(id_servicio) REFERENCES Servicio(id_servicio)
);

CREATE TABLE IF NOT EXISTS `pago` (
	`id_pago` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`id_recibo` INTEGER,
	`fecha` DATE,
	FOREIGN  KEY(id_servicio) REFERENCES Recibo(id_recibo)
); 

CREATE VIEW cuenta as
select s.id_servicio, u.NDI, u.nombre, u.apellidos, s.no_medidor, 
z.nombre as zona, s.calle, s.estado
from Usuario as u inner join Servicio as s on u.ndi = s.ndi_usuario 
inner join Zona as z on z.codigo = s.id_zona

CREATE VIEW recibos as 
select r.id_recibo, u.NDI, u.nombre, u.apellidos, z.nombre as zona, 
s.calle, s.no_calle, r.estado, r.mes, r.anio, s.id_servicio, r.monto
from Usuario as u inner join Servicio as s on u.ndi = s.ndi_usuario
inner join Recibo_sin_medidor as r on s.id_servicio = r.id_servicio
inner join Zona as z on z.codigo = s.id_zona