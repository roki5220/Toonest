<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.79.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<title>Blog Template Â· Bootstrap v5.0</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/blog/">


<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap"
	rel="stylesheet">
<style>
@import url(https://fonts.googleapis.com/earlyaccess/nanumgothic.css);

.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

#A {
	font-size: 20px;
	font-family: 'Noto Sans KR', sans-serif;
	/* 	font-weight: bold; */
	letter-spacing: +1px;
	color: #005e5c;
}

a {
	text-decoration: none;
}

.blog-header {
	line-height: 1;
	border-bottom: 1px solid #e5e5e5;
}
</style>

<!-- Custom styles for this template -->
<link href="../css/blog.css" rel="stylesheet">

</head>
<body>

	<div class="container">
		<header class="blog-header py-3">
			<div
				class="row flex-nowrap justify-content-between align-items-center">
				<div class="col-4 text-center">
					<img src="../images/toonnest_logo.jpg">
				</div>
				<div class="col-4 d-flex justify-content-end align-items-center">
					<form action="#">
						<label> <input placeholder="  오늘은 어떤 웹툰을 찾아볼까요?" size="40"
							style="border: 1px solid #e5e5e5; height: 50px; border-radius: 10px;"
							type="text" name="" class="" value>
						</label>
					</form>
					<a class="link-secondary" href="#" aria-label="Search"> <svg
							id="A" xmlns="http://www.w3.org/2000/svg" width="20" height="20"
							fill="none" stroke="currentColor" stroke-linecap="round"
							stroke-linejoin="round" stroke-width="2" class="mx-3" role="img"
							viewBox="0 0 24 24">
							<title>Search</title><circle cx="10.5" cy="10.5" r="7.5" />
							<path d="M21 21l-5.2-5.2" /></svg>
					</a>
				</div>
			</div>
		</header>

		<div class="nav-scroller py-1 mb-2">
			<nav class="nav d-flex justify-content-between">
				<a class="p-2 link-secondary" id="A" href="#">일 상</a> <a
					class="p-2 link-secondary" id="A" href="#">드 라 마</a> <a
					class="p-2 link-secondary" id="A" href="#">액 션</a> <a
					class="p-2 link-secondary" id="A" href="#">판 타 지</a> <a
					class="p-2 link-secondary" id="A" href="#">스 릴 러</a> <a
					class="p-2 link-secondary" id="A" href="#">로 맨 스</a>
			</nav>
		</div>
	</div>

</body>
</html>
