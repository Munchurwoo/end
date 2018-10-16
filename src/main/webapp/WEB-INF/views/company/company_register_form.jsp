<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- company_register_form -->

<h3 align="center">회원가입</h3><br><br>


<form action="user-registerCompanyMember.do" method="post">
	<input type="button" value="개인회원" onclick="javascript:location.href='user-registerNormalMemberForm.do'"> &nbsp; &nbsp;
	<input type="button" value="기업회원" onclick="javascript:location.href='user-registerCompanyMemberForm.do'"><br><br>
	* 표시는 필수 입력사항<br><br>
	아이디 * <input type="text" name="companyId" required="required">
	<input type="button" value="중복체크"><br><br>
	비밀번호 * <input type="password" name="password" required="required"><br><br>
	비밀번호 확인 * <input type="password" name="checkPass" required="required"><br><br>
	이메일 주소 * <input type="text" name="email" required="required"><br><br>
	주소 * <input type="text" name="address" required="required"><br><br>
	연락처 * <input type="text" name="tel" required="required"><br><br>
	기업명 * <input type="text" name="name" required="required"><br><br>
	소개 * <input type="text" name="introduction" required="required"><br><br>
	업종 * <input type="text" name="industry" required="required"><br><br>
	기업형태 * <input type="text" name="companyType" required="required"><br><br>
	매출액 <input type="number" name="sales" required="required"><br><br>
	설립일 <input type="text" name="dateOfEstablishment" required="required"><br><br>
	사원수 <input type="number" name="numOfEmployees" required="required"><br><br>
	<input type="submit" value="회원가입">
</form>
