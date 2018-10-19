<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">	
	$(document).ready(function(){
		$("input[name='recruitCatNumList']").change(function() {	
			$("#empTypeArea").html('');
			var dataString='';
			$.ajax({
				type:"get",
				url:"getDevCatVOListAjax.do",
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
			var form = $("#pictureUploadForm")[0];	
			var formData = new FormData(form);
			$.ajax({
				type:"post",
				url:"normalPictureUpload.do",
				data:formData,				
				enctype: 'multipart/form-data',
				processData: false,
		        contentType: false,
		        cache: false,
				success:function(path){
					$("#normal-picture").attr('src', "/GoodJob/resources/upload/memberPicture/"+path);
					//$("#pictureInput").val(path);
					alert(path);
					$("#aaa").append("<input type='hidden' name='picturePath' value='"+path+"'>");	
				}
			});
		});//change
		
		$("#registerBtn").click(function() {
			$("#registerForm").submit();

		});//click
		
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
			url:"getDevCatVOListAjax.do",
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
		
		$("#updateBtn").click(function() {
			$("#updatePortfolioForm").submit();
		});
	});//ready
</script>

<!-- normal_update_portfolio -->

<h3>이력서 수정</h3>

<form action="user-updatePortfolio.do" method="post" id="updatePortfolioForm">
	제목 <input type="text" name="title" value="${requestScope.povo.title }" required="required"><br>
	내용<br>&nbsp;&nbsp;&nbsp;<textarea rows="10" cols="60" name="content"  required="required">${requestScope.povo.content }</textarea><br><br>
		
	<h5>지역</h5>
	
	<c:forEach items="${requestScope.allLocCatList}" var="allLocCat">
		<input type="checkbox" name="locCatNumList" value="${allLocCat.locNum}">${allLocCat.locName}&nbsp;
	</c:forEach> <br>
		
	<h5>학력</h5>
	<c:forEach items="${requestScope.allAcaCatList}" var="acaCat" varStatus="i">	
		<input type="radio" name="acaCatNumList" value="${acaCat.academicNum}" required="required">${acaCat.academicName}&nbsp;
	</c:forEach> <br>
	
	<h5>고용형태</h5>
	<c:forEach items="${requestScope.allEmpTypeCatList}" var="empTypeCat" varStatus="i">
		<input type="checkbox" name="empTypeCatNumList" value="${empTypeCat.empTypeNum}" >${empTypeCat.empTypeName}&nbsp;
	</c:forEach> <br>
	
	<h5>모집직군</h5> 
	
		<c:forEach items="${requestScope.allRecruitCatList}" var="recruitCat" varStatus="i">
			<input type="checkbox" class = "recruit" name="recruitCatNumList" value="${recruitCat.rcNum}" >${recruitCat.rcName}  &thinsp;&thinsp;
			<c:if test="${(i.index+1)%3==0}"><br></c:if>
		</c:forEach>
		<input type="hidden" name="a" value="b">	
	<h5>개발분야</h5>
	<div id="empTypeArea">		
	</div>	
	<span id="aaa"></span>
	
	<button type="reset">전체 초기화</button>	
</form >
<h5>사진등록</h5>
<form enctype="multipart/form-data" action="" id="pictureUploadForm">
 <div class="resume_photo">
   <a href="##" class="box_photo" data-api_type="layer" data-api_id="basic_photo" >
       <img id="normal-picture" src="" border="0" width="100" height="140" class="user_image" /></a>
  <!--  <a class="photo_delete" href="##" style=""><span class="blind">사진 삭제</span></a> -->
</div>
<input type="file" name="uploadPicture" id="pictureUploadBtn"><br>

</form>

<button type="submit" id="updateBtn">수정완료</button> &nbsp;&nbsp;
<input type="button" value="취소" onclick="javascript:location.href='home.do'">