<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
제목 :${povo.title }<br>
이름 : ${nmvo.name }<br>
이메일 : ${nmvo.email }<br>
전화번호 : ${nmvo.tel }<br>
내용 : ${povo.content }<br><br>
모집직군 : <c:forEach items="${recruitCatList}" var="recruitCatList">
${recruitCatList.rcName }
</c:forEach><br><br>
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