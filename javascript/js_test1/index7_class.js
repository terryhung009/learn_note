//構造函數
// function createCard(initName) {
//     this.cardName = initName
// }

//part.1 class的基本操作
// class Card {
//     constructor(initName) {
//         this.name = initName
//     }
// }

// const c1 = new Card("布魯斯");
// console.log('c1', c1);
// console.log(c1.name);


//part.2 this的操作->當下執行者是誰，就是this指向的對象
// class Card {
//     constructor(initName) {
//         this.name = initName
//     }

//     hello() {
//         console.log("hello", this.name)
//     }
// }

// const c1 = new Card("布魯斯");
// // console.log('c1', c1);

// // c1.hello();


// //另一種建立物件的方式
// const a = { name: 'AA' }
// a.helloooooo = c1.hello

// a.helloooooo()


//part.3 class內的function，new之後不存在於產生的instance，存在於prototype的Object內
//將function綁訂於class
// class Card {
//     constructor(initName) {
//         this.name = initName
//         //this
//         // this.hello2 = this.hello1.bind(this)
//     }

//     //一般function this會變動
//     // hello1() {
//     //     console.log("hello", this.name)
//     // }

//     //箭頭函式會綁定function this綁定為原class
//     hello1() {
//         console.log("hello", this.name)
//     }
// }

// const c1 = new Card("布魯斯");
// console.log('c1', c1);
// c1.hello2();

// const a = { name: 'AA' }
// a.hello3 = c1.hello2
// a.hello3()

//part.4 繼承

class Car{
    constructor(initName){
        this.name = initName
    }
    start1(){
        console.log('車子啟動')
    }
}

class Porshe extends Car{
    constructor(namePorshe){
        super(namePorshe)
    }

    start2(){
        super.start1()
        console.log('車子排氣')
    }
    start3() {
        super.start1()
        console.log('porshe車子啟動')
    }
}

const p1 = new Porshe("我的保時捷")
// p1.start()
// p1.start2()
p1.start3()

console.log('name',p1.name)