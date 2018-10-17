<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="job_posting_detail.do">
<h3>${jpvo.title }</h3><br><br>
${jpvo.contents }<br><br>
모집직군 : <c:forEach items="${recruitCatList}" var="recruitCatList">
${recruitCatList.rcName }</c:forEach><br><br>
개발분야 : <c:forEach items="${devCatList }" var="devCatList">
${devCatList.devCatName }
</c:forEach><br><br>
고용형태 : <c:forEach items="${empTypeCatList}" var="empTypeCatList">
${empTypeCatList.empTypeName }
</c:forEach><br><br>
근무지역 : <c:forEach items="${locCatList }" var="locCatList">
${locCatList.locName }
</c:forEach><br><br>
학력 : <c:forEach items="${acaCatList }" var="acaCatList">
${acaCatList.academicName }
</c:forEach><br><br>
회사정보<br><br>
회사명 : ${cmvo.name }<br><br>
회사소개 : ${cmvo.introduction }<br><br>
업종 : ${cmvo.industry }<br><br>
매출액 : ${cmvo.sales } 만원<br><br>
설립일 : ${cmvo.dateOfEstablishment }<br><br>
사원수 : ${cmvo.numOfEmployees } 명<br><br>
주소 : ${cmvo.address }<br><br>
전화번호 : ${cmvo.tel }<br><br>
담당자 이메일 : ${cmvo.email }<br><br>
</form>