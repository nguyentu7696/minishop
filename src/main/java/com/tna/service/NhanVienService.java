package com.tna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tna.dao.NhanVienDAO;
import com.tna.daoimp.NhanVienImp;
import com.tna.entity.NhanVien;

@Service
public class NhanVienService implements NhanVienImp{

	@Autowired
	NhanVienDAO nhanVienDAO;

	public boolean kiemTraDangNhap(String email, String matkhau) {
		boolean kiemtra = nhanVienDAO.kiemTraDangNhap(email, matkhau);
		return kiemtra;
	}

	public boolean themNhanVien(NhanVien nhanVien) {
		boolean ktThem = nhanVienDAO.themNhanVien(nhanVien);
		return ktThem;
	}
	
	
}
