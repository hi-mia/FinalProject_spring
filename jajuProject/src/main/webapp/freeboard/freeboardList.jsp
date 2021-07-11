<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="/jaju/css/freeboardList.css" />

<input type="hidden" name="id" value="freeboard">

<div id="total" style="width:1100px; margin:0 auto; ">
<div id="formTotal" style="width:1000px; display:inline-block; float:left;  margin-top: 86px;">
<div class="head_aticle" padding-left="10px">
	<h2 class="tit" style="color: #333;">자유게시판 </h2>
</div>
<br>
<div id="totalDiv">
	<table id="freeboardListTable" style="width:1000px" class="xans-board-listheader jh" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th width="8%">번호</th>
				<th>제목</th>
				<th width="12%">작성자</th>
				<th width="12%">작성일</th>
				<th width="8%">조회수</th>
			</tr>
		</thead>
	<tbody>

</tbody>
</table>
</div>

<br><br>

<div id="totalSearch">


	<table class="xans-board-search xans-board-search2">
	<tbody>
	
	<tr>
		<td class="input_txt">
				
				
			<div style="position:relative">
		<div style="position:absolute;right:0;top:60px;">
		
			<c:if test="${memId != null}">
				<a href="/jaju/freeboard/freeboardWriteForm" id="freeboard_write_a">
					<span class="bhs_buttonsm yb" style="float:none; margin-top:10px;">글쓰기</span>
				</a>
			</c:if>
			
		</div>
	</div>				
				
		<form name="boardSearchList" id="boardSearchList"> <!-- 이전 form name: frmList -->
			
				<!-- 페이징 -->
<div id="freeboardpagingDiv" class="freeboardPagingDiv" align="center">
				
</div>
<br>
			<div class="search" align="right" style="margin-top:100px; margin-bottom:50px;">
			
				<select name="searchOption" id="searchOption" width="100px" align="absmiddle">
					<option value="board_subject">&nbsp;&nbsp;&nbsp;&nbsp;제목&nbsp;&nbsp;&nbsp;&nbsp;</option>
					<option value="board_content">&nbsp;&nbsp;&nbsp;&nbsp;내용&nbsp;&nbsp;&nbsp;&nbsp;</option>
					<option value="board_id">&nbsp;&nbsp;&nbsp;&nbsp;작성자&nbsp;&nbsp;&nbsp;&nbsp;</option>
				</select>	
				<input type="text" name="keyword" id="keyword" required="" align="absmiddle">
				
				<input type="image" src="/jaju/jajuImage/search.png" id="boardSearchBtn" align="absmiddle">

			</div>			
			<input type="hidden" name="pg" id="pg" value="${param.pg }">
			<input type="hidden" name="searchPg" id="searchPg" value="1">	
			<input type="hidden" name="search" id="search">

		</form>
		</td>
	</tr>
	</tbody>
	</table>
	<br>

</div>
</div>
</div>

<input type="hidden" id="board_id" value="${sessionScope.memId }"/>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/jaju/js/freeboardList.js"></script>
<script type="text/javascript">

function freeboardPaging(pg){
	var boardSearchText = document.getElementById('keyword').value;
	
	if($('#search').val() == ''){
		location.href = '/jaju/freeboard/freeboardList?pg='+pg;
	} else{
		$('#searchPg').val(pg);
		$('#keyword').val($('#search').val());
		$('#boardSearchBtn').trigger('click','research');
		//location.href = 'boardSearch?pg='+pg+'&select='+$('#select option:selected').val() +'&keyword='+$('#keyword').val();
		//encodeURIComponent('${keyword}');
		$('#searchPg').val(1);
	}	 	
}

</script>
