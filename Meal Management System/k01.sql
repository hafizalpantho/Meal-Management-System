-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 17, 2019 at 03:19 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `k01`
--

-- --------------------------------------------------------

--
-- Table structure for table `allmember`
--

CREATE TABLE `allmember` (
  `memId` varchar(10) NOT NULL,
  `totalMeal` double NOT NULL,
  `month` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `allmember`
--

INSERT INTO `allmember` (`memId`, `totalMeal`, `month`) VALUES
('a01', 55, 'Jan'),
('m01', 50, 'Jan'),
('p01', 60, 'Jan'),
('t01', 50, 'Jan');

-- --------------------------------------------------------

--
-- Table structure for table `bazar`
--

CREATE TABLE `bazar` (
  `bName` varchar(20) NOT NULL,
  `amountOfBazar` int(5) NOT NULL,
  `bId` varchar(10) DEFAULT NULL,
  `date` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bazar`
--

INSERT INTO `bazar` (`bName`, `amountOfBazar`, `bId`, `date`) VALUES
('Pantho', 265, 'p01', '1'),
('Akash', 250, 'a01', '2'),
('Tonmoy', 300, 't01', '3'),
('Mim', 120, 'm01', '4'),
('Pantho', 400, 'p01', '5'),
('Akash', 100, 'a01', '6'),
('Tonmoy', 405, 't01', '7'),
('Mim', 50, 'm01', '8'),
('Pantho', 660, 'p01', '9'),
('Akash', 136, 'a01', '10'),
('Tonmoy', 340, 't01', '11'),
('Mim', 300, 'm01', '12'),
('Pantho', 440, 'p01', '13'),
('Akash', 222, 'a01', '14'),
('Tonmoy', 555, 't01', '15'),
('Mim', 110, 'm01', '16'),
('Pantho', 223, 'p01', '17'),
('Akash', 212, 'a01', '18'),
('Tonmoy', 121, 't01', '19'),
('Mim', 111, 'm01', '20'),
('Pantho', 199, 'p01', '21'),
('Akash', 542, 'a01', '22'),
('Tonmoy', 113, 't01', '23'),
('Mim', 15, 'm01', '24'),
('Pantho', 1000, 'p01', '25'),
('', 0, '', '26'),
('', 0, NULL, '27'),
('', 0, NULL, '28'),
('', 0, NULL, '29'),
('', 0, NULL, '30'),
('', 0, NULL, '31');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userid` varchar(8) NOT NULL,
  `password` varchar(10) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userid`, `password`, `status`) VALUES
('a01', '4321', 1),
('m01', '98765', 1),
('p01', '1234', 0),
('p02', '10387644', 1),
('t01', '65432', 0),
('t02', '18862809', 0);

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `manId` varchar(8) NOT NULL,
  `mName` varchar(20) NOT NULL,
  `designation` varchar(15) NOT NULL,
  `totalAmmount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`manId`, `mName`, `designation`, `totalAmmount`) VALUES
('a01', 'Akash', 'Member', 2500),
('m01', 'Mim', 'Member', 2650),
('p01', 'Pantho', 'Manager', 2800),
('p02', 'Rakib', 'Member', 500),
('t01', 'Tonmoy', 'Manager', 2200),
('t02', 'Rafi', 'Manager', 1000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `allmember`
--
ALTER TABLE `allmember`
  ADD UNIQUE KEY `memId` (`memId`);

--
-- Indexes for table `bazar`
--
ALTER TABLE `bazar`
  ADD UNIQUE KEY `date` (`date`),
  ADD KEY `date_2` (`date`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userid`,`password`,`status`),
  ADD UNIQUE KEY `userid` (`userid`),
  ADD UNIQUE KEY `password` (`password`),
  ADD UNIQUE KEY `userid_3` (`userid`,`password`,`status`),
  ADD KEY `status` (`status`),
  ADD KEY `userid_2` (`userid`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD UNIQUE KEY `memId` (`manId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
