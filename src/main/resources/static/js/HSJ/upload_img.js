( /* att_zone : 이미지들이 들어갈 위치 id, btn : file tag id */
          imageView = function imageView(att_zone, btn){
        
           var attZone = document.getElementById(att_zone);
           var btnAtt = document.getElementById(btn)
           var sel_files = [];

           const realUpload = document.querySelector('#btnAtt');
           const upload = document.querySelector('.file_upload');

           upload.addEventListener('click', () => realUpload.click());
        
           // 이미지와 체크 박스를 감싸고 있는 div 속성
           var div_style = 'display:inline-block;position:relative;'
                      + 'width:150px;height:150px;margin:5px;' + 'outline: 1px dashed';
           // 미리보기 이미지 속성
           var img_style = 'width:100%;height:100%;z-index:none';
           
           // 이미지안에 표시되는 체크박스의 속성
           var chk_style = 'width:22px;height:30px;position:absolute;font-size:23px;'
                         + 'right:0px;bottom:0px;z-index:999;background-color:rgba(255,255,255,0.9); color:lighslategray;'
                         +'border:1px solid gray; cursor:pointer';
        
           btnAtt.onchange = function(e){
             var files = e.target.files;
             var fileArr = Array.prototype.slice.call(files)
             for(f of fileArr){
              imageLoader(f);
             }          
           }          
        
           // 탐색기에서 드래그앤 드롭 사용
           attZone.addEventListener('dragenter', function(e){
             e.preventDefault();
             e.stopPropagation();
           }, false)
        
           attZone.addEventListener('dragover', function(e){
             e.preventDefault();
             e.stopPropagation();
           }, false)
        
           attZone.addEventListener('drop', function(e){
             var files = {};
             e.preventDefault();
             e.stopPropagation();
             var dt = e.dataTransfer;
             files = dt.files;
             for(f of files){
              imageLoader(f);
             }          
           }, false)
        
           /*첨부된 이미지들을 배열에 넣고 미리보기 */
           
           imageLoader = function(file){
             sel_files.push(file);
             var reader = new FileReader();
             reader.onload = function(ee){
              let img = document.createElement('img')
              img.setAttribute('style', img_style)
              img.src = ee.target.result;
              attZone.appendChild(makeDiv(img, file));
             }
          
             reader.readAsDataURL(file);
           }

           /*첨부된 파일이 있는 경우 checkbox와 함께 attZone에 추가할 div를 만들어 반환 */
           makeDiv = function(img, file){
             var div = document.createElement('div')
             div.setAttribute('style', div_style)


             if(attZone.childElementCount >= 5) {
              alert('이미지파일 첨부는 최대 5개까지 업로드가 가능합니다.');
              return
              }

           //  X 버튼 만들기  
             var btn = document.createElement('input')
             btn.setAttribute('type', 'button')
             btn.setAttribute('value', 'x')
             btn.setAttribute('delFile', file.name);
             btn.setAttribute('style', chk_style);

           //  X 버튼 클릭 시 삭제

             btn.onclick = function(ev){
              var ele = ev.srcElement;
              var delFile = ele.getAttribute('delFile');
              for(var i=0 ;i<sel_files; i++){
                if(delFile== sel_files[i].name){
                 sel_files.splice(i, 1);      
                }
              }
           
              dt = new DataTransfer();
              for(f in sel_files) {
                var file = sel_files[f];
                dt.items.add(file);
              }
              btnAtt.files = dt.files;
              var p = ele.parentNode;
              attZone.removeChild(p)
             }
             
             div.appendChild(img)
             div.appendChild(btn)
             return div
           }
          }
        )('att_zone', 'btnAtt')