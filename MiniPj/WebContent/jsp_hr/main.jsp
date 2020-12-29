<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>TooNesT</title>
<!-- Bootstrap core CSS -->
<link href="/MiniPj/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/MiniPj/css/main.css" rel="stylesheet">
<jsp:include page="header.jsp" />
<style>
.container {
	font-family: 'Noto Sans KR', sans-serif;
}
</style>
</head>
<body>
	<div class="container" align="center">
		<div class="row">
			<div class="col-lg-12">
				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block img-fluid" src="http://placehold.it/900x350"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="http://placehold.it/900x350"
								alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="http://placehold.it/900x350"
								alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">＜</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">＞</span>
					</a>
				</div>
				<div class="row">
					<c:forEach var="vo" end="17" items="${list }">
						<div class="col-lg-2 col-md-5 mb-4">
							<div class="webcard">
								<!-- 클릭하면 상세페이지이동 -->
								<img class="webImg" src="${vo.toon_pic }" onclick="location='/MiniPj/ReviewList.do?toon_no=${vo.toon_no}'">
								<div class="webbody">
									<h4 class="title">
										<a href="/MiniPj/ReviewList.do?toon_no=${vo.toon_no}">${vo.toon_name }</a>
									</h4>
									<h5 class="writer">${vo.toon_writer }
									<c:if test="${vo.toon_site == '네이버' }">
										<img src="/MiniPj/images/Naver_Line_Webtoon_logo.png"
											width="30%">
									</c:if>
									<c:if test="${vo.toon_site == '카카오페이지' }">
										<img src="/MiniPj/images/KakaoPage_logo.png" width="30%">
									</c:if>
									<c:if test="${vo.toon_site == '리디북스' }">
										<img src="/MiniPj/images/ridi_logo.png" width="30%">
									</c:if>
									</h5>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<br>
	<!-- Bootstrap core JavaScript -->
	<script src="/MiniPj/vendor/jquery/jquery.min.js"></script>
	<script src="/MiniPj/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>

</html>
