$(document).ready(function(){
	$("#cot1").click(function(){
		$(this).addClass("active");
	});
	
	
	$("#btnDangNhap").click(function(){
		var email = $("#email").val();
		var paasword = $("#matkhau").val();
		
		$.ajax({
			url:"/minishop/api/kiemtradangnhap",
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
	
});