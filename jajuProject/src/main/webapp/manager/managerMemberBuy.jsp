<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jaju/manager_css/managerMemberSaleList.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
</head>
<body>
<input type="hidden" id="id" name="id" value="${id}">	
<input type="hidden" id="pg" name="pg" value="${pg}">
<jsp:include page="/manager/managerMemberHistory.jsp" />

<div style="margin-top: 100px;">
		<table id="historyTable" style="text-align-last: left;"></table>
		</div>
		<div style="margin: 0px; text-align: center;"
			id="memberBuyListPageDiv"></div>
<script type="text/javascript"
		src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/jaju/manager_js/managerMemberBuy.js"></script>
<script type="text/javascript">
function myBuyPaging(pg){
		//alert($('#id').val())
		location.href="managerMemberBuy?id="+$('#id').val()+"&pg="+pg;
		
	
	};		
</script>	
</body>
</html>