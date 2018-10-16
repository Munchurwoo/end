<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- normal_update_form -->

<h3 align="center">회원 정보 수정</h3><br><br>

<script type="text/javascript">
	$(document).ready(function () {
		var gender = "${requestScope.nmvo.gender }";
		var val;
		if(gender == "여") val="female";
		else val="male";
		$("input:radio[name='gender']:radio[value="+val+"]").prop("checked", true);
		
		if($("#password").val() == "") {
			$("#passwordSpan").text("비밀번호는 8~10자로 입력하세요.").css("color", "red").css("font-weight", "bold");
		}
		
		$("#password").keyup(function() {
			if($(this).val()  == "") {
				$("#passwordSpan").text("비밀번호를 입력해주세요.").css("color", "red").css("font-weight", "bold");
			} else if($(this).val().length < 8 || $(this).val().length > 10) {
				$("#passwordSpan").text("비밀번호는 8~10자로 입력하세요.").css("color", "red").css("font-weight", "bold");
			} else if($(this).val().length >= 8 && $(this).val().length <= 10) {
				$("#passwordSpan").text("사용 가능한 비밀번호입니다.").css("color", "blue").css("font-weight", "bold");
			}
			if($("#checkPass").val() == "") {
				$("#checkPassSpan").text("비밀번호 확인 황목을 입력해주세요.").css("color", "red").css("font-weight", "bold");
			} else if($(this).val() != $("#checkPass").val()) {
				$("#checkPassSpan").text("비밀번호가 일치하지 않습니다.").css("color", "red").css("font-weight", "bold");
			} else if($(this).val() == $("#checkPass").val()) {
				$("#checkPassSpan").text("비밀번호가 일치합니다.").css("color", "blue").css("font-weight", "bold");
			}
		});
		
		$("#checkPass").keyup(function() {
			if($("#password").val() == "") {
				$("#checkPassSpan").text("비밀번호 항목을 먼저 입력해주세요.").css("color", "red").css("font-weight", "bold");
			} else if ($("#password").val() != $(this).val()) {
				$("#checkPassSpan").text("비밀번호가 일치하지 않습니다.").css("color", "red").css("font-weight", "bold");
			} else if($(this).val() == $("#password").val()){
				$("#checkPassSpan").text("비밀번호가 일치합니다.").css("color", "blue").css("font-weight", "bold");
			}
		});
	});
</script>

<form action="updateNormalMember.do" method="post">
	* 표시는 필수 입력사항<br><br>
	아이디 * <input type="text" value="${requestScope.nmvo.id }" name="id" readonly="readonly"><br><br>
	비밀번호 * <input type="password" id="password" name="password" required="required">
	<span id="passwordSpan"> </span><br><br>
	비밀번호 확인 * <input type="password" id="checkPass" name="checkPass" required="required">
	<span id="checkPassSpan"> </span><br><br>
	이메일 주소 * <input type="text" value="${requestScope.nmvo.email }" name="email" required="required"><br><br>
	이름 * <input type="text" value="${requestScope.nmvo.name }" name="name" readonly="readonly"><br><br>
	주소 * <input type="text" value="${requestScope.nmvo.address }" name="address" required="required"><br><br>
	연락처 * <input type="text" value="${requestScope.nmvo.tel }" name="tel" required="required"><br><br>
	경력사항 * <input type="text" value="${requestScope.nmvo.careerStatus }" name="careerStatus" required="required"><br><br>
	사진경로 * <input type="text" value="${requestScope.nmvo.picturePath }" name="picturePath" required="required"><br><br>
	성별 * &nbsp;
	<input type="radio" name="gender" value="male" disabled="disabled">남자 
    <input type="radio" name="gender" value="female" disabled="disabled">여자<br><br>
	<input type="submit" value="회원정보수정">
</form>
