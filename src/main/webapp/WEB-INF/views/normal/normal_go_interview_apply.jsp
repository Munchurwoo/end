<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${sessionScope.mvo==null}">
		</c:when>
		<c:otherwise>
			<form action="submitInterviewForm.do?id=normalId" method="post">
				<input type="hidden" name="jobPostingNum" value="${requestScope.jobPostingNum}">
				<input type="hidden" name="normalId" value="${sessionScope.mvo.id}"> 제목 <input
					type="text" name="title" placeholder="제목을 입력하세요."
					required="required"> <br>
				<br> 내용
				<textarea rows="15px" cols="100" name="content"
					placeholder="내용을 입력하세요">
				
				</textarea>
				<br>
				<br> <input type="submit" value="면접신청하기">
			</form>
		</c:otherwise>
	</c:choose>

</body>
</html>