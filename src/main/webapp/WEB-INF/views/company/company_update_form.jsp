<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- company_update_member_form -->

<style type="text/css">
.resume_photo{
	position : relative;
	width : 120px;
	height : 160px;
}

#company-picture{
	position : absolute;
	width : 120px;
	height : 160px;
}

#pictureDeleteBtn{	
	position: absolute;
	z-index: 1;
	right:0;
	top:0;
	width:27px;
}
</style>

<h4 class="heading">
	<div class="cta-text">
		<h2>
			<span>${requestScope.cmvo.name }</span>님 회원 정보 수정
		</h2>
	</div>
</h4>	

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
		});//submit
		
		/* $("#pictureUploadBtn").change(function(){
			var form = $("#companyUpdateForm")[0];	
			var formData = new FormData(form);
			$.ajax({
				type:"post",
				url:"user-updateCompanyLogo.do",
				data:formData,				
				enctype: 'multipart/form-data',
				processData: false,
		        contentType: false,
		        cache: false,
				success:function(path){	
					$("#company-logo").attr('src', "/GoodJob/resources/upload/companyLogo/"+path);
					$("#aaa").append("<input type='hidden' name='picturePath' value='"+path+"'>");						
				}
			});//ajax */
		$("#pictureUploadBtn").change(function(){
			var deletePictureName=$("#company-picture").attr('alt');
			if( (!deletePictureName) == false){ //기존 사진 있으면 
				pictureDelete(deletePictureName); //삭제
			}			
			//사진 업로드
			var form = $("#companyUpdateForm")[0];
			var formData = new FormData(form);
			formData.append('member', "company");
			$.ajax({
				type:"post",
				url:"user-pictureUpload.do",
				data:formData,				
				enctype: 'multipart/form-data',
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				processData: false,
		        contentType: false,
		        cache: false,
				success:function(path){	
					$("#company-picture").attr('src', "/GoodJob/resources/upload/companyLogo/"+path);
					$("#company-picture").attr('alt', path);
					$("#pictureInputArea").html("<input type='hidden' name='picturePath' value='"+path+"'>");	
				}
			});//ajax
			$("#pictureDeleteBtn").css('display', 'block');
		});//change
		
		$("#pictureDeleteBtn").click(function() {
			//사진파일 삭제
			pictureDelete($("#company-picture").attr('alt'));			
			//src변경
			$("#company-picture").attr('src', "/GoodJob/resources/upload/etc/company_picture_add.png");
			//alt변경
			$("#company-picture").attr('alt', "");
			//display변경
			$("#pictureDeleteBtn").css('display', 'none');
			//input value비움
			$("#pictureUploadBtn").val("");		
		});	//click
	});//ready
	
	function pictureDelete(deletePicturename){
		$.ajax({
			type:"post",
			url:"user-pictureDelete.do",
			data:"member=company&deletePicturename="+deletePicturename,
			success:function(result){
				//alert("사진삭제완료");
			}
		});//ajax			
	}
</script>

<form id="companyUpdateForm" action = "updateCompanyMember.do" method="post" enctype="multipart/form-data">
	아이디  <input type="text" value="${requestScope.cmvo.id }" name="id" readonly="readonly"><br><br>
	비밀번호  <input type="password" id="password" name="password" required="required">
	<span id="passwordView"> </span><br><br>
	비밀번호 확인  <input type="password" id="checkPass" name="checkPass" required="required">
	<span id="checkPassView"> </span><br><br>
	이메일 주소  <input type="text" value="${requestScope.cmvo.email }" name="email" required="required"><br><br>
	기업 명  <input type="text" value="${requestScope.cmvo.name }" name="name" readonly="readonly"><br><br>
	주소  <input type="text" value="${requestScope.cmvo.address }" name="address" required="required"><br><br>
	연락처  <input type="text" value="${requestScope.cmvo.tel }" name="tel" required="required"><br><br>
	기업 소개  <input type="text" value="${requestScope.cmvo.introduction }" name="introduction" required="required"><br><br>
	기업 형태  <input type="text" value="${requestScope.cmvo.companyType }" name="companyType" required="required"><br><br>
	업종  <input type="text" value="${requestScope.cmvo.industry }" name="industry" required="required"><br><br>
	매출액 <input type="number" value="${requestScope.cmvo.sales }" name="sales"><br><br>
	설립일 <input type="text" value="${requestScope.cmvo.dateOfEstablishment }" name="dateOfEstablishment"><br><br>
	사원수 <input type="number" value="${requestScope.cmvo.numOfEmployees }" name="numOfEmployees"><br><br>
	회사로고<br>
	<div class="resume_photo" style="width:120px;">
		<img id="company-picture"  src="${pageContext.request.contextPath}/resources/upload/etc/company_picture_add.png" border="0" width="120" height="160"  >
		<img id="pictureDeleteBtn" src="${pageContext.request.contextPath}/resources/upload/etc/x-button.jpg" class="button"  style="display: none; ">
	</div>
	<span id="pictureInputArea"></span>	<br>
	<input type="file" name="uploadPicture" id="pictureUploadBtn" required="required"><br>
	<input type="submit" value="회원정보수정">
</form>


