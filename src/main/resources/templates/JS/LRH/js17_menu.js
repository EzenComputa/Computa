// 메뉴 마우스올릴시 배경색 반전
$(() => {
      $('.navbar_menu li').hover(
        function(e){$(this).addClass('reverse');},
        function(e){$(this).removeClass('reverse');}        
      )
      })

$(() => {
      $('.my_navbar_menu li').hover(
      function(e){$(this).addClass('reverse');},
      function(e){$(this).removeClass('reverse');}        
      )
      })