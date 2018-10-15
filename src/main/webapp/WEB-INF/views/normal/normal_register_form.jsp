<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- normal_register_form -->

<h3 align="center">회원가입</h3><br><br>

<form action="user-registerNormalMember.do" method="post">
	<input type="button" value="개인회원" onclick="javascript:location.href='user-registerNormalMemberForm.do'"> &nbsp; &nbsp;
	<input type="button" value="기업회원" onclick="javascript:location.href='user-insertCompanyMemberForm.do'"><br><br>
	* 표시는 필수 입력사항<br><br>
	아이디 * <input type="text" name="id" required="required">
	<input type="button" value="중복체크"><br><br>
	비밀번호 * <input type="password" name="password" required="required"><br><br>
	비밀번호 확인 * <input type="password" name="checkPass" required="required"><br><br>
	이메일 주소 * <input type="text" name="email" required="required"><br><br>
	이름 * <input type="text" name="name" required="required"><br><br>
	주소 * <input type="text" name="address" required="required"><br><br>
	연락처 * <input type="text" name="tel" required="required"><br><br>
	경력사항 * <input type="text" name="careerStatus" required="required"><br><br>
	사진경로 * <input type="text" name="picturePath" required="required"><br><br>
	성별 * &nbsp;<input type="radio" name="gender" value="man" required="required">남자 
			    <input type="radio" name="gender" value="girl" required="required">여자 
	<br><br>
	<input type="submit" value="회원가입">
</form>



