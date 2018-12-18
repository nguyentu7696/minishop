package com.tna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tna.dao.SizeSanPhamDAO;
import com.tna.daoimp.SizeSanPhamImp;
import com.tna.entity.SizeSanPham;

@Service
public class SizeSanPhamService implements SizeSanPhamImp{

	@Autowired
	SizeSanPhamDAO sizeSanPhamDAO;
	
	@Override
	public List<SizeSanPham> layDsSize() {
		
		return sizeSanPhamDAO.layDsSize();
	}

}
