
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
  <h2 v-for="friend in friends">
  <h4>{{friend | fullName}}</h4>
  <h4>{{friend.age}}</h4>
  <button v-on:click="incrementAge(friend)">+</button>
  <button v-on:click="decrementAge(friend)">-</button>
  <input v-model="friend.first"/>
  <input v-model="friend.last"/>
  </h2>
  </div>
  `
})