<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
<h4 class="heading">
	<div class="cta-text">
		<h2>
			<span><a href="companyJobPostingList.do?companyId=${requestScope.cmvo.companyId}">${requestScope.cmvo.name}</a></span>
		</h2>
	</div>
</h4>
	<table class="table table-bordered">
		<thead>
			<tr>		
			<th>기업로고</th>
			<td>
			<img src="/GoodJob/resources/upload/companyLogo/${requestScope.cmvo.picturePath}" height="100px" width="100px" >
			</td>
			</tr>
			<tr>
			<th>이메일주소</th>
			<td>${requestScope.cmvo.email}</td>
			</tr>
			<tr>
			<th>회사명</th>
			<td>${requestScope.cmvo.name }</td>
			</tr>
			<tr>
			<th>회사 주소</th>
			<td>${requestScope.cmvo.address }</td>
			</tr>
			<tr>
			<th>연락처</th>
			<td>${requestScope.cmvo.tel }</td>
			</tr>
			<tr>
			<th>회사 소개</th>
			<td> ${requestScope.cmvo.introduction }</td>
			</tr>
			<tr>
			<th>기업 형태</th>
			<td>${requestScope.cmvo.companyType }</td>
			</tr>
			<tr>
			<th>업종</th>
			<td>${requestScope.cmvo.industry }</td>
			</tr>
			<tr>
			<th>매출액</th>
			<td>${requestScope.cmvo.sales }</td>
			</tr>
			<tr>
			<th>설립일</th>
			<td>${requestScope.cmvo.dateOfEstablishment }</td>
			</tr>
			<tr>
			<th>사원수</th>
			<td>${requestScope.cmvo.numOfEmployees }</td>
			</tr>
		</thead>
	</table>
	</div>
	
	<br>
	<h3>회사 위치</h3><br>

<html> 	
<body>
	<!-- 지도를 표시할 크기  -->
	<div id="map" style="width:500px; height:400px;"></div>
	<!-- 카카오디벨로퍼에서 받은 지도 API -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e25d6953d694300e4c8481ebcd62d365&libraries=services,clusterer,drawing"></script>
	
	<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new daum.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new daum.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('${requestScope.cmvo.address}', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === daum.maps.services.Status.OK) {

        var coords = new daum.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new daum.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new daum.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
}); 
</script>
</body>
</html>