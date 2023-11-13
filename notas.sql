-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 13-11-2023 a las 03:06:42
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `notas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE IF NOT EXISTS `alumno` (
  `IDALUMNO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `DNI` varchar(10) DEFAULT NULL,
  `IDCARRERA` int(11) DEFAULT NULL,
  `CICLO` int(11) DEFAULT NULL,
  `TURNO` varchar(10) DEFAULT NULL,
  `IDUSUARIO` int(11) DEFAULT NULL,
  `ACTIVO` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`IDALUMNO`),
  KEY `IDCARRERA` (`IDCARRERA`),
  KEY `IDUSUARIO` (`IDUSUARIO`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`IDALUMNO`, `NOMBRE`, `APELLIDO`, `DNI`, `IDCARRERA`, `CICLO`, `TURNO`, `IDUSUARIO`, `ACTIVO`) VALUES
(1, 'Jason', 'Voorhees', '12345678A', 1, 3, 'Mañana', 11, 1),
(2, 'Freddy', 'Krueger', '23456789B', 2, 3, 'Mañana', 12, 1),
(3, 'Michael', 'Myers', '34567890C', 3, 5, 'Noche', 13, 1),
(4, 'Norman', 'Bates', '45678901D', 4, 4, 'Mañana', 14, 1),
(5, 'Carrie', 'White', '56789012E', 5, 6, 'Tarde', 15, 1),
(6, 'Chucky', 'Doll', '67890123F', 6, 8, 'Noche', 16, 1),
(7, 'Samara', 'Morgan', '78901234G', 7, 9, 'Mañana', 17, 1),
(8, 'Regan', 'MacNeil', '89012345H', 8, 1, 'Tarde', 18, 1),
(9, 'Jigsaw', 'Killer', '90123456I', 1, 7, 'Noche', 19, 1),
(10, 'Pennywise', 'Clown', '01234567J', 2, 6, 'Mañana', 20, 0),
(11, 'Hannibal', 'Lecter', '12345678K', 3, 3, 'Tarde', 21, 1),
(12, 'Ghostface', 'Killer', '23456789L', 4, 9, 'Noche', 22, 1),
(13, 'Kayako', 'Saeki', '34567890M', 5, 4, 'Mañana', 23, 1),
(14, 'Jed', 'Sawyer', '45678901N', 6, 1, 'Tarde', 24, 1),
(15, 'Leatherface', 'Killer', '56789012O', 7, 8, 'Noche', 25, 1),
(16, 'Valak', 'Nun', '67890123P', 8, 2, 'Mañana', 26, 1),
(17, 'Ash', 'Williams', '78901234Q', 1, 5, 'Tarde', 27, 1),
(18, 'Pinhead', 'Cenobite', '89012345R', 2, 8, 'Noche', 28, 1),
(19, 'Kayako', 'Saeki', '90123456S', 3, 10, 'Mañana', 29, 1),
(20, 'Pinhead', 'Cenobite', '01234567T', 4, 4, 'Tarde', 30, 1),
(21, 'Chapulin', 'Colorado', '789345', 3, 4, 'Mañana', 45, 1),
(22, 'Jorge', 'Torres', '123456797', 2, 10, 'Mañana', 196, 1),
(23, 'Jason', 'Voorhees', '12345678A', 7, 4, 'Noche', 197, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrera`
--

CREATE TABLE IF NOT EXISTS `carrera` (
  `IDCARRERA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `ACTIVO` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`IDCARRERA`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Volcado de datos para la tabla `carrera`
--

INSERT INTO `carrera` (`IDCARRERA`, `NOMBRE`, `ACTIVO`) VALUES
(1, 'Ingeniería de Software', 1),
(2, 'Ciberseguridad y Ciencia de Datos', 1),
(3, 'Diseño Gráfico y Multimedia', 1),
(4, 'Marketing y Publicidad', 1),
(5, 'Administración de Empresas', 1),
(6, 'Diseño de Videojuegos', 1),
(7, 'Redes y Comunicaciones', 1),
(8, 'Diseño y Desarrollo Web', 1),
(9, 'Carrera de Prueba', 0),
(10, 'Carrera Registrada', 0),
(11, 'Ingeniería Mecatrónica', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE IF NOT EXISTS `curso` (
  `IDCURSO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `IDCARRERA` int(11) DEFAULT NULL,
  `CICLO` int(11) DEFAULT NULL,
  `ACTIVO` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`IDCURSO`),
  KEY `IDCARRERA` (`IDCARRERA`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=254 ;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`IDCURSO`, `NOMBRE`, `IDCARRERA`, `CICLO`, `ACTIVO`) VALUES
(1, 'Curso Ingeniería de Software Ciclo 1 - Curso 1', 1, 1, 1),
(2, 'Curso Ingeniería de Software Ciclo 1 - Curso 2', 1, 1, 1),
(3, 'Curso Ingeniería de Software Ciclo 1 - Curso 3', 1, 1, 1),
(4, 'Curso Ingeniería de Software Ciclo 2 - Curso 1', 1, 2, 1),
(5, 'Curso Ingeniería de Software Ciclo 2 - Curso 2', 1, 2, 1),
(6, 'Curso Ingeniería de Software Ciclo 2 - Curso 3', 1, 2, 1),
(7, 'Curso Ingeniería de Software Ciclo 3 - Curso 1', 1, 3, 1),
(8, 'Curso Ingeniería de Software Ciclo 3 - Curso 2', 1, 3, 1),
(9, 'Curso Ingeniería de Software Ciclo 3 - Curso 3', 1, 3, 1),
(10, 'Curso Ingeniería de Software Ciclo 4 - Curso 1', 1, 4, 1),
(11, 'Curso Ingeniería de Software Ciclo 4 - Curso 2', 1, 4, 1),
(12, 'Curso Ingeniería de Software Ciclo 4 - Curso 3', 1, 4, 1),
(13, 'Curso Ingeniería de Software Ciclo 5 - Curso 1', 1, 5, 1),
(14, 'Curso Ingeniería de Software Ciclo 5 - Curso 2', 1, 5, 1),
(15, 'Curso Ingeniería de Software Ciclo 5 - Curso 3', 1, 5, 1),
(16, 'Curso Ingeniería de Software Ciclo 6 - Curso 1', 1, 6, 1),
(17, 'Curso Ingeniería de Software Ciclo 6 - Curso 2', 1, 6, 1),
(18, 'Curso Ingeniería de Software Ciclo 6 - Curso 3', 1, 6, 1),
(19, 'Curso Ingeniería de Software Ciclo 7 - Curso 1', 1, 7, 1),
(20, 'Curso Ingeniería de Software Ciclo 7 - Curso 2', 1, 7, 1),
(21, 'Curso Ingeniería de Software Ciclo 7 - Curso 3', 1, 7, 1),
(22, 'Curso Ingeniería de Software Ciclo 8 - Curso 1', 1, 8, 1),
(23, 'Curso Ingeniería de Software Ciclo 8 - Curso 2', 1, 8, 1),
(24, 'Curso Ingeniería de Software Ciclo 8 - Curso 3', 1, 8, 1),
(25, 'Curso Ingeniería de Software Ciclo 9 - Curso 1', 1, 9, 1),
(26, 'Curso Ingeniería de Software Ciclo 9 - Curso 2', 1, 9, 1),
(27, 'Curso Ingeniería de Software Ciclo 9 - Curso 3', 1, 9, 1),
(28, 'Curso Ingeniería de Software Ciclo 10 - Curso 1', 1, 10, 1),
(29, 'Curso Ingeniería de Software Ciclo 10 - Curso 2', 1, 10, 1),
(30, 'Curso Ingeniería de Software Ciclo 10 - Curso 3', 1, 10, 1),
(32, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 1 - Curso 1', 2, 1, 1),
(33, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 1 - Curso 2', 2, 1, 1),
(34, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 1 - Curso 3', 2, 1, 1),
(35, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 2 - Curso 1', 2, 2, 1),
(36, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 2 - Curso 2', 2, 2, 1),
(37, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 2 - Curso 3', 2, 2, 1),
(38, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 3 - Curso 1', 2, 3, 1),
(39, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 3 - Curso 2', 2, 3, 1),
(40, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 3 - Curso 3', 2, 3, 1),
(41, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 4 - Curso 1', 2, 4, 1),
(42, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 4 - Curso 2', 2, 4, 1),
(43, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 4 - Curso 3', 2, 4, 1),
(44, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 5 - Curso 1', 2, 5, 1),
(45, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 5 - Curso 2', 2, 5, 1),
(46, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 5 - Curso 3', 2, 5, 1),
(47, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 6 - Curso 1', 2, 6, 1),
(48, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 6 - Curso 2', 2, 6, 1),
(49, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 6 - Curso 3', 2, 6, 1),
(50, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 7 - Curso 1', 2, 7, 1),
(51, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 7 - Curso 2', 2, 7, 1),
(52, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 7 - Curso 3', 2, 7, 1),
(53, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 8 - Curso 1', 2, 8, 1),
(54, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 8 - Curso 2', 2, 8, 1),
(55, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 8 - Curso 3', 2, 8, 1),
(56, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 9 - Curso 1', 2, 9, 1),
(57, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 9 - Curso 2', 2, 9, 1),
(58, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 9 - Curso 3', 2, 9, 1),
(59, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 10 - Curso 1', 2, 10, 1),
(60, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 10 - Curso 2', 2, 10, 1),
(61, 'Curso Ciberseguridad y Ciencia de Datos Ciclo 10 - Curso 3', 2, 10, 1),
(63, 'Curso Diseño Gráfico y Multimedia Ciclo 1 - Curso 1', 3, 1, 1),
(64, 'Curso Diseño Gráfico y Multimedia Ciclo 1 - Curso 2', 3, 1, 1),
(65, 'Curso Diseño Gráfico y Multimedia Ciclo 1 - Curso 3', 3, 1, 1),
(66, 'Curso Diseño Gráfico y Multimedia Ciclo 2 - Curso 1', 3, 2, 1),
(67, 'Curso Diseño Gráfico y Multimedia Ciclo 2 - Curso 2', 3, 2, 1),
(68, 'Curso Diseño Gráfico y Multimedia Ciclo 2 - Curso 3', 3, 2, 1),
(69, 'Curso Diseño Gráfico y Multimedia Ciclo 3 - Curso 1', 3, 3, 1),
(70, 'Curso Diseño Gráfico y Multimedia Ciclo 3 - Curso 2', 3, 3, 1),
(71, 'Curso Diseño Gráfico y Multimedia Ciclo 3 - Curso 3', 3, 3, 1),
(72, 'Curso Diseño Gráfico y Multimedia Ciclo 4 - Curso 1', 3, 4, 1),
(73, 'Curso Diseño Gráfico y Multimedia Ciclo 4 - Curso 2', 3, 4, 1),
(74, 'Curso Diseño Gráfico y Multimedia Ciclo 4 - Curso 3', 3, 4, 1),
(75, 'Curso Diseño Gráfico y Multimedia Ciclo 5 - Curso 1', 3, 5, 1),
(76, 'Curso Diseño Gráfico y Multimedia Ciclo 5 - Curso 2', 3, 5, 1),
(77, 'Curso Diseño Gráfico y Multimedia Ciclo 5 - Curso 3', 3, 5, 1),
(78, 'Curso Diseño Gráfico y Multimedia Ciclo 6 - Curso 1', 3, 6, 1),
(79, 'Curso Diseño Gráfico y Multimedia Ciclo 6 - Curso 2', 3, 6, 1),
(80, 'Curso Diseño Gráfico y Multimedia Ciclo 6 - Curso 3', 3, 6, 1),
(81, 'Curso Diseño Gráfico y Multimedia Ciclo 7 - Curso 1', 3, 7, 1),
(82, 'Curso Diseño Gráfico y Multimedia Ciclo 7 - Curso 2', 3, 7, 1),
(83, 'Curso Diseño Gráfico y Multimedia Ciclo 7 - Curso 3', 3, 7, 1),
(84, 'Curso Diseño Gráfico y Multimedia Ciclo 8 - Curso 1', 3, 8, 1),
(85, 'Curso Diseño Gráfico y Multimedia Ciclo 8 - Curso 2', 3, 8, 1),
(86, 'Curso Diseño Gráfico y Multimedia Ciclo 8 - Curso 3', 3, 8, 1),
(87, 'Curso Diseño Gráfico y Multimedia Ciclo 9 - Curso 1', 3, 9, 1),
(88, 'Curso Diseño Gráfico y Multimedia Ciclo 9 - Curso 2', 3, 9, 1),
(89, 'Curso Diseño Gráfico y Multimedia Ciclo 9 - Curso 3', 3, 9, 1),
(90, 'Curso Diseño Gráfico y Multimedia Ciclo 10 - Curso 1', 3, 10, 1),
(91, 'Curso Diseño Gráfico y Multimedia Ciclo 10 - Curso 2', 3, 10, 1),
(92, 'Curso Diseño Gráfico y Multimedia Ciclo 10 - Curso 3', 3, 10, 1),
(94, 'Curso Marketing y Publicidad Ciclo 1 - Curso 1', 4, 1, 1),
(95, 'Curso Marketing y Publicidad Ciclo 1 - Curso 2', 4, 1, 1),
(96, 'Curso Marketing y Publicidad Ciclo 1 - Curso 3', 4, 1, 1),
(97, 'Curso Marketing y Publicidad Ciclo 2 - Curso 1', 4, 2, 1),
(98, 'Curso Marketing y Publicidad Ciclo 2 - Curso 2', 4, 2, 1),
(99, 'Curso Marketing y Publicidad Ciclo 2 - Curso 3', 4, 2, 1),
(100, 'Curso Marketing y Publicidad Ciclo 3 - Curso 1', 4, 3, 1),
(101, 'Curso Marketing y Publicidad Ciclo 3 - Curso 2', 4, 3, 1),
(102, 'Curso Marketing y Publicidad Ciclo 3 - Curso 3', 4, 3, 1),
(103, 'Curso Marketing y Publicidad Ciclo 4 - Curso 1', 4, 4, 1),
(104, 'Curso Marketing y Publicidad Ciclo 4 - Curso 2', 4, 4, 1),
(105, 'Curso Marketing y Publicidad Ciclo 4 - Curso 3', 4, 4, 1),
(106, 'Curso Marketing y Publicidad Ciclo 5 - Curso 1', 4, 5, 1),
(107, 'Curso Marketing y Publicidad Ciclo 5 - Curso 2', 4, 5, 1),
(108, 'Curso Marketing y Publicidad Ciclo 5 - Curso 3', 4, 5, 1),
(109, 'Curso Marketing y Publicidad Ciclo 6 - Curso 1', 4, 6, 1),
(110, 'Curso Marketing y Publicidad Ciclo 6 - Curso 2', 4, 6, 1),
(111, 'Curso Marketing y Publicidad Ciclo 6 - Curso 3', 4, 6, 1),
(112, 'Curso Marketing y Publicidad Ciclo 7 - Curso 1', 4, 7, 1),
(113, 'Curso Marketing y Publicidad Ciclo 7 - Curso 2', 4, 7, 1),
(114, 'Curso Marketing y Publicidad Ciclo 7 - Curso 3', 4, 7, 1),
(115, 'Curso Marketing y Publicidad Ciclo 8 - Curso 1', 4, 8, 1),
(116, 'Curso Marketing y Publicidad Ciclo 8 - Curso 2', 4, 8, 1),
(117, 'Curso Marketing y Publicidad Ciclo 8 - Curso 3', 4, 8, 1),
(118, 'Curso Marketing y Publicidad Ciclo 9 - Curso 1', 4, 9, 1),
(119, 'Curso Marketing y Publicidad Ciclo 9 - Curso 2', 4, 9, 1),
(120, 'Curso Marketing y Publicidad Ciclo 9 - Curso 3', 4, 9, 1),
(121, 'Curso Marketing y Publicidad Ciclo 10 - Curso 1', 4, 10, 1),
(122, 'Curso Marketing y Publicidad Ciclo 10 - Curso 2', 4, 10, 1),
(123, 'Curso Marketing y Publicidad Ciclo 10 - Curso 3', 4, 10, 1),
(125, 'Curso Administración de Empresas Ciclo 1 - Curso 1', 5, 1, 1),
(126, 'Curso Administración de Empresas Ciclo 1 - Curso 2', 5, 1, 1),
(127, 'Curso Administración de Empresas Ciclo 1 - Curso 3', 5, 1, 1),
(128, 'Curso Administración de Empresas Ciclo 2 - Curso 1', 5, 2, 1),
(129, 'Curso Administración de Empresas Ciclo 2 - Curso 2', 5, 2, 1),
(130, 'Curso Administración de Empresas Ciclo 2 - Curso 3', 5, 2, 1),
(131, 'Curso Administración de Empresas Ciclo 3 - Curso 1', 5, 3, 1),
(132, 'Curso Administración de Empresas Ciclo 3 - Curso 2', 5, 3, 1),
(133, 'Curso Administración de Empresas Ciclo 3 - Curso 3', 5, 3, 1),
(134, 'Curso Administración de Empresas Ciclo 4 - Curso 1', 5, 4, 1),
(135, 'Curso Administración de Empresas Ciclo 4 - Curso 2', 5, 4, 1),
(136, 'Curso Administración de Empresas Ciclo 4 - Curso 3', 5, 4, 1),
(137, 'Curso Administración de Empresas Ciclo 5 - Curso 1', 5, 5, 1),
(138, 'Curso Administración de Empresas Ciclo 5 - Curso 2', 5, 5, 1),
(139, 'Curso Administración de Empresas Ciclo 5 - Curso 3', 5, 5, 1),
(140, 'Curso Administración de Empresas Ciclo 6 - Curso 1', 5, 6, 1),
(141, 'Curso Administración de Empresas Ciclo 6 - Curso 2', 5, 6, 1),
(142, 'Curso Administración de Empresas Ciclo 6 - Curso 3', 5, 6, 1),
(143, 'Curso Administración de Empresas Ciclo 7 - Curso 1', 5, 7, 1),
(144, 'Curso Administración de Empresas Ciclo 7 - Curso 2', 5, 7, 1),
(145, 'Curso Administración de Empresas Ciclo 7 - Curso 3', 5, 7, 1),
(146, 'Curso Administración de Empresas Ciclo 8 - Curso 1', 5, 8, 1),
(147, 'Curso Administración de Empresas Ciclo 8 - Curso 2', 5, 8, 1),
(148, 'Curso Administración de Empresas Ciclo 8 - Curso 3', 5, 8, 1),
(149, 'Curso Administración de Empresas Ciclo 9 - Curso 1', 5, 9, 1),
(150, 'Curso Administración de Empresas Ciclo 9 - Curso 2', 5, 9, 1),
(151, 'Curso Administración de Empresas Ciclo 9 - Curso 3', 5, 9, 1),
(152, 'Curso Administración de Empresas Ciclo 10 - Curso 1', 5, 10, 1),
(153, 'Curso Administración de Empresas Ciclo 10 - Curso 2', 5, 10, 1),
(154, 'Curso Administración de Empresas Ciclo 10 - Curso 3', 5, 10, 1),
(156, 'Curso Diseño de Videojuegos Ciclo 1 - Curso 1', 6, 1, 1),
(157, 'Curso Diseño de Videojuegos Ciclo 1 - Curso 2', 6, 1, 1),
(158, 'Curso Diseño de Videojuegos Ciclo 1 - Curso 3', 6, 1, 1),
(159, 'Curso Diseño de Videojuegos Ciclo 2 - Curso 1', 6, 2, 1),
(160, 'Curso Diseño de Videojuegos Ciclo 2 - Curso 2', 6, 2, 1),
(161, 'Curso Diseño de Videojuegos Ciclo 2 - Curso 3', 6, 2, 1),
(162, 'Curso Diseño de Videojuegos Ciclo 3 - Curso 1', 6, 3, 1),
(163, 'Curso Diseño de Videojuegos Ciclo 3 - Curso 2', 6, 3, 1),
(164, 'Curso Diseño de Videojuegos Ciclo 3 - Curso 3', 6, 3, 1),
(165, 'Curso Diseño de Videojuegos Ciclo 4 - Curso 1', 6, 4, 1),
(166, 'Curso Diseño de Videojuegos Ciclo 4 - Curso 2', 6, 4, 1),
(167, 'Curso Diseño de Videojuegos Ciclo 4 - Curso 3', 6, 4, 1),
(168, 'Curso Diseño de Videojuegos Ciclo 5 - Curso 1', 6, 5, 1),
(169, 'Curso Diseño de Videojuegos Ciclo 5 - Curso 2', 6, 5, 1),
(170, 'Curso Diseño de Videojuegos Ciclo 5 - Curso 3', 6, 5, 1),
(171, 'Curso Diseño de Videojuegos Ciclo 6 - Curso 1', 6, 6, 1),
(172, 'Curso Diseño de Videojuegos Ciclo 6 - Curso 2', 6, 6, 1),
(173, 'Curso Diseño de Videojuegos Ciclo 6 - Curso 3', 6, 6, 1),
(174, 'Curso Diseño de Videojuegos Ciclo 7 - Curso 1', 6, 7, 1),
(175, 'Curso Diseño de Videojuegos Ciclo 7 - Curso 2', 6, 7, 1),
(176, 'Curso Diseño de Videojuegos Ciclo 7 - Curso 3', 6, 7, 1),
(177, 'Curso Diseño de Videojuegos Ciclo 8 - Curso 1', 6, 8, 1),
(178, 'Curso Diseño de Videojuegos Ciclo 8 - Curso 2', 6, 8, 1),
(179, 'Curso Diseño de Videojuegos Ciclo 8 - Curso 3', 6, 8, 1),
(180, 'Curso Diseño de Videojuegos Ciclo 9 - Curso 1', 6, 9, 1),
(181, 'Curso Diseño de Videojuegos Ciclo 9 - Curso 2', 6, 9, 1),
(182, 'Curso Diseño de Videojuegos Ciclo 9 - Curso 3', 6, 9, 1),
(183, 'Curso Diseño de Videojuegos Ciclo 10 - Curso 1', 6, 10, 1),
(184, 'Curso Diseño de Videojuegos Ciclo 10 - Curso 2', 6, 10, 1),
(185, 'Curso Diseño de Videojuegos Ciclo 10 - Curso 3', 6, 10, 1),
(187, 'Curso Redes y Comunicaciones Ciclo 1 - Curso 1', 7, 1, 1),
(188, 'Curso Redes y Comunicaciones Ciclo 1 - Curso 2', 7, 1, 1),
(189, 'Curso Redes y Comunicaciones Ciclo 1 - Curso 3', 7, 1, 1),
(190, 'Curso Redes y Comunicaciones Ciclo 2 - Curso 1', 7, 2, 1),
(191, 'Curso Redes y Comunicaciones Ciclo 2 - Curso 2', 7, 2, 1),
(192, 'Curso Redes y Comunicaciones Ciclo 2 - Curso 3', 7, 2, 1),
(193, 'Curso Redes y Comunicaciones Ciclo 3 - Curso 1', 7, 3, 1),
(194, 'Curso Redes y Comunicaciones Ciclo 3 - Curso 2', 7, 3, 1),
(195, 'Curso Redes y Comunicaciones Ciclo 3 - Curso 3', 7, 3, 1),
(196, 'Curso Redes y Comunicaciones Ciclo 4 - Curso 1', 7, 4, 1),
(197, 'Curso Redes y Comunicaciones Ciclo 4 - Curso 2', 7, 4, 1),
(198, 'Curso Redes y Comunicaciones Ciclo 4 - Curso 3', 7, 4, 1),
(199, 'Curso Redes y Comunicaciones Ciclo 5 - Curso 1', 7, 5, 1),
(200, 'Curso Redes y Comunicaciones Ciclo 5 - Curso 2', 7, 5, 1),
(201, 'Curso Redes y Comunicaciones Ciclo 5 - Curso 3', 7, 5, 1),
(202, 'Curso Redes y Comunicaciones Ciclo 6 - Curso 1', 7, 6, 1),
(203, 'Curso Redes y Comunicaciones Ciclo 6 - Curso 2', 7, 6, 1),
(204, 'Curso Redes y Comunicaciones Ciclo 6 - Curso 3', 7, 6, 1),
(205, 'Curso Redes y Comunicaciones Ciclo 7 - Curso 1', 7, 7, 1),
(206, 'Curso Redes y Comunicaciones Ciclo 7 - Curso 2', 7, 7, 1),
(207, 'Curso Redes y Comunicaciones Ciclo 7 - Curso 3', 7, 7, 1),
(208, 'Curso Redes y Comunicaciones Ciclo 8 - Curso 1', 7, 8, 1),
(209, 'Curso Redes y Comunicaciones Ciclo 8 - Curso 2', 7, 8, 1),
(210, 'Curso Redes y Comunicaciones Ciclo 8 - Curso 3', 7, 8, 1),
(211, 'Curso Redes y Comunicaciones Ciclo 9 - Curso 1', 7, 9, 1),
(212, 'Curso Redes y Comunicaciones Ciclo 9 - Curso 2', 7, 9, 1),
(213, 'Curso Redes y Comunicaciones Ciclo 9 - Curso 3', 7, 9, 1),
(214, 'Curso Redes y Comunicaciones Ciclo 10 - Curso 1', 7, 10, 1),
(215, 'Curso Redes y Comunicaciones Ciclo 10 - Curso 2', 7, 10, 1),
(216, 'Curso Redes y Comunicaciones Ciclo 10 - Curso 3', 7, 10, 1),
(218, 'Curso Diseño y Desarrollo Web Ciclo 1 - Curso 1', 8, 1, 1),
(219, 'Curso Diseño y Desarrollo Web Ciclo 1 - Curso 2', 8, 1, 1),
(220, 'Curso Diseño y Desarrollo Web Ciclo 1 - Curso 3', 8, 1, 1),
(221, 'Curso Diseño y Desarrollo Web Ciclo 2 - Curso 1', 8, 2, 1),
(222, 'Curso Diseño y Desarrollo Web Ciclo 2 - Curso 2', 8, 2, 1),
(223, 'Curso Diseño y Desarrollo Web Ciclo 2 - Curso 3', 8, 2, 1),
(224, 'Curso Diseño y Desarrollo Web Ciclo 3 - Curso 1', 8, 3, 1),
(225, 'Curso Diseño y Desarrollo Web Ciclo 3 - Curso 2', 8, 3, 1),
(226, 'Curso Diseño y Desarrollo Web Ciclo 3 - Curso 3', 8, 3, 1),
(227, 'Curso Diseño y Desarrollo Web Ciclo 4 - Curso 1', 8, 4, 1),
(228, 'Curso Diseño y Desarrollo Web Ciclo 4 - Curso 2', 8, 4, 1),
(229, 'Curso Diseño y Desarrollo Web Ciclo 4 - Curso 3', 8, 4, 1),
(230, 'Curso Diseño y Desarrollo Web Ciclo 5 - Curso 1', 8, 5, 1),
(231, 'Curso Diseño y Desarrollo Web Ciclo 5 - Curso 2', 8, 5, 1),
(232, 'Curso Diseño y Desarrollo Web Ciclo 5 - Curso 3', 8, 5, 1),
(233, 'Curso Diseño y Desarrollo Web Ciclo 6 - Curso 1', 8, 6, 1),
(234, 'Curso Diseño y Desarrollo Web Ciclo 6 - Curso 2', 8, 6, 1),
(235, 'Curso Diseño y Desarrollo Web Ciclo 6 - Curso 3', 8, 6, 1),
(236, 'Curso Diseño y Desarrollo Web Ciclo 7 - Curso 1', 8, 7, 1),
(237, 'Curso Diseño y Desarrollo Web Ciclo 7 - Curso 2', 8, 7, 1),
(238, 'Curso Diseño y Desarrollo Web Ciclo 7 - Curso 3', 8, 7, 1),
(239, 'Curso Diseño y Desarrollo Web Ciclo 8 - Curso 1', 8, 8, 1),
(240, 'Curso Diseño y Desarrollo Web Ciclo 8 - Curso 2', 8, 8, 1),
(241, 'Curso Diseño y Desarrollo Web Ciclo 8 - Curso 3', 8, 8, 1),
(242, 'Curso Diseño y Desarrollo Web Ciclo 9 - Curso 1', 8, 9, 1),
(243, 'Curso Diseño y Desarrollo Web Ciclo 9 - Curso 2', 8, 9, 1),
(244, 'Curso Diseño y Desarrollo Web Ciclo 9 - Curso 3', 8, 9, 1),
(245, 'Curso Diseño y Desarrollo Web Ciclo 10 - Curso 1', 8, 10, 1),
(246, 'Curso Diseño y Desarrollo Web Ciclo 10 - Curso 2', 8, 10, 1),
(247, 'Curso Diseño y Desarrollo Web Ciclo 10 - Curso 3', 8, 10, 1),
(248, 'Curso de Prueba', 9, 5, 0),
(249, 'Curso de Prueba', 9, 5, 0),
(250, 'Curso de Prueba Editado', 9, 5, 1),
(251, 'Curso de Prueba Editado', 9, 5, 1),
(252, 'Otro Curso de Prueba', 4, 6, 1),
(253, 'Diseño de Mundo Abierto', 8, 6, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notas`
--

CREATE TABLE IF NOT EXISTS `notas` (
  `IDSALON` int(11) NOT NULL DEFAULT '0',
  `IDALUMNO` int(11) NOT NULL DEFAULT '0',
  `NOTA1` double DEFAULT '0',
  `NOTA2` double DEFAULT '0',
  `NOTA3` double DEFAULT '0',
  PRIMARY KEY (`IDSALON`,`IDALUMNO`),
  KEY `IDALUMNO` (`IDALUMNO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `notas`
--

INSERT INTO `notas` (`IDSALON`, `IDALUMNO`, `NOTA1`, `NOTA2`, `NOTA3`) VALUES
(965, 21, 13, 20, 0),
(966, 8, 0, 0, 0),
(966, 21, 13, 20, 0),
(967, 1, 11, 20, 18.5),
(968, 1, 20, 18, 19),
(969, 1, 0, 0, 0),
(970, 2, 0, 0, 0),
(971, 2, 0, 0, 0),
(971, 6, 0, 0, 0),
(972, 2, 0, 0, 0),
(973, 3, 0, 0, 0),
(974, 3, 0, 0, 0),
(975, 3, 0, 0, 0),
(976, 4, 0, 0, 0),
(977, 4, 0, 0, 0),
(978, 4, 0, 0, 0),
(979, 5, 0, 0, 0),
(980, 5, 0, 0, 0),
(981, 5, 0, 0, 0),
(982, 6, 0, 0, 0),
(983, 6, 0, 0, 0),
(984, 6, 0, 0, 0),
(985, 7, 0, 0, 0),
(986, 7, 0, 0, 0),
(987, 7, 0, 0, 0),
(988, 8, 20, 0, 0),
(989, 8, 0, 0, 0),
(990, 8, 0, 0, 0),
(991, 9, 0, 0, 0),
(992, 9, 0, 0, 0),
(993, 9, 0, 0, 0),
(994, 11, 0, 0, 0),
(995, 11, 18, 0, 0),
(996, 11, 0, 0, 0),
(997, 12, 0, 0, 0),
(998, 12, 0, 0, 0),
(999, 12, 0, 0, 0),
(1000, 13, 0, 0, 0),
(1001, 13, 0, 0, 0),
(1002, 13, 0, 0, 0),
(1003, 14, 0, 0, 0),
(1004, 14, 0, 0, 0),
(1005, 14, 0, 0, 0),
(1006, 15, 0, 0, 0),
(1007, 15, 0, 0, 0),
(1008, 15, 0, 0, 0),
(1009, 16, 0, 0, 0),
(1010, 16, 0, 0, 0),
(1011, 16, 0, 0, 0),
(1012, 17, 0, 0, 0),
(1013, 17, 0, 0, 0),
(1014, 17, 0, 0, 0),
(1015, 18, 0, 0, 0),
(1016, 18, 0, 0, 0),
(1017, 18, 0, 0, 0),
(1018, 19, 0, 0, 0),
(1019, 19, 0, 0, 0),
(1020, 19, 0, 0, 0),
(1021, 20, 0, 0, 0),
(1022, 20, 0, 0, 0),
(1023, 20, 0, 0, 0),
(1024, 21, 0, 0, 0),
(1025, 21, 18, 20, 12),
(1026, 21, 0, 0, 0),
(1028, 22, 20, 0, 0),
(1029, 22, 0, 0, 0),
(1030, 22, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE IF NOT EXISTS `profesor` (
  `IDPROFESOR` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `DNI` varchar(20) DEFAULT NULL,
  `IDUSUARIO` int(11) DEFAULT NULL,
  `ACTIVO` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`IDPROFESOR`),
  KEY `IDUSUARIO` (`IDUSUARIO`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`IDPROFESOR`, `NOMBRE`, `APELLIDO`, `DNI`, `IDUSUARIO`, `ACTIVO`) VALUES
(1, 'Stephen', 'King', '123456789A', 2, 1),
(2, 'Edgar Allan', 'Poe', '987654321B', 3, 1),
(3, 'H.P.', 'Lovecraft', '456123789C', 4, 1),
(4, 'Alfred', 'Hitchcock', '789123456D', 5, 1),
(5, 'Wes', 'Craven', '321654987E', 6, 1),
(6, 'George A.', 'Romero', '654987321F', 7, 1),
(7, 'Mary', 'Shelley', '987654123G', 8, 1),
(8, 'Clive', 'Barker', '123987654H', 9, 1),
(9, 'John', 'Carpenter', '456789123I', 10, 1),
(11, 'Sharon', 'Rodriguez', '12345678', 41, 1),
(12, 'Sharon', 'Rodriguez', '12345678', 42, 0),
(13, 'Aaron', 'Rodriguez', '12345678', 43, 1),
(14, 'Sharon', 'Rodriguez', '12345678', 44, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salon`
--

CREATE TABLE IF NOT EXISTS `salon` (
  `IDSALON` int(11) NOT NULL AUTO_INCREMENT,
  `TURNO` varchar(20) DEFAULT NULL,
  `IDCURSO` int(11) DEFAULT NULL,
  `IDPROFESOR` int(11) DEFAULT NULL,
  `ACTIVO` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`IDSALON`),
  KEY `IDCURSO` (`IDCURSO`),
  KEY `IDPROFESOR` (`IDPROFESOR`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1031 ;

--
-- Volcado de datos para la tabla `salon`
--

INSERT INTO `salon` (`IDSALON`, `TURNO`, `IDCURSO`, `IDPROFESOR`, `ACTIVO`) VALUES
(965, 'Tarde', 250, 9, 0),
(966, 'Mañana', 232, 9, 1),
(967, 'Mañana', 7, 3, 1),
(968, 'Mañana', 8, 2, 1),
(969, 'Mañana', 9, 6, 1),
(970, 'Tarde', 35, 8, 1),
(971, 'Tarde', 36, 4, 1),
(972, 'Tarde', 37, 2, 1),
(973, 'Noche', 75, 9, 1),
(974, 'Noche', 76, 6, 1),
(975, 'Noche', 77, 5, 1),
(976, 'Mañana', 103, 7, 1),
(977, 'Mañana', 104, 7, 1),
(978, 'Mañana', 105, 6, 1),
(979, 'Tarde', 140, 6, 1),
(980, 'Tarde', 141, 3, 1),
(981, 'Tarde', 142, 9, 1),
(982, 'Noche', 177, 3, 1),
(983, 'Noche', 178, 7, 1),
(984, 'Noche', 179, 5, 1),
(985, 'Mañana', 211, 5, 1),
(986, 'Mañana', 212, 9, 1),
(987, 'Mañana', 213, 8, 1),
(988, 'Tarde', 218, 1, 1),
(989, 'Tarde', 219, 1, 1),
(990, 'Tarde', 220, 3, 1),
(991, 'Noche', 19, 5, 1),
(992, 'Noche', 20, 5, 1),
(993, 'Noche', 21, 7, 1),
(994, 'Tarde', 69, 4, 1),
(995, 'Tarde', 70, 2, 1),
(996, 'Tarde', 71, 4, 1),
(997, 'Noche', 118, 8, 1),
(998, 'Noche', 119, 4, 1),
(999, 'Noche', 120, 5, 1),
(1000, 'Mañana', 134, 2, 1),
(1001, 'Mañana', 135, 7, 1),
(1002, 'Mañana', 136, 3, 1),
(1003, 'Tarde', 156, 8, 1),
(1004, 'Tarde', 157, 3, 1),
(1005, 'Tarde', 158, 7, 1),
(1006, 'Noche', 208, 4, 1),
(1007, 'Noche', 209, 9, 1),
(1008, 'Noche', 210, 2, 1),
(1009, 'Mañana', 221, 6, 1),
(1010, 'Mañana', 222, 3, 1),
(1011, 'Mañana', 223, 9, 1),
(1012, 'Tarde', 13, 7, 1),
(1013, 'Tarde', 14, 9, 1),
(1014, 'Tarde', 15, 7, 1),
(1015, 'Noche', 53, 8, 1),
(1016, 'Noche', 54, 4, 1),
(1017, 'Noche', 55, 6, 1),
(1018, 'Mañana', 90, 7, 1),
(1019, 'Mañana', 91, 8, 1),
(1020, 'Mañana', 92, 3, 1),
(1021, 'Tarde', 103, 9, 1),
(1022, 'Tarde', 104, 1, 1),
(1023, 'Tarde', 105, 8, 1),
(1024, 'Mañana', 72, 4, 1),
(1025, 'Mañana', 73, 1, 1),
(1026, 'Mañana', 74, 4, 1),
(1027, 'Tarde', 7, 6, 1),
(1028, 'Mañana', 59, 2, 1),
(1029, 'Mañana', 60, 6, 1),
(1030, 'Mañana', 61, 11, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `IDUSUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `USER` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(20) DEFAULT NULL,
  `ROL` varchar(10) DEFAULT NULL,
  `ACTIVO` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`IDUSUARIO`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=198 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`IDUSUARIO`, `USER`, `PASSWORD`, `ROL`, `ACTIVO`) VALUES
(1, 'admin', '123', 'Admin', 1),
(2, 'sking', 'password2', 'Profesor', 1),
(3, 'raven', 'nevermore', 'Profesor', 1),
(4, 'dagon', 'nigga', 'Profesor', 1),
(5, 'birdslover', 'password5', 'Profesor', 1),
(6, 'profesor5', 'password6', 'Profesor', 1),
(7, 'profesor6', 'password7', 'Profesor', 1),
(8, 'profesor7', 'password8', 'Profesor', 1),
(9, 'profesor8', 'password9', 'Profesor', 1),
(10, 'profesor9', 'password10', 'Profesor', 1),
(11, 'knife', 'password11', 'Alumno', 1),
(12, 'thedreamer', 'password12', 'Alumno', 1),
(13, 'alumno3', 'password13', 'Alumno', 1),
(14, 'alumno4', 'password14', 'Alumno', 1),
(15, 'alumno5', 'password15', 'Alumno', 1),
(16, 'alumno6', 'password16', 'Alumno', 1),
(17, 'alumno7', 'password17', 'Alumno', 1),
(18, 'alumno8', 'password18', 'Alumno', 1),
(19, 'alumno9', 'password19', 'Alumno', 1),
(20, 'alumno10', 'password20', 'Alumno', 1),
(21, 'alumno11', 'password21', 'Alumno', 1),
(22, 'alumno12', 'password22', 'Alumno', 1),
(23, 'alumno13', 'password23', 'Alumno', 1),
(24, 'alumno14', 'password24', 'Alumno', 1),
(25, 'alumno15', 'password25', 'Alumno', 1),
(26, 'alumno16', 'password26', 'Alumno', 1),
(27, 'alumno17', 'password27', 'Alumno', 1),
(28, 'alumno18', 'password28', 'Alumno', 1),
(29, 'alumno19', 'password29', 'Alumno', 1),
(30, 'alumno20', 'password30', 'Alumno', 1),
(31, 'alumno21', 'password31', 'Alumno', 1),
(32, 'alumno22', 'password32', 'Alumno', 1),
(33, 'alumno23', 'password33', 'Alumno', 1),
(34, 'alumno24', 'password34', 'Alumno', 1),
(35, 'alumno25', 'password35', 'Alumno', 1),
(36, 'alumno26', 'password36', 'Alumno', 1),
(37, 'alumno27', 'password37', 'Alumno', 1),
(38, 'alumno28', 'password38', 'Alumno', 1),
(39, 'alumno29', 'password39', 'Alumno', 1),
(40, 'alumno30', 'password40', 'Alumno', 1),
(41, 'nuevo', 'prueba2', 'Admin', 0),
(42, 'shrodrig', '1234', 'Profesor', NULL),
(43, 'lallama', '1234', 'Profesor', 1),
(44, 'shaome', '1234', 'Profesor', 1),
(45, 'chanfle', 'chanfle', 'Alumno', 1),
(46, 'profe', 'contra', 'Profesor', 1),
(196, 'prueba', 'contra', 'Alumno', 1),
(197, 'hockeylover', 'knife', NULL, NULL);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD CONSTRAINT `alumno_ibfk_1` FOREIGN KEY (`IDCARRERA`) REFERENCES `carrera` (`IDCARRERA`),
  ADD CONSTRAINT `alumno_ibfk_2` FOREIGN KEY (`IDUSUARIO`) REFERENCES `usuario` (`IDUSUARIO`);

--
-- Filtros para la tabla `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `curso_ibfk_1` FOREIGN KEY (`IDCARRERA`) REFERENCES `carrera` (`IDCARRERA`);

--
-- Filtros para la tabla `notas`
--
ALTER TABLE `notas`
  ADD CONSTRAINT `notas_ibfk_1` FOREIGN KEY (`IDSALON`) REFERENCES `salon` (`IDSALON`),
  ADD CONSTRAINT `notas_ibfk_2` FOREIGN KEY (`IDALUMNO`) REFERENCES `alumno` (`IDALUMNO`);

--
-- Filtros para la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD CONSTRAINT `profesor_ibfk_1` FOREIGN KEY (`IDUSUARIO`) REFERENCES `usuario` (`IDUSUARIO`);

--
-- Filtros para la tabla `salon`
--
ALTER TABLE `salon`
  ADD CONSTRAINT `salon_ibfk_1` FOREIGN KEY (`IDCURSO`) REFERENCES `curso` (`IDCURSO`),
  ADD CONSTRAINT `salon_ibfk_2` FOREIGN KEY (`IDPROFESOR`) REFERENCES `profesor` (`IDPROFESOR`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
