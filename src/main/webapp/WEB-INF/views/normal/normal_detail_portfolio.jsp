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

.detailPortfolioTable tr{
	height:30px;
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
	
<div id="registerPortfolio" >

	<!-- normal_register_portfolio -->
	<h4 class="heading">
		<div class="cta-text">
			<h2>
				<span>${povo.title }</span>
			</h2>
		</div>
	</h4>


	<h5>제목</h5>
	 <input size="90px"  height="50px" type="text" name="title" value="${povo.title }" readonly="readonly"><br>
	<br>
	<div>	
		<div style="float:left; width:180px;">
			<h5>사진</h5>	
			 <div class="resume_photo" style="width:120px;">
			 		<img id="normal-picture"  src="/GoodJob/resources/upload/memberPicture/${povo.picturePath}" border="0" width="120" height="160"  >
			</div>
		</div>
		<table class="detailPortfolioTable">
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
		      
		      <tr>
		        <th>지역</th>	
		        <td colspan="3">		        	
					<c:forEach items="${locCatList }" var="locCatList">
					${locCatList.locName }&nbsp;/ 
					</c:forEach>
		         </td>
		      </tr>
		      
		      <tr>
		        <th>학력</th>
		        <td colspan="3">					
					<c:forEach items="${acaCatList }" var="acaCatList">
					${acaCatList.academicName }&nbsp;/ 
					</c:forEach>
		        </td>
		      </tr>
		      
		      <tr>
		        <th>고용형태</th>
		        <td>
		        	<c:forEach items="${empTypeCatList}" var="empTypeCatList">
					${empTypeCatList.empTypeName }	&nbsp;/ 
					</c:forEach>
		        </td>        
		      </tr>
		      
		       <tr>
		        <th>모집직군</th>
		        <td>
		       		 <c:forEach items="${recruitCatList}" var="recruitCatList">
						${recruitCatList.rcName }	&nbsp;/ 
					</c:forEach>		        	
		        </td>        
		      </tr>
		      
		       <tr>
		        <th>개발분야</th>
		        <td>		        
		        	<c:forEach items="${devCatList }" var="devCatList">
					${devCatList.devCatName }&nbsp;/
					</c:forEach>				        	
		        </td>        
		      </tr>
		      
		      <tr style="height:50px;">
		      	<th>포트폴리오</th>
		      	<td>
					<!-- <input type="file" name="fileList[0]" >
					<input type="file" name="fileList[1]" >
					<input type="file" name="fileList[2]" > -->
					<c:forEach items="${povo.fileNameList}" var="fileName">
					<a href="fileDownload.do?fileName=memberPortfolio/${fileName}">${fileName}</a><br>
					</c:forEach>
					
					
		      	</td>
		      </tr>
		      
		    
		    </tbody>
		</table>	
	</div>		
	<h5>내용</h5>
	<textarea rows="8" cols="90" name="content" readonly="readonly" >${povo.content }</textarea><br>
	<!-- 기업회원이 개인포트폴리오 조회시 수정/삭제 할수 없게 if조건 적용 -->
	<c:if test="${sessionScope.mvo.id==requestScope.nmvo.id}">	
		<input type="button" onclick="javascript:location.href='user-updatePortfolioForm.do?id=${requestScope.nmvo.id}'" value="수정">
		<input type="button" onclick="deletePortfolio('${requestScope.nmvo.id}', '${requestScope.povo.picturePath }')" value="삭제">
	</c:if>	
</div>	
	

	

	
	
	
	