-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2020 at 07:30 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cwoop_2019`
--

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `PlateNo` varchar(100) NOT NULL,
  `Make` varchar(250) DEFAULT NULL,
  `EngineCapacity` int(11) DEFAULT NULL,
  `SeatCapacity` int(11) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `TopSpeed` int(11) DEFAULT NULL,
  `FuelCapacity` int(11) DEFAULT NULL,
  `noOFDoors` int(11) DEFAULT NULL,
  `isWagon` tinyint(1) DEFAULT NULL,
  `isAirConditioned` tinyint(1) DEFAULT NULL,
  `carID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`PlateNo`, `Make`, `EngineCapacity`, `SeatCapacity`, `Price`, `TopSpeed`, `FuelCapacity`, `noOFDoors`, `isWagon`, `isAirConditioned`, `carID`) VALUES
('P0001', 'Toyota', 2000, 5, 5000, 150, 70, 5, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` varchar(50) NOT NULL,
  `UserName` varchar(100) DEFAULT NULL,
  `Password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `UserName`, `Password`) VALUES
('C0001', 'Pasindu', 'pasindu123'),
('C0002', 'Shenal', 'shenal123');

-- --------------------------------------------------------

--
-- Table structure for table `motorbike`
--

CREATE TABLE `motorbike` (
  `PlateNo` varchar(100) NOT NULL,
  `Make` varchar(250) DEFAULT NULL,
  `EngineCapacity` int(11) DEFAULT NULL,
  `SeatCapacity` int(11) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `TopSpeed` int(11) DEFAULT NULL,
  `FuelCapacity` int(11) DEFAULT NULL,
  `noofHelmets` int(11) DEFAULT NULL,
  `bikeID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `motorbike`
--

INSERT INTO `motorbike` (`PlateNo`, `Make`, `EngineCapacity`, `SeatCapacity`, `Price`, `TopSpeed`, `FuelCapacity`, `noofHelmets`, `bikeID`) VALUES
('B0001', 'Yamaha', 200, 2, 500, 120, 20, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `shedule`
--

CREATE TABLE `shedule` (
  `CustomerID` varchar(50) NOT NULL,
  `CarPlateNo` varchar(100) NOT NULL,
  `BikePlateNo` varchar(100) NOT NULL,
  `Pickupdate` date DEFAULT NULL,
  `DropofDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shedule`
--

INSERT INTO `shedule` (`CustomerID`, `CarPlateNo`, `BikePlateNo`, `Pickupdate`, `DropofDate`) VALUES
('C0001', 'P0001', '', '2020-01-20', '2020-01-22');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`PlateNo`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `motorbike`
--
ALTER TABLE `motorbike`
  ADD PRIMARY KEY (`PlateNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
