<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="/jaju/css/reportView.css" />

<jsp:include page="/manager/managerHeader.jsp"/>

<div style="width: 1080px; margin: auto;">
<form id="managerReportView" name="managerReportView">
<jsp:include page="/manager/managerMenu.jsp"/>
<input type="hidden" id="sale_seq" name="sale_seq">
<input type="hidden" id="sale_id" name="sale_id">
<input type="hidden" id="member_warning" name="member_warning">
<input type="hidden" id="report_seq" name="report_seq" value="${report_seq}">
<input type="hidden" id="comment_seq" name="comment_seq" value="${comment_seq}">
<input type="hidden" id="pg" name="pg" value="${pg}">

<div id="wrap" style="float: left; margin-top: 50px;">
<div id="pos_scroll"></div>
<div id="container" style="float:left; margin-left:40px; margin-top:-50px; width:800px;">

<div class="tit_page" style="width:800px; align:center;">
	<h1 class="tit" style="margin-bottom: 20px;">신고 게시판</h1>
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
						<ul style="margin-block-start: 0em; margin-block-end: 0em;">
							<li class="tpye ">
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
					<th scope="row" style="border-bottom: 1px solid #f4f4f4;">신고글 제목</th>
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
		
		
		
		<div class="replyRealTotal">
		<div class="replyTotal">
		
		<table class="replyList" style="">
			<!-- <tbody>
				<tr>
					<td class="contnet">
						안녕하세요
						<br><br><br><br><br><br><br><br>
					</td>
				</tr>
				<tr>
					<td class="date" style="text-align:right; border-top: 1px solid #333;">
						2021.06.21
					</td>
				</tr>
				
				<tr>
					<td style="align: right;">
						<a href="javascript:void(0)" onclick="mode(4)">
							<span class="reportBtn comModify" style="float:none;">수정</span>
						</a>
						<a href="javascript:void(0)" onclick="mode(5)">
							<span class="reportBtn comDelete" style="float:none;">삭제</span>
						</a>
					</td>
				</tr>
			</tbody> -->
		</table>
		
		<table class="reply">
			<tbody>
				<tr>
					<td>
					<textarea id="comment_content" name="comment_content" placeholder="댓글을 입력하세요"></textarea>
					<div id="commentDiv"></div>
					</td>
				</tr>
			
				<tr>
					<td style="text-align: left; font-size: 13px; width: 630px; display:inline-block;">
						- 보이기 버튼을 누르면 신고된 글이 다시 보여집니다. <br>
						- 원글 삭제 버튼을 누르면 신고 누적횟수가 +1 됩니다.
					</td>
					<td style="align: right; display:inline-block; margin-top: 10px;">
						<input type="button" class="reportBtn show" value="보이기">
						<input type="button" class="reportBtn hide" value="원글삭제">
					</td>
				</tr>
			</tbody>
		</table>
		
		<table class="replyModify">
			<tbody>
				<tr>
					<td>
					<textarea id="comment_content" name="comment_content" class="comment_content" placeholder="댓글을 입력하세요"></textarea>
					<div id="commentDiv" class="commentDiv"></div>
					</td>
				</tr>
			
				<tr>
					<td align="right">
						<input type="button" class="reportBtn comReWrite" value="저장">
						<%-- <a href="javascript:void(0)" onclick="mode(6,${param.comment_seq})">
							<span class="reportBtn comReWrite" style="float:none;">저장</span>
						</a> --%>
					</td>
				</tr>
			</tbody>
		</table>
		
		
		
		</div>
		</div>
		</tbody>
		</table>
		<div class="listView">
			<a href="/jaju/manager/managerReportList">
				<span class="reportBtn list">목록</span>
			</a>
		</div>
	</div>
</div>
</div>
</div>
</div>
</div>
</form>
</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/jaju/manager_js/managerReportView.js"></script>