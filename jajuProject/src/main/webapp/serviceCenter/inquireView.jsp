<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/jaju/css/inquireView.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:if test="${memId == 'jajuadmin' }">
<jsp:include page="/manager/managerHeader.jsp"/>
</c:if>
<form name = "inquireView" id = "inquireView">
<input type="hidden" name="seq" id = "inquiry_seq" value= "${seq}">
<input type="hidden" name="pg" value="${pg}">
<div style="width: 1050px; margin: auto;" >
<c:if test="${memId != 'jajuadmin' }">
<jsp:include page="/serviceCenter/serviceMenu.jsp"/>
</c:if>
<c:if test="${memId == 'jajuadmin' }">
<jsp:include page="/manager/managerMenu.jsp"/>
</c:if>

<div id="wrap">
<div id="pos_scroll"></div>
<div id="container" style="float:left; margin-left:40px; /* margin-top:-50px; */ width:800px;">

<div class="tit_page" style="width:800px; align:center;">
	<h3 class="tit" >1:1 문의</h3>
</div>

<div id="main">
<div id="content">

<div id="qnb" class="quick-navigation" style="top: 70px;"></div>
<div class="layout-wrapper">
	<div class="xans-element- xans-myshop xans-myshop-couponserial ">
	
		<table class="xans-board-listheader" style="width:800px; align:center;" cellpadding="0" cellspacing="0">
			<tbody>
			<tr>
			<td>
			<table style="width:800px;">
			<tbody>
			<tr>
			<td>
				<table class="boardView" width="100%;">
				<tbody>
				<tr  style="border-top: 2px solid #47597e;">
					<th scope="row" style="border:none;">제목</th>
					<td><span id = "inquiry_subject"></span></td>
				</tr>
				
				<tr>
					<th scope="row">작성자</th>
					<td><span id = "inquiry_id"></span></td>
				</tr>
				
				<tr class="etcArea">
					<td colspan="2">
					<ul style="margin-block-start: 0;">
					<li class="tpye">
						<strong class="th">전화번호</strong>
						<span class="td" id = "inquiry_telephone"></span>
					</li>
					<li class="date">
						<strong class="th">작성일</strong> 
						 <span class="td" id = "logtime"></span>
					</li>
					</ul>
					</td>
				</tr>
			</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td align="right" class="eng" style="padding:5px;"></td>
		</tr>
			<tr>
			<td style="margin:0;" height="200" valign="top" id="contents">
				<pre class="viewPre">
					<span id = "inquiry_contents"></span>
				</pre>
			<br>
			<hr>
			<img id = "inquiry_image1">
			<span id = "inquiry_image1"></span>
			<img id = "inquiry_image2">
			<span id = "inquiry_image2"></span>
			<img id = "inquiry_image3">
			<span id = "inquiry_image3"></span>
			</td>
			
		<tr>
			<td height="1" bgcolor="#f4f4f4"></td>
		</tr>
		</tbody>
		</table>
		<br>
		
		<table width="100%" style="table-layout:fixed" cellpadding="0" cellspacing="0">
		<tbody>
		<tr>
		<td align="center" style="padding-top:10px;">
		
		<table width="100%">
			<tbody>
				<tr>
					<td align="right">
						<a href="/jaju/manager/managerInquireReplyForm?seq=${seq }&pg=${pg}">
						<c:if test="${memId == 'jajuadmin' }">
							<span class="inquireBtn reply" style="float:none;">답글</span>
						</c:if>
						</a>
						<a href="javascript:void(0)" onclick ="mode(1)" >
						<c:if test="${memId != 'jajuadmin' && inquiry_id != '관리자'}">
							<span class="inquireBtn modify" style="float:none;">수정</span>
						</c:if>
						</a>
						<a href="javascript:void(0)" onclick ="mode(2)">
						<c:if test="${memId != 'jajuadmin' && inquiry_id != '관리자'}">
							<span class="inquireBtn delete" style="float:none;">삭제</span>
						</c:if>
						</a>
						<a href="/jaju/serviceCenter/inquireList">
						<c:if test="${memId != 'jajuadmin' }">
							<span class="inquireBtn list" style="float:none;">목록</span>
						</c:if>
						</a>
						<a href="/jaju/manager/managerServiceInquire">
						<c:if test="${memId == 'jajuadmin' }">
							<span class="inquireBtn list" style="float:none;">목록</span>
						</c:if>
						</a>
					</td>
				</tr>
			</tbody>
		</table>
		</td>
		</tr>
		</tbody>
		</table>
		
		
		</td>
		</tr>
		</tbody>
		</table>
	</div>
</div>
</div>
</div>
</div>
</div>
</div>
</form>
<script type = "text/javascript" src = "http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/jaju/js/inquireView.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	
	$('#type3').addClass('on');
});
</script>
</body>
</html>