<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="header.jsp" />
</head>
<body id="body-login">
	<!-- 	<form method="post">
		<input type="text" name="tendangnhap">
		<input type="password" name="matkhau">
		<input type="submit">
	</form> -->

	<div id="body-flex-login">
		<div id="container-login">

			<div id="container-login-left">
				<div id="header-left" class="header-login">
					<span id="text-logo">Welcome</span><br /> <span
						id="hint-text-logo">HÃ£y táº¡o nÃªn phong cÃ¡ch cá»§a báº¡n cÃ¹ng
						Minishop</span>
				</div>
				<div id="header-bottom-left">
					<p>
						<img alt="icon_oval"
							src='<c:url value="/resources/image/icon_oval.png" />'><span>LuÃ´n
							cáº­p nháº­t su hÆ°á»›ng thá»�i trang má»›i nháº¥t</span>
					</p>
					<p>
						<img alt="icon_oval"
							src='<c:url value="/resources/image/icon_oval.png" />'><span>Giáº£m
							hÆ¡n 50% táº¥t cáº£ cÃ¡c máº·t hÃ ng dÃ nh cho khÃ¡ch VIP</span>
					</p>
					<p>
						<img alt="icon_oval"
							src='<c:url value="/resources/image/icon_oval.png" />'><span>Táº­n
							tÃ¬nh tÆ° váº¥n táº¡o nÃªn phong cÃ¡ch cá»§a báº¡n</span>
					</p>
				</div>
			</div>

			<div id="container-login-rigth">
				<div id="header-top-right" class="header-login">
					<span class="active" id="dangnhap">Ä�Äƒng nháº­p</span> / <span
						id="dangky">Ä�Äƒng KÃ½</span>
				</div>

				<div id="container-center-login-right">
					<div class="container-login-form" id="container-center-login-right">
						<input id="email" class="meterial-textinput input-icon-email"
							type="text" name="email" placeholder="Email"><br /> <input
							id="matkhau" class="meterial-textinput input-icon-password"
							type="password" name="matkhau" placeholder="Password"> <br />
						<input id="btnDangNhap" type="submit"
							class="meterial-primary-button" value="Ä�Ä‚NG NHáº¬P" /> <br />
					</div>
					<div class="container-signup-form"
						id="container-center-login-right">
						<form action="/dangnhap/" method="post">
							<input id="email" class="meterial-textinput input-icon-email"
								type="text" name="email" placeholder="Email"><br /> <input
								id="matkhau" class="meterial-textinput input-icon-password"
								type="password" name="matkhau" placeholder="Máº­t kháº©u"> <br />
							<input id="nhaplaimatkhau"
								class="meterial-textinput input-icon-password" type="password"
								name="nhaplaimatkhau" placeholder="Nháº­p láº¡i máº­t kháº©u"> <br />
							<input id="btnDangNhap" type="submit"
								class="meterial-primary-button" value="Ä�Ä‚NG KÃ�" /> <br />
						</form>
					</div>

					<span id="ketqua"></span> <span>${kiemtradangnhap}</span> <span>${email}</span>
				</div>

				<div id="container-social-login">
					<img alt="icon_facebook"
						src='<c:url value="/resources/image/icon_facebook.png" />'>
					<img alt="icon_google"
						src='<c:url value="/resources/image/icon_google.png" />'>
				</div>



			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />

</body>



</html>