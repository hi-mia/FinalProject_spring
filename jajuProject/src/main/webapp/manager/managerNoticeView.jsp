<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="/jaju/css/noticeView.css" />

<jsp:include page="/manager/managerHeader.jsp"/>
<div style="width: 1050px; margin: auto;" >
<jsp:include page="/manager/managerMenu.jsp"/>
<form id="ManagerNoticeView" name="ManagerNoticeView">
<input type="hidden" id="notice_seq" name="notice_seq" value="${notice_seq}">
<input type="hidden" id="pg" name="pg" value="${pg}">
<div id="wrap" style="width:1080px; margin-top: 60px;">
<div id="pos_scroll"></div>
<div id="container" style="float:left; margin-left:40px; margin-top:-50px; width:800px;">

<div class="tit_page" style="width:800px; align:center;">
	<h1 class="tit" >공지사항</h1>
</div>

<div id="main">
<div id="content"">

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
		<table class="boardView" style="width:800px; font-size:14px;">
			<tbody>
				<tr>
					<th scope="row" style="border:none;">제목</th>
					<td><span id="subjectSpan"></span></td>
				</tr>
				<tr>
					<th scope="row">작성일</th>
					<td><span class="td" id="dateSpan"></span></td>
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
				<img id="imageSpan0">
				<span id="imageSpan0"></span>
				<img id="imageSpan1">
				<span id="imageSpan1"></span>
				<img id="imageSpan2">
				<span id="imageSpan2"></span>
				<img id="imageSpan3">
				<span id="imageSpan3"></span>
				<img id="imageSpan4">
				<span id="imageSpan4"></span>
				<img id="imageSpan5">
				<span id="imageSpan5"></span>
				<img id="imageSpan6">
				<span id="imageSpan6"></span>
				<img id="imageSpan7">
				<span id="imageSpan7"></span>
				<img id="imageSpan8">
				<span id="imageSpan8"></span>
				<img id="imageSpan9">
				<span id="imageSpan9"></span>
			</td>
		</tr>
			
			
			
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
						
						<input type="button" id="noticeModifyBtn" value="수정">
						<!-- <a href="javascript:void(0)" onclick ="mode(1)" >
							<span class="noticeBtn modify" style="float:none;">수정</span>
						</a> -->
					
						<a href="/jaju/manager/managerNoticeList">
							<span class="noticeBtn list" style="float:none;">목록</span>
						</a>
					</td>
				</tr>
			</tbody>
		</table>
		</td>
		</tr>
		</tbody>
		</table>
		
		
		<div class="xans-element- xans-board xans-board-movement-1002 xans-board-movement xans-board-1002 " style="width: 800px;">
			<ul>
				<li class="prev">
					<strong>이전글</strong>
					<a id="prevBtn">
						<span class="prev" id="prevSpan"></span>
					</a>
				</li>
				<li class="next">
					<strong>다음글</strong>
					<a id="nextBtn">
						<span class="next" id="nextSpan"></span>
					</a>
				</li>
			</ul>
		</div>
		<br>
		<table width="100%" cellpadding="5" cellspacing="0">
			<colgroup>
				<col width="100" align="right" bgcolor="#f7f7f7" style="padding-right:10px">
				<col style="padding-left:10px">
			</colgroup>
		</table>
		<p>
		<br>
		<textarea id="examC_924" style="display:none;width:100%;height:300px"></textarea>
		</p>
		
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
</form>
</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/jaju/manager_js/managerNoticeView.js"></script>