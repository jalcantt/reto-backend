CREATE TABLE producto (
id NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
nombre VARCHAR2(100) NOT NULL,
descripcion CLOB,
precio NUMBER(10, 2) NOT NULL,
fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
estado VARCHAR2(10) CHECK (estado IN ('Activo', 'Inactivo')) NOT NULL
);

CREATE TABLE cliente (
id NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
nombre VARCHAR2(100) NOT NULL,
email VARCHAR2(100) UNIQUE NOT NULL,
telefono VARCHAR2(15)
);

CREATE TABLE orden (
id NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
cliente_id NUMBER NOT NULL,
fecha_orden TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE orden_producto (
orden_id NUMBER NOT NULL,
producto_id NUMBER NOT NULL,
cantidad NUMBER NOT NULL,
precio NUMBER(10, 2) NOT NULL,
PRIMARY KEY (orden_id, producto_id),
FOREIGN KEY (orden_id) REFERENCES orden(id),
FOREIGN KEY (producto_id) REFERENCES producto(id)
);