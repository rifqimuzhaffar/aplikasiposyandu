-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 07, 2024 at 11:45 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `posyanduhanna`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbbidan`
--

CREATE TABLE `tbbidan` (
  `id` varchar(50) NOT NULL,
  `nik_bidan` varchar(50) NOT NULL,
  `nama_bidan` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `telp` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbbidan`
--

INSERT INTO `tbbidan` (`id`, `nik_bidan`, `nama_bidan`, `alamat`, `telp`) VALUES
('BD001', '123', 'dwqqw', 'dqwdq', '2314414'),
('BD002', '1234', '2rqwrqwr', 'qrqrq', '214141');

-- --------------------------------------------------------

--
-- Table structure for table `tbdataanak`
--

CREATE TABLE `tbdataanak` (
  `id` varchar(50) NOT NULL,
  `nama_anak` varchar(50) NOT NULL,
  `nik` varchar(50) NOT NULL,
  `tanggallahir` date NOT NULL,
  `golongandarah` varchar(50) NOT NULL,
  `kelamin` varchar(50) NOT NULL,
  `berat` varchar(50) NOT NULL,
  `tinggi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbdataanak`
--

INSERT INTO `tbdataanak` (`id`, `nama_anak`, `nik`, `tanggallahir`, `golongandarah`, `kelamin`, `berat`, `tinggi`) VALUES
('DA001', 'fawa', '123', '2024-03-07', 'AB', 'Perempuan', '11KG', '44CM'),
('DA002', 'dwqdwqp', '124', '2024-03-01', 'B', 'Laki-Laki', '22KG', '113CM');

-- --------------------------------------------------------

--
-- Table structure for table `tbjadwal`
--

CREATE TABLE `tbjadwal` (
  `id` varchar(50) NOT NULL,
  `bidan` varchar(50) NOT NULL,
  `nik_bidan` varchar(50) NOT NULL,
  `tanggal` varchar(50) NOT NULL,
  `waktu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbjadwal`
--

INSERT INTO `tbjadwal` (`id`, `bidan`, `nik_bidan`, `tanggal`, `waktu`) VALUES
('JD001', '2rqwrqwr', '1234', 'Kamis, 14 Mar 2024', 'ffff'),
('JD002', 'dwqqw', '123', 'Jumat, 15 Maret 2024', 'fwfq');

-- --------------------------------------------------------

--
-- Table structure for table `tbkondisi`
--

CREATE TABLE `tbkondisi` (
  `id` varchar(50) NOT NULL,
  `idkunjungan` varchar(50) NOT NULL,
  `nama_anak` varchar(50) NOT NULL,
  `nama_bidan` varchar(50) NOT NULL,
  `usia` varchar(50) NOT NULL,
  `lingkarkepala` varchar(50) NOT NULL,
  `lingkarlengan` varchar(50) NOT NULL,
  `berat` varchar(50) NOT NULL,
  `tinggi` varchar(50) NOT NULL,
  `kondisi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbkondisi`
--

INSERT INTO `tbkondisi` (`id`, `idkunjungan`, `nama_anak`, `nama_bidan`, `usia`, `lingkarkepala`, `lingkarlengan`, `berat`, `tinggi`, `kondisi`) VALUES
('KA001', 'KJ001', 'fawa', '2rqwrqwr', '12 Bulan', '22 CM', '21 CM', '14 KG', '41 CM', 'wqdqwdqw'),
('KA002', 'KJ002', 'dwqdwq', 'dwqqw', '22 Bulan', '421 CM', '24141 CM', '1421 KG', '4214 CM', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbkunjungan`
--

CREATE TABLE `tbkunjungan` (
  `tgl` date NOT NULL,
  `id` varchar(50) NOT NULL,
  `nama_anak` varchar(99) NOT NULL,
  `nama_orangtua` varchar(50) NOT NULL,
  `rt` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbkunjungan`
--

INSERT INTO `tbkunjungan` (`tgl`, `id`, `nama_anak`, `nama_orangtua`, `rt`) VALUES
('2024-03-14', 'KJ001', 'fawa', 'khkhnk', 'RT 23'),
('2024-03-28', 'KJ002', 'dwqdwq', 'fffffffffff', 'RT 22');

-- --------------------------------------------------------

--
-- Table structure for table `tbpendaftaran`
--

CREATE TABLE `tbpendaftaran` (
  `tgl` date NOT NULL,
  `id` varchar(50) NOT NULL,
  `nik_anak` varchar(50) NOT NULL,
  `nama_anak` varchar(50) NOT NULL,
  `usia` varchar(50) NOT NULL,
  `imunisasi` varchar(50) NOT NULL,
  `vitamin` varchar(50) NOT NULL,
  `nama_orangtua` varchar(50) NOT NULL,
  `nohp` varchar(50) NOT NULL,
  `jenis_kb` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbpendaftaran`
--

INSERT INTO `tbpendaftaran` (`tgl`, `id`, `nik_anak`, `nama_anak`, `usia`, `imunisasi`, `vitamin`, `nama_orangtua`, `nohp`, `jenis_kb`) VALUES
('2024-03-07', 'PD001', '123', 'fawa', '13 Bulan', 'DPT', 'VITAMIN A', 'gatau', '533432523', 'Suntik'),
('2024-03-07', 'PD002', '124', 'dwqdwqp', '12 Bulan', 'POLIO', 'ORALIT BLN', 'jawa', '21412151', 'Implan');

-- --------------------------------------------------------

--
-- Table structure for table `tbuser`
--

CREATE TABLE `tbuser` (
  `nama` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `repassword` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbuser`
--

INSERT INTO `tbuser` (`nama`, `username`, `password`, `repassword`) VALUES
('admin', 'admin', 'admin123', 'admin123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbbidan`
--
ALTER TABLE `tbbidan`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nik_bidan` (`nik_bidan`);

--
-- Indexes for table `tbdataanak`
--
ALTER TABLE `tbdataanak`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `NIK` (`nik`),
  ADD UNIQUE KEY `nik_2` (`nik`);

--
-- Indexes for table `tbjadwal`
--
ALTER TABLE `tbjadwal`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nik_bidan` (`nik_bidan`);

--
-- Indexes for table `tbkondisi`
--
ALTER TABLE `tbkondisi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbkunjungan`
--
ALTER TABLE `tbkunjungan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbpendaftaran`
--
ALTER TABLE `tbpendaftaran`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nik_anak` (`nik_anak`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
