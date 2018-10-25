<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

<table class="table table-bordered">
<tbody>
<tr>
	<th>접수번호</th><th>제목</th><th>접수자</th>	
</tr>
<c:forEach items="${requestScope.interviewerList}" var="ivList">
<tr>
<td>${ivList.interviewNum}${ivList.jobPostingNum}</td>
<td><a href="normalDetailPortfolio.do?jobPostingNum=${ivList.interviewNum}${ivList.jobPostingNum}&normalId=${ivList.normalMemberVO.id}&companyId=${ivList.companyId}">${ivList.title}</a></td>
<td>${ivList.normalMemberVO.name}</td>
</tr>
</c:forEach>
</tbody>	
</table>
</div>
