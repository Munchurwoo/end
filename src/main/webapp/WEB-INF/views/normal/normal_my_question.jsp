<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-hover">

<h4 class="heading">
	<div class="cta-text">
		<h2>
			<span>GoodJob</span> 나의 질문 모두 보기
		</h2>
	</div>
</h4>	

<c:forEach items="${qavo}" var="qavo"><tr><td>질문 : ${qavo.question }<br>답 : ${qavo.answer }<br><br></td></tr></c:forEach>


</table>

${qavo }
