-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 20, 2018 lúc 07:28 PM
-- Phiên bản máy phục vụ: 10.1.32-MariaDB
-- Phiên bản PHP: 5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dbminishop`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_hoa_don`
--

CREATE TABLE `chi_tiet_hoa_don` (
  `hoa_don_id` int(11) NOT NULL,
  `chi_tiet_san_pham_id` int(11) NOT NULL,
  `so_luong` int(11) DEFAULT NULL,
  `gia_tien` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_khuyen_mai`
--

CREATE TABLE `chi_tiet_khuyen_mai` (
  `khuyen_mai_id` int(11) NOT NULL,
  `san_pham_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_san_pham`
--

CREATE TABLE `chi_tiet_san_pham` (
  `id` int(11) NOT NULL,
  `san_pham_id` int(11) DEFAULT NULL,
  `size_id` int(11) DEFAULT NULL,
  `mau_id` int(11) DEFAULT NULL,
  `so_luong` int(11) DEFAULT NULL,
  `ngay_nhap` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chuc_vu`
--

CREATE TABLE `chuc_vu` (
  `id` int(11) NOT NULL,
  `ten_chuc_vu` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chuc_vu`
--

INSERT INTO `chuc_vu` (`id`, `ten_chuc_vu`) VALUES
(1, 'admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danh_muc_san_pham`
--

CREATE TABLE `danh_muc_san_pham` (
  `id` int(11) NOT NULL,
  `ten_danh_muc` varchar(100) DEFAULT NULL,
  `hinh_danh_muc` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoa_don`
--

CREATE TABLE `hoa_don` (
  `id` int(11) NOT NULL,
  `ten_khach_hang` varchar(100) DEFAULT NULL,
  `sdt` char(12) DEFAULT NULL,
  `dia_chi_giao_hang` varchar(200) DEFAULT NULL,
  `tinh_trang` bit(1) DEFAULT NULL,
  `ngay_lap` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyen_mai`
--

CREATE TABLE `khuyen_mai` (
  `id` int(11) NOT NULL,
  `ten_khuyen_mai` varchar(200) DEFAULT NULL,
  `thoi_gian_bat_dau` varchar(50) DEFAULT NULL,
  `thoi_gian_ket_thuc` varchar(50) DEFAULT NULL,
  `mo_ta` text,
  `hinh_khuyen_mai` text,
  `gia_giam` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mau_san_pham`
--

CREATE TABLE `mau_san_pham` (
  `id` int(11) NOT NULL,
  `ten_mau` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhan_vien`
--

CREATE TABLE `nhan_vien` (
  `id` int(11) NOT NULL,
  `ho_ten` varchar(50) DEFAULT NULL,
  `dia_chi` varchar(200) DEFAULT NULL,
  `gioi_tinh` bit(1) DEFAULT NULL,
  `cmnd` char(20) DEFAULT NULL,
  `sdt` char(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `chuc_vu_id` int(11) DEFAULT NULL,
  `ten_dang_nhap` varchar(50) DEFAULT NULL,
  `mat_khau` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhan_vien`
--

INSERT INTO `nhan_vien` (`id`, `ho_ten`, `dia_chi`, `gioi_tinh`, `cmnd`, `sdt`, `email`, `chuc_vu_id`, `ten_dang_nhap`, `mat_khau`) VALUES
(1, 'Nguyễn Anh Tú', 'Hà Nội', b'1', NULL, NULL, 'anhtu7696@gmail.com', 1, 'anhtu7696', '123456');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `san_pham`
--

CREATE TABLE `san_pham` (
  `id` int(11) NOT NULL,
  `danh_muc_id` int(11) DEFAULT NULL,
  `ten_san_pham` varchar(100) DEFAULT NULL,
  `gia_tien` varchar(50) DEFAULT NULL,
  `mo_ta` text,
  `hinh_san_pham` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `size_san_pham`
--

CREATE TABLE `size_san_pham` (
  `id` int(11) NOT NULL,
  `size` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chi_tiet_hoa_don`
--
ALTER TABLE `chi_tiet_hoa_don`
  ADD PRIMARY KEY (`hoa_don_id`,`chi_tiet_san_pham_id`),
  ADD KEY `fk_chitiethoadon_chitietsanpham` (`chi_tiet_san_pham_id`);

--
-- Chỉ mục cho bảng `chi_tiet_khuyen_mai`
--
ALTER TABLE `chi_tiet_khuyen_mai`
  ADD PRIMARY KEY (`khuyen_mai_id`,`san_pham_id`),
  ADD KEY `fk_chitietkhuyenmai_sanpham` (`san_pham_id`);

--
-- Chỉ mục cho bảng `chi_tiet_san_pham`
--
ALTER TABLE `chi_tiet_san_pham`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_chitiet_sanpham` (`san_pham_id`),
  ADD KEY `fk_chitiet_size` (`size_id`),
  ADD KEY `fk_chitiet_mau` (`mau_id`);

--
-- Chỉ mục cho bảng `chuc_vu`
--
ALTER TABLE `chuc_vu`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `danh_muc_san_pham`
--
ALTER TABLE `danh_muc_san_pham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `khuyen_mai`
--
ALTER TABLE `khuyen_mai`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `mau_san_pham`
--
ALTER TABLE `mau_san_pham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_nhanvien_chucvu` (`chuc_vu_id`);

--
-- Chỉ mục cho bảng `san_pham`
--
ALTER TABLE `san_pham`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_sanpham_danhmuc` (`danh_muc_id`);

--
-- Chỉ mục cho bảng `size_san_pham`
--
ALTER TABLE `size_san_pham`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chi_tiet_san_pham`
--
ALTER TABLE `chi_tiet_san_pham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `chuc_vu`
--
ALTER TABLE `chuc_vu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `danh_muc_san_pham`
--
ALTER TABLE `danh_muc_san_pham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `hoa_don`
--
ALTER TABLE `hoa_don`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `khuyen_mai`
--
ALTER TABLE `khuyen_mai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `mau_san_pham`
--
ALTER TABLE `mau_san_pham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `nhan_vien`
--
ALTER TABLE `nhan_vien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `san_pham`
--
ALTER TABLE `san_pham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `size_san_pham`
--
ALTER TABLE `size_san_pham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chi_tiet_hoa_don`
--
ALTER TABLE `chi_tiet_hoa_don`
  ADD CONSTRAINT `fk_chitiethoadon_chitietsanpham` FOREIGN KEY (`chi_tiet_san_pham_id`) REFERENCES `chi_tiet_san_pham` (`id`),
  ADD CONSTRAINT `fk_chitiethoadon_hoadon` FOREIGN KEY (`hoa_don_id`) REFERENCES `hoa_don` (`id`);

--
-- Các ràng buộc cho bảng `chi_tiet_khuyen_mai`
--
ALTER TABLE `chi_tiet_khuyen_mai`
  ADD CONSTRAINT `fk_chitietkhuyenmai_khuyenmai` FOREIGN KEY (`khuyen_mai_id`) REFERENCES `khuyen_mai` (`id`),
  ADD CONSTRAINT `fk_chitietkhuyenmai_sanpham` FOREIGN KEY (`san_pham_id`) REFERENCES `san_pham` (`id`);

--
-- Các ràng buộc cho bảng `chi_tiet_san_pham`
--
ALTER TABLE `chi_tiet_san_pham`
  ADD CONSTRAINT `fk_chitiet_mau` FOREIGN KEY (`mau_id`) REFERENCES `mau_san_pham` (`id`),
  ADD CONSTRAINT `fk_chitiet_sanpham` FOREIGN KEY (`san_pham_id`) REFERENCES `san_pham` (`id`),
  ADD CONSTRAINT `fk_chitiet_size` FOREIGN KEY (`size_id`) REFERENCES `size_san_pham` (`id`);

--
-- Các ràng buộc cho bảng `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD CONSTRAINT `fk_nhanvien_chucvu` FOREIGN KEY (`chuc_vu_id`) REFERENCES `chuc_vu` (`id`);

--
-- Các ràng buộc cho bảng `san_pham`
--
ALTER TABLE `san_pham`
  ADD CONSTRAINT `fk_sanpham_danhmuc` FOREIGN KEY (`danh_muc_id`) REFERENCES `danh_muc_san_pham` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
