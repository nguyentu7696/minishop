package com.tna.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.tna.daoimp.MauSanPhamImp;
import com.tna.entity.MauSanPham;
import com.tna.entity.SizeSanPham;

@Repository
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS)
public class MauSanPhamDAO implements MauSanPhamImp{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<MauSanPham> layDsMau() {
		Session session = sessionFactory.getCurrentSession();
		String query = "from MauSanPham";
		List<MauSanPham> mauSanPhams = (List<MauSanPham>) session.createQuery(query).getResultList();
		return mauSanPhams;
	}
	
}
