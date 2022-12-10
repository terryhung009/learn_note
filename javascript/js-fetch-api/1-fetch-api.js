// console.log(fetch("https://jsonplaceholder.typicode.com/users"));

fetch('https://jsonplaceholder.typicode.com/users')
.then((response)=>{
  // console.log(response);
  // console.log(response.json());
  if(response.ok){
    console.log('SUCCESS');
    return response.json();
  }else{
    console.log('NOT SUCCESS');
  }
  
})
.then((data)=>{
  console.log(data);
})
.catch((error)=>{
  console.log('ERROR');
})

