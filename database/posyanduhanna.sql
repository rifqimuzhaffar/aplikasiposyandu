-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 15, 2024 at 04:34 AM
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
('DA001', 'gatau', '0001', '2024-02-15', 'A', 'L', '3,4KG', '33CM'),
('DA002', 'qrqr', '0002', '2024-02-20', 'AB', 'P', '3,1KG', '29CM'),
('DA003', 'gatau', '0003', '2024-02-23', 'A', 'L', '3,6KG', '40CM'),
('DA004', 'saya', '0004', '2024-02-22', 'AB', 'P', '3,5KG', '34CM'),
('DA005', 'dia', '0005', '2024-02-01', 'A', 'L', '3,1KG', '30CM');

-- --------------------------------------------------------

--
-- Table structure for table `tbjadwal`
--

CREATE TABLE `tbjadwal` (
  `id` varchar(50) NOT NULL,
  `tanggal` varchar(50) NOT NULL,
  `tempat` varchar(50) NOT NULL,
  `waktu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbjadwal`
--

INSERT INTO `tbjadwal` (`id`, `tanggal`, `tempat`, `waktu`) VALUES
('JD001', 'Rabu, 21 Februari 2024', 'Sekretariat RW 06', '09.00 - Selesai'),
('JD002', 'Rabu, 28 Februari 2024', 'Posyandu RW 06', '10.00 - Selesai');

-- --------------------------------------------------------

--
-- Table structure for table `tbkondisi`
--

CREATE TABLE `tbkondisi` (
  `id` varchar(99) NOT NULL,
  `idkunjungan` varchar(50) NOT NULL,
  `nama_anak` varchar(99) NOT NULL,
  `usia` varchar(99) NOT NULL,
  `lingkarkepala` varchar(50) NOT NULL,
  `lingkarlengan` varchar(50) NOT NULL,
  `berat` varchar(99) NOT NULL,
  `tinggi` varchar(99) NOT NULL,
  `kondisi` varchar(99) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbkondisi`
--

INSERT INTO `tbkondisi` (`id`, `idkunjungan`, `nama_anak`, `usia`, `lingkarkepala`, `lingkarlengan`, `berat`, `tinggi`, `kondisi`) VALUES
('KA001', 'KJ001', 'gatau', '1 Bulan', '12 CM', '6,4 CM', '3,5 KG', '33 CM', 'Sehat'),
('KA002', 'KJ002', 'qrqr', '2 Bulan', '13 CM', '5,5 CM', '3,4 KG', '34 CM', 'Sakit'),
('KA003', 'KJ003', 'bingung', '10 Bulan', '15 CM', '7,4 CM', '4,3 KG', '50 CM', 'Pelayanan Kesehatan'),
('KA004', 'KJ004', 'saya', '11 Bulan', '12 CM', '6,5 CM', '3,5 KG', '40 CM', 'Sehat'),
('KA005', 'KJ005', 'dia', '12 Bulan', '15 CM', '4,9 CM', '4,0 KG', '44 CM', 'Pelayanan Kesehatan');

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
('2024-02-17', 'KJ001', 'gatau', 'okwdo', 'RT 02'),
('2024-02-20', 'KJ002', 'qrqr', 'dwqdq', 'RT 04'),
('2024-02-09', 'KJ003', 'bingung', 'asfsafa', 'RT 07'),
('2024-02-12', 'KJ004', 'saya', 'baba', 'RT 06'),
('2024-02-12', 'KJ005', 'dia', 'sasa', 'RT 01');

-- --------------------------------------------------------

--
-- Table structure for table `tbpelayanan`
--

CREATE TABLE `tbpelayanan` (
  `id` varchar(99) NOT NULL,
  `nama_anak` varchar(99) NOT NULL,
  `usia` varchar(99) NOT NULL,
  `kondisi` varchar(99) NOT NULL,
  `imunisasi` varchar(99) NOT NULL,
  `vitamin` varchar(99) NOT NULL,
  `catatan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbpelayanan`
--

INSERT INTO `tbpelayanan` (`id`, `nama_anak`, `usia`, `kondisi`, `imunisasi`, `vitamin`, `catatan`) VALUES
('PA001', 'qrqr', '2 Bulan', 'Sakit', 'BCG', 'VITAMIN A', ''),
('PA002', 'bingung', '10 Bulan', 'Pelayanan Kesehatan', 'POLIO', 'SIRUP BESI', ''),
('PA003', 'dia', '12 Bulan', 'Pelayanan Kesehatan', 'POLIO', '-', 'dwadadwadwadwa');

-- --------------------------------------------------------

--
-- Table structure for table `tbpendaftaran`
--

CREATE TABLE `tbpendaftaran` (
  `tgl` date NOT NULL,
  `id` varchar(50) NOT NULL,
  `nama_anak` varchar(50) NOT NULL,
  `nama_orangtua` varchar(50) NOT NULL,
  `alamat` varchar(99) NOT NULL,
  `nohp` varchar(50) NOT NULL,
  `jenis_kb` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbpendaftaran`
--

INSERT INTO `tbpendaftaran` (`tgl`, `id`, `nama_anak`, `nama_orangtua`, `alamat`, `nohp`, `jenis_kb`) VALUES
('2024-02-12', 'PD001', 'gatau', 'iya', 'jalan jalan', '02040214', 'Spiral'),
('2024-02-12', 'PD002', 'qrqr', 'rwafw', 'fwafa', '42141', 'Suntik'),
('2024-02-12', 'PD003', 'bingung', 'sapakek', 'dimana?', '093219039', 'Implan'),
('2024-02-12', 'PD004', 'saya', 'baba', 'jalan jalan', '2131231', 'Suntik'),
('2024-02-12', 'PD005', 'dia', 'sasa', 'jalan jauh', '11111', 'Spiral');

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
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `tbpelayanan`
--
ALTER TABLE `tbpelayanan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbpendaftaran`
--
ALTER TABLE `tbpendaftaran`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
