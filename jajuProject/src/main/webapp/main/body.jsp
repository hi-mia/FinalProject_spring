<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 제이쿼리 불러오기 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<!-- Slick 불러오기 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css">

<div class="test_index_div stagger-item">
	<div>
		<jsp:include page="/main/top_slider.jsp" />
	</div>

	<div>
		<jsp:include page="/main/slider01.jsp" />
	</div>

	<%-- <div>
		<jsp:include page="/main/slider02.jsp" />
	</div>

	<div>
		<jsp:include page="/main/slider03.jsp" />
	</div> --%>

	<div>
		<jsp:include page="/main/md_recommend.jsp" />
	</div>

	<div id="total" style="margin-top: 100px;">
		<div id="formTotal"
			style="width: 1050px; max-width: 1050px; padding: 0 0 20px; margin: 0 auto; text-align: center;">
			<div class="head_aticle" padding-left="10px">
				<h2 class="tit" style="font-weight: 700; font-size: 28px; line-height: 32px; letter-spacing: -0.3px; text-align: center;">자유게시판</h2>
			</div>
			<br>
			<div id="totalDiv">
				<table style="width: 100%; border-top: 2px solid #47597e; font-size: 18px;" class="xans-board-listheader jh" cellpadding="0" cellspacing="0">
					<thead>
						<tr>
							<th width="8%" style="text-align: center;">번호</th>
							<th style="text-align: center;">제목</th>
							<th width="12%" style="text-align: center;">작성자</th>
							<th width="12%" style="text-align: center;">작성일</th>
							<th width="8%" style="text-align: center;">조회수</th>
						</tr>
					</thead>
					<tbody id="boardTable">
						
					</tbody>
				</table>
			</div>
			
			<div class="link_cate" style="width: 516px; margin: 0 auto; margin-top: 50px;">
				<a id="b_linkBtn" class="link" style="display: block; overflow: hidden; height: 56px; padding-top: 16px;
						border: 1px solid #e3e3e3; border-radius: 3px; font-size: 16px; line-height: 20px; text-align: center;
						letter-spacing: -0.3px; cursor: pointer; color:#333;"><span class="ico">자유게시판 더보기</span></a>
			</div>
		</div>
	</div>
<script type="text/javascript" src="/jaju/js/body.js"></script>

	<div class="section-container_info">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-md-8 col-md-offset-2">
					<div class="text-center">
						<h2>당신 근처의 자주마켓</h2>
						<p>
							중고 거래부터 동네 정보까지, 이웃과 함께해요. 가깝고 따뜻한 당신의 근처를 만들어요. <br>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="section-container">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">


					<div id="carousel-example-generic"
						class="carousel carousel-fade slide" data-ride="carousel">

						<!-- 로고 -->
						<!--    <div class="item active">
                      <img class="img-responsive" src="/jaju/logo/jajuTextLogo.png" alt="First slide">
             		</div> -->

						<div class="carousel-inner" role="listbox">
							<div class="carousel-caption card-shadow reveal">
								<h3>자주마켓은</h3>
								<a class="left carousel-control"
									href="#carousel-example-generic" role="button"
									data-slide="prev"> <!--<i class="fa fa-chevron-left" aria-hidden="true"></i> -->
									<span class="sr-only">Previous</span>
								</a> <a class="right carousel-control"
									href="#carousel-example-generic" role="button"
									data-slide="next"> <!--<i class="fa fa-chevron-right" aria-hidden="true"></i> -->
									<span class="sr-only">Next</span>
								</a>
								<p>자주마켓은 동네 이웃 간의 연결을 도와 따뜻하고 활발한 교류가 있는 지역 사회를 꿈꾸고 있어요!</p>
								<p>지역 내에서 발생하는 모든 생활정보(중고거래, 지역업체, 질문답변, 부동산, 구인구직 등)들이 모이고,
									그 정보들이 따뜻한 문화 안에서 교류되는 세상을 꿈꾸고 있어요. 자주마켓은 중고거래에서 시작하지만 지역커뮤니티 및
									정보 서비스 공유를 지향합니다.</p>
								<!-- <a href="/jaju/main/fullpage.jsp" class="btn btn-primary" title="">자주마켓 소개 </a> -->
							</div>
							<!-- card-shadow reveal  -->
						</div>

						<div class="item">
							<!--   <a href=""  class="img-responsive"></a>
 -->
							<div class="carousel-caption card-shadow reveal">

								<h3>중고거래 전 반드시 숙지!</h3>
								<a class="left carousel-control"
									href="#carousel-example-generic" role="button"
									data-slide="prev"> <!--( < )    <i class="fa fa-chevron-left" aria-hidden="true"></i> -->
									<span class="sr-only">Previous</span>
								</a> <a class="right carousel-control"
									href="#carousel-example-generic" role="button"
									data-slide="next"> <!-- ( > )  <i class="fa fa-chevron-right" aria-hidden="true"></i> -->
									<span class="sr-only">Next</span>
								</a>
								<p>매너온도는 판매자의 신용도에요. 매너온도가 낮다면 주의해주세요! 직거래가 아닌 택배이용을 한다면
									판매자의 후기를 먼저 읽고 거래해주세요.</p>

								<a href="/jaju/serviceCenter/noticeList" class="btn btn-primary"
									title=""> 더 많은 꿀팁 </a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- <div class="section-container contact-container">
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="section-container-spacer">
					<h2 class="text-center">자주마켓 최다 검색어</h2>
					<p class="text-center">자주마켓을 이용한 고객님들이 많이 검색한 검색어 입니다. 중고거래 시
						참고해보세요.</p>
				</div>
				<div class="card-container">
					<div
						class="card card-shadow col-xs-10 col-xs-offset-1 col-md-8 col-md-offset-2 reveal">
						<form action="" class="reveal-content">
							<div class="row">
								<div class="col-md-7">
									<div class="form-group">
										<input type="email" class="form-control" id="email"
											placeholder="검색어 입력">
									</div>

									<button type="submit" class="btn btn-primary">검색</button>
								</div>
								<div class="col-md-5">
									<ul class="list-unstyled address-container">
										<li><a href="#">#에코백</a></li>
										<li><a href="#">#제습기</a></li>
										<li><a href="#">#미니 선풍기</a></li>
										<li><a href="#">#아이패드</a></li>
									</ul>
								</div>
							</div>
						</form>
					</div>
					<div class="card-image col-xs-12" style="background-image: url('')"></div>
				</div>
			</div>
		</div>
	</div>
</div>
-->


