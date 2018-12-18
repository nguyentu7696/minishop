package com.tna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tna.entity.DanhMucSanPham;
import com.tna.entity.MauSanPham;
import com.tna.entity.SanPham;
import com.tna.entity.SizeSanPham;
import com.tna.service.DanhMucService;
import com.tna.service.MauSanPhamService;
import com.tna.service.SanPhamService;
import com.tna.service.SizeSanPhamService;

@Controller
@RequestMapping("/themsanpham")
public class ThemSanPhamController {

	@Autowired
	SanPhamService spService;
	
	@Autowired
	DanhMucService danhmucService;
	
	@Autowired
	SizeSanPhamService sizeSanPhamService;
	
	@Autowired
	MauSanPhamService mauSanPhamService;
	
	@GetMapping
	public String Default(ModelMap modelMap) {
		List<SanPham> lstsp = (List<SanPham>) spService.layDanhSachSanPhamLimit(0);
		List<SanPham> allSp = (List<SanPham>) spService.layDanhSachSanPhamLimit(-1);
		List<DanhMucSanPham> danhMucSanPhams = danhmucService.layDanhMuc();
		List<SizeSanPham> sizeSanPhams = (List<SizeSanPham>) sizeSanPhamService.layDsSize();
		List<MauSanPham> mauSanPhams = (List<MauSanPham>) mauSanPhamService.layDsMau();
		
		double tongSp = Math.ceil((double)allSp.size() / 5);
		modelMap.addAttribute("lstsp", lstsp);
		modelMap.addAttribute("allSp", allSp);
		modelMap.addAttribute("tongSp", tongSp);
		modelMap.addAttribute("danhMucs", danhMucSanPhams);
		modelMap.addAttribute("sizeSanPhams", sizeSanPhams);
		modelMap.addAttribute("mauSanPhams", mauSanPhams);
		return "themsanpham";
	}
}
