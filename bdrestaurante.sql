/*
Navicat MySQL Data Transfer

Source Server         : conexion
Source Server Version : 100131
Source Host           : localhost:3308
Source Database       : bdrestaurante

Target Server Type    : MYSQL
Target Server Version : 100131
File Encoding         : 65001

Date: 2018-11-08 12:36:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for articulo
-- ----------------------------
DROP TABLE IF EXISTS `articulo`;
CREATE TABLE `articulo` (
  `id_Articulo` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_articulo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_Tipo_articulo` int(11) DEFAULT NULL,
  `Tiempo_preparacion_articulo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Precio_articulo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_Articulo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of articulo
-- ----------------------------
INSERT INTO `articulo` VALUES ('1', 'Papas', '4', '20 minutos', '150');

-- ----------------------------
-- Table structure for cliente
-- ----------------------------
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `id_Cliente` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_cliente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `CUIT_cliente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Tipo_cliente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_Cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of cliente
-- ----------------------------
INSERT INTO `cliente` VALUES ('1', 'Juan', '1-25481487', 'CONSUMIDORFINAL');
INSERT INTO `cliente` VALUES ('2', 'Marcos', '1-54879798', 'CONSUMIDORFINAL');
INSERT INTO `cliente` VALUES ('3', 'Nahuel', '1-4564897', 'RESPONSABLEINSCRIPTO');

-- ----------------------------
-- Table structure for comanda
-- ----------------------------
DROP TABLE IF EXISTS `comanda`;
CREATE TABLE `comanda` (
  `id_Comanda` int(11) NOT NULL AUTO_INCREMENT,
  `id_Pedido` int(11) DEFAULT NULL,
  `Estado_comanda` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_Comanda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of comanda
-- ----------------------------

-- ----------------------------
-- Table structure for empleado
-- ----------------------------
DROP TABLE IF EXISTS `empleado`;
CREATE TABLE `empleado` (
  `Legajo` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_empleado` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Apellido_empleado` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DNI` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `CUIL` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Tipo_empleado` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`Legajo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of empleado
-- ----------------------------
INSERT INTO `empleado` VALUES ('1', 'Juan', 'Cebilla', '45789684', '1544544586-8', 'COCINERO');

-- ----------------------------
-- Table structure for encuesta
-- ----------------------------
DROP TABLE IF EXISTS `encuesta`;
CREATE TABLE `encuesta` (
  `id_Encuesta` int(11) NOT NULL AUTO_INCREMENT,
  `id_Mesa_Cliente` int(11) DEFAULT NULL,
  `Hora_encuesta` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Fecha_encuesta` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_Encuesta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of encuesta
-- ----------------------------

-- ----------------------------
-- Table structure for factura
-- ----------------------------
DROP TABLE IF EXISTS `factura`;
CREATE TABLE `factura` (
  `id_Factura` int(11) NOT NULL AUTO_INCREMENT,
  `id_Mesa_Cliente` int(11) DEFAULT NULL,
  `Tipo_factura` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Numero_factura` int(11) DEFAULT NULL,
  `Fecha_factura` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Importe_factura` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_Factura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of factura
-- ----------------------------

-- ----------------------------
-- Table structure for mesa
-- ----------------------------
DROP TABLE IF EXISTS `mesa`;
CREATE TABLE `mesa` (
  `id_Mesa` int(11) NOT NULL AUTO_INCREMENT,
  `Estado_Mesa` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_Mesa`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of mesa
-- ----------------------------
INSERT INTO `mesa` VALUES ('1', 'Abierta');
INSERT INTO `mesa` VALUES ('2', 'Disponible');
INSERT INTO `mesa` VALUES ('3', 'ABIERTA');
INSERT INTO `mesa` VALUES ('4', 'Disponible');
INSERT INTO `mesa` VALUES ('5', 'Disponible');

-- ----------------------------
-- Table structure for mesa_cliente
-- ----------------------------
DROP TABLE IF EXISTS `mesa_cliente`;
CREATE TABLE `mesa_cliente` (
  `id_Mesa_Cliente` int(11) NOT NULL AUTO_INCREMENT,
  `id_Mesa` int(11) DEFAULT NULL,
  `id_Cliente` int(11) DEFAULT NULL,
  `Estado_Mesa_Cliente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_Mesa_Cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of mesa_cliente
-- ----------------------------
INSERT INTO `mesa_cliente` VALUES ('1', '1', '1', 'Cerrada');
INSERT INTO `mesa_cliente` VALUES ('2', '1', '0', 'Pidiendo');
INSERT INTO `mesa_cliente` VALUES ('3', '1', '1', 'ESPERANDO_PEDIDO');
INSERT INTO `mesa_cliente` VALUES ('4', '1', '2', 'Pidiendo');
INSERT INTO `mesa_cliente` VALUES ('5', '3', '3', 'Pidiendo');
INSERT INTO `mesa_cliente` VALUES ('6', '3', '3', 'Pidiendo');

-- ----------------------------
-- Table structure for pago
-- ----------------------------
DROP TABLE IF EXISTS `pago`;
CREATE TABLE `pago` (
  `id_Pago` int(11) NOT NULL AUTO_INCREMENT,
  `id_Factura` int(11) DEFAULT NULL,
  `Fecha_pago` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Importe_pago` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_Pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of pago
-- ----------------------------

-- ----------------------------
-- Table structure for pedido
-- ----------------------------
DROP TABLE IF EXISTS `pedido`;
CREATE TABLE `pedido` (
  `id_Pedido` int(11) NOT NULL AUTO_INCREMENT,
  `Hora_pedido` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Fecha_pedido` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Estado_pedido` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_Mesa_Cliente` int(11) DEFAULT NULL,
  `Legajo` int(45) DEFAULT NULL,
  PRIMARY KEY (`id_Pedido`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of pedido
-- ----------------------------
INSERT INTO `pedido` VALUES ('1', '11:48:10', '2018/11/02', 'MARCHANDO', '1', '1');
INSERT INTO `pedido` VALUES ('2', '11:58:30', '2018/11/08', 'PENDIENTE', '2', '2');

-- ----------------------------
-- Table structure for pedido_articulo
-- ----------------------------
DROP TABLE IF EXISTS `pedido_articulo`;
CREATE TABLE `pedido_articulo` (
  `id_Pedido_articulo` int(11) NOT NULL AUTO_INCREMENT,
  `id_Pedido` int(11) DEFAULT NULL,
  `id_Articulo` int(11) DEFAULT NULL,
  `Cantidad_pedido_articulo` int(11) DEFAULT NULL,
  `Precio_pedido_articulo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_Pedido_articulo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of pedido_articulo
-- ----------------------------
INSERT INTO `pedido_articulo` VALUES ('1', '1', '0', '2', '300');
INSERT INTO `pedido_articulo` VALUES ('2', '1', '0', '2', '300');
INSERT INTO `pedido_articulo` VALUES ('3', '1', '1', '2', '300');

-- ----------------------------
-- Table structure for registro_empleado
-- ----------------------------
DROP TABLE IF EXISTS `registro_empleado`;
CREATE TABLE `registro_empleado` (
  `id_Registro_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `Legajo` int(11) DEFAULT NULL,
  `Hora_entrada` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Hora_salida` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Estado_registro_empleado` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_Registro_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of registro_empleado
-- ----------------------------
INSERT INTO `registro_empleado` VALUES ('1', '1', '11:38:00 8/11/18', '11:40:00 8//11/18', 'CERRADO');
INSERT INTO `registro_empleado` VALUES ('2', '1', '11:45:00 8/11/18', null, 'CERRADO');
INSERT INTO `registro_empleado` VALUES ('3', null, null, null, null);
INSERT INTO `registro_empleado` VALUES ('4', '1', '12:15:03 2018/11/08', null, 'CERRADO');

-- ----------------------------
-- Table structure for tipo_articulo
-- ----------------------------
DROP TABLE IF EXISTS `tipo_articulo`;
CREATE TABLE `tipo_articulo` (
  `id_Tipo_articulo` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo_articulo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_Tipo_articulo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of tipo_articulo
-- ----------------------------
INSERT INTO `tipo_articulo` VALUES ('1', 'BARTENDER');
INSERT INTO `tipo_articulo` VALUES ('2', 'CANDYBAR');
INSERT INTO `tipo_articulo` VALUES ('3', 'CERVERCERO');
INSERT INTO `tipo_articulo` VALUES ('4', 'COCINERO');

-- ----------------------------
-- Table structure for tipo_empleado
-- ----------------------------
DROP TABLE IF EXISTS `tipo_empleado`;
CREATE TABLE `tipo_empleado` (
  `id_Tipo_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo_empleado` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_Tipo_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of tipo_empleado
-- ----------------------------
INSERT INTO `tipo_empleado` VALUES ('1', 'MOZO');
INSERT INTO `tipo_empleado` VALUES ('2', 'EMPLEADO_ADMINISTRATIVO');
INSERT INTO `tipo_empleado` VALUES ('3', 'BARTENDER');
INSERT INTO `tipo_empleado` VALUES ('4', 'CANDYBAR');
INSERT INTO `tipo_empleado` VALUES ('5', 'CERVECERO');
INSERT INTO `tipo_empleado` VALUES ('6', 'COCINERO');
