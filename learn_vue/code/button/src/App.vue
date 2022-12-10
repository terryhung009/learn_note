<template>
  <img alt="Vue logo" src="./assets/logo.png">

  <div v-for="(number,index) in numbers" :key="index">
  <button v-on:click="getTheSelectedOne(number)">Get The Value</button>
  <br>
  <span v-show="show.show" :id="show.id">{{ number }}</span>
  </div>
  
</template>

<script>


export default {
  name: 'App',
  components: {
    
  },
  methods: {
    getTheSelectedOne(number){
      alert(number);
    },
    doShow(){

    }
  },data() {
    return {
      numbers:[1,
        2,
        3,
        4,
        5],
        show:[{id:1,show:true
        }]
        
      
    }
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
