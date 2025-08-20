-- Tabla de usuarios
CREATE TABLE usuarios (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(100),
                          email VARCHAR(100),
                          fecha_nacimiento DATE,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de productos
CREATE TABLE productos (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           nombre VARCHAR(100),
                           precio DECIMAL(10,2),
                           fecha_creacion DATE,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de órdenes
CREATE TABLE ordenes (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         usuario_id BIGINT,
                         fecha TIMESTAMP,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Tabla intermedia orden-producto
CREATE TABLE orden_producto (
                                orden_id BIGINT,
                                producto_id BIGINT,
                                cantidad INT,
                                PRIMARY KEY (orden_id, producto_id),
                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                FOREIGN KEY (orden_id) REFERENCES ordenes(id),
                                FOREIGN KEY (producto_id) REFERENCES productos(id)
);

-- Datos de ejemplo
INSERT INTO usuarios (nombre, email, fecha_nacimiento) VALUES ('Juan Pérez', 'juan@gtec.com', '1990-05-10');
INSERT INTO usuarios (nombre, email, fecha_nacimiento) VALUES ('Ana López', 'ana@gtec.com', '1985-08-22');

INSERT INTO productos (nombre, precio, fecha_creacion) VALUES ('Laptop', 15000.00, '2024-06-01');
INSERT INTO productos (nombre, precio, fecha_creacion) VALUES ('Mouse', 250.00, '2024-06-02');
INSERT INTO productos (nombre, precio, fecha_creacion) VALUES ('Teclado', 500.00, '2024-06-03');

INSERT INTO ordenes (usuario_id, fecha) VALUES (1, CURRENT_TIMESTAMP);
INSERT INTO ordenes (usuario_id, fecha) VALUES (2, CURRENT_TIMESTAMP);

INSERT INTO orden_producto (orden_id, producto_id, cantidad) VALUES (1, 1, 1);
INSERT INTO orden_producto (orden_id, producto_id, cantidad) VALUES (1, 2, 2);
INSERT INTO orden_producto (orden_id, producto_id, cantidad) VALUES (2, 3, 1);