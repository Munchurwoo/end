<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
	<div class="col-lg-12">
		<div class="row">
			<h4 class="heading">
				<div class="cta-text">
					<h2>
						<span>GoodJob</span>
					</h2>
				</div>
			</h4>
<c:set var="cmvoList"  value="${postListVO.cmvoList}"></c:set>
<c:set var="pb"  value="${postListVO.pagingBean}"></c:set>

<%-- ${postListVO.cmvoList}
${postListVO.pagingBean} --%>

<%--Controller에서 받아온 기업정보리스트를 아래 div 구간에 정보들을 집어 넣고 반복문을 돌려보기  --%>	
				<c:forEach items="${cmvoList}" var="cmvo">
				<div class="col-lg-3">
					<div class="box">	
						<div class="box-gray aligncenter">
							<h4>${cmvo.name}</h4>
							<div class="icon">
								<i class="fa fa-desktop fa-3x"></i>
								${cmvo.picturePath}
							</div>
							<p>${cmvo.introduction}</p>
	
						</div>
						<div class="box-bottom">
							<a href="user-detailCompanyInfo.do?companyId=${cmvo.companyId}">기업정보 자세히보기</a>
						</div>
					</div>					
				</div>
				<!-- <div class="col-lg-1">
				</div> -->
				</c:forEach>	
		</div>
	</div>
	<div class="col-lg-12">
		<div align="center">
			<ul class="pagination">
				<c:if test="${pb.previousPageGroup }">
					<li><a
						href="${pageContext.request.contextPath}/user-allCompanyInfo.do?pageNum=${pb.startPageOfPageGroup-1}">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${pb.startPageOfPageGroup}"
					end="${pb.endPageOfPageGroup}" var="pagenum">
					<c:choose>
						<c:when test="${pagenum==pb.nowPage}">
							<li class="active"><a href="#">${pagenum}</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.request.contextPath}/user-allCompanyInfo.do?pageNum=${pagenum}">${pagenum}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>				
				<c:if test="${pb.nextPageGroup }">
					<li><a
						href="${pageContext.request.contextPath}/user-allCompanyInfo.do?pageNum=${pb.endPageOfPageGroup+1}">&raquo;</a></li>
				</c:if>
			</ul>
		</div>	
	</div>	
</div>