<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet" href="/jaju/css/boardMenu.css" />
<style type="text/css">
#snb .list_menu li .type{
	background: #fafafa url(https://res.kurly.com/pc/ico/2008/ico_arrow_6x11_on.svg) no-repeat 174px 52%;
    background-size: 6px 11px;
    font-weight: 700;
    color: #47597e;
}
</style>

	<c:if test="${memId == null}">
		<div class="page_aticle aticle_type2">
		</div>
	</c:if>	

	<c:if test="${memId != null}">
		<div class="page_aticle aticle_type2">
			<div id="snb" class="snb_cc">
				<h2 class="tit_snb">게시판</h2>
				<div class="inner_snb">
					<ul class="list_menu">
						<li id="type1">
							<a id="type" style="padding-left: 0; font-weight: bold;" class="type1" href="#">자유 게시판</a>
						</li>
						<li id="type2">
							<a id="type" style="padding-left: 0;" class="type2" href="/jaju/freeboard/freeboardList?pg=1">목록보기</a>
						</li>
						<li id="type3">
							<a id="type" style="padding-left: 0;" class="type3" href="/jaju/freeboard/freeboardWriteForm">글쓰기</a>
						</li>
						<li id="type4">
							<a id="type" style="padding-left: 0; font-weight: bold;" class="type4" href="#">후기 게시판</a>
						</li>
						<li id="type5">
							<a id="type" style="padding-left: 0;" class="type5" href="/jaju/reviewboard/reviewboardList?pg=1">목록보기</a> <!-- pg값 주기 -->
						</li>
						<li id="type6">
							<a id="type" style="padding-left: 0;" class="type6" href="/jaju/reviewboard/review_saleReport?pg=1">글쓰기</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</c:if>	