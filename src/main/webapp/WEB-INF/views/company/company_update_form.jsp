<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- company_update_member_form -->

<h3 align="center">회원 정보 수정</h3><br><br>

<form action = "updateCompanyMember.do" method="post">
	* 표시는 필수 입력사항<br><br>
	아이디 * <input type="text" value="${requestScope.cmvo.id }" name="id" readonly="readonly"><br><br>
	비밀번호 * <input type="password" name="password" required="required"><br><br>
	비밀번호 확인 * <input type="password" name = "checkPass" required="required"><br><br>
	이메일 주소 * <input type="text" value="${requestScope.cmvo.email }" name="email" required="required"><br><br>
	회사 명 * <input type="text" value="${requestScope.cmvo.name }" name="name" readonly="readonly"><br><br>
	회사 주소 * <input type="text" value="${requestScope.cmvo.address }" name="address" required="required"><br><br>
	연락처 * <input type="text" value="${requestScope.cmvo.tel }" name="tel" required="required"><br><br>
	회사 소개 * <input type="text" value="${requestScope.cmvo.introduction }" name="introduction" required="required"><br><br>
	기업 형태 * <input type="text" value="${requestScope.cmvo.companyType }" name="companyType" required="required"><br><br>
	업종 * <input type="text" value="${requestScope.cmvo.industry }" name="industry" required="required"><br><br>
	매출액 <input type="text" value="${requestScope.cmvo.sales }" name="sales"><br><br>
	설립일 <input type="text" value="${requestScope.cmvo.dateOfEstablishment }" name="dateOfEstablishment"><br><br>
	사원수 <input type="text" value="${requestScope.cmvo.numOfEmployees }" name="numOfEmployees"><br><br>
	<input type="submit" value="회원정보수정">
</form>


