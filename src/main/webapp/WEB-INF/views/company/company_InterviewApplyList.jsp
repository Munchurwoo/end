<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>면접신청자 목록 interviewerList에서 타이틀 컨텐트 등등 정보 받아와야함</h3>
<div class="container">
<table class="table table-bordered">
	<thead>	
	<tr>
	<h4>${jpvo.jobPostingVO.content}</h4>
	</tr>
	</thead>
	<tbody>
	
	</tbody>
	</table>
	</div>

<!-- 181020 MIRI 세션에 있는 회원이 직접 올린 구인 공고 글이면 면접 신청자 리스트를 볼 수 있음 (작억중) -->
	<c:if test="${sessionScope.mvo.id == requestScope.jpvo.companyId}">
		<form action="getJobPostingInterviewerList.do?jobPostingNum=${requestScope.jpvo.jobPostingVO.jobPostingNum}" method="post">
			<input type="submit" value="면접 신청자 리스트">
		</form>
		<form action="getJobPostingQAList.do?jobPostingNum=${requestScope.jpvo.jobPostingVO.jobPostingNum}" method="post">
			<input type="submit" value="구인 공고 질답 리스트">
		</form>
	</c:if>

