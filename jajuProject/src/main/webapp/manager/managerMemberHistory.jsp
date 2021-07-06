<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jaju/manager_css/managerMemberHistory.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>

<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>


</head>
<body>
	<!-- 가로메뉴바,세로메뉴바 고정 -->
	<!-- 프로필, 스크랩, 팔로우, 메세지 -->
	
	<!-- controller에서 넘어온 id/pg ,id는 임의로 만들어둔 변수명. 나중에 session값 처리-->
	<input type="hidden" id="id" name="id" value="${id}">
	<input type="hidden" id="pg" name="pg" value="${pg}">
	
	
	<div id="myPageTop" class="page_aticle mypage_top">
		<div class="historyTitle">회원 활동 내역</div>
		
		<div class="mypagetop_user">

			<div class="inner_mypagetop">
			
					<!--프로필 이미지 사진 동적태그-->					
					<div class="profile_image_div">
						<img src="" alt="프로필" class="profile_image">
					<!--이름 동적태그-->					
					<h2 class="name" id="name"></h2>
				</div>

				
				
				<div class="list_mypage">
					<div class="list">
						
						<div id="deal_count" href="/jaju/mypage/myScrap" class="link_wrap">
							<div class="link_title">거래내역</div>
							
								<a href="/jaju/manager/managerMemberSale?id=${id}" id="sale" ></a>
								<a href="/jaju/manager/managerMemberBuy?id=${id}" id="buy" ></a>
								<a href="/jaju/manager/managerMemberDeal?id=${id}" id="deal" ></a>	
						</div>
						
							
						<a id="scrap_count" href="/jaju/manager/managerMemberReview?id=${id}" class="link_wrap">
							<div class="link_title">후기내역</div>
							<p id="review" class="info"></p>
							<div class="spacer"></div>
						</a>
					
								
						
					</div>
				</div>
			</div>
		</div>
		
	
		<div id="historyDiv">
			<div id="historyInfo" style='height:34px; margin-bottom: 50px; display: table-cell; vertical-align: middle;' >
				클릭하여 세부 내역을 확인하세요.
			</div>
		</div>
		
		 	
	</div>
	
			
 
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="/jaju/manager_js/managerMemberHistory.js"></script>
	<script type="text/javascript">
		
		
	
	</script>
</body>
</html>














