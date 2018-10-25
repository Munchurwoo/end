<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- normal_detail_portfolio -->

<style type="text/css">
.resume_photo{
	position : relative;
	width : 120px;
	height : 160px;
}

#normal-picture{
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

#registerPortfolio{

	margin: 0px 240px 0px 240px;
	padding : 5px;
}



</style>



<script>
	function deletePortfolio(id, picturePath) {
		var delPortfolio = confirm("포트폴리오 \'${requestScope.povo.title}\' 를 삭제하시겠습니까?");
		if(delPortfolio == true) {
			location.href="deletePortfolio.do?id="+id+"&picturePath="+picturePath;
		} else {
			return;
		}
	}
</script>

<%-- <h3 align="center">이력서 상세보기</h3><br><br>

	제목 :${povo.title }<br>
	이름 : ${nmvo.name }<br>
	<img src="/GoodJob/resources/upload/memberPicture/${povo.picturePath}" height="100px" width="100px" ><br>
	이메일 : ${nmvo.email }<br>
	전화번호 : ${nmvo.tel }<br>
	내용 : ${povo.content }<br>
	성별 : ${nmvo.gender }<br>
	<br>
	모집직군 : <c:forEach items="${recruitCatList}" var="recruitCatList">
	${recruitCatList.rcName }
	</c:forEach><br><br>
	개발분야 : <c:forEach items="${devCatList }" var="devCatList">
	${devCatList.devCatName }
	</c:forEach><br><br>
	고용형태 : <c:forEach items="${empTypeCatList}" var="empTypeCatList">
	${empTypeCatList.empTypeName }
	</c:forEach><br><br>
	근무지역 : <c:forEach items="${locCatList }" var="locCatList">
	${locCatList.locName }
	</c:forEach><br><br>
	학력 : <c:forEach items="${acaCatList }" var="acaCatList">
	${acaCatList.academicName }
	</c:forEach><br><br> --%>
	

	
	
	
<div id="registerPortfolio" >

	<!-- normal_register_portfolio -->
	<h4 class="heading">
		<div class="cta-text">
			<h2>
				<span>GoodJob</span> 이력서 상세보기
			</h2>
		</div>
	</h4>


	<h5>제목</h5>
	 <input size="90px"  height="50px" type="text" name="title" value="${povo.title }" readonly="readonly"><br>
	
	<div>
	<br>
	
		<div style="float:left; width:180px;">
			<h5>사진</h5>	
			 <div class="resume_photo" style="width:120px;">
			 		<img id="normal-picture"  src="/GoodJob/resources/upload/memberPicture/${povo.picturePath}" border="0" width="120" height="160"  >
			</div>
		</div>
		<table>
		      <colgroup>
		        <col width="90px">
		        <col width="320px">
		        <col width="120px">
		        <col width="320px">
		      </colgroup>
		      <tbody>
		      <tr>
		      	<th>이름</th>
		      	<td>${nmvo.name }</td>
		      </tr>
		       <tr>
		      	<th>이메일</th>
		      	<td>${nmvo.email }</td>
		      </tr>
		      <tr>
		      	<th>전화번호</th>
		      	<td>${nmvo.tel }</td>
		      </tr>
		      <tr>
		      	<th>성별</th>
		      	<td>${nmvo.gender }</td>
		      </tr>      
		      
		      <tr height="50px">
		        <th>지역</th>	
		        <td colspan="3">
		        	<%-- <c:forEach items="${requestScope.locCatList}" var="locCat" varStatus="i">
						<input type="checkbox" name="locCatNumList" value="${locCat.locNum}" >${locCat.locName}&nbsp;
					</c:forEach> --%>
					<c:forEach items="${locCatList }" var="locCatList">
					${locCatList.locName }
					</c:forEach>
		         </td>
		      </tr>
		      
		      <tr height="50px">
		        <th>학력</th>
		        <td colspan="3">
		        <%-- 	<c:forEach items="${requestScope.acaCatList}" var="acaCat" varStatus="i">	
						<input type="radio" name="acaCatNumList" value="${acaCat.academicNum}" required="required">${acaCat.academicName}&nbsp;
					</c:forEach>  --%>
					
					<c:forEach items="${acaCatList }" var="acaCatList">
					${acaCatList.academicName }
					</c:forEach>
		        </td>
		      </tr>
		      
		      <tr height="50px">
		        <th>고용형태</th>
		        <td>
		        	<c:forEach items="${empTypeCatList}" var="empTypeCatList">
					${empTypeCatList.empTypeName }
					</c:forEach>
		        </td>        
		      </tr>
		      
		      <tr height="110px">
		      	<th>포트폴리오</th>
		      	<td>
					<!-- <input type="file" name="fileList[0]" >
					<input type="file" name="fileList[1]" >
					<input type="file" name="fileList[2]" > -->
					파일 리스트
					
		      	</td>
		      </tr>
		      
		    
		    </tbody>
		</table>	
	</div>
	<div>
	<h5>면접신청 제목</h5>
	<c:forEach items="${ivo}" var="info">
		${info}
	</c:forEach>
	

	
	<h5>내용</h5>
	<textarea rows="8" cols="90" name="content" readonly="readonly" value=""></textarea><br><br>
	
	</div>
		
	
	
	<table class="table table-bordered">
		<colgroup>
		        <col width="92px">
		       <%--  <col width="320px"> --%>
		      </colgroup>
		<tbody>
		  <tr height="50px">
		      	<th>모집직군</th>
		        <td>
					<%-- <c:forEach items="${requestScope.recruitCatList}" var="recruitCat" varStatus="i" >
						<input type="checkbox" class = "recruit" name="recruitCatNumList" value="${recruitCat.rcNum}" >${recruitCat.rcName}  &thinsp;&thinsp;
						<c:if test="${(i.index+1)%4==0}">
							<br>
						</c:if>
					</c:forEach> --%>
					<c:forEach items="${recruitCatList}" var="recruitCatList">
					${recruitCatList.rcName }
					</c:forEach>
		        </td>      
		      </tr>
		      
		      <tr height="50px" >
		        <th>개발분야</th>
		        <td style="padding-top:5px;">
		        	<!-- <div id="empTypeArea">		
					</div>		 -->	
					<c:forEach items="${devCatList }" var="devCatList">
					${devCatList.devCatName }
					</c:forEach>							
		        </td>        
		      </tr>      
		      </tbody>
	</table>
	<br><br>
		<input type="button" onclick="javascript:location.href='user-updatePortfolioForm.do?id=${requestScope.nmvo.id}'" value="수정하기">
		<input type="button" onclick="deletePortfolio('${requestScope.nmvo.id}', '${requestScope.povo.picturePath }')" value="삭제하기">
	
	<button type="reset" onclick="location.href='home.do'">홈으로</button>	
</div>
	

	
	
	
	