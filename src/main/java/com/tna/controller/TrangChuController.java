package com.tna.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tna.entity.DanhMucSanPham;
import com.tna.entity.SanPham;
import com.tna.service.DanhMucService;
import com.tna.service.SanPhamService;


@Controller
@RequestMapping("/")
public class TrangChuController {
	
	@Autowired
	SanPhamService sanphamService;
	
	@Autowired
	DanhMucService danhmucService;
		
	@GetMapping
	@Transactional
	public String trangchu(String email, ModelMap modelMap, HttpSession httpSession) {
		
				
		if(httpSession.getAttribute("user") != null) {
			String mail = (String)httpSession.getAttribute("user");
			String chucaidau = mail.substring(0, 1);
			modelMap.addAttribute("chucaidau", chucaidau);
		}
		
		List<DanhMucSanPham> danhMucSanPhams = danhmucService.layDanhMuc();
		modelMap.addAttribute("danhMucs", danhMucSanPhams);
		
		List<SanPham> listsanpham = sanphamService.layDanhSachSanPhamLimit(0);
		modelMap.addAttribute("listSanPham", listsanpham);
		
		return "trangchu";
	}
}
