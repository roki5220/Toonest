<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/MiniPj/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<style>
strong a {
	color: black;
}

.page_wrap {
	text-align: center;
	font-size: 0;
}

#pageForm {
	display: inline-block;
}

#pageForm .none {
	display: none;
}

#pageForm a {
	display: block;
	margin: 0 3px;
	float: left;
	border: 1px solid #e6e6e6;
	width: 40px;
	height: 40px;
	line-height: 40px;
	text-align: center;
	background-color: #fff;
	font-size: 20px;
	color: #999999;
	text-decoration: none;
}

.page_nation .arrow {
	border: 1px solid #ccc;
}

#pageForm .pprev {
	background: #f8f8f8 url('img/page_pprev.png') no-repeat center center;
	margin-left: 0;
}

#pageForm .prev {
	background: #f8f8f8 url('img/page_prev.png') no-repeat center center;
	margin-right: 7px;
}

.page_nation .next {
	background: #f8f8f8 url('img/page_next.png') no-repeat center center;
	margin-left: 7px;
}

#pageForm .nnext {
	background: #f8f8f8 url('img/page_nnext.png') no-repeat center center;
	margin-right: 0;
}

#pageForm a.active {
	background-color: #42454c;
	color: #fff;
	border: 1px solid #42454c;
}

.title a {
	font-weight: bold;
	font-size: 25px;
}

.author, .genre {
	font-size: 20px;
}

.toonInfo {
	margin-left: 20px;
	vertical-align: middle;
	margin-bottom:20px;
}

.toonEach {
	margin-top: 20px;
}

h4 {
	margin-top: 20 px;
	margin-bottom: 35px;
}

.searchList {
	border-top: 2px solid #262424;
	margin-top: 20px;
	padding-top: 20px;
}

.author {
	line-height: 35px;
}

.imgTag {
	vertical-align: bottom;
}
</style>

</head>
<body>
	<!-- Navigation -->
	<jsp:include page="header.jsp" />

	<div class="container">
		<br>
		<h4 align="center">"${search }"에 대한 검색결과입니다.</h4>
		<br>
		<div class="searchList">
			<div class="row">
				<c:forEach var="vo" items="${list }">
					<div class="col-lg-6">
						<div class="toonEach">
							<a href="/MiniPj/DetailController.do?toon_no=${vo.toon_no}" class="thumb_link"> <img
								src="${vo.toon_pic}" width="160" class="img_thumb">
							</a>
							<div class="toonInfo" style="display: inline-block;">
								<strong class="title"> <a href="/MiniPj/DetailController.do?toon_no=${vo.toon_no}" class="title_link">${vo.toon_name }</a>
								</strong>
								<p></p>
								<div>
									<div class="author">${vo.toon_writer }</div>
									<div class="genre">
										<c:if test="${vo.toon_site == '네이버' }">
											<img class="imgTag"
												src="/MiniPj/images/Naver_Line_Webtoon_logo.png" width="9%">
										</c:if>
										<c:if test="${vo.toon_site == '카카오페이지' }">
											<img class="imgTag" src="/MiniPj/images/KakaoPage_logo.png"
												width="8%">
										</c:if>
										<c:if test="${vo.toon_site == '리디북스' }">
											<img class="imgTag" src="/MiniPj/images/ridi_logo.png"
												width="10%">
										</c:if>
										${vo.toon_genre }
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="page_wrap">
		<div id="pageForm" align="center">
			<c:if test="${startPage != 1 }">
				<a class="arrow pprev"
					href="/MiniPj/SearchController.do?page=${startPage-1 }&searchBox2=${searchBox2}">&laquo;</a>
			</c:if>

			<c:forEach var="pageNum" begin="${startPage }" end="${endPage }">
				<c:if test="${pageNum == spage }">
					<a href="#" onclick="return false;" class="active">${pageNum }</a>

				</c:if>
				<c:if test="${pageNum != spage }">
					<a
						href="/MiniPj/SearchController.do?page=${pageNum }&searchBox2=${searchBox2}">${pageNum }</a>
				</c:if>
			</c:forEach>

			<c:if test="${endPage != maxPage }">
				<a class="arrow nnext"
					href="/MiniPj/SearchController.do?page=${endPage+1 }&searchBox2=${searchBox2}">&raquo;</a>
			</c:if>
		</div>
	</div>
	<br>
</body>
</html>