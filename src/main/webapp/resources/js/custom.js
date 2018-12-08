$(document).ready(function(){
	$("#cot1").click(function(){
		$(this).addClass("active");
	});
	
	
	$("#btnDangNhap").click(function(){
		var email = $("#email").val();
		var paasword = $("#matkhau").val();
		
		$.ajax({
			url:"/api/kiemtradangnhap",
			type:"GET",
			data:{
				email:email,
				matkhau: paasword
			},
			success: function(value){
				if(value=="true"){
					duongDanHienTai = window.location.href;
					duongdan = duongDanHienTai.replace("dangnhap/","");
					window.location = duongdan;
				}else{
					$("#ketqua").text("dang nhap that bai!");
				}
			}
		});
	});
	
	
	$("#dangnhap").click(function(){
		$(this).addClass("active");
		$("#dangky").removeClass("active");
		$(".container-login-form").show();
		$(".container-signup-form").css("display","none");		
	});
	
	$("#dangky").click(function(){
		$(this).addClass("active");
		$("#dangnhap").removeClass("active");
		$(".container-signup-form").show();
		$(".container-login-form").hide();
	});
	
	$(".btn-giohang").click(function(){
		
		var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
		var tenmau = $(this).closest("tr").find(".mau").text();
		
		var masize = $(this).closest("tr").find(".size").attr("data-masize");
		var tensize = $(this).closest("tr").find(".size").text();
		
		var soluong = $(this).closest("tr").find(".soluong").text();

		var tensp = $("#tensp").text();
		var masp = $("#tensp").attr("data-masp");
		var giatien = $("#giatien").attr("data-value");


		$.ajax({
			url:"/api/themgiohang",
			type:"GET",
			data:{
				tensp: tensp,
				maSp: masp,
				maSize: masize,
				maMau: mamau,
				soLuong: soluong,
				giaTien: giatien,
				tenMau: tenmau,
				tenSize: tensize
			},
			success: function(value){
				//luoo luon thanh cong vi khong dong vao db
			}
		}).done(function(){
			// done la khi ajax chay xong thi thuc hien cong viec j do
			$.ajax({
				url:"/api/laysoluonggiohang",
				type:"GET",
				success: function(value){
					$("#giohang").find("div").addClass("circle-giohang");
					$("#giohang").find("div").html("<span>" + value + "</span>");
				}
			});
		});
	});
	
});