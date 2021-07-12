<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/jaju/manager_css/managerQuestionView.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/manager/managerHeader.jsp"/>
<form name = "managerQuestionView" id = "managerQuestionView">
<input type="hidden" name="question_seq" id = "question_seq" value= "${seq}">
<input type="hidden" name="pg" value="${pg}">
<div style="width: 1050px; margin: auto;" >

<jsp:include page="/manager/managerMenu.jsp"/>


<div id="wrap">
<div id="pos_scroll"></div>
<div id="container" style="float:left; margin-left:40px; /* margin-top:-50px; */ width:800px;">

<div class="tit_page" style="width:800px; align:center;">
	<h3 class="tit"style="font-size: 31px; color: #333; " >자주 하는 질문</h3>
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
					<td><span id = "question_subject"></span></td>
				</tr>
				
				<tr>
					<th scope="row">작성일</th>
					<td><span class="td" id = "logtime"></span></td>
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
					<span id = "question_contents"></span>
				</pre>
			<br>
			<hr>
			<img id = "question_image1">
			<span id = "question_image1"></span>
			<img id = "question_image2">
			<span id = "question_image2"></span>
			<img id = "question_image3">
			<span id = "question_image3"></span>
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
						<a href="javascript:void(0)" onclick ="mode(1)" >
							<span class="questionBtn modify" style="float:none;">수정</span>
						</a>
						<a href="/jaju/manager/managerServiceQuestion">
							<span class="questionBtn list" style="float:none;">목록</span>
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
<script src="/jaju/manager_js/managerQuestionView.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	
	$('#managerServiceQuestion').addClass('on');
});
</script>
</body>
</html>