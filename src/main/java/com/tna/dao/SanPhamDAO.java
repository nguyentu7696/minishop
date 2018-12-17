package com.tna.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tna.daoimp.SanPhamImp;
import com.tna.entity.ChiTietSanPham;
import com.tna.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamImp {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<SanPham> layDanhSachSanPhamLimit(int spbatdau) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> listSanPham = new ArrayList<SanPham>();
		if(spbatdau < 0) {
			String query = "from SanPham";
			listSanPham = (List<SanPham>) session.createQuery(query).getResultList();;
		}else {
			listSanPham = (List<SanPham>) session.createQuery("from SanPham")
					.setFirstResult(spbatdau)
					.setMaxResults(5)
					.getResultList();
		}
		return listSanPham;
	}
	
	@Override
	@Transactional
	public SanPham layChiTietSanPhamTheoMa(int maSanPham){
		Session session = sessionFactory.getCurrentSession();
		String query = "from SanPham sp where sp.id = " + maSanPham;
		SanPham sanPham = (SanPham) session.createQuery(query).getSingleResult();
		return sanPham;
	}
	
	@Override
	@Transactional
	public boolean XoaSpTheoMa(int id) {
		Session session = sessionFactory.getCurrentSession();
		SanPham sanPham = session.get(SanPham.class, id);
		
		Set<ChiTietSanPham> chiTietSanPhams = sanPham.getChiTietSanPhams();
		for (ChiTietSanPham chiTietSanPham : chiTietSanPhams) {
			session.createQuery("delete ChiTietHoaDon where id = " + chiTietSanPham.getId()).executeUpdate();
		}
		session.createQuery("delete ChiTietSanPham where id = " + id).executeUpdate();
		session.createQuery("delete SanPham where id = " + id).executeUpdate();
		return false;
	}

	@Override
	@Transactional
	public List<SanPham> laySPTheoDanhMuc(int idDanhMuc) {
		Session session = sessionFactory.getCurrentSession();
		String query = "from SanPham sp where sp.danhMucSanPham.id = " + idDanhMuc;
		List<SanPham> sanPhams = (List<SanPham>) session.createQuery(query).getSingleResult();
		return sanPhams;
	}
}
