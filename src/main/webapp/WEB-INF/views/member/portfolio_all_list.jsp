<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("input[name='recruitCatNumList']")
								.change(
										function() {
											$("#empTypeArea").html('');
											var dataString = '';
											$
													.ajax({
														type : "get",
														url : "user-DevCatVOListAjax.do",
														dataType : "json",
														data : $(
																"#portfolioSearchList")
																.serialize(),
														success : function(
																catList) {
															var catListString = '';
															for (var i = 0; i < catList.length; i++) {
																for (var j = 0; j < catList[i].length; j++) {
																	catListString += '<input type="checkbox" class = "recruit" name="devCatNumList" value="'+catList[i][j].devCatNum+'">'
																			+ catList[i][j].devCatName
																			+ '&nbsp;';
																}
																catListString += '<br>';
															}
															$("#empTypeArea")
																	.html(
																			$(
																					"#empTypeArea")
																					.html()
																					+ catListString);
														}//success					
													});//ajax 			
										});//change

						$("#SearchBtn").click(function() {
							$("#portfolioSearchList").submit();
						});

					});//ready
</script>

<div>

</div>
<!-- normal_register_portfolio -->
<h3>인재 검색</h3>


<form action="portfolioSearchList.do" method="get"
	id="portfolioSearchList">
	<h5>지역</h5>
	<c:forEach items="${requestScope.locCatList}" var="locCat"
		varStatus="i">
		<input type="checkbox" name="locCatNumList" value="${locCat.locNum}">${locCat.locName}&nbsp;
	</c:forEach>
	<br>


	<h5>학력</h5>
	<c:forEach items="${requestScope.acaCatList}" var="acaCat"
		varStatus="i">
		<input type="radio" name="acaCatNumList" value="${acaCat.academicNum}"
			required="required">${acaCat.academicName}&nbsp;
	</c:forEach>
	<br>

	<h5>고용형태</h5>
	<c:forEach items="${requestScope.empTypeCatList}" var="empTypeCat"
		varStatus="i">
		<input type="checkbox" name="empTypeCatNumList"
			value="${empTypeCat.empTypeNum}">${empTypeCat.empTypeName}&nbsp;
	</c:forEach>
	<br>

	<h5>모집직군</h5>

	<c:forEach items="${requestScope.recruitCatList}" var="recruitCat"
		varStatus="i">
		<input type="checkbox" class="recruit" name="recruitCatNumList"
			value="${recruitCat.rcNum}">${recruitCat.rcName}  &thinsp;&thinsp;
			<c:if test="${(i.index+1)%3==0}">
			<br>
		</c:if>
	</c:forEach>
	<input type="hidden" name="a" value="b">
	<h5>개발분야</h5>
	<div id="empTypeArea"></div>
</form>

<span id="enter"></span>
<button type="reset">초기화</button>

<button type="submit" id="SearchBtn">검색하기</button>
<button type="reset" onclick="location.href='home.do'">홈으로</button>

<!-- 구분선 -->


<%-- <c:forEach items="${list }" var="list" varStatus="status">
	${list.name}
	${devCatList[status.index].devCatName}
	${povo[status.index].content}<br>
</c:forEach> --%>

<h4 class="heading">
	<div class="cta-text">
		<h2>
			<span>GoodJob</span> 인재 정보
		</h2>
	</div>
</h4>
<section id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="row">
					<c:forEach items="${list}" var="list" varStatus="status">
													<!--  -->
					<%-- 	<div class="col-lg-3">
							<div class="box">
								<div class="box-gray aligncenter">
									<div class="icon">
										<i class="fa fa-desktop fa-3x"></i>
									</div>
									<h4>${list.name }</h4>
										
									<p>	${povo[status.index].content}</p>
								</div>
							</div>
						</div> --%>
						<div class="col-lg-3">
							<div class="box">
								<div class="box-gray aligncenter">
									<h4>Kakao</h4>
									<div class="icon">
										<i class="fa fa-desktop fa-3x"></i>
									</div>
									<div class="box-bottom">
										<a href="user-normalDetailPortfolioList.do?normalId=${list.normalId }">
										개발분야 : ${devCatList[status.index].devCatName}	</a>
									</div>
								</div>
							</div>
						</div>	
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</section>



