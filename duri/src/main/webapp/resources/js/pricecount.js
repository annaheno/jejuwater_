/**
 * 
 */

$(function(){
	
});

function Btn() {
	this.constMnmmAccptCnt = 0;
	this.constMxmmAccptCnt = 10;
	
	this.nbox1 = 0;
	this.nbox2 = 0;
	this.nbox3 = 0;
	
	this.chargeYn="Y";
	this.perPersonAmt = (this.chargeYn=="Y") ? 10000 : 0;
	this.perPersonAmt2 = (this.chargeYn=="Y") ? 12000 : 0;
	this.perPersonAmt3 = (this.chargeYn=="Y") ? 7800 : 0;
	
	var p = this;
	
	this.inner = function(num) {
		return$("#nbox1").val();
	}
	
	this.add = function(type) {
		var nowCnt = p.nbox1 + p.nbox2 + p.nbox3;
		
		if(nowCnt == p.constMxmmAccptCnt){
			alert("10개 이상은 대량 구매 문의로 구매 가능합니다.");
			return false;
		}
		eval("p."+type+"++;");
		p.afterProc();
	}
	
	this.remove = function (type){
		if($('#'+type).val()==0) return false;
		
		eval("p."+type+"--;");
		p.afterProc();
	}
	this.afterProc = function() {
		$('#nbox1').val(this.nbox1);
		$('#nbox2').val(this.nbox2);
		$('#nbox3').val(this.nbox3);
		
		var nowCnt = p.nbox1 + p.nbox2 + p.nbox3;
		var excessCnt = (nowCnt - p.constMnmmAccptCnt < 0)? 0 : nowCnt - p.constMnmmAccptCnt;
		$('#excessCnt').val(excessCnt);
		$('#total').val(excessCnt*p.perPersonAmt);
	}
}
var btn = new Btn();