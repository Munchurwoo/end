<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){	
	$("#detail").hide();
	var jobPostingNum=${jpvo.jobPostingVO.jobPostingNum};
	$("#registerQuestionBtn").click(function(){
		 $.ajax({
		type:"get",
		url:"registerQuestion.do",
		data:"question="+$("#questionArea").val()+"&jobPostingNum="+jobPostingNum,
		success:function(result) {
			$("#questionArea").val("");
			document.location.reload();
				}	
			})//ajax 
		})//click	
		$("#questionTable").click(function(){
			$("#detail").toggle();
		})
	})//ready
</script>
<h3>${jpvo.jobPostingVO.title }</h3>
<div class="container">
<table class="table table-bordered">
	<thead>	
	<tr>
	<h4>${jpvo.jobPostingVO.content}</h4>
	</tr>
	</thead>
	<tbody>
	
	<tr>
	<th>모집직군</th>
	<td>
	<c:forEach items="${recruitCatList}" var="recruitCatList">
		${recruitCatList.rcName}&nbsp;/&nbsp;
	</c:forEach>
	</td>
	</tr>
	
	<tr>
	<th>개발분야</th>
	<td>
	<c:forEach items="${devCatList }" var="devCatList">
		${devCatList.devCatName}&nbsp;/&nbsp;
	</c:forEach>
	</td>
	</tr>
	
	<tr>
	<th>고용형태</th>
	<td>
	<c:forEach items="${empTypeCatList}" var="empTypeCatList">
		${empTypeCatList.empTypeName }&nbsp;/&nbsp;
	</c:forEach>
	</td>
	</tr>
	
	<tr>
	<th>근무지역</th>
	<td>
	<c:forEach items="${locCatList }" var="locCatList">
		${locCatList.locName }&nbsp;/&nbsp;
	</c:forEach>
	</td>
	</tr>
	<tr>
	<th>학력</th>
	<td>
	<c:forEach items="${acaCatList }" var="acaCatList">
		${acaCatList.academicName }&nbsp;/&nbsp;
	</c:forEach>
	</td>
	</tr>
	
	<tr>
	<th>회사명</th>
	<td>
	${jpvo.name }
	</td>
	</tr>
	
	<tr>
	<th>회사소개</th>
	<td>
	${jpvo.introduction }
	</td>
	</tr>
	
	<tr>
	<th>업종</th>
	<td>
	${jpvo.industry }
	</td>
	</tr>

	<tr>
	<th>매출액</th>
	<td>
	${jpvo.sales } 만원
	</td>
	</tr>
	
	<tr>
	<th>설립일</th>
	<td>
	${jpvo.dateOfEstablishment }
	</td>
	</tr>
	
	<tr>
	<th>사원수</th>
	<td>
	${jpvo.numOfEmployees } 명
	</td>
	</tr>
	
	<tr>
	<th>주소</th>
	<td>
	${jpvo.address }
	</td>
	</tr>
	
	<tr>
	<th>전화번호</th>
	<td>
	${jpvo.tel }
	</td>
	</tr>
	
	<tr>
	<th>담당자이메일</th>
	<td>
	${jpvo.email }
	</td>
	</tr>
	
	<tr>
	<th colspan="2" id="questionTable"><a href="##">질의응답</a></th>
	</tr>	
	<tr>
	<th colspan="2">
	<c:choose>
<c:when test="${sessionScope.mvo.memberType==1}">

		<input type="text" name="questionArea" id="questionArea" required="required"  style="height:30px; width:500px;">
		<input type="hidden" name="jobPostingNum" id="jobPostingNum">
		<input type="button" value="질문등록" id="registerQuestionBtn" name="registerQuestionBtn">
		</c:when>
		<c:otherwise>		
		</c:otherwise>
		</c:choose>
<th>
	</tr>
		
		<tr><td colspan="2" id="detail">
		<c:forEach items="${qaList}" var="qaList">질문 : ${qaList.question }<br>답 : ${qaList.answer }<br><br></c:forEach></td></tr>
		

	</tbody>
</table>
</div>
<!-- 세션에 있는 회원이 normalMember 이면 면접신청 을 할수있는 기능을 추가하려고 함 -->
<c:choose>
	<c:when test="${sessionScope.mvo.memberType==1}">
	<form action="goInterviewApply.do?id=${sessionScope.mvo.id}">
	<input type="hidden" name="jobPostingNum" value="${jpvo.jobPostingVO.jobPostingNum}">
	<input type="submit" value="면접신청">
	</form>
	</c:when>
	<c:otherwise>
	<c:if test="${sessionScope.mvo.id==jpvo.companyId}">
	<form action="updateJobPostingForm.do">
	<input type="hidden" name="companyId" value="${jpvo.companyId}">
	<input type="hidden" name="jobPostingNum" value="${jpvo.jobPostingVO.jobPostingNum}">
	<input type="submit" value="수정하기">
	</form>	
	<br>
	<form action="deleteJobPosting.do">
	<input type="hidden" name="companyId" value="${jpvo.companyId}">
	<input type="hidden" name="jobPostingNum" value="${jpvo.jobPostingVO.jobPostingNum}">
	<input type="submit" value="삭제하기">
	</form>
	</c:if>
	</c:otherwise>
</c:choose>
<br>
<!-- 181020 MIRI 세션에 있는 회원이 직접 올린 구인 공고 글이면 면접 신청자 리스트를 볼 수 있음 (작억중) -->
	<c:if test="${sessionScope.mvo.id == requestScope.jpvo.companyId}">
		<form action="getJobPostingInterviewerList.do?jobPostingNum=${requestScope.jpvo.jobPostingVO.jobPostingNum}" method="post">
			<input type="submit" value="면접 신청자 리스트">
		</form>
		<br>
		<form action="getJobPostingQAList.do?jobPostingNum=${requestScope.jpvo.jobPostingVO.jobPostingNum}" method="post">
			<input type="submit" value="구인 공고 질답 리스트">
		</form>
	</c:if>

