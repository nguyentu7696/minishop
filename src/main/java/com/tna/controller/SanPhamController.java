package com.tna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tna.entity.DanhMucSanPham;
import com.tna.service.DanhMucService;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {
	
	@Autowired
	DanhMucService danhmucService;
	
	@GetMapping("{id}")
	public String Default(ModelMap modelMap, @PathVariable int id) {
		
		List<DanhMucSanPham> danhMucSanPhams = danhmucService.layDanhMuc();
		modelMap.addAttribute("danhMucs", danhMucSanPhams);
		
		return "sanpham";
	}
}
