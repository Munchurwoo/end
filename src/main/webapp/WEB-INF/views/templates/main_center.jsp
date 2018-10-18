<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col-lg-12">
		<div class="row">
			<h4 class="heading">
				<div class="cta-text">
					<h2>
						<span>GoodJob</span> 추천 기업
					</h2>
				</div>
			</h4>
			<c:forEach items="${postListVO.cmvoList }" var="cmvo" begin="0" end="3">
				<div class="col-lg-3">
					<div class="box" >
						<div class="box-gray aligncenter">
							<h4>${cmvo.companyId } 채용</h4>
								<div class="icon">
									<i class="fa fa-pagelines fa-3x"></i>
								</div>
								${cmvo.introduction }
						</div>
						<div class="box-bottom">
							<a href="user-detailCompanyInfo.do?companyId=${cmvo.companyId}">Learn more</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
