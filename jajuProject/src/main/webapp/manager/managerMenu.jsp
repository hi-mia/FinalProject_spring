<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/jaju/manager_css/managerMenu.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="side">
<ul class="list_lnb">
	<li class="lnb_admin1" >
		<strong><span class="ico_admin"></span> <span class="txt_lnb">운영/관리</span></strong>
		<ul>
			<li id="managerMainChart" style="text-align: left;"><a href="/jaju/manager/managerMainChart.jsp" class="link_lnb">홈</a></li>
			<li id="managerMainCalender" style="text-align: left;"><a href="/jaju/manager/managerMainCalender.jsp" class="link_lnb">일별조회</a></li>
		</ul>
	</li>
	<li class="lnb_admin2">
		<strong><span class="ico_admin"></span> <span class="txt_lnb">회원 관리</span></strong>
		<ul>
			<li id="managerMember" style="text-align: left;"><a href="/jaju/manager/managerMember?sortinSelect=member_date_desc" class="link_lnb">회원 관리</a></li>
			<li id="managerMemberBlack" style="text-align: left;"><a href="/jaju/manager/managerMemberBlack?sortinSelect=break_member" class="link_lnb">블랙리스트 관리</a></li>
		</ul>
	</li>
	<li class="lnb_admin3">
		<strong><span class="ico_admin"></span> <span class="txt_lnb">게시판 관리</span></strong>
		<ul>
			<li id="managerSaleboard" style="text-align: left;"><a href="/jaju/managerSaleboard/managerSaleboardList?pg=1&sale_category=*" class="link_lnb">판매게시판 관리</a></li>
			<li id="managerFreeboard" style="text-align: left;"><a href="/jaju/manager/managerFreeboardList?pg=1" class="link_lnb">자유게시판 관리</a></li>
			<li id="managerReviewboard" style="text-align: left;"><a href="/jaju/manager/managerReviewboardList?pg=1" class="link_lnb">리뷰게시판 관리</a></li>
		</ul>
	</li>
		<li class="lnb_admin4">
		<strong><span class="ico_admin"></span> <span class="txt_lnb">고객센터 관리</span></strong>
		<ul>
			<li id="managerNotice" style="text-align: left;"><a href="/jaju/manager/managerNoticeList" class="link_lnb">공지사항 관리</a></li>
			<li id="managerServiceQuestion" style="text-align: left;"><a href="/jaju/manager/managerServiceQuestion" class="link_lnb">자주묻는질문 관리</a></li>
			<li id="managerServiceInquire" style="text-align: left;"><a href="/jaju/manager/managerServiceInquire" class="link_lnb">1:1 문의 관리</a></li>
			<li id="managerReport" style="text-align: left;"><a href="/jaju/manager/managerReportList" class="link_lnb">신고게시판 관리</a></li>
		</ul>
	</li>
</ul>
</div>
</body>
</html>