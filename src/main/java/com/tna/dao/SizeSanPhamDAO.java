package com.tna.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tna.daoimp.SizeSanPhamImp;
import com.tna.entity.SanPham;
import com.tna.entity.SizeSanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SizeSanPhamDAO implements SizeSanPhamImp{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<SizeSanPham> layDsSize() {
		Session session = sessionFactory.getCurrentSession();
		String query = "from SizeSanPham";
		List<SizeSanPham> sanPhams = (List<SizeSanPham>) session.createQuery(query).getResultList();
		return sanPhams;
	}
}
