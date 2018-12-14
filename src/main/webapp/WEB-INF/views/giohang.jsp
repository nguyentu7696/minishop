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
	<div id="header-chitiet" class="container-fluid">

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
					<li class="active"><a href="#">TRANG CHá»¦</a></li>
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
					<li><a href="#">Dá»ŠCH Vá»¤</a></li>
					<li><a href="#">LIÃŠN Há»†</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${chucaidau != null}">
							<li><a href="dangnhap/" class="circle-avatar">
								<div></div>
								<span>${chucaidau}</span>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="dangnhap/"><span>đăng nhập</span></a></li>
						</c:otherwise>
					</c:choose>
					<li id="giohang"><a href="#"><img alt=""
							src="<c:url value="/resources/image/icon_cart.png" />">

							<c:if test = "${soluongsanphamgiohang > 0}">
								<div class="circle-giohang">
									<span>${ soluongsanphamgiohang }</span> 
								</div>
							</c:if>

							<c:if test = "${soluongsanphamgiohang <= 0  || soluongsanphamgiohang == null }">
								<div>
									<span>${ soluongsanphamgiohang }</span> 
								</div>
							</c:if>
							
							</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>
	</div>

	<div class="container">
        <div class="row">
            <h3>Danh Sách thông tin giỏ hàng</h3>
            <div class="col-md-6 col-sm-12">
                <table class="table">
                    <thead>
                        <tr>
                            <td>Tên sản phẩm</td>
                            <td>Màu</td>
                            <td>Size</td>
                            <td>Số lượng</td>
                            <td><h5>Giá Tiền</h5></td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="value"
                            items="${ giohang }">
                            <tr data-machitiet="${value.getMaChiTiet()}">
                                <td class="tensp" data-masp="${ value.getMaSp()}"> ${ value.getTensp() }</td>
                                <td class="mau" data-mamau="${value.getMaMau() }">${value.getTenMau() }</td>
                                <td class="size" data-masize="${value.getMaSize() }"> ${value.getTenSize() } </td>
                                <td class="soluong"><input min="1" type="number" class="soluong-giohang" value="${value.getSoLuong() }"/> </td>
                                <td class="giatien"  data-value="${value.getGiaTien()}" >${value.getGiaTien()}</td>
                                <td class="xoa-giohang btn btn-danger">Xóa</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <h4>Tổng tiền: <span  id="tongtien" style="color: red">1,800,000</span></h4>
            </div>
            <div class="col-md-6 col-sm-12">
                <h3>Thông tin người nhận/mua</h3>
                <div class="form-group">
                    <form action="" method="POST">
                        <label for="tenKhachHang">Tên người mua</label>
                        <input id="tenKhachHang" name="tenKhachHang" class="form-control"/>
    
                        <label for="sdt">Điện thoại liên lạc</label>
                        <input id="sdt"  name="sdt" class="form-control"/>
    
                        <div class="radio">
                            <label><input type="radio" name="hinhThucGiaoHang" checked value="Giao Hàng tận nơi">Giao Hàng tận nơi</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="hinhThucGiaoHang" value="Giao Hàng tận nơi">Nhận hàng tại cửa hàng</label>
                        </div> 
    
                        <label for="diaChiGiaoHang">Tên người mua</label>
                        <input id="diaChiGiaoHang" name="diaChiGiaoHang" class="form-control"/>
    
                        <label for="ghiChu">Ghi chú</label>
                        <textarea class="form-control" rows="5" id="ghiChu" name="ghiChu"></textarea>

                        <br>

                        <input type="submit" class="btn btn-primary" value="Đặt Hàng"/>
                    </form>                    
                </div>
            </div>
        </div>
	</div>

	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-md-4 wow tada">
				<p>
					<span class="title-footer">THÃ”NG TIN SHOP</span>
				</p>
				<span>Má»™t thÆ°Æ¡ng hiá»‡u thá»�i trang Ä‘áº§y uy tÃ­n luÃ´n Ä‘áº£m báº£o cháº¥t
					lÆ°á»£ng sáº£n pháº©m tá»‘t nháº¥t cho khÃ¡ch hÃ ng</span>
			</div>
			<div class="col-sm-4 col-md-4 wow tada">
				<p>
					<span class="title-footer">LIÃŠN Há»†</span>
				</p>
				<span>XuÃ¢n La, TÃ¢y Há»“, HÃ  Ná»™i</span><br /> <span>anhtu7696@gmail.com</span><br />
				<span>0974858669</span><br />
			</div>
			<div class="col-sm-4 col-md-4 wow tada">
				<p>
					<span class="title-footer">GÃ“P Ã�</span>
				</p>
				<form action="" method="post">
					<input name="tenNhanVien" class="meterial-textinput"
						style="margin-bottom: 8px" type="text" placeholder="Email">
					<textarea name="tuoi" style="margin-bottom: 8px" rows="4" cols="50"
						placeholder="Ná»™i dung"></textarea>
					<button class="meterial-primary-button" style="margin-bottom: 8px">Ä�á»’NG
						Ã�</button>
				</form>

			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>

</html>