fetch('https://jsonplaceholder.typicode.com/users', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({
    name: 'User 1'
  })
})
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
// .catch((error)=>{
//   console.log('ERROR');
// })

