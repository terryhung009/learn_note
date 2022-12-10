"use strict";
// let aaa : string = 'burce';
// console.log('aaa',aaa);
var __classPrivateFieldSet = (this && this.__classPrivateFieldSet) || function (receiver, state, value, kind, f) {
    if (kind === "m") throw new TypeError("Private method is not writable");
    if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a setter");
    if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot write private member to an object whose class did not declare it");
    return (kind === "a" ? f.call(receiver, value) : f ? f.value = value : state.set(receiver, value)), value;
};
var _Live2_name;
//========================基本類型
// let str:string = 'burce'
// let str1:string;
// // str1 = 999;
// let num:number =1000
// let boo:boolean=true
// // boo=0000
// let n :null = null
// let un:undefined = undefined
// let test:any =true
// //陣列array
// // let arr:string[]=['a','b',1];
// // let arr2:string[][] = [['aa','bb',1]];
// //元祖
// let tuple:[number,string,boolean]=[1,'a',true];
// let tuple2:[string, string][] =[['a','b'],[1,2]];
// //===================枚舉 enum
// //開直播
// //成功 失敗 直播中
// //0-1 1 
// enum LiveStatus{
//   SUCCESS = 0,
//   FAIL = -1,
//   STREAMING =1
// }
// const staus = LiveStatus.SUCCESS;
// //================== Union
// let aaa:number | string;
// aaa=123;
// aaa='wilson'
// aaa=true
// //================= type
// type A = number | string
// type B = boolean |string
// let a1: A
// a1=999
// a1='str'
// a1=true
// let b1:B
// b1=true
// //=================== interface
// interface user{
//   name: string;
//   age: number;
// }
// //=====================object
// /*
// //type 不可擴充
// //interface 可以重複宣告方式擴充
// */
// type Card ={
//   name:string
//   desc: string
// }
// //不可重複
// type Card ={
//   age:number
// }
// const obj:Card={
//   name:'bruce',
//   desc:'.....'
// }
// interface Card2{
//   name:string
//   desc: string
// }
// interface Card2{
//   age?:number//除了number也可接受undefined
// }
// const obj2:Card2={
//   name:'bruce',
//   desc:'.....',
//   age:100
// }
// const obj3:Card2={
//   name:'bruce',
//   desc:'.....',
//   //未填age屬性也不報錯
// }
// //==============function
// //參數parameter
// //function hello(){}
// function hello(a:string,b:string){
//   return a + b
// }
// function hello2(a:string,b:string):number{
//   console.log(a,b)
//   return 999
// }
// function hello3(a:number,b:boolean,c:string){
//   return 100
// }
// //undefined
// function test2(a:number){
//   console.log(a);
// }
// function hello4(age:number,name4?:string){
// // let a:number
// // a=age
// if(age === undefined) return -1
// test2(age)
// return
// }
// //箭頭函式
// const func = ()=>{
// }
// const func2= ()=>{
//   return 1;
// }
// //========== 斷言 as                //對於 unknown  不知道類型
// type Data ={
//   userId:number,
//   id: number,
//   title:string,
//   completed:boolean
// }
// fetch('https://jsonplaceholder.typicode.com/todos/1')
// async function getData(params:type){
//   const res = await fetch('https://jsonplaceholder.typicode.com/todos/1')
//   const data = await res.json() as Data
// }
// const data1:Data={
//     "userId": 1,
//     "id": 1,
//     "title": "delectus aut autem",
//     "completed": false
// }
// type Beta = {
//   name:string
// }
// //假設data1是動態的
// const beta = data1 as unknown as Beta
//============ class
//成員
//private 私有
//public 公開
//protected 受保護
class Live {
    constructor(roomName1, id1, name1) {
        console.log('建立直播中...');
        this.roomName = roomName1;
        this.id = id1;
        this.name = name1;
    }
}
class CarLive extends Live {
    constructor(roomName1, id1, name1) {
        super(roomName1, id1, name1);
    }
    start() {
        super.name;
        // super.id//訪問不到
    }
}
//外面
// const live = new Live('1號','00001','burce')
// console.log(live)
const carLive = new CarLive('car room', '00002', 'bruce2');
// carLive.name//訪問不到
class Live2 {
    constructor(name) {
        _Live2_name.set(this, void 0); //js設定為私有變數
        __classPrivateFieldSet(this, _Live2_name, name, "f");
    }
}
_Live2_name = new WeakMap();
const live2 = new Live2('live2');
class Car {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
    start() {
    }
}
//===========================泛型  使用時才知道型別
function print(data) {
    console.log('data=', data);
}
print(999);
// print<number>("string")//型別不對會報錯
print("burce");
class Print {
    constructor(d) {
        this.data = d;
    }
}
const p = new Print(999);
const p1 = new Print('burce');
console.log('p', p);
console.log('p1', p1);
//key
//value
const cats = {
    miffy: { age: 10, breed: "Persian" },
    boris: { age: 5, breed: "Maine Coon" },
    mordred: { age: 16, breed: "British Shorthair" },
    burce: { age: 10, breed: "British Shorthair" },
};
console.log(cats);
const obj1 = {
    name: true,
    // age:123
};
const todo = {
    title: "Clean room",
    completed: false,
    createdAt: 1615544252770,
};
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiMS5qcyIsInNvdXJjZVJvb3QiOiIiLCJzb3VyY2VzIjpbIi4uL3NyYy8xLnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7QUFBQSw4QkFBOEI7QUFDOUIsMEJBQTBCOzs7Ozs7OztBQUcxQiw4QkFBOEI7QUFFOUIsMkJBQTJCO0FBQzNCLG1CQUFtQjtBQUNuQixpQkFBaUI7QUFFakIsdUJBQXVCO0FBQ3ZCLHVCQUF1QjtBQUN2QixjQUFjO0FBQ2QscUJBQXFCO0FBQ3JCLCtCQUErQjtBQUUvQixxQkFBcUI7QUFFckIsWUFBWTtBQUNaLG1DQUFtQztBQUNuQyw0Q0FBNEM7QUFFNUMsT0FBTztBQUNQLGtEQUFrRDtBQUNsRCxvREFBb0Q7QUFFcEQsK0JBQStCO0FBRS9CLFFBQVE7QUFDUixjQUFjO0FBRWQsV0FBVztBQUVYLG1CQUFtQjtBQUNuQixpQkFBaUI7QUFDakIsZUFBZTtBQUNmLGlCQUFpQjtBQUVqQixJQUFJO0FBQ0osb0NBQW9DO0FBRXBDLDZCQUE2QjtBQUU3QiwyQkFBMkI7QUFDM0IsV0FBVztBQUNYLGVBQWU7QUFDZixXQUFXO0FBRVgsMkJBQTJCO0FBRTNCLDJCQUEyQjtBQUMzQiwyQkFBMkI7QUFFM0IsWUFBWTtBQUNaLFNBQVM7QUFDVCxXQUFXO0FBQ1gsVUFBVTtBQUVWLFdBQVc7QUFDWCxVQUFVO0FBRVYsa0NBQWtDO0FBRWxDLGtCQUFrQjtBQUNsQixrQkFBa0I7QUFDbEIsaUJBQWlCO0FBQ2pCLElBQUk7QUFFSixnQ0FBZ0M7QUFDaEMsS0FBSztBQUNMLGNBQWM7QUFDZCx5QkFBeUI7QUFDekIsS0FBSztBQUdMLGVBQWU7QUFDZixnQkFBZ0I7QUFDaEIsaUJBQWlCO0FBQ2pCLElBQUk7QUFDSixTQUFTO0FBQ1QsZUFBZTtBQUNmLGVBQWU7QUFDZixJQUFJO0FBRUosbUJBQW1CO0FBQ25CLGtCQUFrQjtBQUNsQixpQkFBaUI7QUFDakIsSUFBSTtBQUNKLG1CQUFtQjtBQUNuQixnQkFBZ0I7QUFDaEIsaUJBQWlCO0FBQ2pCLElBQUk7QUFF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