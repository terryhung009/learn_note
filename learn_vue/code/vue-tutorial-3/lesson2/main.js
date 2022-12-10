
const app = new Vue({
  el:'#app',
  data:{
    bobby:{
      first:"bobby",
      last:"boone",
      
      age:25,
    },
    john:{
      first:"John",
      last:"boby",
      
      age:35,
    }
  },
  computed:{
    bobbyFullName(){
      return ` ${this.bobby.first} ${this.bobby.last}`
    },
    johnFullName(){
      return ` ${this.john.first} ${this.john.last}`
    },
    johnAgeInOneYear(){
      return this.john.age + 1;
    }
  },
  filters:{
    fullName(value){
      return `${value.first} ${value.last}`;
    },
    ageInOneYear(age){
      return age + 1;
    }
  },
  
  template:`
  <div>
  <h1>Name: {{ johnFullName }}</h1>
  <h1>Name: {{ john | fullName }}</h1>
  <h2>Age: {{ john.age }}</h2>
  <h2>Age: {{ johnAgeInOneYear }}</h2>
  <h2>Age: {{ john.age | ageInOneYear }}</h2>
  <h1>Name: {{ bobbyFullName }}</h1>
  <h2>Age: {{ john.age }}</h2>
  </div>
  `
})