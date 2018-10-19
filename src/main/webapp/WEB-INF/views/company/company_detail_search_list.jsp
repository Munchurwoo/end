<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--Controller에서 받아온 기업정보리스트를 아래 div 구간에 정보들을 집어 넣고 반복문을 돌려보기  --%>	
			<c:forEach items="${requestScope.cmvoList}" var="cmvo">
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
			
		</div>
	</div>
</div>