package com.tna.daoimp;

import java.util.List;

import com.tna.entity.SanPham;

public interface SanPhamImp {
	public List<SanPham> layDanhSachSanPhamLimit(int spbatdau);
	
	public SanPham layChiTietSanPhamTheoMa(int maSanPham);
}
