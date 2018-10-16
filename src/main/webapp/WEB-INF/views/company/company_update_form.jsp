<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- company_update_member_form -->

<h3 align="center">회원 정보 수정</h3><br><br>

<script type="text/javascript">
	$(document).ready(function () {
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
		
		$("#companyUpdateForm").submit(function() {
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

<form id="companyUpdateForm" action = "updateCompanyMember.do" method="post">
	* 표시는 필수 입력사항<br><br>
	아이디 * <input type="text" value="${requestScope.cmvo.id }" name="id" readonly="readonly"><br><br>
	비밀번호 * <input type="password" id="password" name="password" required="required">
	<span id="passwordView"> </span><br><br>
	비밀번호 확인 * <input type="password" id="checkPass" name="checkPass" required="required">
	<span id="checkPassView"> </span><br><br>
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


