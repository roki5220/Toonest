<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<link href="/MiniPj/css/body_detail.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap"
	rel="stylesheet">
<style>

@import url(//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css);
.container {
	font-family: 'Noto Sans KR', sans-serif;
}
.button {
	width: 160px;
	height: 40px;
	font-family: 'Roboto', sans-serif;
	font-size: 17px;
	text-transform: uppercase;
	letter-spacing: 2.5px;
	font-weight: 550;
	color: #fff;
	background-color: #005e5c;
	border: none;
	border-radius: 45px;
	box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
	transition: all 0.3s ease 0s;
	cursor: pointer;
	outline: none;
}

.button:hover {
	background-color: #005e5c;
	box-shadow: 0px 15px 20px rgba(46, 229, 157, 0.4);
	color: #fff;
	transform: translateY(-7px);
}
</style>

<title>Insert title here</title>

</head>
<body>
	<main class="container" align="center">
		<div class="row mb-2">
			<div class="col-md-12">
				<div
					class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
					<div class=""
						style="width: 220px; margin-top: 3%; margin-left: 10px">

						<img src="${vo.toon_pic}" height="85%">

					</div>
					<div class="col p-4 d-flex flex-column position-static"
						align="left">
						<strong class="d-inline-block mb-2 text-primary">${vo.toon_genre }</strong>
						<h3 class="mb-0">${vo.toon_name }</h3>
						<div class="mb-1 text-muted">${vo.toon_writer }</div>
						<p class="card-text mb-auto">별점</p>
						<p class="keyword">키워드</p>
						<div align="right">
							<input type="button" class="button"
								onclick="location.href='${vo.toon_link }'" value="보러가기 →">
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

	<main class="container" align="left">
		<div class="row mb-2">
			<div class="col-md-12">
				<div
					class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">

					<div class="col p-4 d-flex flex-column position-static">
						<h5 class="review_title" style="font-weight: 800; color: #005e5c;">REVEIW</h5>
						
						<!-- 별점 -->
						<div>
						<fieldset class="rating">
							<input type="radio" id="star5" name="rating" value="5" />
							<label class="full" for="star5" title="Awesome - 5 stars"></label> 
							
							<input type="radio" id="star4" name="rating" value="4" />
							<label class="full" for="star4" title="Pretty good - 4 stars"></label>
							
							<input type="radio" id="star3" name="rating" value="3" />
							<label class="full" for="star3" title="Meh - 3 stars"></label> 
							
							<input type="radio" id="star2" name="rating" value="2" />
							<label class="full" for="star2" title="Kinda bad - 2 stars"></label> 
							
							<input type="radio" id="star1" name="rating" value="1" />
							<label class="full" for="star1" title="Sucks big time - 1 star"></label>
							
						</fieldset>
						</div>


						<div style="float: left; margin-right: 10px;">
							<textarea id="story" name="story" rows="5"
								style="width: 100%; border: 1px solid #e5e5e5; border-radius: 5px;"
								id="textarea" placeholder="  후기를 남겨주세요 :)"></textarea>
						</div>

						<div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>회귀</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>환생</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>중세판타지</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>빙의</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>힐링</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>먼치킨</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>여주원탑</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>동양풍</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>정령</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>스포츠</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>의학</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>용사</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>초능력</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>하렘</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>역하렘</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>복수/배신</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>미래</span>
								</label>
							</div>
							<div id="ck-button">
								<label> <input type="checkbox" id="" class="" value=""><span>타임슬립</span>
								</label>
							</div>
						</div>

						<!-- <p id="star_grade">
							<a href="#">★</a> <a href="#">★</a> <a href="#">★</a> <a href="#">★</a>
							<a href="#">★</a>
						</p> -->

						<button class="buttonA">리뷰 등록</button>
					</div>

				</div>
			</div>
		</div>
	</main>

	<main class="container" align="center">
		<div class="row mb-2">
			<div class="col-md-12">
				<div
					class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
					<div class="col p-4 d-flex flex-column position-static"
						align="left">
						<h5 class="review_list" style="font-weight: 800; color: #005e5c;">REVIEW LIST</h5>

						<div class="u_cbox_area">
							<ul>
								<li>
									닉네임??
								</li>
								<li>
									내용
								</li>
								<li>
									별점
								</li>
								<li>
									키워드
								</li>
							</ul>
						</div>

					</div>

				</div>
			</div>
		</div>
	</main>
</body>
</html>