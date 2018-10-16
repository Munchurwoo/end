<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- tiles framework 선언부 --%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<!-- title이 null인 경우는 무시된다 -->
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<!--  -->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<!-- css -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css?ver=1"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/fancybox/jquery.fancybox.css?ver=1"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/jcarousel.css?ver=1"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/flexslider.css?ver=1"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/style.css?ver=1"
	rel="stylesheet" />

<!-- Theme skin -->
<link
	href="${pageContext.request.contextPath}/resources/skins/default.css?ver=1"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.easing.1.3.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.fancybox.pack.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.fancybox-media.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/google-code-prettify/prettify.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/portfolio/jquery.quicksand.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/portfolio/setting.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.flexslider.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/animate.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
<!--  -->

</head>
<body>
	<div id="wrapper">
		<!-- start header -->
		<tiles:insertAttribute name="header" />
		<!-- end header -->

		<!-- main_header -->
		<tiles:insertAttribute name="main_header"  ignore="true"/>
		<!-- end main_header -->

		<section id="content">
			<div class="container">
				<!-- main_center 시작 (추천기업) -->
				<tiles:insertAttribute name="main_center" ignore="true"  />
				<!-- end main_center 시작 (추천기업) -->

				<!-- divider ( 기업 추천과 인재 추천 구분선 )-->
				<div class="row">
					<div class="col-lg-12">
						<div class="solidline"></div>
					</div>
				</div>
				<!-- end divider -->

				<!-- main_footer 시작 ( 인재추천 ) -->
				<tiles:insertAttribute name="main_footer"  ignore="true" />
				<!-- main_footer 종료 -->
			</div>
		</section>

		<!-- footer 시작  -->
		<tiles:insertAttribute name="footer" ignore="true" />
		<!-- footer 종료 -->
</body>
</html>










