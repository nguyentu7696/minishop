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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "khuyen_mai")
public class KhuyenMai implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ten_khuyen_mai")
	private String tenKhuyenMai;

	@Column(name = "thoi_gian_bat_dau")
	private String thoiGianBatDau;

	@Column(name = "thoi_gian_ket_thuc")
	private String thoiGianKetThuc;

	@Column(name = "mo_ta")
	private String moTa;

	@Column(name = "hinh_khuyen_mai")
	private String hinhKhuyenMai;

	@Column(name = "gia_giam")
	private int giaGiam;

	@ManyToMany(mappedBy="danhSachKhuyenMai")
	Set<SanPham> danhSachSanPham;

	
	
	public Set<SanPham> getDanhSachSanPham() {
		return danhSachSanPham;
	}

	public void setDanhSachSanPham(Set<SanPham> danhSachSanPham) {
		this.danhSachSanPham = danhSachSanPham;
	}

	public int getGiaGiam() {
		return giaGiam;
	}

	public void setGiaGiam(int giaGiam) {
		this.giaGiam = giaGiam;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}

	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}

	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getHinhKhuyenMai() {
		return hinhKhuyenMai;
	}

	public void setHinhKhuyenMai(String hinhKhuyenMai) {
		this.hinhKhuyenMai = hinhKhuyenMai;
	}

}
