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
	
	var tongtiensp = 0;
	ganTongTienGioHang();

	function ganTongTienGioHang(isEventChange){
		var tongtiensp = 0;
		$(".giatien").each(function(){
			var soluong = $(this).closest("tr").find(".soluong-giohang").val();
			var giatien = $(this).text();

			var tongtien = parseFloat(giatien) * soluong;

			var formatGiaTien = parseFloat(tongtien).toFixed(3).replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.").toString();

			if(!isEventChange){
				$(this).html(formatGiaTien);
			}

			tongtiensp = tongtiensp + tongtien;

			var formatTongtien = tongtiensp.toFixed(3).replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.").toString();
			$("#tongtien").html(formatTongtien + "");
		})
	}


	$(".xoa-giohang").click(function(){
		var self = $(this);
		var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");		
		var masize = $(this).closest("tr").find(".size").attr("data-masize");
		var masp = $(this).closest("tr").find(".tensp").attr("data-masp");

		$.ajax({
			url:"/api/xoagiohang",
			type:"GET",
			data:{
				masp: masp,
				masize: masize,
				mamau: mamau,
			},
			success: function(value){
				self.closest("tr").remove();
				ganTongTienGioHang(true);
			}
		})

	})

	$(".soluong-giohang").change(function(){
		var soluong = $(this).val();
		var giatien = $(this).closest("tr").find(".giatien").attr("data-value");
		var tongtien = soluong * parseInt(giatien);
		var format = tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.").toString();
		$(this).closest("tr").find(".giatien").html(format);
		ganTongTienGioHang(true);

		var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");		
		var masize = $(this).closest("tr").find(".size").attr("data-masize");
		var masp = $(this).closest("tr").find(".tensp").attr("data-masp");

		$.ajax({
			url:"/api/capnhatgiohang",
			type:"GET",
			data:{
				masp: masp,
				masize: masize,
				mamau: mamau,
				soluong: soluong,
			},
			success: function(value){
				//luoo luon thanh cong vi khong dong vao db
			}
		})
	})


	// $(".soluong-giohang").blur(function(){
	// 	// thuc hien khi mat focus
	// 	var soluong = $(this).val();
	// 	var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");		
	// 	var masize = $(this).closest("tr").find(".size").attr("data-masize");
	// 	var masp = $(this).closest("tr").find(".tensp").attr("data-masp");

	// 	$.ajax({
	// 		url:"/api/capnhatgiohang",
	// 		type:"GET",
	// 		data:{
	// 			masp: masp,
	// 			masize: masize,
	// 			mamau: mamau,
	// 			soluong: soluong,
	// 		},
	// 		success: function(value){
	// 			//luoo luon thanh cong vi khong dong vao db
	// 		}
	// 	})
	// })

});