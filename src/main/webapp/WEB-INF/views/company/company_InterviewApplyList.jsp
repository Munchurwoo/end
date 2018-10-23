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
<td>${ivList.interviewNum}</td>
<td><a href="normalDetailPortfolio.do?normalId=${ivList.normalMemberVO.id}">${ivList.title}</a></td>
<td>${ivList.normalMemberVO.name}</td>
</tr>
</c:forEach>
</tbody>	
</table>
</div>
포트폴리오 상세보기로 보내낼때 사진경로 불러오기 추가해야함
