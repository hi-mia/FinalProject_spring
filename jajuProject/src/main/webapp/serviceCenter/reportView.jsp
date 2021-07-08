<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/jaju/css/reportView.css" />
<jsp:include page="/serviceCenter/serviceMenu.jsp"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<form id="reportViewForm" name="reportViewForm">
<input type="hidden" id="sale_seq" name="sale_seq">
<input type="hidden" id="report_seq" name="report_seq" value="${report_seq}">
<input type="hidden" id="pg" name="pg" value="${pg}">
<div style="width: 1050px; margin: auto;" >
<div id="wrap">
<div id="pos_scroll"></div>
<div id="container" style="float:left; margin-left:40px; margin-top:-50px; width:800px;">

<div class="tit_page" style="width:800px; align:center;">
	<h1 class="tit" >신고 게시판</h1>
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
			<table class="View1" style="width:800px;">
			<tbody>
			<tr>
			<td>
				<table class="boardView" width="100%;">
				<tbody>
				<tr  style="border-top: 2px solid #47597e;">
					<th scope="row" style="border:none;">제목</th>
					<td><span id="subjectSpan"></span></td>
				</tr>
				
				<tr>
					<th scope="row">작성자</th>
					<td><span id="idSapn"></span></td>
				</tr>
				
				<tr class="etcArea">
					<td colspan="2">
						<ul style="margin-block-end: 0em; ">
							<li class="tpye">
								<strong class="th">전화번호</strong>
								<span class="td" id="talSpan"></span>
							</li>
							<li class="date ">
								<strong class="th">작성일</strong> 
								<span class="td" id="dateSpan"></span>
							</li>
						</ul>
					</td>
				</tr>
				
				<tr>
					<th scope="row" style="border-top: none; border-bottom: 1px solid #f4f4f4;">신고글 제목</th>
					<td style="border-top: none; border-bottom: 1px solid #f4f4f4;">
						<a id="sale_subject" href="#">
							<span id="sale_subjectSpan"></span>
						</a>
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
					<span id="contentSpan"></span>
				</pre>
				
				<br><br>
				<img id="imageSpan1">
				<span id="imageSpan1"></span>
				<img id="imageSpan2">
				<span id="imageSpan2"></span>
				<img id="imageSpan3">
				<span id="imageSpan3"></span>
			</td>
		</tr>
			<tr>
				<td height="1" bgcolor="#f4f4f4"></td>
			</tr>
		</tbody>
		</table>
		<br>
		
		<table class="View2" width="100%" style="table-layout:fixed" cellpadding="0" cellspacing="0">
		<tbody>
		<tr>
		<td align="center" style="padding-top:10px;">
		
		<c:if test="${memId != 'jajuadmin'}">
		<table class="View3" width="100%">
			<tbody>
				<tr>
					<td align="right">
						<a href="javascript:void(0)" onclick="mode(1)">
							<span class="reportBtn modify" style="float:none;">수정</span>
						</a>
						<a href="javascript:void(0)" onclick="mode(2)">
							<span class="reportBtn delete" style="float:none;">삭제</span>
						</a>
					</td>
				</tr>
			</tbody>
		</table>
		</c:if>
		</td>
		</tr>
		</tbody>
		</table>
		
		<div class="replyRealTotal">
			<div class="replyTotal">
			
				<table class="replyList" style="">
					
		
				</table>
			
			</div>
		</div>
		
		
		</td>
		</tr>
		</tbody>
		</table>
		<div class="listView">
			<a href="/jaju/serviceCenter/reportList">
				<span class="reportBtn list">목록</span>
			</a>
		</div>
	</div>
</div>
</div>
</div>
</div>
</div>
</div>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/jaju/js/reportView.js"></script>
</body>
</html>