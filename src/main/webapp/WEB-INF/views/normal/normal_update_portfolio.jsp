<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


<script type="text/javascript">	
	$(document).ready(function(){
		$("input[name='recruitCatNumList']").change(function() {	
			//alert(1);
			$("#empTypeArea").html('');
			var dataString='';
			$.ajax({
				type:"get",
				url:"user-getDevCatVOListAjax.do",
				dataType:"json",
				data:$("#updatePortfolioForm").serialize(),
				success:function(catList){
					var catListString='';
					for(var i=0; i<catList.length; i++){			
						for(var j=0; j<catList[i].length; j++){
							catListString += '<input type="checkbox" class = "recruit" name="devCatNumList" value="'+catList[i][j].devCatNum+'">'+catList[i][j].devCatName+'&nbsp;';
						}
						catListString+='<br>';
					}
					$("#empTypeArea").html($("#empTypeArea").html()+catListString);
				}//success					
			});//ajax 			
		});//change
		
		$("#pictureUploadBtn").change(function(){
			 var deletePictureName=$("#normal-picture").attr('alt');
				if( (!deletePictureName) == false){ //기존 사진 있으면 
					pictureDelete(deletePictureName); //삭제
				}			
				//사진 업로드
				var form = $("#updatePortfolioForm")[0];
				var formData = new FormData(form);
				formData.append('member', "normal");
				$.ajax({
					type:"post",
					url:"user-pictureUpload.do",
					data:formData,				
					enctype: 'multipart/form-data',
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					processData: false,
			        contentType: false,
			        cache: false,
					success:function(path){
						$("#normal-picture").attr('src', "/GoodJob/resources/upload/memberPicture/"+path);
						$("#normal-picture").attr('alt', path);
						$("#pictureInputArea").html("<input type='hidden' name='picturePath' value='"+path+"'>");	
					}
				});//ajax
				$("#pictureDeleteBtn").css('display', 'block');
		});//change
		
		$("#pictureDeleteBtn").click(function() {
			//사진파일 삭제
			pictureDelete($("#normal-picture").attr('alt'));			
			//src변경
			$("#normal-picture").attr('src', "/GoodJob/resources/upload/etc/member_picture_add.png");
			//alt변경
			$("#normal-picture").attr('alt', "");
			//display변경
			$("#pictureDeleteBtn").css('display', 'none');
			//input value비움
			$("#pictureUploadBtn").val("");		
		});	//click
		
		
		if(${requestScope.povo != null}) {
			$('input:checkbox[name="locCatNumList"]').each(function() {
				<c:forEach items="${requestScope.locCatList}" var="locCat">
					if(this.value == ${locCat.locNum}) {
						this.checked = true;
					}
				</c:forEach>
			});
			
			$('input:radio[name="acaCatNumList"]').each(function() {
				<c:forEach items="${requestScope.acaCatList}" var="acaCat">
					if(this.value == ${acaCat.academicNum}) {
						$('input:radio[name="acaCatNumList"][value="${acaCat.academicNum}"]').prop('checked',true);
					}
			</c:forEach>
			});

			$('input:checkbox[name="empTypeCatNumList"]').each(function() {
				<c:forEach items="${requestScope.empTypeCatList}" var="empTypeCat">
					if(this.value == ${empTypeCat.empTypeNum}) {
						this.checked = true;
					}
				</c:forEach>
			});

			$('input:checkbox[name="recruitCatNumList"]').each(function() {
				<c:forEach items="${requestScope.recruitCatList}" var="recruitCat">
					if(this.value == ${recruitCat.rcNum}) {
						this.checked = true;
					}
				</c:forEach>
			});
		}
		
		$("#empTypeArea").html('');
		var dataString='';
		$.ajax({
			type:"get",
			/* 181023 MIRI url 재수정 */
			url:"user-getDevCatVOListAjax.do",
			dataType:"json",
			data:$("#updatePortfolioForm").serialize(),
			success:function(catList){
				var catListString='';
				for(var i=0; i<catList.length; i++){			
					for(var j=0; j<catList[i].length; j++){
						catListString += '<input type="checkbox" class = "recruit" name="devCatNumList" value="'+catList[i][j].devCatNum+'">'+catList[i][j].devCatName+'&nbsp;';
					}
					catListString+='<br>';
				}
				$("#empTypeArea").html($("#empTypeArea").html()+catListString);
				
				$('input:checkbox[name="devCatNumList"]').each(function() {
					<c:forEach items="${requestScope.devCatList}" var="devCat">
						if(this.value == ${devCat.devCatNum}) {
							this.checked = true;
						}
					</c:forEach>
				});
			}//success					
		});//ajax 				
	});//ready
	
	function pictureDelete(deletePicturename){
		$.ajax({
			type:"post",
			url:"user-pictureDelete.do",
			data:"member=normal&deletePicturename="+deletePicturename,
			success:function(result){
				//alert("사진삭제완료");
			}
		});//ajax			
	}
	
	
	function checkForm(){
		if($("input[name=locCatNumList]:checked").size()==0){
			alert("지역을 하나 이상 선택해주세요!");
			return false;
		}
		
		if($("input[name=empTypeCatNumList]:checked").size()==0){
			alert("고용형태를 하나 이상 선택해주세요!");
			return false;
		}
		if($("input[name=recruitCatNumList]:checked").size()==0){
			alert("모집직군을 하나 이상 선택해주세요!");
			return false;
		}
		if($("input[name=devCatNumList]:checked").size()==0){
			alert("개발분야를 하나 이상 선택해주세요!");
			return false;
		}
	}
	
	
	
</script>


<div id="registerPortfolio" >

	<!-- normal_register_portfolio -->
	<h4 class="heading">
		<div class="cta-text">
			<h2>
				<span>GoodJob</span> 이력서 수정
			</h2>
		</div>
	</h4>


	<form action="user-updatePortfolio.do" method="post" id="updatePortfolioForm" enctype="multipart/form-data">
	<h5>제목</h5>
	 <input size="90px"  height="50px" type="text" name="title" value="${requestScope.povo.title }" required="required"><br>
	
	<div>
	<br>
	
		<div style="float:left;">
			<h5>사진등록</h5>	
			 <div class="resume_photo" style="width:120px;">
			 		<img id="normal-picture"  src="${pageContext.request.contextPath}/resources/upload/etc/member_picture_add.png" border="0" width="120" height="160"  >
			  		<img id="pictureDeleteBtn" src="${pageContext.request.contextPath}/resources/upload/etc/x-button.jpg" class="button"  style="display: none; ">
			</div>
	 		<span id="pictureInputArea"></span>	<br>
			<input type="file" name="uploadPicture" id="pictureUploadBtn" required="required"><br>
		</div>
		<table>
		      <colgroup>
		        <col width="90px">
		        <col width="320px">
		        <col width="120px">
		        <col width="320px">
		      </colgroup>
		      <tbody>
		      <tr height="50px">
		        <th>지역</th>
		        <td colspan="3">		        	
					<c:forEach items="${requestScope.allLocCatList}" var="allLocCat">
						<input type="checkbox" name="locCatNumList" value="${allLocCat.locNum}">${allLocCat.locName}&nbsp;
					</c:forEach> <br>					
		         </td>
		      </tr>
		      
		      <tr height="50px">
		        <th>학력</th>
		        <td colspan="3">
		        	<c:forEach items="${requestScope.allAcaCatList}" var="acaCat" varStatus="i">	
						<input type="radio" name="acaCatNumList" value="${acaCat.academicNum}" required="required">${acaCat.academicName}&nbsp;
					</c:forEach> <br>
		        </td>
		      </tr>
		      
		      <tr height="50px">
		        <th>고용형태</th>
		        <td>
		        	<c:forEach items="${requestScope.allEmpTypeCatList}" var="empTypeCat" varStatus="i">
						<input type="checkbox" name="empTypeCatNumList" value="${empTypeCat.empTypeNum}" >${empTypeCat.empTypeName}&nbsp;
					</c:forEach> <br>
		        </td>        
		      </tr>
		      
		      <tr height="110px">
		      	<th>포트폴리오</th>
		      	<td>
					<input type="file" name="fileList[0]" >
					<input type="file" name="fileList[1]" >
					<input type="file" name="fileList[2]" >
		      	</td>
		      </tr>
		      
		    
		    </tbody>
		</table>	
	</div>
	<br><br>
	<div>
	<h5>내용</h5>
	<textarea rows="8" cols="90" name="content" } required="required">${requestScope.povo.content}</textarea><br><br>
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
					<c:forEach items="${requestScope.allRecruitCatList}" var="recruitCat" varStatus="i">
						<input type="checkbox" class = "recruit" name="recruitCatNumList" value="${recruitCat.rcNum}" >${recruitCat.rcName}  &thinsp;&thinsp;
						<c:if test="${(i.index+1)%3==0}"><br></c:if>
					</c:forEach>	
		        </td>      
		      </tr>  
		      <tr height="50px" >
		        <th>개발분야</th>
		        <td style="padding-top:5px;">
		        	<div id="empTypeArea">		
					</div>	
					<span id="aaa"></span>					
		        </td>     
		      </tr>      
		      </tbody>
	</table>
	<br><br>
		<!-- <button type="reset">초기화</button>	updateBtn
		<button type="submit"  onclick="return checkForm()">등록하기</button>	 -->		
		<button type="submit"  onclick="return checkForm()">수정완료</button>	
		<input type="button" value="취소" onclick="javascript:location.href='home.do'">		
	</form >	
</div>








