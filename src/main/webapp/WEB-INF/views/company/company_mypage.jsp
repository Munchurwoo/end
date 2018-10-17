<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- company_mypage -->

<h3 align="center">${sessionScope.mvo.name }님 마이페이지</h3><br><br>

<a href="updateCompanyMemberForm.do">회원정보수정</a><br><br>
<a href="registerJobPostingForm.do">구인등록</a><br><br>
<a href="deleteCompanyMember.do">회원탈퇴</a><br><br>
<a href="job_posting_detail.do">구인등록상세보기 임시로만듬-동규</a>
	아이디   ${requestScope.cmvo.companyId }<br><br>
	이메일 주소  ${requestScope.cmvo.email }"<br><br>
	회사 명   ${requestScope.cmvo.name }<br><br>
	회사 주소  ${requestScope.cmvo.address }<br><br>
	연락처   ${requestScope.cmvo.tel }<br><br>
	회사 소개  ${requestScope.cmvo.introduction }<br><br>
	기업 형태  ${requestScope.cmvo.companyType }<br><br>
	업종  ${requestScope.cmvo.industry }<br><br>
	매출액  ${requestScope.cmvo.sales }<br><br>
	설립일  ${requestScope.cmvo.dateOfEstablishment }<br><br>
	사원수  ${requestScope.cmvo.numOfEmployees }<br><br>

