package com.tna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tna.entity.SanPham;
import com.tna.service.SanPhamService;

@Controller
@RequestMapping("/themsanpham")
public class ThemSanPhamController {

	@Autowired
	SanPhamService spService;
	
	
	@GetMapping
	public String Default(ModelMap modelMap) {
		List<SanPham> lstsp = (List<SanPham>) spService.layDanhSachSanPhamLimit(0);
		List<SanPham> allSp = (List<SanPham>) spService.layDanhSachSanPhamLimit(-1);
		double tongSp = Math.ceil((double)allSp.size() / 5);
		modelMap.addAttribute("lstsp", lstsp);
		modelMap.addAttribute("allSp", allSp);
		modelMap.addAttribute("tongSp", tongSp);
		return "themsanpham";
	}
}
