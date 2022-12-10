// 正常寫法
var sayHi = (name) => {
    return name + '你好哇';
}
console.log(sayHi('阿華'));

/* 
//如果程式碼只有一行，可以省略大括號 {}，會直接 return 第一行程式碼 
*/
var sayHi = (name) => name + '你好哇'
console.log(sayHi('阿華')); // 阿華你好哇

/* 
//只有一個參數可以不加小括號()
 */
var sayHi = name => name + '你好哇'
console.log(sayHi('阿華')); // 阿華你好哇

/* 
//沒有參數或兩個參數以上時，一定要有小括號()
*/
var sayHi = () => '阿華你好哇'
console.log(sayHi()); // 阿華你好哇

var sayHi = (name1,name2) => name1 + name2 + '你好哇'
console.log(sayHi('阿華','萱萱')); // 阿華萱萱你好哇

/* 
//如果程式碼有多行時，一定要使用大括號{}將它們括起來，並且使用 return 返回
*/
let getYear = () => {
    let date = new Date();
    return date.getFullYear();
}
console.log(getYear()); // 2019

//如果要直接 return 物件，必須在物件外面加上括號()，否則會報錯。
// 出現錯誤
// let myHome1 = () => { dog: 1, brother: "豪豪" };

// 正確寫法
let myHome2 = () => ({ dog: 1, brother: "豪豪" });