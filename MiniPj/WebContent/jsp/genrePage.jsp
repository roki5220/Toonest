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
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap"
	rel="stylesheet">
<style>
div, a {
	font-family: 'Noto Sans KR', sans-serif;
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
	width: 30px;
	height: 30px;
	line-height: 30px;
	text-align: center;
	background-color: #fff;
	font-size: 15px;
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
	background-color: #005e5c;
	color: #fff;
	border: 1px solid #005e5c;
}

.title a {
	color: black;
	font-size: 17px;
}

.author, .genre {
	font-size: 13px;
}

.toonInfo {
	margin-left: 10px;
	vertical-align: middle;
}

.toonEach {
	margin-top: 20px;
}

h4 {
	margin-top: 20 px;
	margin-bottom: 35px;
}

.searchList {
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	function getParameterByName(name) {
	    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	        results = regex.exec(location.search);
	    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}
	
	var genre = getParameterByName('genre');
	if(genre == 'daily'){
		$('.g-daily').css({
			"text-decoration": "underline",
			"font-weight": "bold"
		});
	} else if(genre == 'drama'){
		$('.g-drama').css({
			"text-decoration": "underline",
			"font-weight": "bold"
		});
	} else if(genre == 'action'){
		$('.g-action').css({
			"text-decoration": "underline",
			"font-weight": "bold"
		});
	} else if(genre == 'fantasy'){
		$('.g-fantasy').css({
			"text-decoration": "underline",
			"font-weight": "bold"
		});
	} else if(genre == 'thriller'){
		$('.g-thriller').css({
			"text-decoration": "underline",
			"font-weight": "bold"
		});
	} else if(genre == 'romance'){
		$('.g-romance').css({
			"color": "#005e5c",
			"text-decoration": "underline",
			"font-weight": "bold"
		});
	}
});
</script>
</head>
<body>
	<!-- Navigation -->
	<jsp:include page="header.jsp" />

	<div class="container">
		<br>
		<br>
		<div class="searchList">
			<div class="row">
				<c:forEach var="vo" items="${list }">
					<div class="col-lg-4">
						<div class="toonEach">
							<a href="/MiniPj/DetailController.do?toon_no=${vo.toon_no}" class="thumb_link"> <img
								src="${vo.toon_pic}" width="110" class="img_thumb">
							</a>
							<div class="toonInfo" style="display: inline-block; width: 60%;">
								<strong class="title"> <a href="/MiniPj/DetailController.do?toon_no=${vo.toon_no}" class="title_link">${vo.toon_name }</a>
								</strong>
								<p></p>
								<div>
									<div class="author">${vo.toon_writer }</div>
									<div class="genre">
										<c:if test="${vo.toon_site == '네이버' }">
											<img class="imgTag"
												src="/MiniPj/images/Naver_Line_Webtoon_logo.png" width="8%">
										</c:if>
										<c:if test="${vo.toon_site == '카카오페이지' }">
											<img class="imgTag" src="/MiniPj/images/KakaoPage_logo.png"
												width="7%">
										</c:if>
										<c:if test="${vo.toon_site == '리디북스' }">
											<img class="imgTag" src="/MiniPj/images/ridi_logo.png"
												width="8%">
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
	<br>
	<div class="page_wrap">
		<div id="pageForm" align="center">
			<c:if test="${startPage != 1 }">
				<a class="arrow pprev"
					href="/MiniPj/GenreListController.do?page=${startPage-1 }&genre=${genre}">&laquo;</a>
			</c:if>

			<c:forEach var="pageNum" begin="${startPage }" end="${endPage }">
				<c:if test="${pageNum == spage }">
					<a href="#" onclick="return false;" class="active">${pageNum }</a>

				</c:if>
				<c:if test="${pageNum != spage }">
					<a
						href="/MiniPj/GenreListController.do?page=${pageNum }&genre=${genre}">${pageNum }</a>
				</c:if>
			</c:forEach>

			<c:if test="${endPage != maxPage }">
				<a class="arrow nnext"
					href="/MiniPj/GenreListController.do?page=${endPage+1 }&genre=${genre}">&raquo;</a>
			</c:if>
		</div>
	</div>
	<br>
</body>
</html>