// console.log(window);

axios.get("https://jsonplaceholder.typicode.com/users")
.then((response)=>{
  // console.log(response);
  console.log(response.data);
});