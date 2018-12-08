package com.tna.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tna.entity.GioHang;
import com.tna.service.NhanVienService;


@Controller
@RequestMapping("api/")
@SessionAttributes({"user", "giohang"})
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
	
	@GetMapping("themgiohang")
	@ResponseBody
	public void themgiohang(@RequestParam String tensp, @RequestParam int maSp, @RequestParam int maSize , 
			@RequestParam int maMau, @RequestParam int soLuong, @RequestParam String giaTien, 
			@RequestParam String tenMau, @RequestParam String tenSize, HttpSession httpSession) {
		
		if(httpSession.getAttribute("giohang") == null) {
			List<GioHang> giohangs = new ArrayList<>();
			
			GioHang gioHang = new GioHang();
			gioHang.setGiaTien(giaTien);
			gioHang.setMaMau(maMau);
			gioHang.setMaSize(maSize);
			gioHang.setMaSp(maSp);
			gioHang.setSoLuong(1);
			gioHang.setTenMau(tenMau);
			gioHang.setTenSize(tenSize);
			gioHang.setTensp(tensp);
			
			giohangs.add(gioHang);
			httpSession.setAttribute("giohang", giohangs);
		}else {
			int vitri = kiemTraSPTonTaiGioHang(httpSession, maSp, maMau, maSize);
			if(vitri == -1) {
				List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
				GioHang gioHang = new GioHang();
				gioHang.setGiaTien(giaTien);
				gioHang.setMaMau(maMau);
				gioHang.setMaSize(maSize);
				gioHang.setMaSp(maSp);
				gioHang.setSoLuong(1);
				gioHang.setTenMau(tenMau);
				gioHang.setTenSize(tenSize);
				gioHang.setTensp(tensp);
				listGioHangs.add(gioHang);
			}else {
				List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
				int soluongMoi = listGioHangs.get(vitri).getSoLuong() + 1;
				listGioHangs.get(vitri).setSoLuong(soluongMoi);
			}
		}
		List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
		for (GioHang gioHang : listGioHangs) {
			System.out.println(gioHang.getMaSp() + "-" + gioHang.getTenMau() + "-" + gioHang.getTenSize());
		}
	}
	
	
	private int kiemTraSPTonTaiGioHang(HttpSession httpSession, int masp, int mamau, int masize) {
		List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
		for(int i = 0;  i < listGioHangs.size(); i++) {
			if(listGioHangs.get(i).getMaSp() == masp 
					&& listGioHangs.get(i).getMaMau() == mamau 
					&& listGioHangs.get(i).getMaSize() == masize) {
				return i;
			}
		}
		return  -1;
	}
	
}
