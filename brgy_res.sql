-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2023 at 01:00 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `brgy_resident`
--

-- --------------------------------------------------------

--
-- Table structure for table `puroks_tbl`
--

CREATE TABLE `puroks_tbl` (
  `purok_id` int(10) NOT NULL,
  `res_id` int(10) NOT NULL,
  `purok_name` varchar(100) NOT NULL,
  `purok_desc` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `puroks_tbl`
--

INSERT INTO `puroks_tbl` (`purok_id`, `res_id`, `purok_name`, `purok_desc`) VALUES
(3, 3, 'Tangigue', 'Near BRC Building '),
(4, 4, 'Bolinao', 'Near Chapel');

-- --------------------------------------------------------

--
-- Table structure for table `reports_tbl`
--

CREATE TABLE `reports_tbl` (
  `report_id` int(10) NOT NULL,
  `res_id` int(10) NOT NULL,
  `purok_id` int(10) NOT NULL,
  `report_date` varchar(1000) NOT NULL,
  `report_desc` varchar(100) NOT NULL,
  `report_status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reports_tbl`
--

INSERT INTO `reports_tbl` (`report_id`, `res_id`, `purok_id`, `report_date`, `report_desc`, `report_status`) VALUES
(9, 3, 3, 'asd', 'asdasd', 'Not Actioned');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_residents`
--

CREATE TABLE `tbl_residents` (
  `res_id` int(10) NOT NULL,
  `res_lname` varchar(50) NOT NULL,
  `res_fname` varchar(50) NOT NULL,
  `res_bdate` varchar(50) NOT NULL,
  `res_gender` varchar(50) NOT NULL,
  `res_status` varchar(50) NOT NULL,
  `res_child` varchar(50) NOT NULL,
  `res_contact` varchar(50) NOT NULL,
  `res_email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_residents`
--

INSERT INTO `tbl_residents` (`res_id`, `res_lname`, `res_fname`, `res_bdate`, `res_gender`, `res_status`, `res_child`, `res_contact`, `res_email`) VALUES
(3, 'Aniñon', 'Mark Eliezon', '12/12/2000', 'Male', 'Single', '0923423422', 'none', 'eliezon@gmail.com'),
(4, 'Cano', 'John Paul', '09/23/2001', 'Male', 'Engaged', '0923405622', 'none', 'jpcano@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `users_tbl`
--

CREATE TABLE `users_tbl` (
  `u_id` int(11) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_bdate` varchar(50) NOT NULL,
  `u_user` varchar(50) NOT NULL,
  `u_pword` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users_tbl`
--

INSERT INTO `users_tbl` (`u_id`, `u_lname`, `u_fname`, `u_bdate`, `u_user`, `u_pword`, `u_email`) VALUES
(1, 'Aniñon', 'mark', '12/12/2000', 'mark123', '123123', 'eliezon@gmail.com'),
(2, 'adas', 'asd', 'asda', 'dasd', 'sdas', 'asdasd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `puroks_tbl`
--
ALTER TABLE `puroks_tbl`
  ADD PRIMARY KEY (`purok_id`),
  ADD KEY `res_id` (`res_id`);

--
-- Indexes for table `reports_tbl`
--
ALTER TABLE `reports_tbl`
  ADD PRIMARY KEY (`report_id`),
  ADD KEY `res_id` (`res_id`),
  ADD KEY `purok_id` (`purok_id`);

--
-- Indexes for table `tbl_residents`
--
ALTER TABLE `tbl_residents`
  ADD PRIMARY KEY (`res_id`);

--
-- Indexes for table `users_tbl`
--
ALTER TABLE `users_tbl`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `puroks_tbl`
--
ALTER TABLE `puroks_tbl`
  MODIFY `purok_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `reports_tbl`
--
ALTER TABLE `reports_tbl`
  MODIFY `report_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tbl_residents`
--
ALTER TABLE `tbl_residents`
  MODIFY `res_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `users_tbl`
--
ALTER TABLE `users_tbl`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `puroks_tbl`
--
ALTER TABLE `puroks_tbl`
  ADD CONSTRAINT `puroks_tbl_ibfk_1` FOREIGN KEY (`res_id`) REFERENCES `tbl_residents` (`res_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reports_tbl`
--
ALTER TABLE `reports_tbl`
  ADD CONSTRAINT `reports_tbl_ibfk_1` FOREIGN KEY (`res_id`) REFERENCES `tbl_residents` (`res_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reports_tbl_ibfk_2` FOREIGN KEY (`purok_id`) REFERENCES `puroks_tbl` (`purok_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
