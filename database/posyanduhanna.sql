-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 08, 2024 at 12:52 PM
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
  `tempatlahir` varchar(50) NOT NULL,
  `tanggallahir` date NOT NULL,
  `golongandarah` varchar(50) NOT NULL,
  `kelamin` varchar(50) NOT NULL,
  `berat` varchar(50) NOT NULL,
  `tinggi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbdataanak`
--

INSERT INTO `tbdataanak` (`id`, `nama_anak`, `tempatlahir`, `tanggallahir`, `golongandarah`, `kelamin`, `berat`, `tinggi`) VALUES
('DA001', 'rifqi', 'jakarta', '2024-02-26', 'AB', 'L', '11KG', '111CM');

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
  `nama_anak` varchar(99) NOT NULL,
  `usia` varchar(99) NOT NULL,
  `berat` varchar(99) NOT NULL,
  `tinggi` varchar(99) NOT NULL,
  `kondisi` varchar(99) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbkondisi`
--

INSERT INTO `tbkondisi` (`id`, `nama_anak`, `usia`, `berat`, `tinggi`, `kondisi`) VALUES
('KA001', 'rifqi', '21 Bulan', '123 KG', '123 CM', 'Sehat');

-- --------------------------------------------------------

--
-- Table structure for table `tbkunjungan`
--

CREATE TABLE `tbkunjungan` (
  `tgl` date NOT NULL,
  `id` varchar(50) NOT NULL,
  `nama_anak` varchar(99) NOT NULL,
  `nama_orangtua` varchar(50) NOT NULL,
  `rt` varchar(50) NOT NULL,
  `jenis_kb` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbkunjungan`
--

INSERT INTO `tbkunjungan` (`tgl`, `id`, `nama_anak`, `nama_orangtua`, `rt`, `jenis_kb`) VALUES
('2024-02-13', 'KJ001', 'rifqi', 'fwafdwqd', 'RT 02', 'Suntik');

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
('PA001', 'rifqi', '21 Bulan', 'Sehat', 'Imunisasi B', 'Vitamin A', 'vitamin kurang');

-- --------------------------------------------------------

--
-- Table structure for table `tbpendaftaran`
--

CREATE TABLE `tbpendaftaran` (
  `tgl` date NOT NULL,
  `id` varchar(50) NOT NULL,
  `nama_anak` varchar(50) NOT NULL,
  `nama_wali` varchar(50) NOT NULL,
  `alamat` varchar(99) NOT NULL,
  `nohp` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbpendaftaran`
--

INSERT INTO `tbpendaftaran` (`tgl`, `id`, `nama_anak`, `nama_wali`, `alamat`, `nohp`) VALUES
('2024-02-03', 'PD002', 'rifqi', 'aaaa', 'fawfa', '088238131'),
('2024-02-03', 'PD003', 'dawda', 'dwqdq', 'dwqdq', '21414'),
('2024-02-03', 'PD004', 'fwq', 'fwqfq', 'fqwf', '918492841');

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
('admin', 'admin', 'admin123', 'admin123'),
('rifqi', 'rifqi', 'sekolah251', 'sekolah251'),
('saya', 'saya', 'saya123', 'saya123'),
('saya2', 'saya2', 'saya123', 'saya123'),
('fwafa', 'fwa', '123', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbdataanak`
--
ALTER TABLE `tbdataanak`
  ADD PRIMARY KEY (`id`);

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
