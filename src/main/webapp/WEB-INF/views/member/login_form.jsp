<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- login_form -->



<form action="user-login.do" method="post">
<div class="container">
<div class="col-sm-8" style="text-align: right">
	<input type="text" name="id" required="required" placeholder="아이디" style="height:40px; width:500px;"><br><br>
	<input type="password"  name="password" required="required" placeholder="비밀번호" style="height:40px; width:500px;"><br><br>
	<a href="user-registerNormalMemberForm.do">회원가입</a> &nbsp; &nbsp;
	<a href="#">비밀번호를 잊으셨나요?</a>
	</div>
	<div  class="col-sm-4" style="text-align: left">
	<input type="submit" value="로그인"style="height:100px; width:100px; background: #81BEF7;font-size: 20px">
	</div>
	</div>
</form>

	

	
