-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-11-2022 a las 08:17:55
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `residuos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `certificado`
--

CREATE TABLE `certificado` (
  `id_Certificado` int(11) NOT NULL,
  `Transportista` varchar(100) NOT NULL,
  `periodoMensual` date NOT NULL,
  `TotalPeso` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generador_consultorio`
--

CREATE TABLE `generador_consultorio` (
  `id_consultorio` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Cuit` varchar(20) NOT NULL,
  `Domicilio` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `generador_consultorio`
--

INSERT INTO `generador_consultorio` (`id_consultorio`, `Nombre`, `Cuit`, `Domicilio`) VALUES
(1, 'Crespo Carlos', '2012341011', 'Colon 820');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket_control`
--

CREATE TABLE `ticket_control` (
  `id_Ticket` int(11) NOT NULL,
  `Transportista` varchar(100) NOT NULL,
  `id_Consultorio` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `ResiduoTipo` varchar(50) NOT NULL,
  `ResiduoCant` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ticket_control`
--

INSERT INTO `ticket_control` (`id_Ticket`, `Transportista`, `id_Consultorio`, `Fecha`, `ResiduoTipo`, `ResiduoCant`) VALUES
(6, 'Victor Alvarez', 1, '0022-11-23', 'Materiales Organicos', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `certificado`
--
ALTER TABLE `certificado`
  ADD PRIMARY KEY (`id_Certificado`);

--
-- Indices de la tabla `generador_consultorio`
--
ALTER TABLE `generador_consultorio`
  ADD PRIMARY KEY (`id_consultorio`),
  ADD UNIQUE KEY `Cuit` (`Cuit`);

--
-- Indices de la tabla `ticket_control`
--
ALTER TABLE `ticket_control`
  ADD PRIMARY KEY (`id_Ticket`),
  ADD KEY `id_Consultorio` (`id_Consultorio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `certificado`
--
ALTER TABLE `certificado`
  MODIFY `id_Certificado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `generador_consultorio`
--
ALTER TABLE `generador_consultorio`
  MODIFY `id_consultorio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `ticket_control`
--
ALTER TABLE `ticket_control`
  MODIFY `id_Ticket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ticket_control`
--
ALTER TABLE `ticket_control`
  ADD CONSTRAINT `ticket_control_ibfk_1` FOREIGN KEY (`id_Consultorio`) REFERENCES `generador_consultorio` (`id_consultorio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
