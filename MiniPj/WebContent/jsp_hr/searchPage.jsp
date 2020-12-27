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
</style>
</head>
<body>
	<!-- Navigation -->
	<jsp:include page="../jsp_hr/header.jsp" />

	<div class="searchContent">
	<br>
		<h4 align="center">"${search }"에 대한 검색결과입니다.</h4>
		<br>
		<p></p>
		<ul id="resultList" style="list-style:none;">
		
			<li>
			<c:forEach var="vo" items="${list }">
				<div class="toonEach" style="margin-bottom: 10px;">
					<a href="${vo.toon_pic}" class="thumb_link">
						<img src="${vo.toon_pic}" width="106" height="148" class="img_thumb">
					</a>
					<div class="toonInfo" style="display:inline">
						<strong class="title">
							<a href="" class="title_link">${vo.toon_name }</a>
						</strong>
					</div>
				</div>
			</c:forEach>
				
			</li>
		</ul>
	</div>
</body>
</html>