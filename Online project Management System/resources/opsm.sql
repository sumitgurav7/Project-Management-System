-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 17, 2018 at 07:42 AM
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
('mukesh.sharma.connnect@gmail.com', 'mukesh sharma', 'admin', 'admin', 12345);

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
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_table`
--

INSERT INTO `login_table` (`username`, `password`, `valid_from`, `valid_upto`, `last_login`) VALUES
('mukesh.sharma.connnect@gmail.com', 'hello', '2018-07-17', '2019-01-17', '2018-07-17 06:02:24'),
('12345', 'hello', '2018-07-17', '2019-01-17', '2018-07-17 06:01:22');

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
  `group_leader` int(16) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
  `pnr` int(16) NOT NULL,
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
(12345, 'mukesh sharma', 'mukesh.sharma.connnect@gmail.com', 'admin', 12345, 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
