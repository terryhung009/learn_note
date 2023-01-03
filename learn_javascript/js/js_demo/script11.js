// event listener

// function handle_click(element){
//     // alert("按就按");
//     // console.log(element);

//     element.innerText = "按屁阿";
//     element.style.color = "red";

// }

var btn = document.getElementById("btn");
btn.addEventListener("click",function(){
    // alert("按就按");
    this.innerText="按屁阿";
    this.style.color = "red";



})

var img = document.getElementById("img");
img.addEventListener("mouseover",function(){
    this.src="hotpot2.jpg"



})
var img = document.getElementById("img");
img.addEventListener("mouseout",function(){
    this.src="hotpot.jpg"



})