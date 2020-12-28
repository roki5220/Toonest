<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	font-size: 18px;
	font-weight: bold;
}

.toonInfo {
	margin-left: 10px;
}
</style>
</head>
<body>
	<!-- Navigation -->
	<jsp:include page="../jsp_hr/header.jsp" />

	<div class="container">
		<br>
		<h4 align="center">"${search }"에 대한 검색결과입니다.</h4>
		<br>
		<div class="row">
			<ul id="resultList" style="list-style: none;">
				<li><c:forEach var="vo" items="${list }">
						<div class="toonEach" style="margin-bottom: 10px;">
							<a href="${vo.toon_pic}" class="thumb_link"> <img
								src="${vo.toon_pic}" width="130" class="img_thumb">
							</a>
							<div class="toonInfo" style="display: inline-block;">
								<strong class="title"> <a href="" class="title_link">${vo.toon_name }</a>
								</strong>
								<p></p>
								<dl>
									<dd class="author">${vo.toon_writer }</dd>
									<dd class="genre">${vo.toon_genre }</dd>
								</dl>
							</div>
						</div>
					</c:forEach></li>
			</ul>
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