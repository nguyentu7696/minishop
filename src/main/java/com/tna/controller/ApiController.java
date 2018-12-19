package com.tna.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tna.entity.ChiTietSanPham;
import com.tna.entity.DanhMucSanPham;
import com.tna.entity.GioHang;
import com.tna.entity.JsonSanPham;
import com.tna.entity.MauSanPham;
import com.tna.entity.SanPham;
import com.tna.entity.SizeSanPham;
import com.tna.service.NhanVienService;
import com.tna.service.SanPhamService;


@Controller
@RequestMapping("api/")
@SessionAttributes({"user", "giohang"})
public class ApiController {

	@Autowired
	NhanVienService nhanvienService;
	
	@Autowired
	SanPhamService spService;
	
	@Autowired
	ServletContext servletContext;
	
	@GetMapping("kiemtradangnhap")
	@ResponseBody
	public String kiemTraDangNhap(@RequestParam String email, @RequestParam String matkhau, ModelMap modelMap) {
		Boolean kiemtra = nhanvienService.kiemTraDangNhap(email, matkhau);
		modelMap.addAttribute("user", email);
		return ""+kiemtra;
	}
	
	@GetMapping("capnhatgiohang")
	@ResponseBody
	public void capNhatGioHang(HttpSession httpSession, @RequestParam int soluong,
			@RequestParam int masp, @RequestParam int mamau, @RequestParam int masize) {
		if(null!=httpSession.getAttribute("giohang")) {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");;
			int vitri = kiemTraSPTonTaiGioHang(listGioHangs, httpSession, masp, mamau, masize);
			listGioHangs.get(vitri).setSoLuong(soluong);
		}
	}
	
	@GetMapping("xoagiohang")
	@ResponseBody
	public void xoagiohang(HttpSession httpSession,
			@RequestParam int masp, @RequestParam int mamau, @RequestParam int masize) {
		if(null!=httpSession.getAttribute("giohang")) {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");;
			int vitri = kiemTraSPTonTaiGioHang(listGioHangs, httpSession, masp, mamau, masize);
			listGioHangs.remove(vitri);
		}
	}
	
	@GetMapping("themgiohang")
	@ResponseBody
	public void themgiohang(@RequestParam String tensp, @RequestParam int maSp, @RequestParam int maSize , 
			@RequestParam int maMau, @RequestParam int soLuong, @RequestParam String giaTien, 
			@RequestParam String tenMau, @RequestParam String tenSize, HttpSession httpSession,
			@RequestParam int machitiet) {
		
		if(null==httpSession.getAttribute("giohang")) {
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
			gioHang.setMaChiTiet(machitiet);
			
			giohangs.add(gioHang);
			httpSession.setAttribute("giohang", giohangs);
		}else {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");;
			int vitri = kiemTraSPTonTaiGioHang(listGioHangs, httpSession, maSp, maMau, maSize);
			if(vitri == -1) {
				GioHang gioHang = new GioHang();
				gioHang.setGiaTien(giaTien);
				gioHang.setMaMau(maMau);
				gioHang.setMaSize(maSize);
				gioHang.setMaSp(maSp);
				gioHang.setSoLuong(1);
				gioHang.setTenMau(tenMau);
				gioHang.setTenSize(tenSize);
				gioHang.setTensp(tensp);
				gioHang.setMaChiTiet(machitiet);
				
				listGioHangs.add(gioHang);
			}else {
				int soluongMoi = listGioHangs.get(vitri).getSoLuong() + 1;
				listGioHangs.get(vitri).setSoLuong(soluongMoi);
			}
		}
		List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");;
		System.out.println(listGioHangs.size());
		for (GioHang gioHang : listGioHangs) {
			System.out.println(gioHang.getMaSp() + "-" + gioHang.getTenMau() + "-" + 
					gioHang.getTenSize() + "" +gioHang.getSoLuong());
		}
	}
	
	
	private int kiemTraSPTonTaiGioHang(List<GioHang> listGioHangs ,HttpSession httpSession, int masp, int mamau, int masize) {
		for(int i = 0;  i < listGioHangs.size(); i++) {
			if(listGioHangs.get(i).getMaSp() == masp 
					&& listGioHangs.get(i).getMaMau() == mamau 
					&& listGioHangs.get(i).getMaSize() == masize) {
				return i;
			}
		}
		return  -1;
	}
	
	
	@GetMapping("laysoluonggiohang")
	@ResponseBody
	public String laySoLuongGioHang(HttpSession httpSession) {
		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			return gioHangs.size() + "";
		}
		return "";
	}
	
	
	@GetMapping(path="laysplimit", produces="plain/text;charset=utf-8")
	@ResponseBody
	public String laysplimit(@RequestParam int spBatDau){
		String html = "";
		List<SanPham> lstSp = spService.layDanhSachSanPhamLimit(spBatDau);
		for (SanPham sanPham : lstSp) {
			html += "<tr>";
				html += "<td>\r\n" + 
						"	<div class=\"checkbox\">\r\n" + 
						"		<label>\r\n" + 
						"			<input type=\"checkbox\" class=\"checkboxsanpham\" value=\" "+ sanPham.getId() +"  \">\r\n" + 
						"		</label>\r\n" + 
						"	</div>\r\n" + 
						"</td>";
				html += "<td class=\"tensp\" data-masp=\" "+ sanPham.getId() + " + \"> " + sanPham.getTenSanPham() + "</td>";
				html += "<td class=\"giatien\" data-value=\""+ sanPham.getGiaTien()+"\">"+ sanPham.getGiaTien()+"</td>";
				html += "<td class=\"gianhcho\" data-value=\" " + sanPham.getGianhCho() +" \"> " + sanPham.getGianhCho() + " </td>";
				html += "<td class=\"btn btn-warning capnhatsanpham\" data-id=\" "+ sanPham.getId() + " \">Sua</td>";
			html += "</tr>";
		}
		return html;
	}
	
	@GetMapping(path="xoasanpham", produces="plain/text;charset=utf-8")
	@ResponseBody
	public String xoaSanPhamTheoMa(@RequestParam int id) {
		spService.XoaSpTheoMa(id);
		return "";
	}
	
	
	
	@PostMapping(path="uploadfile")
	@ResponseBody
	public String uploadfile(MultipartHttpServletRequest request) {
		//lay duong dan that su treb server
		// khi build project tren server tomcat thi n se tao ra ban copy, ban copy co duong
		// vd: ../wtpwebapps/duong dan project
		// khi save thi luu tren server
		String path_save_file = servletContext.getRealPath("/resiyrces/image/sanpham/");
		Iterator<String> lstNames = request.getFileNames();
		MultipartFile mpf = request.getFile(lstNames.next());
		
		File file = new File(path_save_file + mpf.getOriginalFilename());
		
		try {
			mpf.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	@PostMapping("themsanpham")
	@ResponseBody
	public void themsanpham(@RequestParam String dataJson ) {
		ObjectMapper objectMapper = new ObjectMapper();
		
		JsonNode jsonObject;
		try {
			SanPham sanPham = new SanPham();
			DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
			
			jsonObject = objectMapper.readTree(dataJson);
			danhMucSanPham.setId(jsonObject.get("danhMucSanPham").asInt());
			
			JsonNode jsonchitet = jsonObject.get("chiTietSanPhams");
			Set<ChiTietSanPham> lstChiTiet = new HashSet<>();
			for (JsonNode objchiTiet : jsonchitet) {
				ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
				
				MauSanPham mauSanPham = new MauSanPham();
				mauSanPham.setId(objchiTiet.get("mau").asInt());
				
				SizeSanPham sizeSanPham = new SizeSanPham();
				sizeSanPham.setId(objchiTiet.get("size").asInt());
				
				chiTietSanPham.setMauSanPham(mauSanPham);;
				chiTietSanPham.setSizeSanPham(sizeSanPham);
				chiTietSanPham.setSoLuong(objchiTiet.get("soluong").asInt());
			
				lstChiTiet.add(chiTietSanPham);
			}
			
			String tensp = jsonObject.get("tenSanPham").asText();
			String giatien = jsonObject.get("giaTien").asText();
			String mota = jsonObject.get("moTa").asText();
			String gianhcho = jsonObject.get("gianhCho").asText();
			String hinhsp = jsonObject.get("hinhSanPham").asText();
			
			sanPham.setChiTietSanPhams(lstChiTiet);
			sanPham.setDanhMucSanPham(danhMucSanPham);
			sanPham.setTenSanPham(tensp);
			sanPham.setGiaTien(giatien);
			sanPham.setMoTa(mota);
			sanPham.setGianhCho(gianhcho);
			sanPham.setHinhSanPham(hinhsp);
			
			spService.themSanPham(sanPham);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PostMapping(path="laydssanphamtheoma", produces="application/json;charset=utf-8")
	@ResponseBody
	public JsonSanPham layDSSpTheoMa(@RequestParam int id) {
		JsonSanPham json_sp = new JsonSanPham();
		
		SanPham sp =  spService.layChiTietSanPhamTheoMa(id);
		
		json_sp.setId(sp.getId());
		json_sp.setTenSanPham(sp.getTenSanPham());
		json_sp.setGiaTien(sp.getGiaTien());
		json_sp.setMoTa(sp.getMoTa());
		json_sp.setGianhCho(sp.getGianhCho());
		json_sp.setHinhSanPham(sp.getHinhSanPham());
		
		DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
		danhMucSanPham.setId(sp.getDanhMucSanPham().getId());
		danhMucSanPham.setTenDanhMuc(sp.getDanhMucSanPham().getTenDanhMuc());
		
		json_sp.setDanhMucSanPham(danhMucSanPham);
		
		Set<ChiTietSanPham> chiTietSanPhams = new HashSet<>();
		for (ChiTietSanPham value : sp.getChiTietSanPhams()) {
			ChiTietSanPham chiTietSp = new ChiTietSanPham();
			
			chiTietSp.setId(value.getId());
			
			MauSanPham mauSanPham = new MauSanPham();
			mauSanPham.setId(value.getMauSanPham().getId());
			mauSanPham.setTenMau(value.getMauSanPham().getTenMau());
			
			chiTietSp.setMauSanPham(mauSanPham);
			
			SizeSanPham sizeSanPham = new SizeSanPham();
			sizeSanPham.setId(value.getSizeSanPham().getId());
			sizeSanPham.setSize(value.getSizeSanPham().getSize());
			
			chiTietSp.setSizeSanPham(sizeSanPham);
			chiTietSp.setSoLuong(value.getSoLuong());
			
			chiTietSanPhams.add(chiTietSp);
		}
		json_sp.setChiTietSanPhams(chiTietSanPhams);
		
		return json_sp;
	}
	
}
