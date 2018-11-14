package com.tna.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDonId implements Serializable{

	
	private int hoaDonID;
	
	
	private int chiTietSanPhamId;


	public int getHoaDonID() {
		return hoaDonID;
	}


	public void setHoaDonID(int hoaDonID) {
		this.hoaDonID = hoaDonID;
	}


	public int getChiTietSanPhamId() {
		return chiTietSanPhamId;
	}


	public void setChiTietSanPhamId(int chiTietSanPhamId) {
		this.chiTietSanPhamId = chiTietSanPhamId;
	}
	
	
	
}
