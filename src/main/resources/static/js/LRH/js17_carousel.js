const best = document.querySelector('#best');
const arrows = document.querySelectorAll('.arrow');
const pics = ['1.jpg','2.jpg','3.jpg','4.jpg','5.jpg','6.jpg','7.jpg','8.jpg','9.jpg','10.jpg','11.jpg','12.jpg']

best.style.backgroundImage = `url(image2/${pics[0]})`;
let i = 0;




arrows.forEach(arrow => {
    arrow.addEventListener('click',e => {
        if(e.target.id === "left") {
            i--;
            if(i<0) i=pics.length -1;
        }else if(e.target.id === "right"){
            i++;
            if(i>=pics.length) i = 0;
        }
        console.log(i)
        best.style.backgroundImage = `url(image2/${pics[i]})`;



    })
})
