/**
 * 
 */

$(document).ready(function() {
	var formObj = $("form[role='form']");
	console.log(formObj);
	
//	수정 버튼 클릭
	$(".btn-modify").on("click",function(){
		formObj.attr("action","/duri/board/modify");
		formObj.attr("method","get");
		formObj.submit();
	});
	
//	삭제 버튼 클릭
	$(".btn-delete").on("click",function(){
		formObj.attr("action","/duri/board/remove");
		formObj.attr("method","post");
		formObj.submit();
		alert("게시물을 삭제합니다.")
	});
//	목록 버튼 클릭
	$(".btn-list").on("click",function(){
		formObj.attr("action","/duri/board/list");
		formObj.attr("method","get");
		formObj.submit();
	});
//	bno 값 저장
	var bno = $("#bno").val();
	
//	t_attach 에 대한 처리
	$.getJSON("/duri/board/getAttachList",{bno:bno},function(arr){
		console.log(arr);
		var str = "";
		$(arr).each(function(i,attach) {
			if(attach.fileType){
				var fileCallPath=encodeURIComponent(attach.uploadPath+"/th_"+attach.uuid+"_"+attach.fileName);
				str+="<li><img src='/duri/display?fileName="+fileCallPath+"'>"+"</li>";
			}else{
				str+="<li><a href='/duri/download?fileName="+fileCallPath+"'>"
				+"<img src='../resources/image/clip.png'>"+attach.fileName+"</a></li>";
			}
		})
		$(".uploadResult ul").append(str);
	})
});