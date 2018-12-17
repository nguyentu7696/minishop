package com.tna.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tna.dao.DanhMucDAO;
import com.tna.entity.DanhMucSanPham;
import com.tna.entity.GioHang;
import com.tna.entity.SanPham;
import com.tna.service.DanhMucService;
import com.tna.service.SanPhamService;

@Controller
@RequestMapping("/chitiet")
@SessionAttributes("giohang")
public class ChiTietController {

	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	DanhMucService danhmucService;

	@GetMapping("/{masanpham}")
	@Transactional
	public String Default(@PathVariable int masanpham, ModelMap modelMap, HttpSession httpSession) {
		SanPham sanPham = sanPhamService.layChiTietSanPhamTheoMa(masanpham);
		List<DanhMucSanPham> danhMucSanPhams = danhmucService.layDanhMuc();
		for (DanhMucSanPham danhMucSanPham : danhMucSanPhams) {
			System.out.println(danhMucSanPham.getTenDanhMuc());
		}

		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsanphamgiohang", gioHangs.size());
		}
		modelMap.addAttribute("danhMucs", danhMucSanPhams);
		modelMap.addAttribute("sanPham", sanPham);

		return "chitiet";
	}
}
