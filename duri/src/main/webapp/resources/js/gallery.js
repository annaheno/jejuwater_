/**
 * 
 */

window.onload = function() {
    var list_zone = document.getElementById("inner_list");
    var list_a = list_zone.getElementsByTagName("a"); // 썸네일 이미지

    for (var i=0; i<list_a.length; i++) { // 썸네일 == 3개
        // 썸네일 이미지 클릭하면..
        list_a[i].onclick = function() {
            var ph = document.getElementById("photo").children[0]; // 큰 이미지!
            //썸네일이 가지고 있는 큰 이미지 href값을 전달!
            ph.src = this.href; // this === list_a
            return false; // <a>를 클릭했을 때 링크가 되지 않도록!
        }
    }
};