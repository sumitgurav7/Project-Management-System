-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 25, 2018 at 06:42 PM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `opms`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `email_id` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `contact_no` bigint(20) NOT NULL,
  PRIMARY KEY (`email_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`email_id`, `name`, `contact_no`) VALUES
('admin@gmail.com', 'admin', 8765490761);

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
CREATE TABLE IF NOT EXISTS `comments` (
  `timestamp` timestamp NOT NULL,
  `project_id` int(16) NOT NULL,
  `comment` text NOT NULL,
  `updated_by` varchar(64) NOT NULL,
  PRIMARY KEY (`timestamp`),
  KEY `project_id` (`project_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
CREATE TABLE IF NOT EXISTS `faculty` (
  `email_id` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `department` varchar(16) NOT NULL,
  `designation` varchar(32) NOT NULL,
  `contact_no` bigint(20) NOT NULL,
  PRIMARY KEY (`email_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`email_id`, `name`, `department`, `designation`, `contact_no`) VALUES
('rahulg@gmail.com', 'Rahul Goyal', 'PG-DAC', 'Assistant Faculty', 8907654312),
('vparmar@gmail.com', 'Vishwajeet parmar', 'PG-DITTIS', 'Senior Faculty', 9006543218);

-- --------------------------------------------------------

--
-- Table structure for table `files`
--

DROP TABLE IF EXISTS `files`;
CREATE TABLE IF NOT EXISTS `files` (
  `filename` varchar(64) NOT NULL,
  `filepath` varchar(264) NOT NULL,
  `filehash` varchar(128) NOT NULL,
  `timestamp` timestamp NOT NULL,
  `project_id` int(16) NOT NULL,
  `uploaded_by` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `login_table`
--

DROP TABLE IF EXISTS `login_table`;
CREATE TABLE IF NOT EXISTS `login_table` (
  `username` varchar(64) NOT NULL,
  `password` varchar(128) NOT NULL,
  `valid_from` date NOT NULL,
  `valid_upto` date NOT NULL,
  `last_login` timestamp NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '0',
  `verification_code` int(64) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_table`
--

INSERT INTO `login_table` (`username`, `password`, `valid_from`, `valid_upto`, `last_login`, `enabled`, `verification_code`) VALUES
('vparmar@gmail.com', 'hello', '2018-07-25', '2019-01-25', '2018-07-25 18:22:57', 1, 2030734695),
('180251920010', 'hello', '2018-07-25', '2018-07-30', '2018-07-24 18:30:00', 1, 45790754),
('180259120016', 'hello', '2018-07-25', '2018-08-10', '2018-07-24 20:33:00', 1, 8764080),
('180259120014', 'hello', '2018-07-25', '2019-01-25', '2018-07-25 18:04:06', 1, 1842147283),
('180251920016', 'hello', '2018-07-25', '2019-01-25', '2018-07-25 17:38:27', 1, 529363252),
('rahulg@gmail.com', 'hello', '2018-07-25', '2019-01-25', '2018-07-25 18:24:11', 1, 2014657936),
('admin@gmail.com', 'hello', '2018-07-25', '2019-01-25', '2018-07-25 18:26:40', 0, 2050228835);

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
CREATE TABLE IF NOT EXISTS `project` (
  `project_id` int(16) NOT NULL AUTO_INCREMENT,
  `title` text NOT NULL,
  `abstract` text NOT NULL,
  `guide` varchar(64) NOT NULL,
  `group_leader` varchar(32) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`project_id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`project_id`, `title`, `abstract`, `guide`, `group_leader`, `start_date`, `end_date`, `status`) VALUES
(11, 'Library Management System', 'The Library Management System is gaining  more importance as the number of its users are increasing rapidly. As the number is rising there is a need of effective management of library, one such effective system is our Library Management System its designed using VS C++ as front end and SQL 2005 as backend. ', 'vparmar@gmail.com', '180251920016', '2018-07-25', '2018-08-25', 1),
(12, 'Hotel Management System', 'The hotel management project is an excellent software tool for the related industries that can be used in hostels, resorts, lodgings, motels, lodges, hostels, naval pensions, farms, and suites.', '', '180251920011', '2018-07-25', '2018-08-25', 0);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
CREATE TABLE IF NOT EXISTS `status` (
  `timestamp` timestamp NOT NULL,
  `project_id` int(16) NOT NULL,
  `description` text NOT NULL,
  `updated_by` int(16) NOT NULL,
  PRIMARY KEY (`timestamp`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `pnr` varchar(16) NOT NULL,
  `name` varchar(64) NOT NULL,
  `email_id` varchar(64) NOT NULL,
  `department` varchar(16) NOT NULL,
  `contact_no` bigint(20) NOT NULL,
  `project_id` int(16) NOT NULL,
  UNIQUE KEY `pnr` (`pnr`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`pnr`, `name`, `email_id`, `department`, `contact_no`, `project_id`) VALUES
('180259120014', 'Vivek', 'vivek@gmail.com', 'PG-DAC', 9234567890, 12),
('180251920011', 'Priya', 'priya@gmail.com', 'PG-DAC', 8765432190, 12),
('180251920010', 'Sumit', 'sumitgurav@gmail.com', 'PG-DAC', 9876432341, 0),
('180251920016', 'Prachi Bhardwaj', 'prachibhardwaj04@gmail.com', 'PG-DAC', 9012345678, 11);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
