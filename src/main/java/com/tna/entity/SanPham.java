package com.tna.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "san_pham")
public class SanPham {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ten_san_pham")
	private String tenSanPham;

	@Column(name = "gia_tien")
	private String giaTien;

	@Column(name = "mo_ta")
	private String moTa;
	
	@Column(name="gianh_cho")
	private String gianhCho;

	@Column(name = "hinh_san_pham")
	private String hinhSanPham;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "danh_muc_id")
	private DanhMucSanPham danhMucSanPham;

	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "san_pham_id")
	Set<ChiTietSanPham> chiTietSanPhams;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "chi_tiet_khuyen_mai", joinColumns = {
			@JoinColumn(name="san_pham_id") }, inverseJoinColumns = {
					@JoinColumn(name="khuyen_mai_id") })
	Set<KhuyenMai> danhSachKhuyenMai;

	public Set<KhuyenMai> getDanhSachKhuyenMai() {
		return danhSachKhuyenMai;
	}

	public void setDanhSachKhuyenMai(Set<KhuyenMai> danhSachKhuyenMai) {
		this.danhSachKhuyenMai = danhSachKhuyenMai;
	}

	public Set<ChiTietSanPham> getChiTietSanPhams() {
		return chiTietSanPhams;
	}

	public void setChiTietSanPhams(Set<ChiTietSanPham> chiTietSanPhams) {
		this.chiTietSanPhams = chiTietSanPhams;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(String giaTien) {
		this.giaTien = giaTien;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getHinhSanPham() {
		return hinhSanPham;
	}

	public void setHinhSanPham(String hinhSanPham) {
		this.hinhSanPham = hinhSanPham;
	}

	public DanhMucSanPham getDanhMucSanPham() {
		return danhMucSanPham;
	}

	public void setDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
		this.danhMucSanPham = danhMucSanPham;
	}

	public String getGianhCho() {
		return gianhCho;
	}

	public void setGianhCho(String gianhCho) {
		this.gianhCho = gianhCho;
	}
}
