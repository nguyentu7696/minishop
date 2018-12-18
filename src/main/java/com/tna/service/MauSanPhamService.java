package com.tna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tna.dao.MauSanPhamDAO;
import com.tna.daoimp.MauSanPhamImp;
import com.tna.entity.MauSanPham;

@Service
public class MauSanPhamService implements MauSanPhamImp{

	@Autowired
	MauSanPhamDAO mauSanPhamDAO;
	
	@Override
	public List<MauSanPham> layDsMau() {
		
		return mauSanPhamDAO.layDsMau();
	}

}
