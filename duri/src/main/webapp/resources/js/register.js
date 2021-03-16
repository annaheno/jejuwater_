/**
 * 
 */

// 웹페이지가 시작 되자 마자
$(document).ready(function() {
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$"); 
	var maxSize=5242880;
	
	function checkExtension(fileName, fileSize){
		if(fileSize>=maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		if(regex.test(fileName)){
			alert("해당 종류의 파일은 업로드 할 수 없습니다.")
			return false;
		}
		return true;
	}
	
	function showUploadFile(uploadResultArr) {
		var str = "";
		// data는 배열. for문과 같은 반복문을 이용해서 0~배열 끝까지를 화면에 출력 (each)
		$(uploadResultArr).each(function(i, obj) {
			var fileCallPath=encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
			if(!obj.image){
				str+="<li><a href='/duri/download?fileName="+fileCallPath+"'>"
					+"<img src='../duri/image/clip.png'>"+obj.fileName+"</a></li>";
			}else{
				var fileCallPath=encodeURIComponent(obj.uploadPath+"/th_"+obj.uuid+"_"+obj.fileName);
				
				str+="<li data-filename='"+obj.fileName+"' data-uuid='"+obj.uuid+"' data-uploadpath='"+obj.uploadPath+"' data-filetype='"+obj.image+"'>" +
				"<img src='/duri/display?fileName="+fileCallPath+"'>"+
				"<span data-file='"+fileCallPath+"'data-type='image'>X</span>"+"</li>";
			}
		})
		$(".uploadResult ul").append(str);
	}
	
	$(".fileDrop").on("dragenter dragover", function(e) {
		e.preventDefault();
	});
	$(".fileDrop").on("drop", function(e) {
		e.preventDefault();
		var files = e.originalEvent.dataTransfer.files;
		console.log(files);
		var formData = new FormData();

		for (var i = 0; i < files.length; i++) {
			if (!checkExtension(files[i].name,files[i].size) ){
			return false;
	}
			formData.append("file", files[i]);
		}
		
		$.ajax({
			url : "/duri/uploadAjax",
			data : formData,
			dataType : "json",
			processData : false,
			contentType : false,
			type : 'POST',
			success : function(data){
				alert("업로드 되었습니다.");
				console.log(data);
				showUploadFile(data);
			}
		})
	}) // Drop 이벤트 끝
	
		// x 클릭 이벤트 (삭제) 시작
	$(".uploadResult").on("click","span",function(e){
		var fileName =  $(this).data("file")
		var type=$(this).data("type")
		$.ajax({
			url : "/duri/deleteFile",
			data : {fileName : fileName, type : type}, // 어떤 파일 삭제해야 하는지 (파일명)
			dataType : "text",
			type : "POST",
			success : function(data){
				alert("삭제 완료");
			}
		})
	}) // x 클릭 이벤트 (삭제) 끝
	
//		선택자를 이용해서 form태그를 석탠해 formObj 변수에 저장
	var formObj = $("form[role='form']");
	// form[role='form'] : form 태그의 role 속성이 form 인 것을 선택하라
	
//	글쓰기 버튼을 클릭하면 이벤트 시작
	$("input[type='submit']").on("click",function(e){ // input[type='submit'] : input 태그의 type 속성이 submit 인 것을 선택하라
		e.preventDefault();
		var str="";
		$(".uploadResult ul li").each(function(i,obj) {
			var jobj=$(obj);
			console.log(jobj);
			str+="<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
			str+="<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
			str+="<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("uploadpath")+"'>";
			str+="<input type='hidden' name='attachList["+i+"].fileType' value='"+jobj.data("filetype")+"'>";
		})
		// formObj에 str을 추가(append)하여 submit을 하라
		 formObj.append(str).submit();
		/*$(".uploadResult1").html(str);*/
		
	}) //	글쓰기 버튼을 클릭하면 이벤트 끝

});