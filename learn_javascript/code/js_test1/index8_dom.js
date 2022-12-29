//dom操作
//window
//document

//callback回呼
window.addEventListener('load', function(){
    // console.log('load')
    const title = this.document.getElementById('title')
    // console.log(title)
    title.innerText="訂閱布魯斯前端"

    const btn = document.getElementById('btn')
    btn.addEventListener('click',function(){
        console.log('點下去')

    })

    const box1 = document.getElementById('box')
    box1.innerHTML='<p>test</p>'

    const input1 = document.getElementById('input1')
    input1.addEventListener('keyup',function(event){
        console.log('event.target.value:',event.target.value)
    }) 

})