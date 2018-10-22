<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="jobPostingList"  value="${postListVO.jobPostingList}"></c:set>
<c:set var="pb"  value="${postListVO.pagingBean}"></c:set>

<%--Controller에서 받아온 기업정보리스트를 아래 div 구간에 정보들을 집어 넣고 반복문을 돌려보기  --%>	
			<c:forEach items="${jobPostingList}" var="cmvo">
			<div class="col-lg-3">
				<div class="box">
					<div class="box-gray aligncenter">
						<h4>${cmvo.jobPostingVO.title}</h4>
						<div class="icon">
							<i class="fa fa-desktop fa-3x"></i>
						</div>
						<p></p>

					</div>
					<div class="box-bottom">
						<a href="job_posting_detail.do?jobPostingNum=${cmvo.jobPostingVO.jobPostingNum}">채용정보 확인하기</a>
					</div>
				</div>
			</div>
			</c:forEach>
			
			<div align="center">
			<ul class="pagination">
				<c:if test="${pb.previousPageGroup }">
					<li><a
						href="${pageContext.request.contextPath}/user-company_detail_search_list.do?pageNum=${pb.startPageOfPageGroup-1}">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${pb.startPageOfPageGroup}"
					end="${pb.endPageOfPageGroup}" var="pagenum">
					<c:choose>
						<c:when test="${pagenum==pb.nowPage}">
							<li class="active"><a href="#">${pagenum}</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.request.contextPath}/user-company_detail_search_list.do?pageNum=${pagenum}">${pagenum}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>				
				<c:if test="${pb.nextPageGroup }">
					<li><a
						href="${pageContext.request.contextPath}/user-company_detail_search_list.do?pageNum=${pb.endPageOfPageGroup+1}">&raquo;</a></li>
				</c:if>
			</ul>
		</div>	
			
		