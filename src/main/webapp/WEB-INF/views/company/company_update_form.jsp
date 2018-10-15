<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- company_update_member_form -->

<h3 align="center">회원 정보 수정</h3><br><br>

<form>
	* 표시는 필수 입력사항<br><br>
	아이디 * <input type="text" required="required">
	<input type="button" value="중복체크"><br><br>
	비밀번호 * <input type="password" required="required"><br><br>
	비밀번호 확인 * <input type="password" required="required"><br><br>
	이메일 주소 * <input type="text" required="required"><br><br>
	연락처 * <input type="text" required="required"><br><br>
	사업자번호 * <input type="text" required="required"><br><br>
	기업명 * <input type="text" required="required"><br><br>
	업종 * <input type="text" required="required"><br><br>
	매출액 <input type="text" required="required"><br><br>
	설립일 <input type="text" required="required"><br><br>
	사원수 <input type="text" required="required"><br><br>
	<input type="submit" value="회원정보수정">
</form>


