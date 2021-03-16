/**
 * 
 */

$(document).ready(function() {
//	댓글 전체 리스트 (페이징 처리)
	var bnoValue=$("#bno").val();
	var bno = bnoValue;
	var page = 1;
	
	getAllList(page);
	function getAllList(page) {
		var str="";
		$("#reply_section").hide();
	
	$.getJSON("/duri/replies/all/"+bno+"/"+page, 
			
		function(data) {
		console.log(data)
		
		$(data.list).each(
		function() {
			str+="<li data-rno="+this.rno
			+" class='replyLi'>"
			+this.rno+":"
			+this.replytext
			+"<input type='button' value='수정'/></li>"
		});
		
//		댓글 페이징
		console.log("댓글 전체 수 =" + data.replyCnt)
//		endNum
		var endNum = Math.ceil(page/10.0)*10;
		var startNum = endNum-9;
		var prev = startNum>1;
		var next = false;
		if(endNum*10>=data.replyCnt){
		endNum=Math.ceil(data.replyCnt/10.0);	
		}
		if(endNum*10<data.replyCnt){
			next=true;
			}
		var pagestr="";
//		페이징 이전
		if(prev){
			pagestr+="<li><a href='"+(startNum-1)+"'>이전</a></li>";
		}
		for(var i=startNum; i<=endNum; i++){
			var active=page==i?"active":"";
			pagestr+="<li class='page-item"+active+" '><a href='"+i+"'>"+i+"</a></li>";
		}
//		페이징 다음
		if(next){
			pagestr+="<li><a href='"+(endNum+1)+"'>다음</a></li>";
		}
		$("#replypage").html(pagestr);
		$("#replies").html(str);
	})
	} // getAllList end

$("#replypage").on("click","li a", function(e) {
	e.preventDefault();
	var targetPageNum=$(this).attr("href");
	page=targetPageNum;
	getAllList(page);
})
$("#replyAdd").on("click",function(){
	var replyer = $("#newReplyer").val();
	var replytext = $("#newReplytext").val();
	
	$.ajax({
		type : "post",
		url : "/duri/replies",
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Overried" : "POST"
		},
		dataType : "text",
		data : JSON.stringify({
			bno : bno,
			replyer : replyer,
			replytext : replytext
		}),
		success : function(result) {
			if (result == "SUCCESS"){
				alert("등록 되었습니다.");
				getAllList(page);
			}
		}
		}) // 댓글 쓰기 ajax end
}) // 댓글 쓰기 버튼 end
		
// 수정 버튼을 클릭했을 때 수정 처리
$("#replyModify").on("click",function(){
	var rno = $("#reply_title").html();
	var replytext = $("#replytext").val();
	console.log("rno" ,rno);
	$.ajax({
		type : "put",
		url :"/duri/replies/"+rno,
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "PUT"
		},
		data : JSON.stringify ({replytext : replytext}),
		dataType : "text",
		success : function(result) {
			console.log("result : " + result)
			if(result == "SUCCESS"){
				alert("수정 되었습니다.");
				$("#reply_section").hide();
				getAllList(page);
			}
	     }
		})
})

	$("#replies").on("click",".replyLi input", function(e) {
		e.preventDefault();
		var reply = $(this).parent();
		var rno = reply.attr("data-rno");
		console.log("rno:",rno);
		console.log("reply:",reply);
		var replytext=reply.text();
		$("#reply_title").html(rno);
		$("#replytext").val(replytext);
		$("#reply_section").show("slow");
	});
//		삭제 버튼 클릭 했을 때
$("#replyDelete").on("click",function(){
	var rno = $("#reply_title").html();
	$.ajax({
		type : "delete",
		url : "/duri/replies/"+rno,
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Overried" : "DELETE"},
			dateType : "text",
			success : function(result) {
				if (result == "SUCCESS"){
					alert("삭제 되었습니다.");
					$("#reply_section").show();
					getAllList(page);
				}
			}
	})
	
	})
	$("#replyClose").on("click",function(){
		$("#reply_section").hide("slow");
})
	})