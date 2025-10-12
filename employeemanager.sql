-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 12, 2025 at 12:21 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employeemanager`
--

-- --------------------------------------------------------

--
-- Table structure for table `chamcong`
--

CREATE TABLE `chamcong` (
  `maChamCong` int(11) NOT NULL,
  `maNhanVien` int(11) NOT NULL,
  `ngayChamCong` date NOT NULL,
  `thoiGianVao` time NOT NULL,
  `thoiGianRa` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chucvu`
--

CREATE TABLE `chucvu` (
  `maChucVu` int(11) NOT NULL,
  `tenChucVu` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chucvu`
--

INSERT INTO `chucvu` (`maChucVu`, `tenChucVu`) VALUES
(1, 'Employee'),
(2, 'Leader'),
(3, 'Boss'),
(4, 'CEO'),
(5, 'CFO'),
(6, 'HR');

-- --------------------------------------------------------

--
-- Table structure for table `hopdong`
--

CREATE TABLE `hopdong` (
  `maHopDong` int(11) NOT NULL,
  `maNhanVien` int(11) DEFAULT NULL,
  `ngayBatDau` int(11) NOT NULL,
  `ngayKetThuc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `luong`
--

CREATE TABLE `luong` (
  `maLuong` int(11) NOT NULL,
  `maNhanVien` int(11) DEFAULT NULL,
  `luongCoBan` int(11) NOT NULL,
  `soGioCoBan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nghiphep`
--

CREATE TABLE `nghiphep` (
  `maDonNghiPhep` int(11) NOT NULL,
  `maNhanVien` int(11) NOT NULL,
  `ngayBatDau` date NOT NULL,
  `ngayKetThuc` date NOT NULL,
  `lyDo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `maNhanVien` int(11) NOT NULL,
  `hoTen` varchar(50) NOT NULL,
  `ngaySinh` date NOT NULL,
  `gioiTinh` varchar(1) NOT NULL,
  `diaChi` varchar(50) NOT NULL,
  `soDienThoai` varchar(10) NOT NULL,
  `maPhongBan` int(11) DEFAULT NULL,
  `maChucVu` int(11) DEFAULT NULL,
  `trangThai` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`maNhanVien`, `hoTen`, `ngaySinh`, `gioiTinh`, `diaChi`, `soDienThoai`, `maPhongBan`, `maChucVu`, `trangThai`) VALUES
(3, 'dsadadsadsa', '2001-10-17', 'M', 'dadadsad', '0123456678', 7, 3, 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `phongban`
--

CREATE TABLE `phongban` (
  `maPhongBan` int(11) NOT NULL,
  `tenPhongBan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phongban`
--

INSERT INTO `phongban` (`maPhongBan`, `tenPhongBan`) VALUES
(6, 'IT'),
(7, 'Maketing'),
(8, 'Boss'),
(9, 'sdsadad');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `maNhanVien` int(11) NOT NULL,
  `taiKhoan` int(20) NOT NULL,
  `matKhau` int(20) NOT NULL,
  `phanQuyen` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tangca`
--

CREATE TABLE `tangca` (
  `maTangCa` int(11) NOT NULL,
  `maNhanVien` int(11) NOT NULL,
  `ngayTangCa` date NOT NULL,
  `soGioTangCa` int(11) NOT NULL,
  `luongTangCa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chamcong`
--
ALTER TABLE `chamcong`
  ADD PRIMARY KEY (`maChamCong`),
  ADD KEY `maNhanVien` (`maNhanVien`);

--
-- Indexes for table `chucvu`
--
ALTER TABLE `chucvu`
  ADD PRIMARY KEY (`maChucVu`);

--
-- Indexes for table `hopdong`
--
ALTER TABLE `hopdong`
  ADD PRIMARY KEY (`maHopDong`),
  ADD KEY `maNhanVien` (`maNhanVien`);

--
-- Indexes for table `luong`
--
ALTER TABLE `luong`
  ADD PRIMARY KEY (`maLuong`),
  ADD KEY `maNhanVien` (`maNhanVien`);

--
-- Indexes for table `nghiphep`
--
ALTER TABLE `nghiphep`
  ADD PRIMARY KEY (`maDonNghiPhep`),
  ADD KEY `maNhanVien` (`maNhanVien`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`maNhanVien`),
  ADD KEY `maPhongBan` (`maPhongBan`),
  ADD KEY `maChucVu` (`maChucVu`);

--
-- Indexes for table `phongban`
--
ALTER TABLE `phongban`
  ADD PRIMARY KEY (`maPhongBan`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD KEY `maNhanVien` (`maNhanVien`);

--
-- Indexes for table `tangca`
--
ALTER TABLE `tangca`
  ADD PRIMARY KEY (`maTangCa`),
  ADD KEY `maNhanVien` (`maNhanVien`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chamcong`
--
ALTER TABLE `chamcong`
  MODIFY `maChamCong` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `chucvu`
--
ALTER TABLE `chucvu`
  MODIFY `maChucVu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `hopdong`
--
ALTER TABLE `hopdong`
  MODIFY `maHopDong` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `luong`
--
ALTER TABLE `luong`
  MODIFY `maLuong` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nghiphep`
--
ALTER TABLE `nghiphep`
  MODIFY `maDonNghiPhep` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `maNhanVien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `phongban`
--
ALTER TABLE `phongban`
  MODIFY `maPhongBan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tangca`
--
ALTER TABLE `tangca`
  MODIFY `maTangCa` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chamcong`
--
ALTER TABLE `chamcong`
  ADD CONSTRAINT `chamcong_ibfk_1` FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`);

--
-- Constraints for table `hopdong`
--
ALTER TABLE `hopdong`
  ADD CONSTRAINT `hopdong_ibfk_1` FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`);

--
-- Constraints for table `luong`
--
ALTER TABLE `luong`
  ADD CONSTRAINT `luong_ibfk_1` FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`);

--
-- Constraints for table `nghiphep`
--
ALTER TABLE `nghiphep`
  ADD CONSTRAINT `nghiphep_ibfk_1` FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`);

--
-- Constraints for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`maPhongBan`) REFERENCES `phongban` (`maPhongBan`),
  ADD CONSTRAINT `nhanvien_ibfk_2` FOREIGN KEY (`maChucVu`) REFERENCES `chucvu` (`maChucVu`);

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`);

--
-- Constraints for table `tangca`
--
ALTER TABLE `tangca`
  ADD CONSTRAINT `tangca_ibfk_1` FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
