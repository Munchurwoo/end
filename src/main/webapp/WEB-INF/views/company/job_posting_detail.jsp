<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>${jpvo.jobPostingVO.title }</h3>
<div class="container">
<table class="table table-bordered">
	<thead>	
	<tr>
	<h4>${jpvo.jobPostingVO.contents}</h4>
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
	</tbody>
</table>
</div>
<!-- 세션에 있는 회원이 normalMember 이면 면접신청 을 할수있는 기능을 추가하려고 함 -->
<c:choose>
	<c:when test="${sessionScope.mvo.memberType==1}">
	<form action="goInterviewApply.do?id=${sessionScope.mvo.id}">
	<input type="submit" value="면접신청">
	</form>
	</c:when>
</c:choose>


