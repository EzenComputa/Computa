$(document).ready(function() {
    // 메뉴 호버 시 하위 메뉴 보이기
    $('#gnb li.m').hover(function() {
      $('ul', this).stop().slideDown();
    }, function() {
      $('ul', this).stop().slideUp();
    });
});
