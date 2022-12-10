Vue.component('friend-component',{
  props:[
    'friend'
  ],
  filters:{
    fullName(value){
      return `${value.first} ${value.last}`;
    },
    ageInOneYear(age){
      return age + 1;
    }
  },
  methods:{
    incrementAge(friend){
      friend.age = friend.age +1;
    },
    decrementAge(friend){
      friend.age = friend.age -1;
    }
  },
  template:`
  <div>
  <h4>{{friend | fullName}}</h4>
  <h4>{{friend.age}}</h4>
  <button v-on:click="incrementAge(friend)">+</button>
  <button v-on:click="decrementAge(friend)">-</button>
  <input v-model="friend.first"/>
  <input v-model="friend.last"/>
  </div>
  `
})



const app = new Vue({
  el:'#app',
  data:{
    friends:[
      {
        first:"bobby",
        last:"boone",
        
        age:25,
      },
      {
        first:"John",
        last:"boby",
        
        age:35,
      }
    ],
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
    
  },
  methods:{
    
  },
  
  template:`
  <div>
  <friend-component v-for="item in friends" v-bind:friend="item"/>
  
  
  </div>
  `
})