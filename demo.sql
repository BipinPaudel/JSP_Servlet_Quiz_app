-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 15, 2016 at 09:30 AM
-- Server version: 5.5.53-0ubuntu0.14.04.1
-- PHP Version: 5.6.23-1+deprecated+dontuse+deb.sury.org~trusty+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `demo`
--

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`id`, `title`) VALUES
(1, 'g1'),
(2, 'g2'),
(3, 'g3'),
(4, 'g4');

-- --------------------------------------------------------

--
-- Table structure for table `group_answer`
--

CREATE TABLE IF NOT EXISTS `group_answer` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `answer` varchar(20) DEFAULT NULL,
  `question_id` int(6) DEFAULT NULL,
  `group_id` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=169 ;

--
-- Dumping data for table `group_answer`
--

INSERT INTO `group_answer` (`id`, `answer`, `question_id`, `group_id`) VALUES
(161, 'JVM', 12, 1),
(162, 'Paudel', 16, 2),
(163, 'Oracle', 15, 3),
(164, 'Web', 13, 4),
(165, 'raaute', 9, 1),
(166, 'Prakash sir', 10, 2),
(167, 'Sita', 3, 3),
(168, 'Google', 14, 4);

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(256) DEFAULT NULL,
  `answer1` varchar(64) DEFAULT NULL,
  `answer2` varchar(64) DEFAULT NULL,
  `answer3` varchar(64) DEFAULT NULL,
  `answer4` varchar(64) DEFAULT NULL,
  `correct` varchar(64) DEFAULT NULL,
  `category` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `title`, `answer1`, `answer2`, `answer3`, `answer4`, `correct`, `category`) VALUES
(3, 'Who is wife of Ram?', 'Sunny Leone', 'Rekha Thapa', 'Sita', 'Geeta', 'Sita', 'History'),
(9, 'what is subash caste?', 'raaute', 'khaaute', 'chepang', 'tepang', 'raaute', 'human'),
(10, 'our java teacher?', 'Prakash sir', 'ganesh sir', 'gopal sir', 'bidur sir', 'Prakash sir', 'Human'),
(12, 'Java runs over?', 'JVM', 'SVM', 'TDM', 'MDM', 'JVM', 'programming'),
(13, 'Ruby on Rails used for?', 'Android', 'Ios', 'Web', 'Desktop', 'Web', 'programming'),
(14, 'Android is owned by?', 'Apple', 'Google', 'Facebook', 'Amazon', 'Google', 'Software'),
(15, 'MySql is owned by?', 'Oracle', 'Facebook', 'Deerwalk', 'Bipin', 'Oracle', 'Software'),
(16, 'My caste ?', 'Aryal', 'Pandey', 'Nepali', 'Paudel', 'Paudel', 'Human');

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE IF NOT EXISTS `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `role` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`id`, `username`, `password`, `role`) VALUES
(1, 'admin', 'admin', 'ROLE_ADMIN'),
(4, 'user', 'user', 'ROLE_ADMIN'),
(5, 'gopal', 'gopal', 'ROLE_USER'),
(6, 'shankar', 'shankar', 'ROLE_ADMIN'),
(7, 'osheen', 'osheen', 'ROLE_ADMIN');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
