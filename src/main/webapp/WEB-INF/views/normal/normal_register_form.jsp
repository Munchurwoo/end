<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- normal_register_form -->

<h3 align="center">회원가입</h3><br><br>

<form action="registerNormalMember.do">
	<input type="button" value="개인회원" onclick="javascript:location.href='insertNormalMemberForm.do'"> &nbsp; &nbsp;
	<input type="button" value="기업회원" onclick="javascript:location.href='insertCompanyMemberForm.do'"><br><br>
	* 표시는 필수 입력사항<br><br>
	아이디 * <input type="text" name="id" required="required">
	<input type="button" value="중복체크"><br><br>
	비밀번호 * <input type="password" name="password" required="required"><br><br>
	비밀번호 확인 * <input type="password" name="checkPass" required="required"><br><br>
	이메일 주소 * <input type="text" name="email" required="required"><br><br>
	이름 * <input type="text" name="name" required="required"><br><br>
	주소 * <input type="text" name="address" required="required"><br><br>
	연락처 * <input type="text" name="tel" required="required"><br><br>
	<input type="submit" value="회원가입">
</form>



