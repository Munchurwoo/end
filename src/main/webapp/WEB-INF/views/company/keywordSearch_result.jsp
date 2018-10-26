<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="jobPostingList"  value="${requestScope.jobPostingList2.jobPostingList}"></c:set>
<c:set var="pb" value="${requestScope.jobPostingList2.pagingBean}"></c:set>
<%--Controller에서 받아온 기업정보리스트를 아래 div 구간에 정보들을 집어 넣고 반복문을 돌려보기  --%>	
		
		<c:choose>
			<c:when test="${empty jobPostingList}">
			<div>
			<span align="center">
				<h3>'${requestScope.searchText}' &nbsp;검색 결과가 없습니다.</h3>
			</span>
			</div>
			</c:when>
			<c:otherwise>
			<c:forEach items="${jobPostingList}" var="jobList">
			<div class="col-lg-3">
				<div class="box">
					<div class="box-gray aligncenter">
						<h4>${jobList.jobPostingVO.title}</h4>
						<div class="icon">
							<i class="fa fa-desktop fa-3x"></i>
						</div>
						<p></p>

					</div>
					<div class="box-bottom">
						<a href="job_posting_detail.do?jobPostingNum=${jobList.jobPostingVO.jobPostingNum}">채용정보 확인하기</a>
					</div>
				</div>
			</div>
			</c:forEach>
			<div class="col-lg-12">
		<div align="center">
			<ul class="pagination">
				<c:if test="${pb.previousPageGroup }">
					<li><a
						href="${pageContext.request.contextPath}/user-findJobPostingByTitle.do?searchType=${requestScope.searchType}&searchText=${requestScope.searchText}&pageNum=${pb.startPageOfPageGroup-1}">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${pb.startPageOfPageGroup}"
					end="${pb.endPageOfPageGroup}" var="pageNum">
					<c:choose>
						<c:when test="${pageNum==pb.nowPage}">
							<li class="active"><a href="#">${pageNum}</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.request.contextPath}/user-findJobPostingByTitle.do?searchType=${requestScope.searchType}&searchText=${requestScope.searchText}&pageNum=${pageNum}">${pageNum}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>				
				<c:if test="${pb.nextPageGroup }">
					<li><a
						href="${pageContext.request.contextPath}/user-findJobPostingByTitle.do?searchType=${requestScope.searchType}&searchText=${requestScope.searchText}&pageNum=${pb.endPageOfPageGroup+1}">&raquo;</a></li>
				</c:if>
			</ul>
		</div>	
	</div>	
			
			</c:otherwise>
		</c:choose>
		
			
