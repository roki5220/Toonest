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
					<div class="" style=" width:220px;  margin-top:3%; margin-left:10px">
						
						<img src="${vo.toon_pic}" height="85%">

					</div>
					<div class="col p-4 d-flex flex-column position-static" align="left">
						<strong class="d-inline-block mb-2 text-primary">${vo.toon_genre }</strong>
						<h3 class="mb-0">${vo.toon_name }</h3>
						<div class="mb-1 text-muted">${vo.toon_writer }</div>
						<p class="card-text mb-auto">별점</p>
						<p class="stretched-link">키워드</p>
						
							<input type="button" class="button" onclick="location.href='${vo.toon_link }'" value="보러가기 →">
						
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
						<h5 class="mb-0">후기</h5>
						<br/>
						<div style="float:left; margin-right:10px;">
						<textarea id="story" name="story" rows="5" style="width:100%; border: 1px solid #e5e5e5; border-radius: 5px;" id="textarea" placeholder="  후기를 남겨주세요 :)"></textarea> 
						</div>
						
						<div>
							<button class="keyword_b">회귀</button>
							<button class="keyword_b">환생</button>
							<button class="keyword_b">중세판타지</button>
							<button class="keyword_b">빙의</button>
							<button class="keyword_b">힐링</button>
							<button class="keyword_b">먼치킨</button>
							<button class="keyword_b">게임판타지</button>
							<button class="keyword_b">여주원탑</button>
							<button class="keyword_b">동양풍</button>
							<button class="keyword_b">정령</button>
							<button class="keyword_b">스포츠</button>
							<button class="keyword_b">의학</button>
							<button class="keyword_b">용사</button>
							<button class="keyword_b">초능력</button>
							<button class="keyword_b">하렘</button>
							<button class="keyword_b">역하렘</button>
							<button class="keyword_b">퇴마</button>
							<button class="keyword_b">복수/배신</button>
							<button class="keyword_b">미래</button>
							<button class="keyword_b">타임슬립</button>
						</div>
						
						<button class="buttonA">리뷰 등록</button>
					</div>

				</div>
			</div>
		</div>
	</main>
	
	<main class="container" align="center">
		<div class="row mb-2">
			<div class="col-md-12">
				<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
					<div class="col p-4 d-flex flex-column position-static" align="left">
						<h5 class="mb-0">다른 사람들은?</h5>
						
						<div class="">
							<ul>
								<li>
									<div>
									실질적인 내용이 들어갈 거에요 
									</div>
									<div>
										<button>댓글 추천</button>
									</div>
								
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