// 버튼 눌렀을때 동작
document.getElementById('img').style.display = 'block';
  function showContent(contentId) {
    var selectedContent = document.getElementById(contentId);
      var imgElement = document.getElementById('img');
    
      var contents = document.getElementsByClassName('content');
      for (var i = 0; i < contents.length; i++) {
        contents[i].style.display = 'none';
      }
        
      imgElement.style.display = 'none';
    
      if (selectedContent) {
        selectedContent.style.display = 'block';
      }
  }
  