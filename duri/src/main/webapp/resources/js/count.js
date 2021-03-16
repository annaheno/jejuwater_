/**
 * 
 */
//감소
function reduce(num){
    var prices=document.getElementsByName("price")[num].value;
    var count=parseInt(document.getElementsByName("amount")[num].value)-1;
    if(count>-1){

        document.getElementsByName("amount")[num].value=count;
        var totals=parseInt(prices*count);
        document.getElementById("price"+num).innerHTML=totals.toFixed(2);
        total();
    }
}
//증가
function add(num){
    var prices=document.getElementsByName("price")[num].value;
    var count=parseInt(document.getElementsByName("amount")[num].value)+1;
    if(count>10){
    	alert("대량주문 문의를 통해 주문 해주세요.")
    }else{
    document.getElementsByName("amount")[num].value=count;
    var totals=parseInt(prices*count);
    document.getElementById("price"+num).innerHTML="" +totals.toFixed(2);
    total();
	}
}
//총액
function total(){
    var prices=document.getElementsByName("price");
    var count=document.getElementsByName("amount");
    var sum=0;
    for(var i=0; i<prices.length;i++){
       sum+=prices[i].value*count[i].value;
    }
    document.getElementById("totalPrice").getElementsByTagName("span")[0].innerHTML=""+sum.toFixed(2);
}