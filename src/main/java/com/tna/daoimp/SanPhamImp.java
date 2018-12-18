package com.tna.daoimp;

import java.util.List;

import com.tna.entity.SanPham;

public interface SanPhamImp {
	public List<SanPham> layDanhSachSanPhamLimit(int spbatdau);
	
	public SanPham layChiTietSanPhamTheoMa(int maSanPham);
	
	public List<SanPham> laySPTheoDanhMuc(int idDanhMuc);
	
	boolean XoaSpTheoMa(int id);
	
	boolean themSanPham(SanPham sanPham);
}
