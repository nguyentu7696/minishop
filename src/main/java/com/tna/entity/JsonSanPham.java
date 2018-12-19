package com.tna.entity;

import java.util.Set;

public class JsonSanPham {
	private int id;
	private String tenSanPham;
	private String giaTien;
	private String moTa;
	private String gianhCho;
	private String hinhSanPham;
	private DanhMucSanPham danhMucSanPham;
	Set<ChiTietSanPham> chiTietSanPhams;
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
	public String getGianhCho() {
		return gianhCho;
	}
	public void setGianhCho(String gianhCho) {
		this.gianhCho = gianhCho;
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
	public Set<ChiTietSanPham> getChiTietSanPhams() {
		return chiTietSanPhams;
	}
	public void setChiTietSanPhams(Set<ChiTietSanPham> chiTietSanPhams) {
		this.chiTietSanPhams = chiTietSanPhams;
	}
}
