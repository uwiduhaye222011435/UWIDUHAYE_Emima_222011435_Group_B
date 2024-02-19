-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 12:37 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `emima_uwiduhaye_oms_b`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `id_number` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `gender` varchar(250) DEFAULT NULL,
  `martial_status` varchar(255) DEFAULT NULL,
  `DoB` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`fname`, `lname`, `id_number`, `phone`, `gender`, `martial_status`, `DoB`, `email`, `password`) VALUES
('WERTYU', 'QWERTY', '23456', '345678', 'Male', 'WERTYUJKL', '2000-09-09', 'SDFGHJ', 'DFGHJK'),
('uwiduhaye', 'emima', '23456', '23456u', 'Female', 'female', '2000-09-07', 'emima1@gmail.com', 'Emima222011435');

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `appointment_id` int(11) NOT NULL,
  `appointmentdate` date DEFAULT NULL,
  `status_` varchar(20) DEFAULT NULL,
  `reason` varchar(18) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`appointment_id`, `appointmentdate`, `status_`, `reason`, `patient_id`, `doctor_id`) VALUES
(1, '2024-12-12', 'male', 'illness', 1, 1),
(2, '2024-12-20', 'female', 'illness', 2, 2),
(3, '2023-04-09', 'RRTYU', 'RTYU', 1, 2),
(4, '2024-07-08', 'wer', 'sick', 1, 2),
(5, '2023-09-07', 'sdfg', 'dfg', 1, 2),
(6, '2000-08-09', 'tyuk', 'ghj', 1, 2),
(7, '2023-09-06', 'wert', 'sdf', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `Doctor_id` int(10) NOT NULL,
  `DoctorName` varchar(90) DEFAULT NULL,
  `Specialty` text DEFAULT NULL,
  `Email` varchar(40) DEFAULT NULL,
  `Phonenumber` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`Doctor_id`, `DoctorName`, `Specialty`, `Email`, `Phonenumber`) VALUES
(1, 'Dr Samuel DUSHIMIMA', 'Eyes', 'samuel@123gmail.com', '0783425765'),
(2, 'Dr Emima UWIDUHAYE', 'Teeth', 'uwiduhaye@2023gmail.com', '0782772897'),
(4, 'FGHJM', 'VBNM', 'VBM,', ' 123'),
(5, 'ASCVBASDV', '\\ASDFG', 'ASDFGB', 'ASDFB'),
(6, 'erty', NULL, 'ert@', '23476'),
(7, 'wer', 'dfgh', 'dfg@', '1234'),
(8, '3ty', 'rtyjkl', 'erty@', '234345'),
(9, 'ertyu', 'tyuiop', 'yuiop', '5678');

-- --------------------------------------------------------

--
-- Table structure for table `insurance`
--

CREATE TABLE `insurance` (
  `insurance_id` int(11) NOT NULL,
  `insurance_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `insurance`
--

INSERT INTO `insurance` (`insurance_id`, `insurance_name`) VALUES
(1, 'RSSB'),
(2, 'RAMA'),
(4, 'ryuu'),
(5, 'muge'),
(6, 'vbnm');

-- --------------------------------------------------------

--
-- Table structure for table `medical_clinic`
--

CREATE TABLE `medical_clinic` (
  `medical_id` int(11) NOT NULL,
  `medical_clinicname` varchar(30) DEFAULT NULL,
  `date_` date DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `medical_clinic`
--

INSERT INTO `medical_clinic` (`medical_id`, `medical_clinicname`, `date_`, `patient_id`) VALUES
(1, 'Medical Victory clinic', '2023-12-13', 1),
(2, 'zirumuze clinic', '2023-12-13', 2),
(3, 'ert', '2000-04-09', 1),
(4, 'sdfghjk', '2000-02-20', 1);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `patient_id` int(10) NOT NULL,
  `patientname` varchar(150) DEFAULT NULL,
  `patientaddress` varchar(20) DEFAULT NULL,
  `phonenumber` varchar(20) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patient_id`, `patientname`, `patientaddress`, `phonenumber`, `email`) VALUES
(1, 'Byiringiro dany', 'Nyamasheke ', '0783002728', 'bringiro@gmail.com'),
(2, 'uwera angel', 'Gasabo', '0787951768', 'uwera@222gmail.com'),
(3, 'erty', 'ertyer', '123', 'dfg@');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `amount` int(10) DEFAULT NULL,
  `paymentdate` date DEFAULT NULL,
  `paymentstatus` varchar(20) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `appointment_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`payment_id`, `amount`, `paymentdate`, `paymentstatus`, `patient_id`, `doctor_id`, `appointment_id`) VALUES
(1, 2500, '2023-12-13', 'male', 1, 1, 1),
(3, 4000, '2023-12-15', 'female', 2, 2, 2),
(4, 0, '2000-09-09', '2000-09-09', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `prescription`
--

CREATE TABLE `prescription` (
  `prescription_id` int(11) NOT NULL,
  `medication_name` varchar(20) DEFAULT NULL,
  `dosage` int(8) DEFAULT NULL,
  `frequency` int(10) DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `Enddate` date DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `appointment_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `prescription`
--

INSERT INTO `prescription` (`prescription_id`, `medication_name`, `dosage`, `frequency`, `startdate`, `Enddate`, `patient_id`, `doctor_id`, `appointment_id`) VALUES
(1, 'amoxy', 2, 3, '2023-12-11', '2023-12-30', 1, 1, 1),
(2, 'Recel', 3, 3, '2023-12-04', '2023-12-31', 2, 2, 2),
(5, 'dfgh', 1, 3, '2009-07-08', '2010-09-09', 1, 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`appointment_id`),
  ADD KEY `patient_id` (`patient_id`),
  ADD KEY `doctor_id` (`doctor_id`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`Doctor_id`);

--
-- Indexes for table `insurance`
--
ALTER TABLE `insurance`
  ADD PRIMARY KEY (`insurance_id`);

--
-- Indexes for table `medical_clinic`
--
ALTER TABLE `medical_clinic`
  ADD PRIMARY KEY (`medical_id`),
  ADD KEY `patient_id` (`patient_id`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patient_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `patient_id` (`patient_id`),
  ADD KEY `doctor_id` (`doctor_id`),
  ADD KEY `appointment_id` (`appointment_id`);

--
-- Indexes for table `prescription`
--
ALTER TABLE `prescription`
  ADD PRIMARY KEY (`prescription_id`),
  ADD KEY `patient_id` (`patient_id`),
  ADD KEY `doctor_id` (`doctor_id`),
  ADD KEY `appointment_id` (`appointment_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `appointment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `Doctor_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `insurance`
--
ALTER TABLE `insurance`
  MODIFY `insurance_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `medical_clinic`
--
ALTER TABLE `medical_clinic`
  MODIFY `medical_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `patient_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `prescription`
--
ALTER TABLE `prescription`
  MODIFY `prescription_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`),
  ADD CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`Doctor_id`);

--
-- Constraints for table `medical_clinic`
--
ALTER TABLE `medical_clinic`
  ADD CONSTRAINT `medical_clinic_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`),
  ADD CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`Doctor_id`),
  ADD CONSTRAINT `payment_ibfk_3` FOREIGN KEY (`appointment_id`) REFERENCES `appointment` (`appointment_id`);

--
-- Constraints for table `prescription`
--
ALTER TABLE `prescription`
  ADD CONSTRAINT `prescription_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`),
  ADD CONSTRAINT `prescription_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`Doctor_id`),
  ADD CONSTRAINT `prescription_ibfk_3` FOREIGN KEY (`appointment_id`) REFERENCES `appointment` (`appointment_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
