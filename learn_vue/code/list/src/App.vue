<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <h1>Vue 3 Todo App</h1>
  <form v-on:submit="addNewTodo">
    <label for="">New Todo</label>
    <input type="text" name="newtodo" id="">
    <button>Add New Todo</button>
  </form>
  
  
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'


export default {
  name: 'App',
  components: {
    // HelloWorld,
    
  },
  data(){
        return{
            items: [{ message: 'Foo' }, { message: 'Bar' }],
             myObject: {
                title: 'How to do lists in Vue',
                author: 'Jane Doe',
                 publishedAt: '2016-04-10'
              }
        }   
    }
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
