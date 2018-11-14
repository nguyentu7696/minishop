package com.tna.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="danh_muc_san_pham")
public class DanhMucSanPham implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ten_danh_muc")
	private String tenDanhMuc;
	
	@Column(name="hinh_danh_muc")
	private String hinhDanhMuc;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="danh_muc_id")
	private Set<SanPham> danhSachSanPham; 
	
	public Set<SanPham> getDanhSachSanPham() {
		return danhSachSanPham;
	}

	public void setDanhSachSanPham(Set<SanPham> danhSachSanPham) {
		this.danhSachSanPham = danhSachSanPham;
	}

	public String getHinhDanhMuc() {
		return hinhDanhMuc;
	}

	public void setHinhDanhMuc(String hinhDanhMuc) {
		this.hinhDanhMuc = hinhDanhMuc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	
	
}
