package com.tna.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tna.daoimp.SanPhamImp;
import com.tna.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamImp {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<SanPham> layDanhSachSanPhamLimit(int spbatdau) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> listSanPham = (List<SanPham>) session.createQuery("from SanPham")
				.setFirstResult(spbatdau)
				.setMaxResults(20)
				.getResultList();

		return listSanPham;
	}
	
	@Transactional
	public SanPham layChiTietSanPhamTheoMa(int maSanPham){
		Session session = sessionFactory.getCurrentSession();
		String query = "from SanPham sp where sp.id = " + maSanPham;
		SanPham sanPham = (SanPham) session.createQuery(query).getSingleResult();
		return sanPham;
	}
}
