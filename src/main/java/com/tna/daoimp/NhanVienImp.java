package com.tna.daoimp;

import com.tna.entity.NhanVien;

public interface NhanVienImp {
	boolean kiemTraDangNhap(String email, String matkhau);
	boolean themNhanVien(NhanVien nhanVien);
}
