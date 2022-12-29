function count() {
    var price = 100;
    console.log(price); //出現100，function內的var變數只會存在在function內
}
console.log(price); //出現錯誤，無法存取price