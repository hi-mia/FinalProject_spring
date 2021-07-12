<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet" href="/jaju/css/header.css" />
<style type="text/css">
</style>
</head>
<body>


	<!-- header -->
	<div class="header">

		<div align="center" class="header_bar">
			<div class="carrot_image">
				<%-- <img src="" alt="" />--%>
			</div>

			<ul class="member_items">
			
				<c:if test="${memId == 'jajuadmin'}">
					<li class="sign_up_item"><a href="/jaju/manager/managerMainChart">관리자</a></li>
				</c:if>
				
				<c:if test="${memId == null}">
					<li class="sign_up_item"><a href="/jaju/member/writeForm">회원가입 </a></li>
					<li class="sign_in_item"><a href="/jaju/member/loginForm">로그인</a></li>
				</c:if>

				<c:if test="${memId != null}">
					<li class="sign_up_item"><a href="/jaju/mypage/myKeywordForm">마이페이지</a></li>
					<li class="sign_in_item"><a href="javascript: logout()">로그아웃</a></li>
					<li class="map_item"><a href="/jaju/mypage/myLocationForm">지도</a></li>

				</c:if>

				<li class="service_center_item">
					
					<a class="service_center" href="/jaju/serviceCenter/noticeList"> 고객센터</a>
					<button type="button" class="service_center_icon"></button>
					
					<ul class="service_center_detail">
						<li><a href="/jaju/serviceCenter/noticeList">공지사항</a></li>

						<li><a href="/jaju/serviceCenter/questionList">자주하는 질문</a></li>

						<c:if test="${memId != null}">
							<li><a href="/jaju/serviceCenter/inquireList">1:1 문의</a></li>
							<li><a href="/jaju/serviceCenter/reportList">신고 게시판</a></li>
							<li><a href="/jaju/mypage/myKeywordForm">마이페이지</a></li>
						</c:if>
					</ul>
				</li>
			</ul>
		</div>

		<div class="logo_image">
		<h1 class="logo">
			<a href="/jaju/"> 
				<img src="/jaju/logo/logo_basic.png" />
			</a>
		</h1>
		</div>

		<div class="menuDiv">
			<!-- == nav -->

			<ul class="menu">
				<!-- == main -->
				<li class="all_category header_a_li">
					<!-- == MAIN01 == 전체카테고리 --> <a href="#" class="button">
						<button type="button" class="menu_button"></button> 상품 카테고리
				</a> <!-- 전체카테고리 hover시 나타남. -->
					<ul class="all_category_item" id="all_category_item">
						<!-- == sub -->

						<li><a class="digital">디지털/가전</a></li>
						<!-- == SUB01 -->

						<li><a class="life">생활</a></li>

						<li><a class="instant_food"> 가공식품</a></li>

						<li><a class="women_cloth"> 여성의류</a></li>

						<li><a class="beauty"> 뷰티 / 미용</a></li>

						<li><a class="furniture"> 가구 / 인테리어</a></li>

						<li><a class="sport"> 스포츠 / 레저</a></li>

						<li><a class="men_choth"> 남성 / 패션잡화 </a></li>

						<li><a class="dogCat"> 반려동물용품 </a></li>

						<li><a class="kids"> 유아동 / 유아도서 </a></li>

						<li><a class="womenAcc"> 여성잡화 </a></li>

						<li><a class="game"> 게임 / 취미 </a></li>

						<li><a class="kitchen"> 주방용품 </a></li>

						<li><a class="book"> 도서 / 티켓 / 음반 </a></li>

						<li><a class="else"> 기타 중고물품 </a></li>
					</ul>
				</li>

				<li class="new-product-category">
					<a	href="/jaju/saleboard/saleboardList?pg=1&sortinSelect=sale_date" style="text-decoration:none;">판매게시판</a></li>
				<c:if test="${memId != null }">
					<li class="new-product-category">
						<a	href="/jaju/saleboard/saleboardListFavorite?pg=1&sortinSelect=sale_date" style="text-decoration:none;">관심게시판</a></li>
				</c:if>
				<li class="cheap-product-category  header_a_li">
					<a href="/jaju/freeboard/freeboardList?pg=1"	class="button" style="text-decoration:none;">자유게시판</a></li>
				<c:if test="${memId != null }">
					<li class="cheap-product-category  header_a_li">
						<a href="/jaju/reviewboard/reviewboardList?pg=1"	class="button" style="text-decoration:none;">리뷰게시판</a></li>
				</c:if>
			</ul>
			<%--mainnav --%>

			<%-- </div> class menu1 --%>

			<div class="sub_menu">
				<!--         <form action="#" class="search_box"> </form> -->
				<input type="text" placeholder="&emsp;&emsp;검색할 중고 물품을 입력하세요."
					class="search-box" />
				<button type="button" class="button_search"></button>



				<c:if test="${memId != null}">
					<button type="button" class="button-user" id="button-user"
						value="마이페이지" onclick="location.href='/jaju/mypage/myKeywordForm'">
						<i class="far fa-user icon-user"></i>
					</button>
				</c:if>

			</div>
			<!-- sub_menu -->
		</div>
	</div>



	<script type="text/javascript"
		src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script type="text/javascript">
	   Kakao.init('eb076581cabcf4b94c737d45185362db');
	   Kakao.isInitialized();
	</script>
	<script type="text/javascript" src="/jaju/js/main.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			//전체 카테고리 hover event
			$(".menu>.all_category").mouseover(function() {
				$(this).children(".all_category_item").stop().slideDown();
			});
			$(".menu>.all_category").mouseleave(function() {
				$(this).children(".all_category_item").stop().slideUp();
			});
			
			//고객센터 hover event
			$(".member_items .service_center_item").mouseover(function() {
				$(this).children(".service_center_detail").stop().slideDown();
			});
			$(".member_items .service_center_item").mouseleave(function() {
				$(this).children(".service_center_detail").stop().slideUp();
			});
			
		});
	
		$('#all_category_item>li').click(function(){
			//alert("hover 중 한개 선택 했음 그 값은?"+ $(this).children('a').attr('class'));
			location.href = '/jaju/saleboard/saleboardListCategory?pg=1&sortinSelect=sale_date&sale_category=' + $(this).children('a').attr('class');
		});
		
		//header 상단에 고정 시키기
	    $(function(){
	        var top_pos= $('.menuDiv').offset().top;
	        win = window;
	        $(win).on('scroll',
	           function(){
	             var pos = $(this).scrollTop();
	             
	             if(pos >= top_pos){
	                $('.menuDiv').addClass('fix');
	             } 
	              else{
	                $('.menuDiv').removeClass('fix');
	              }
	        });         
	      });
		//header 검색
		$('.button_search').click(function(){
			if($('.search-box').val() == ''){
				alert('검색어를 입력해 주세요');				
			} else{
				location.href = '/jaju/saleboard/saleboardList?pg=1&sortinSelect=sale_date&headerSerachText='+$('.search-box').val()				
			}
		});
		
	</script>
</body>
</html>