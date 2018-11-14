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
@Table(name="hoa_don")
public class HoaDon implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ten_khach_hang")
	private String tenKhachHang;
	
	@Column(name="s")
	private String sdt;
	
	@Column(name="dia_chi_giao_hang")
	private String diaChiGiaoHang;
	
	@Column(name="tinh_trang")
	private Boolean tinhTrang;
	
	@Column(name="ngay_lap")
	private String ngayLap;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="hoa_don_id")
	private Set<ChiTietHoaDon> danhSachChiTietHoaDon;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChiGiaoHang() {
		return diaChiGiaoHang;
	}

	public void setDiaChiGiaoHang(String diaChiGiaoHang) {
		this.diaChiGiaoHang = diaChiGiaoHang;
	}

	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}

	public Set<ChiTietHoaDon> getDanhSachChiTietHoaDon() {
		return danhSachChiTietHoaDon;
	}

	public void setDanhSachChiTietHoaDon(Set<ChiTietHoaDon> danhSachChiTietHoaDon) {
		this.danhSachChiTietHoaDon = danhSachChiTietHoaDon;
	}
	
	
}
