<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- normal_update_form -->

<h3 align="center">회원 정보 수정</h3><br><br>

<script type="text/javascript">
	$(document).ready(function () {
		var gender = "${requestScope.nmvo.gender }";
		var value;
		if(gender == "여") {
			val = "girl";
		} else {
			val = "man";
		} 
		$("input:radio[name='gender']:radio[value="+val+"]").prop("checked", true);
	});
</script>

<form action="updateNormalMember.do" method="post">
	* 표시는 필수 입력사항<br><br>
	아이디 * <input type="text" value="${requestScope.nmvo.id }" name="id" disabled="disabled"><br><br>
	비밀번호 * <input type="password" name="password" required="required"><br><br>
	비밀번호 확인 * <input type="password" name="checkPass" required="required"><br><br>
	이메일 주소 * <input type="text" placeholder="${requestScope.nmvo.email }" name="email" required="required"><br><br>
	이름 * <input type="text" value="${requestScope.nmvo.name }" name="name" disabled="disabled"><br><br>
	주소 * <input type="text" placeholder="${requestScope.nmvo.address }" name="address" required="required"><br><br>
	연락처 * <input type="text" placeholder="${requestScope.nmvo.tel }" name="tel" required="required"><br><br>
	경력사항 * <input type="text" placeholder="${requestScope.nmvo.picturePath }" name="careerStatus" required="required"><br><br>
	사진경로 * <input type="text" placeholder="${requestScope.nmvo.careerStatus }" name="picturePath" required="required"><br><br>
	성별 * &nbsp;
	<input type="radio" name="gender" value="man" disabled="disabled">남자 
    <input type="radio" name="gender" value="girl" disabled="disabled">여자<br><br>
	<input type="submit" value="회원정보수정">
</form>
