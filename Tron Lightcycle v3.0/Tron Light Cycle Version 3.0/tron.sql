-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 18 juil. 2019 à 08:41
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tron`
--

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `addPlayer`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addPlayer` (IN `name` VARCHAR(64), IN `sec` FLOAT)  NO SQL
INSERT INTO gamedata (player_name , Game_time)
VALUES (name , sec)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `gamedata`
--

DROP TABLE IF EXISTS `gamedata`;
CREATE TABLE IF NOT EXISTS `gamedata` (
  `Player_Name` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `game_Time` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `gamedata`
--

INSERT INTO `gamedata` (`Player_Name`, `game_Time`) VALUES
('Player 1', 1.05),
('Player 1', 2.64),
('Player 1', 1.05),
('Player 1', 1.05),
('Player 1', 1.05),
('Player 2', 0.6),
('Player 2', 1.57),
('Player 1', 0.45),
('Player 2', 2.6),
('Player 1', 1.05),
('Player 1', 1.05),
('Player 1', 0.77),
('Player 1', 14.06),
('Player 1', 1.05),
('Player 2', 15.01),
('Player 2', 9.35),
('Player 2', 5.85),
('Player 2', 4.69),
('Player 2', 7.65),
('Player 1', 1.55),
('Player 2', 6.77),
('Player 2', 3.25),
('Player 1', 1.05),
('Player 1', 1.05),
('Player 1', 1.05),
('Player 2', 0.49),
('Player 1', 1.05),
('Player 2', 0.97),
('Player 2', 0.97),
('Player 1', 0.86),
('Player 1', 3.07),
('Player 2', 1.16),
('Player 2', 9.29),
('Player 2', 0.02),
('Player 1', 1.05),
('Player 2', 3.23),
('Player 1', 3.81),
('Player 2', 0.75),
('Player 2', 0.77),
('Player 2', 0.02),
('Player 2', 0.8),
('Player 1', 1.05),
('Player 2', 0.26),
('Player 1', 1.05),
('Player 2', 1.03),
('Player 1', 1.05),
('Player 2', 0.37),
('Player 1', 1.05),
('Player 1', 1.05),
('Player 1', 1.05),
('Player 2', 0.58),
('Player 1', 1.05),
('Player 1', 1.05),
('Player 1', 1.05),
('Player 1', 1.05),
('Player 2', 0.58),
('Player 1', 1.05),
('Player 2', 0.8),
('Player 2', 1.89),
('Player 2', 3.35),
('Player 2', 2.6),
('Player 2', 4.26),
('Player 2', 2.04),
('Player 1', 0.62),
('Player 1', 0.28),
('Player 1', 0.32),
('Player 1', 0.28),
('Player 1', 3.46);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
