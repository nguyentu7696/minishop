package com.tna.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tna.daoimp.DanhMucImp;
import com.tna.entity.DanhMucSanPham;
import com.tna.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDAO implements DanhMucImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<DanhMucSanPham> layDanhMuc() {
		Session session = sessionFactory.getCurrentSession();
		String query = "from DanhMucSanPham";
		List<DanhMucSanPham> danhMucSanPhams = session.createQuery(query).getResultList();
		return danhMucSanPhams;
	}

}
