package com.tna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tna.dao.DanhMucDAO;
import com.tna.daoimp.DanhMucImp;
import com.tna.entity.DanhMucSanPham;

@Service
public class DanhMucService implements DanhMucImp{

	@Autowired
	private DanhMucDAO danhMucDAO;
	
	public List<DanhMucSanPham> layDanhMuc() {
		return danhMucDAO.layDanhMuc();
	}

}
