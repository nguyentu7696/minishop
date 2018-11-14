package com.tna.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="chi_tiet_san_pham")
public class ChiTietSanPham implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="so_luong")
	private int soLuong;
	
	@Column(name="ngay_nhap")
	private String ngayNhap;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="san_pham_id")
	private SanPham sanPham;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="size_id")
	private SizeSanPham sizeSanPham;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="mau_id")
	private MauSanPham mauSanPham;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public SizeSanPham getSizeSanPham() {
		return sizeSanPham;
	}

	public void setSizeSanPham(SizeSanPham sizeSanPham) {
		this.sizeSanPham = sizeSanPham;
	}

	public MauSanPham getMauSanPham() {
		return mauSanPham;
	}

	public void setMauSanPham(MauSanPham mauSanPham) {
		this.mauSanPham = mauSanPham;
	}
	
	
	
}
