// let aaa : string = 'burce';
// console.log('aaa',aaa);


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

class Live{
  roomName:string
  private id :string
  protected name:string

  constructor(roomName1: string, id1: string,name1:string){
    console.log('建立直播中...')
    this.roomName = roomName1
    this.id = id1
    this.name=name1
  }
}

class CarLive extends Live{
  constructor(roomName1: string, id1: string,name1:string){
    super(roomName1,id1,name1)




  }
  start(){
    super.name
    // super.id//訪問不到

  }


}

//外面
// const live = new Live('1號','00001','burce')
// console.log(live)
const carLive = new CarLive('car room','00002','bruce2')
// carLive.name//訪問不到


class Live2{
  #name//js設定為私有變數
  constructor(name:string){
    this.#name =name;
  }
}

const live2 = new Live2('live2')
// console.log(live2.#name);//訪問不到

// 屬性都應該為public
interface CarProps{
  name:string,
  age:number,
  start:()=>void
}


class Car implements CarProps{
  name:string
  age:number
  

  constructor(name:string,age:number){
    this.name= name;
    this.age =age;
  }

  start(){

  }
}


//===========================泛型  使用時才知道型別

function print<T>(data: T){
  console.log('data=' , data)
}

print<number>(999)
// print<number>("string")//型別不對會報錯

print<string>("burce")


