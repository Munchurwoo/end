<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-hover">


<c:forEach items="${qavo}" var="qavo"><tr><td>질문 : ${qavo.question }<br>답 : ${qavo.answer }<br><br></td></tr></c:forEach>


</table>

${qavo }
