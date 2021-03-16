/**
 * 
 */

	var idck = false; //아이디 유효성 검사 체크
	var pwck = false; //비밀번호 유효성 검사 체크
	var iddupck = false; // 아이디 중복체크 검사 체크
	var repwck = false; // 비밀번호 확인 유효성 검사 체크
	
	$(document).ready(function() {
		$("#userid").on("keyup blur",function(){
		$.ajax({
			type : "GET",
			url : "/duri/member/idCheck",
			data : {"userid" : $('#userid').val()},
			success : function(data){
				console.log(data);
				if (data == 1){
					$("#idmsg").html("이미 존재하는 아이디 입니다.");
					iddupck = false;
				}else if (data == 0 && $('#userid').val() !=''){
					$("#idmsg").html("사용 가능한 아이디 입니다.");
					iddupck=true;
				}
			}
		})
//		아이디 유효성 검사
		$("#userid").on("keyup blur",function(){
			var idreg = /^[a-zA-Z0-9]{4,12}$/
			var idVal = $("#userid").val();
			
			if(idreg.test(idVal)){
				$("#idmsg").html("사용 가능한 아이디 입니다.");
				idck = true;
			}else{
				$("#idmsg").html("영문+숫자 총 길이는 4~12자 이내로 입력해주세요.");
				idck = false;
			}
		})
		$("#userpw").on("blur",function(){
			var pwreg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#!@$^&*_]).{8,}$/;
			var pwVal = $("#userpw").val();
			if(pwreg.test(pwVal)){
				$("#pwmsg").html("적절한 비밀번호 입니다.");
				pwck = true;
			}else{
				$("#pwmsg").html("대소문자·숫자· 특수 문자 포함, 총 8자 이상이어야 합니다.");
				pwck = false;
			}
			$("#repw").on("blur",function(){
				var pwVal = $("#userpw").val();
				var reVal = $("#repw").val();
				if(pwVal == reVal){
					$("#remsg").html("비밀번호가 일치합니다.");
					repwck = true;
				}else{
					$("#remsg").html("비밀번호가 일치하지 않습니다.");
					repwck = false;
				}
			})
		})
	});
	function checkmem(){
		alert(idck);
		alert(pwck);
		alert(iddupck);
		alert(repwck);
		if(idck == true && pwck == true && iddupck == true && repwck == true){
			return true;
		}
		alert("회원가입에 실패했습니다. 양식을 다시 확인해주세요.");
		return false;
	}
	})