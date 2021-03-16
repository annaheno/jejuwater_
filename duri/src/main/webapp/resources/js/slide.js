$(function(){
	var imgItems = $('.slider li').length;
  var imgPos = 1;
  for(i = 1; i <= imgItems; i++){
  	$('.pagination').append('<li><span>●</span></li>');
  }
  
$('.slider li').hide();
  $('.slider li:first').show();
  $('.pagination li:first').css({'color': '#2E9AFE'});
  
  $('.pagination li').click(pagination);
  $('.left span').click(prevSlider);
  $('.right span').click(nextSlider);
  
  
  function pagination(){
 		var paginationPos = $(this).index() + 1;
    $('.slider li').hide();
    $('.slider li:nth-child('+ paginationPos +')').fadeIn();
    $('.pagination li').css({'color': '#FAFAFA'});
    $('.pagination li:nth-child('+ paginationPos +')').css({'color': '#2E9AFE'});
    imgPos = paginationPos;
  }
  
  function nextSlider(){
  	if(imgPos >= imgItems){
    	imgPos = 1;
    }else{imgPos++;}
  	$('.slider li').hide();
    $('.slider li:nth-child('+ imgPos +')').fadeIn();
    $('.pagination li').css({'color': '#FAFAFA'});
    $('.pagination li:nth-child('+ imgPos +')').css({'color': '#2E9AFE'});
  }
  function prevSlider(){
  	if(imgPos <= 1){
    	imgPos = imgItems;
    }else{imgPos--;}
  	$('.slider li').hide();
    $('.slider li:nth-child('+ imgPos +')').fadeIn();
    $('.pagination li').css({'color': '#FAFAFA'});
    $('.pagination li:nth-child('+ imgPos +')').css({'color': '#2E9AFE'});
  }
  setInterval(function(){
  	nextSlider();
  },3000);
  
});
