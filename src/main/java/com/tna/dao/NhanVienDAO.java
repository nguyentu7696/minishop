package com.tna.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tna.daoimp.NhanVienImp;
import com.tna.entity.NhanVien;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class NhanVienDAO implements NhanVienImp{

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean kiemTraDangNhap(String email, String matkhau) {
		Session session = sessionFactory.getCurrentSession();
		try {
			NhanVien nhanVien = (NhanVien) session
					.createQuery("from NhanVien nv where nv.email='" + email + "' and nv.matKhau='" + matkhau + "' ")
					.getSingleResult();
			if (nhanVien != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean themNhanVien(NhanVien nhanVien) {
		Session session = sessionFactory.getCurrentSession();
		int idNhanvien = (Integer)session.save(nhanVien);
		if(idNhanvien > 0 ) {
			return true;
		}else {
			return false;
		}
	}

}
