<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:choose>
		<c:when test="${sessionScope.mvo==null}">
		</c:when>
		<c:otherwise>
<div class="cta-text" >
	<h2>
		<span>GoodJob </span>면접 신청
	</h2>
</div>
<div>
			<form action="submitInterviewForm.do" style="margin-left: 235px;">
				<input type="hidden" name="jobPostingNum" value="${requestScope.jobPosting.jobPostingNum}">
				<input type="hidden" name="companyId" value="${requestScope.jobPosting.companyId}">
				<input type="hidden" name="normalId" value="${sessionScope.mvo.id}"> <br>
				제목 <input
					type="text" name="title" placeholder="제목을 입력하세요."
					required="required" style=" height: 27px;  width: 604px;"> <br>
				<br> 내용<br>
				<textarea rows="15" cols="89" name="content"
					placeholder="내용을 입력하세요">
				
				</textarea>
				<br>
				<br> <input type="submit" value="면접신청하기">
			</form>
</div>
		</c:otherwise>
	</c:choose>

</body>
</html>