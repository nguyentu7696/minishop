package com.tna.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="chuc_vu")
public class ChucVu{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ten_chuc_vu")
	private String tenChucvu;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenChucvu() {
		return tenChucvu;
	}

	public void setTenChucvu(String tenChucvu) {
		this.tenChucvu = tenChucvu;
	}
	
	
	
	
}
