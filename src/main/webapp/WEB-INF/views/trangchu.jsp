<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="header" class="container-fluid">

		<nav class="navbar navbar-default none-nav">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"> <img alt=""
					src="<c:url value="/resources/image/fall_leaf.png" />"></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-center">
					<li class="active"><a href="#">TRANG CHỦ</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
					<li><a href="#">DỊCH VỤ</a></li>
					<li><a href="#">LIÊN HỆ</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${chucaidau != null}">
							<li><a href="dangnhap/" class="circle-avatar"><span>${chucaidau}</span></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="dangnhap/"><span>ĐĂNG NHẬP</span></a></li>
						</c:otherwise>
					</c:choose>
					<li><a href="#"><img alt=""
							src="<c:url value="/resources/image/icon_cart.png" />"> </a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>

		<div class="event-header container wow bounceIn">
			<span>Ngày 17/10 - 23/10/2018</span><br /> <span
				style="font-size: 50px">Mua 1 tặng 1</span><br />
			<button>XEM NGAY</button>
		</div>

	</div>

	<div id="info" class="container">
		<div class="row">
			<div class="col-12 col-md-4 col-sm-4 wow fadeInLeft"
				data-wow-duration="2s">
				<img class="icon" alt=""
					src="<c:url value="/resources/image/icon_quality.png" />"> <br />
				<span style="font-size: 32px; font-weight: 500px">CHẤT LƯỢNG</span><br />
				<span>Chúng tôi cam kết mang đến cho các bạn chất lượng sản
					phẩm tốt nhất</span><br />
			</div>
			<div class="col-12 col-md-4 col-sm-4 wow fadeInDown"
				data-wow-duration="2s" data-wow-delay="2s">
				<img class="icon" alt=""
					src="<c:url value="/resources/image/icon_quality.png" />"> <br />
				<span style="font-size: 32px; font-weight: 500px">CHẤT LƯỢNG</span><br />
				<span>Chúng tôi cam kết mang đến cho các bạn chất lượng sản
					phẩm tốt nhất</span><br />
			</div>
			<div class="col-12 col-md-4 col-sm-4 wow fadeInUp"
				data-wow-duration="2s" data-wow-delay="4s">
				<img class="icon" alt=""
					src="<c:url value="/resources/image/icon_quality.png" />"> <br />
				<span style="font-size: 32px; font-weight: 500px">CHẤT LƯỢNG</span><br />
				<span>Chúng tôi cam kết mang đến cho các bạn chất lượng sản
					phẩm tốt nhất</span><br />
			</div>

		</div>
	</div>

	<div id="title-sanpham" class="container">
		<span>SẢN PHẨM HOT</span>
		<div class="row" style="margin-top: 42px">
			<c:forEach var="sanpham" items="${listSanPham }">
				<div class="col-md-3 col-sm-6">
					<a href="chitiet/${ sanpham.getId() }">
						<div class="sanpham wow zoomIn">
							<img alt="" src="<c:url value="/resources/image/sanpham/${sanpham.getHinhSanPham() }" />">
							<br /> 
							<span>${sanpham.getTenSanPham() }</span>
							<br />
							<span class="gia">${sanpham.getGiaTien() } VND</span>
						</div>
					</a>
				</div>
			</c:forEach>

		</div>
	</div>

	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-md-4 wow tada">
				<p>
					<span class="title-footer">THÔNG TIN SHOP</span>
				</p>
				<span>Một thương hiệu thời trang đầy uy tín luôn đảm bảo chất
					lượng sản phẩm tốt nhất cho khách hàng</span>
			</div>
			<div class="col-sm-4 col-md-4 wow tada">
				<p>
					<span class="title-footer">LIÊN HỆ</span>
				</p>
				<span>Xuân La, Tây Hồ, Hà Nội</span><br /> <span>anhtu7696@gmail.com</span><br />
				<span>0974858669</span><br />
			</div>
			<div class="col-sm-4 col-md-4 wow tada">
				<p>
					<span class="title-footer">GÓP Ý</span>
				</p>
				<form action="" method="post">
					<input name="tenNhanVien" class="meterial-textinput"
						style="margin-bottom: 8px" type="text" placeholder="Email">
					<textarea name="tuoi" style="margin-bottom: 8px" rows="4" cols="50"
						placeholder="Nội dung"></textarea>
					<button class="meterial-primary-button" style="margin-bottom: 8px">ĐỒNG
						Ý</button>
				</form>

			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>

</html>