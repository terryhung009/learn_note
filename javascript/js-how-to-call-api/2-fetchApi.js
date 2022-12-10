// console.log(window);

fetch("https://jsonplaceholder.typicode.com/users")
.then((response)=>{
  // console.log(response);
  return response.json();
}).then((json)=>{
  console.log(json);
})