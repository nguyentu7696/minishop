package com.tna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tna.dao.SanPhamDAO;
import com.tna.daoimp.SanPhamImp;
import com.tna.entity.SanPham;

@Service
public class SanPhamService implements SanPhamImp{

	@Autowired
	SanPhamDAO sanPhamDAO;
	
	public List<SanPham> layDanhSachSanPhamLimit(int spbatdau) {
		
		return sanPhamDAO.layDanhSachSanPhamLimit(spbatdau);
	}

	public SanPham layChiTietSanPhamTheoMa(int maSanPham) {
		
		return sanPhamDAO.layChiTietSanPhamTheoMa(maSanPham);
	}

}
