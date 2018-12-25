$(document).ready(function () {
	$("#cot1").click(function () {
		$(this).addClass("active");
	});


	$("#btnDangNhap").click(function () {
		var email = $("#email").val();
		var paasword = $("#matkhau").val();

		$.ajax({
			url: "/api/kiemtradangnhap",
			type: "GET",
			data: {
				email: email,
				matkhau: paasword
			},
			success: function (value) {
				if (value == "true") {
					duongDanHienTai = window.location.href;
					duongdan = duongDanHienTai.replace("dangnhap/", "");
					window.location = duongdan;
				} else {
					$("#ketqua").text("dang nhap that bai!");
				}
			}
		});
	});


	$("#dangnhap").click(function () {
		$(this).addClass("active");
		$("#dangky").removeClass("active");
		$(".container-login-form").show();
		$(".container-signup-form").css("display", "none");
	});

	$("#dangky").click(function () {
		$(this).addClass("active");
		$("#dangnhap").removeClass("active");
		$(".container-signup-form").show();
		$(".container-login-form").hide();
	});

	$(".btn-giohang").click(function () {
		var machitiet = $(this).attr("data-machitiet");
		var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
		var tenmau = $(this).closest("tr").find(".mau").text();

		var masize = $(this).closest("tr").find(".size").attr("data-masize");
		var tensize = $(this).closest("tr").find(".size").text();

		var soluong = $(this).closest("tr").find(".soluong").text();

		var tensp = $("#tensp").text();
		var masp = $("#tensp").attr("data-masp");
		var giatien = $("#giatien").attr("data-value");


		$.ajax({
			url: "/api/themgiohang",
			type: "GET",
			data: {
				tensp: tensp,
				maSp: masp,
				maSize: masize,
				maMau: mamau,
				soLuong: soluong,
				giaTien: giatien,
				tenMau: tenmau,
				tenSize: tensize,
				machitiet: machitiet
			},
			success: function (value) {
				//luoo luon thanh cong vi khong dong vao db
			}
		}).done(function () {
			// done la khi ajax chay xong thi thuc hien cong viec j do
			$.ajax({
				url: "/api/laysoluonggiohang",
				type: "GET",
				success: function (value) {
					$("#giohang").find("div").addClass("circle-giohang");
					$("#giohang").find("div").html("<span>" + value + "</span>");
				}
			});
		});
	});

	var tongtiensp = 0;
	ganTongTienGioHang();

	function ganTongTienGioHang(isEventChange) {
		var tongtiensp = 0;
		$(".giatien").each(function () {
			var soluong = $(this).closest("tr").find(".soluong-giohang").val();
			var giatien = $(this).text();

			var tongtien = parseFloat(giatien) * soluong;

			var formatGiaTien = parseFloat(tongtien).toFixed(3).replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.").toString();

			if (!isEventChange) {
				$(this).html(formatGiaTien);
			}

			tongtiensp = tongtiensp + tongtien;

			var formatTongtien = tongtiensp.toFixed(3).replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.").toString();
			$("#tongtien").html(formatTongtien + "");
		})
	}


	$(".xoa-giohang").click(function () {
		var self = $(this);
		var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
		var masize = $(this).closest("tr").find(".size").attr("data-masize");
		var masp = $(this).closest("tr").find(".tensp").attr("data-masp");

		$.ajax({
			url: "/api/xoagiohang",
			type: "GET",
			data: {
				masp: masp,
				masize: masize,
				mamau: mamau,
			},
			success: function (value) {
				self.closest("tr").remove();
				ganTongTienGioHang(true);
			}
		})

	})

	$(".soluong-giohang").change(function () {
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
			url: "/api/capnhatgiohang",
			type: "GET",
			data: {
				masp: masp,
				masize: masize,
				mamau: mamau,
				soluong: soluong,
			},
			success: function (value) {
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


	//phan trang
	$("body").on("click", ".paging-item", function () {
		$(".paging-item").removeClass("active");
		$(this).addClass("active");
		var sotrang = $(this).text();
		var spBatDau = (sotrang - 1) * 5;
		$.ajax({
			url: "/api/laysplimit",
			type: "GET",
			data: {
				spBatDau: spBatDau,
			},
			success: function (value) {
				var tbodySanPham = $("#table-sanpham").find("tbody");
				tbodySanPham.empty();
				tbodySanPham.append(value);
			}
		})
	})


	$("#check-all").change(function () {
		if (this.checked) {
			$("#table-sanpham input").each(function () {
				$(this).attr("checked", true);
			})
		} else {
			$("#table-sanpham input").each(function () {
				$(this).attr("checked", false);
			})
		}
	})

	$("#xoa-sanpham").click(function () {
		$("#table-sanpham input:checked").each(function () {
			var masp = $(this).val();
			var This = $(this);
			$.ajax({
				url: "/api/xoasanpham",
				type: "GET",
				data: {
					id: masp,
				},
				success: function (value) {
					This.closest("tr").remove();
				}
			})
		})
	})

	// upload file le server
	var files = [];
	var tenhinh="";
	$("#hinhanh").change(function (event) {
		files = event.target.files;
		tenhinh = files[0].name;
		forms = new FormData();
		forms.append("file", files[0])
		$.ajax({
			url: "/api/uploadfile",
			type: "POST",
			contentType: false,
			data: forms,
			processData: false,
			enctype: "multipar/form-data",
			success: function (value) {
				This.closest("tr").remove();
			}


		});
	});

	$("body").on("click", ".btn-chitiet", function(){
		$(this).remove();
		var chitietclone = $("#chitietsanpham").clone().removeAttr("id");
		$("#container-chitietsanpham").append(chitietclone);
	});


	// xu ly nhung j nhap o form du lieu thanh jsong tring de gui cho controller
	$("#btn-themsanpham").click(function(event){
		event.preventDefault();
		var formData = $("#form-sanpham").serializeArray();
		json = {};
		arrayChiTiet = [];
		
		$.each(formData, function(i, field){
			json[field.name] = field.value;
			
		});
		
		$("#container-chitietsanpham > .chitietsanpham").each(function(){
			mausp = $(this).find('select[name="mau"]').val();
			sizesp = $(this).find('select[name="size"]').val();
			soluongSp = $(this).find('input[name="soluong"]').val();

			objectChitet = {};
			objectChitet["mau"] = mausp;
			objectChitet["size"] = sizesp;
			objectChitet["soluong"] = soluongSp;

			arrayChiTiet.push(objectChitet);
		})

		json["chiTietSanPhams"] = arrayChiTiet;
		json["hinhSanPham"]= tenhinh;

		$.ajax({
			url: "/api/themsanpham",
			type: "POST",
			data: {
				dataJson: JSON.stringify(json)
			},
			success: function (value) {
				
			}


		});
	});


	$("body").on("click", ".capnhatsanpham", function(){
		maSp = $(this).attr("data-id");
		$.ajax({
			url: "/api/laydssanphamtheoma",
			type: "POST",
			data: {
				id: maSp
			},
			success: function (value) {
				// hien nhung j json trả ve len thanh phan trong form
			}


		});
	});

});
