<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- normal_register_form -->

<h3 align="center">회원가입</h3><br><br>

<script type="text/javascript">
	$(document).ready(function () {
		var gender = "${requestScope.nmvo.gender }";
		var val;
		if(gender == "여") val="female";
		else val="male";
		$("input:radio[name='gender']:radio[value="+val+"]").prop("checked", true);
		
		var retFirVal = false;
		var retSecVal = false;
		
		if($("#password").val() == "") {
			$("#passwordView").text("비밀번호는 8~10자로 입력하세요.").css("color", "red").css("font-weight", "bold");
			retFirVal = false;
		}
		
		$("#password").keyup(function() {
			if($(this).val()  == "") {
				$("#passwordView").text("비밀번호를 입력해주세요.").css("color", "red").css("font-weight", "bold");
				retFirVal = false;
			} else if($(this).val().length < 8 || $(this).val().length > 10) {
				$("#passwordView").text("비밀번호는 8~10자로 입력하세요.").css("color", "red").css("font-weight", "bold");
				retFirVal = false;
			} else if($(this).val().length >= 8 && $(this).val().length <= 10) {
				$("#passwordView").text("사용 가능한 비밀번호입니다.").css("color", "blue").css("font-weight", "bold");
				retFirVal = true;
			}
			
			if($("#checkPass").val() == "") {
				$("#checkPassView").text("비밀번호 확인 황목을 입력해주세요.").css("color", "red").css("font-weight", "bold");
				retSecVal = false;
			} else if($(this).val() != $("#checkPass").val()) {
				$("#checkPassView").text("비밀번호가 일치하지 않습니다.").css("color", "red").css("font-weight", "bold");
				retSecVal = false;
			} else if($(this).val() == $("#checkPass").val()) {
				$("#checkPassView").text("비밀번호가 일치합니다.").css("color", "blue").css("font-weight", "bold");
				retSecVal = true;
			}
		});
	
		$("#checkPass").keyup(function() {
			if($("#password").val() == "") {
				$("#checkPassView").text("비밀번호 항목을 먼저 입력해주세요.").css("color", "red").css("font-weight", "bold");
				retSecVal = false;
			} else if ($(this).val() == "") {
				$("#checkPassView").text("비밀번호 확인 황목을 입력해주세요.").css("color", "red").css("font-weight", "bold");
				retSecVal = false;
			} else if ($("#password").val() != $(this).val()) {
				$("#checkPassView").text("비밀번호가 일치하지 않습니다.").css("color", "red").css("font-weight", "bold");
				retSecVal = false;
			} else if($(this).val() == $("#password").val()){
				$("#checkPassView").text("비밀번호가 일치합니다.").css("color", "blue").css("font-weight", "bold");
				retSecVal = true;
			}
		});
		
		$("#normalRegisterForm").submit(function() {
			if(retFirVal == false || retSecVal == false) {
				$("#checkPass").val("");
				$("#password").val("");
				$("#password").focus();
				$("#passwordView").text("비밀번호는 8~10자로 입력하세요.").css("color", "red").css("font-weight", "bold");
				$("#checkPassView").text(" ");
				return false;
			}
		});
	});
</script>

<form id="normalRegisterForm" action="user-registerNormalMember.do" method="post">
	<input type="button" value="개인회원" onclick="javascript:location.href='user-registerNormalMemberForm.do'"> &nbsp; &nbsp;
	<input type="button" value="기업회원" onclick="javascript:location.href='user-registerCompanyMemberForm.do'"><br><br>
	* 표시는 필수 입력사항<br><br>
	아이디 * <input type="text" name="id" required="required">
	<input type="button" value="중복체크"><br><br>
	비밀번호 * <input type="password" id="password" name="password" required="required">
	<span id="passwordView"> </span><br><br>
	비밀번호 확인 * <input type="password" id="checkPass" name="checkPass" required="required">
	<span id="checkPassView"> </span><br><br>
	이메일 주소 * <input type="text" name="email" required="required"><br><br>
	이름 * <input type="text" name="name" required="required"><br><br>
	주소 * <input type="text" name="address" required="required"><br><br>
	연락처 * <input type="text" name="tel" required="required"><br><br>
	경력사항 * <input type="text" name="careerStatus" required="required"><br><br>
	사진경로 * <input type="text" name="picturePath" required="required"><br><br>
	성별 * &nbsp;<input type="radio" name="gender" value="male" required="required">남자 
			    <input type="radio" name="gender" value="female" required="required">여자 
	<br><br>
	<input type="submit" value="회원가입">
</form>



