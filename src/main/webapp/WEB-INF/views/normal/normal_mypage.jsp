<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- normal_mypage -->

<h3 align="center">${sessionScope.mvo.name }님 마이페이지</h3><br><br>
<a href="updateNormalMemberForm.do">회원정보수정</a><br>
<a href="registerPortfolioForm.do">이력서 등록</a><br>
<a href="deleteNormalMember.do">회원탈퇴</a><br>
	아이디 ${requestScope.nmvo.id }<br><br>
	이메일 주소 ${requestScope.nmvo.email }<br><br>
	이름 ${requestScope.nmvo.name }<br><br>
	주소 ${requestScope.nmvo.address }<br><br>
	연락처 ${requestScope.nmvo.tel }<br><br>
	경력사항 ${requestScope.nmvo.careerStatus }<br><br>
	사진경로 ${requestScope.nmvo.picturePath }<br><br>
	성별  ${requestScope.nmvo.gender}<br><br>