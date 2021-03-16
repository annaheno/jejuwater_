/**
 * 
 */

    $(".order").click(function () {
    	var gno1 = $("#gno1").text();
    	var gno2 = $("#gno2").text();
    	var gno3 = $("#gno3").text();
    	
		var cstock = $("#amount1").val();
		var cstock2 = $("#amount2").val();
		var cstock3 = $("#amount3").val();
		
		console.log(gno1+gno2+gno3);
		
		var data = {
				gno : gno1,
				cstock : cstock
		};
		
		var data2 = {
				gno : gno2,
				cstock : cstock2
		};
		
		var data3 = {
				gno : gno3,
				cstock : cstock3
		};
		
		$.ajax({
			url : "/duri/item",
			type : "post",
			data : data, 
			success : function () {
				$("#amount").val("1");
			}
		});
		
		$.ajax({
			url : "/duri/item",
			type : "post",
			data :  data2,
			success : function () {
				$("#amount").val("1");
			}
		});
		
		$.ajax({
			url : "/duri/item",
			type : "post",
			data : data3,
			success : function () {
				$("#amount").val("1");
			}
		});
	});