<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center" id="indexHeader">
		<jsp:include page="/manager/managerHeader.jsp" />
		<jsp:include page="/manager/managerMenu.jsp" />
	</div>
	
	<div width="800" heigth="400" style="margin-top: 450px; margin-left: 300px;">
		바디 관리자 페이지에서 처음 보여줘야하는 것들
		헤더와 메뉴는 모든 관리자 페이지에서 인클루드한다.(풋터도 일단은 인클루드한다.)
	</div>
	
	<div id="footer">
		<jsp:include page="/main/footer.jsp" />
	</div>		

</body>
</html>