create database concesionario;

use concesionario;

CREATE TABLE vehiculos (
    matricula VARCHAR(7) PRIMARY KEY,
    precio FLOAT,
    modelo VARCHAR(100),
    marca VARCHAR(100)
);

CREATE TABLE clientes (
    dni VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(100),
    apellidos VARCHAR(100)
);

CREATE TABLE ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_de_venta DATE,
    descuento INT,
    descripcion VARCHAR(100),
    importe FLOAT,
    matricula_fk VARCHAR(7),
    dni_fk VARCHAR(9),
    FOREIGN KEY (matricula_fk) REFERENCES vehiculos(matricula),
    FOREIGN KEY (dni_fk) REFERENCES clientes(dni)
);

INSERT INTO vehiculos (matricula, precio, modelo, marca) VALUES
('ABC1234', 15000.00, 'Sedán', 'Toyota'),
('XYZ7892', 18000.50, 'SUV', 'Ford'),
('DEF4561', 12000.75, 'Compacto', 'Honda'),
('GHI7893', 21000.25, 'Camioneta', 'Chevrolet'),
('JKL0129', 16000.75, 'Deportivo', 'Nissan');

INSERT INTO clientes (dni, nombre, apellidos) VALUES
('12345678A', 'Juan', 'Pérez'),
('98765321B', 'María', 'González'),
('55555555C', 'Carlos', 'Martínez'),
('77777777D', 'Luisa', 'Rodríguez'),
('99999999E', 'Ana', 'López');

INSERT INTO ventas (fecha_de_venta, descuento, descripcion, importe, matricula_fk, dni_fk) VALUES 
(CURDATE(), 15,'hola klk', 46000, 'ABC1234', '12345678A'),
(CURDATE(), 27, 'hola klk', 46000,'GHI7893', '98765321B'),
(CURDATE(), 11, 'hola klk', 46000,'XYZ7892', '55555555C');


