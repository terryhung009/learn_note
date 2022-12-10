
const app = new Vue({
  el:'#app',
  data:{
    bobby:{
      name:"bobby boone",
      age:25,
    },
    john:{
      name:"John boby",
      age:35,
    }
  }
  ,
  template:`
  <div>
  <h1>Name:{{ john.name }}</h1>
  <h2>Age: {{ john.age }}</h2>
  </div>
  `
})