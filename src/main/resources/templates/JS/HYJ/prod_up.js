// 2.1 자동 실행 함수를 사용하여 만듦

// 첫 번째 매개변수인 att_zone은 첨부된 이미지들이 표시될
// 영역을 나타내는 id값이고, 두 번째 매개변수는 file 태그의 id값을 의미한다.

( /* att_zone : 이미지들이 들어갈 위치 id, btn : file tag id */
  imageView = function imageView(att_zone, btn){
  
  }
)('att_zone', 'btnAtt')


// 2.2 함수내에서 사용될 변수들 선언

// 함수의 매개변수로 전달된 id값을 사용하여 각각 attZone, btnAtt객체를
// 생성한 뒤, 첨부된 파일의 목록을 저장할 sel_files 변수를 배열로 지정해둔다.

( /* att_zone : 이미지들이 들어갈 위치 id, btn : file tag id */
	imageView = function imageView(att_zone, btn){
		var attZone = document.getElementById(att_zone);
		var btnAtt = document.getElementById(btn)
		var sel_files = [];
	}
)('att_zone', 'btnAt')


// 이미지와 체크 박스를 감싸고 있는 div 속성
var div_style = 'display:inline-block;position:relative;'
              + 'width:150px;height:120px;margin:5px;border:1px solid #00f;z-index:1';
// 미리보기 이미지 속성
var img_style = 'width:100%;height:100%;z-index:none';
// 이미지안에 표시되는 체크박스의 속성
var chk_style = 'width:30px;height:30px;position:absolute;font-size:24px;'
              + 'right:0px;bottom:0px;z-index:999;background-color:rgba(255,255,255,0.1);color:#f00';
