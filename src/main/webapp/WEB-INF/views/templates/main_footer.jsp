<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col-lg-12">
		<div class="row">
			<h4 class="heading">
				<div class="cta-text">
					<h2>
						<span>GoodJob</span> 추천 인재
						
					</h2>
				</div>
			</h4>
			<c:forEach items="${pvo }" var="pvo" begin="0" end="3">
				<div class="col-lg-3">
					<div class="box" >
						<div class="box-gray aligncenter">
							<h4>${pvo.title }</h4>
								<img src="/GoodJob/resources/upload/memberPicture/${pvo.picturePath}" height="100px" width="100px" >
						</div>
						<div class="box-bottom">
							<a href="normalDetailPortfolio.do?normalId=${pvo.normalId}">Learn more</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
