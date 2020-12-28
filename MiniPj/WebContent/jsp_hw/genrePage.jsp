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
</body>
</html>