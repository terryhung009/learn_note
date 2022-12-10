<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <Module1 />
    <Module2 />
  </div>
</template>

<script>
import Module1 from "./Module1.vue"
import Module2 from "./Module2.vue"

export default {

  name: 'HelloWorld',
  components:{
    Module1,
    Module2,
    
},
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
