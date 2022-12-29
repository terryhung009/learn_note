// // //function函數

// // //最簡單的函數
// // // function hello() {
// // //     console.log('你好')
// // // }

// // // function hello2() {
// // //     console.log('你好2')
// // // }

// // // hello();
// // // hello2();


// // //有參數的函數
// // // function addmoney(price1, price2, discount) {
// // //     console.log('price1', price1)
// // //     console.log('price2', price2)
// // //     console.log('discount', discount)
// // //     console.log(price1 + price2 - discount)
// // // }

// // // addmoney(2000, 100, 50);


// // // addmoney(3000, 200, 0);


// // //有回傳值的函數
// // function addmoney2(price1, price2, discount) {
// //     let result = price1 + price2 - discount;
// //     return result;
// // }

// // let total = addmoney2(5000, 5000, 100);
// // console.log('total', total);

// // //
// // function addmoney3(price1, price2, discount) {
// //     let result = price1 + price2 - discount;
// //     let message = '普通會員'

// //     if (result >= 50000) {
// //         message = "尊榮會員"
// //         return message;
// //     }
// //     if (result >= 20000) {
// //         message = "白金會員";
// //         return message;

// //     }

// //     return message
// // }

// // let msg = addmoney3(50000, 10000, 0);
// // console.log('msg', msg);

// //構造函數
// const card = {
//     name: '小明'
// }
// const card2 = {
//     name: '小明2'
// }
// const card3 = {
//     name: '小明3'
// }

// function createCard(initName) {
//     this.name = initName
// }

// //new 建立或構造
// const a1 = new createCard('小明');
// console.log(a1);

//箭頭函數
function hello() { }

let hello2 = function () { }

let hello3 = () => { }