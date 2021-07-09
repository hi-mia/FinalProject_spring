<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/jaju/css/noticeList.css" />
</head>
<body>
<div style="width: 1050px; margin: auto;" >
<jsp:include page="/serviceCenter/serviceMenu.jsp"/>
<input type="hidden" id="searchHidden" name="searchHidden">
<input type="hidden" id="notice_seq" name="notice_seq" value="${notice_seq}">
<input type="hidden" id="pg" value="${pg}">

<div id="formTotal" style="min-height: 550px;">
<div class="head_aticle" padding-left="10px">
	<h2 class="tit">공지사항 </h2>
</div>
<div id="totalDiv">
	<table id="noticeListTable" class="xans-board-listheader jh" cellpadding="0" cellspacing="0" style="width: 800px; table-layout: fixed;">
		<thead>
			<tr>
				<th class="th1" style="width: '80px'; align: 'center';">번호</th>
				<th class="th2" style="width: '570px';">제목</th>
				<th class="th3" style="width: '150px'; align: 'center';">작성일</th>
			</tr>
			
		</thead>
		
		<tr class="no_data">
			<td colspan="19" class="no_article" style="margin-bottom: 57px;">공지 글이 존재하지 않습니다.</td>
			
		</tr>
</table>
</div>
<div style="padding: 1px; border-top: 1px solid #e6e6e6"></div>
<div class="layout-pagination" style="font-size:12px;">
	<div class="pagediv"></div>
</div>

<form id="noticeList" name="noticeList">
<input type="hidden" name="pg" class="pg" value="1">
<div id="totalSearch">
	<table class="xans-board-search xans-board-search2">
	
	<tbody>
	<tr>
		<td class="input_txt">&nbsp;</td>
		<td>
		<br>
			<div class="search" style="float: right">
				<select id="itemcd" name="itemcd" width="100px" >
					<option value="notice_subject">&nbsp;&nbsp;&nbsp;&nbsp;제목&nbsp;&nbsp;&nbsp;&nbsp;</option>
					<option value="notice_content">&nbsp;&nbsp;&nbsp;&nbsp;내용&nbsp;&nbsp;&nbsp;&nbsp;</option>
				</select>
					<a id="searchBtn" style="cursor: pointer;">
						<img src="/jaju/jajuImage/search.png">
					</a>
				<input type="text" id="keyword" name="keyword" value="${keyword}" style="font-size:14px;">
			</div>
		</td>
	</tr>
	</tbody>
	</table>
	<br>
</div>

</form>
</div>
</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/jaju/js/noticeList.js"></script>
</body>
</html>