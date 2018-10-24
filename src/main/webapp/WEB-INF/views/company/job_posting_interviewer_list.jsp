<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h4 class="heading">
	<div class="cta-text">
		<h2>
			<span>GoodJob</span> 인재 정보
		</h2>
	</div>
</h4>

<c:forEach items="${requestScope.ivvoList}" var="ivvo">
	<c:set value="${ivvo.normalMemberVO }" var="nmvo" />
	<div class="media">
		<a class="pull-left" href="#">
			<c:forEach items="${requestScope.mapList }" var="map">
				<c:if test="${nmvo.id == map.id }">
					<img class="media-object" src="${pageContext.request.contextPath }/resources/upload/memberPicture/${map.picturePath}" width="145px" height="145px">
				</c:if>
			</c:forEach>
		</a>
		<div class="media-body">
			<h4 class="media-heading">${nmvo.name}</h4>
			<h5>${ivvo.title}</h5>
			<h6>${ivvo.content}</h6>
			<!-- Nested media object -->
			<div class="media-object">
				<c:forEach items="${requestScope.mapList }" var="map">
					<c:if test="${nmvo.id == map.id && !empty map.dcnameList }">
						개발분야 : <c:out value="${map.dcnameList }" />
					</c:if>
				</c:forEach>
				<br><a href="user-normalDetailPortfolioList.do?normalId=${nmvo.id }"> 인재 상세보기 </a>
			</div>
		</div>
	</div>
	<hr>
</c:forEach>
