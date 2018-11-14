package com.tna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tna.service.NhanVienService;

@Controller
@RequestMapping("api/")
@SessionAttributes("user")
public class ApiController {

	@Autowired
	NhanVienService nhanvienService;
	
	@GetMapping("kiemtradangnhap")
	@ResponseBody
	public String kiemTraDangNhap(@RequestParam String email, @RequestParam String matkhau, ModelMap modelMap) {
		Boolean kiemtra = nhanvienService.kiemTraDangNhap(email, matkhau);
		modelMap.addAttribute("user", email);
		return ""+kiemtra;
	}
}
