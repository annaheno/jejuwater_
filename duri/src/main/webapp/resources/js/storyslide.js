var slides2 = document.querySelector('.slides2'),
slide = document.querySelectorAll('.slides2 li'),
currentIdx = 0,
slideCount = slide.length,
prev =document.querySelector('.s_prev'),
slideWidth = 520,
slideMargin = 30,
next = document.querySelector('.s_next');

slides2.style.width = (slideWidth + slideMargin)*slideCount - slideMargin+'px';

function moveSlide2(num){
    slides2.style.left = -num * 520 + 'px';
    currentIdx = num;
}
next.addEventListener('click', function(){
    if(currentIdx < slideCount -1){
        moveSlide2(currentIdx + 1);
    }else{
        moveSlide2(0);
    }
});
prev.addEventListener('click', function(){
    if(currentIdx > 0){
        moveSlide2(currentIdx - 1);
    }else{
        moveSlide2(slideCount - 1);
    }
    event.stopPropagation();
});