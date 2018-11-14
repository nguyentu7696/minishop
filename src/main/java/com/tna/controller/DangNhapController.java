package com.tna.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tna.entity.NhanVien;
import com.tna.service.NhanVienService;

@Controller
@RequestMapping("dangnhap/")
public class DangNhapController {
	
	@Autowired
	NhanVienService nhanvienService;

	@GetMapping
	public String macDinh() {
		return "dangnhap";
	}

	@PostMapping
	public String dangky(@RequestParam String email, @RequestParam String matkhau,
			@RequestParam String nhaplaimatkhau, ModelMap map) {
		boolean ktemail = validate(email);
		if(ktemail) {
			if(matkhau.equals(nhaplaimatkhau)) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setEmail(email);
				nhanVien.setTenDangNhap(email);
				nhanVien.setMatKhau(matkhau);
				
				boolean ktthem = nhanvienService.themNhanVien(nhanVien);
				if(ktthem) {
					map.addAttribute("kiemtradangnhap", "Tạo tài khoản thành công");
				}else {
					map.addAttribute("kiemtradangnhap", "Tạo tài khoản thất bại");
				}
			}else {
				map.addAttribute("kiemtradangnhap", "Mât khẩu không trùng khớp");			}
		}else {
			map.addAttribute("kiemtradangnhap", "Vui lòng nhập đúng định dạng eamil");								
		}
		return "dangnhap";
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
			.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
}
