<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4 class="heading">
	<div class="cta-text">
		<h2>
			<span>GoodJob</span> 인재 정보
		</h2>
	</div>
</h4>

<%-- 	<c:when test="${empty povo }">
		<div class="media">
			<a class="pull-left" href="#"> 
			<img class="media-object" src="${pageContext.request.contextPath}/
				resources/upload/memberPicture/" width="130px" height="130px">
			</a>
			<div class="media-body">
				<h4 class="media-heading">${ivvo.normalMemberVO.name}</h4>
				<h5>${ivvo.title}</h5>
				<h6>${ivvo.content}</h6>
				<!-- Nested media object -->
				<div class="media">
					<a href="user-normalDetailPortfolioList.do?normalId=${ivvo.normalMemberVO.id }"></a>
				</div>
			</div>
		</div>
		<hr>	
	</c:when> --%>
<c:forEach items="${requestScope.ivvoList}" var="ivvo">
	<c:forEach items="${requestScope.povoList }" var="povo">
		<c:choose>
			<c:when test="${empty povo }">
				<div class="media">
					<a class="pull-left" href="#">
					<img class="media-object" src="${pageContext.request.contextPath}/resources/upload/memberPicture/"
						width="130px" height="130px">
					</a>
					<div class="media-body">
						<h4 class="media-heading">${ivvo.normalMemberVO.name}</h4>
						<h5>${ivvo.title}</h5>
						<h6>${ivvo.content}</h6>
						<!-- Nested media object -->
						<div class="media">
							<a href="user-normalDetailPortfolioList.do?normalId=${ivvo.normalMemberVO.id }"></a>
						</div>
					</div>
				</div>
				<hr>
			</c:when>
			<c:otherwise>
				<div class="media">
					<a class="pull-left" href="#">
					<img class="media-object" src="${pageContext.request.contextPath}/ resources/upload/memberPicture/${povo.picturePath}"
						width="130px" height="130px">
					</a>
					<div class="media-body">
						<h4 class="media-heading">${ivvo.normalMemberVO.name}</h4>
						<h5>${ivvo.title}</h5>
						<h6>${ivvo.content}</h6>
						<!-- Nested media object -->
						<div class="media">
							<a href="user-normalDetailPortfolioList.do?normalId=${ivvo.normalMemberVO.id }">
								포트폴리오 : ${povo.title} -> 인재상세 보기
							</a>
						</div>
					</div>
				</div>
				<hr>
			</c:otherwise>
		s</c:choose>
	</c:forEach>
</c:forEach>
<%-- <c:forEach items="${requestScope.povoList }" var="povo">
	<div class="media">
		<a class="pull-left" href="#"> 
		<img class="media-object" src="${pageContext.request.contextPath}/
			resources/upload/memberPicture/${povo.picturePath}" width="130px" height="130px">
		</a>
		<div class="media-body">
			<h4 class="media-heading">${ivvo.normalMemberVO.name}</h4>
			<h5>${ivvo.title}</h5>
			<h6>${ivvo.content}</h6>
			<!-- Nested media object -->
			<div class="media">
				<a href="user-normalDetailPortfolioList.do?normalId=${ivvo.normalMemberVO.id }">
					포트폴리오 : ${povo.title} -> 인재상세 보기 </a>
			</div>
		</div>
	</div>
	<hr>
</c:forEach> --%>