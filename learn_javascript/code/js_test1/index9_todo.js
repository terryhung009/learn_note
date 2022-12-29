const content = document.getElementById('content')
const date = document.getElementById('date')
const time = document.getElementById('time')
const addedBtn = document.getElementById('addedBtn')
const deletedBtn = document.getElementById('deletedBtn')
const list = document.getElementById('list')

const listContent = []

//使用class方式
class RenderFeature {

    render() {
        let htmlStr = ''

        listContent.forEach(function (item) {
            // console.log('item',item)
            htmlStr = htmlStr + `
        <div class="item">
        <div>
          <p>內容：${item.content}</p>
          <p>時間：${item.date} ${item.time}</p>
        </div>
        </div>
        `
        })

        // for (let index = 0; index < array.length; index++) {
        //     const element = array[index];

        // }

        console.log(htmlStr)
        list.innerHTML = htmlStr

    }
}

//使用function方式
// function render() {
//     let htmlStr = ''

//     listContent.forEach(function (item) {
//         // console.log('item',item)
//         htmlStr = htmlStr + `
//         <div class="item">
//         <div>
//           <p>內容：${item.content}</p>
//           <p>時間：${item.date} ${item.time}</p>
//         </div>
//         </div>
//         `
//     })

//     // for (let index = 0; index < array.length; index++) {
//     //     const element = array[index];

//     // }

//     console.log(htmlStr)
//     list.innerHTML = htmlStr

// }

const renderFeature = new RenderFeature()

addedBtn.addEventListener('click', function () {
    // console.log(content.value)
    // console.log(date.value)
    // console.log(time.value)

    listContent.push({
        content: content.value,
        date: date.value,
        time: time.value,
    })

    // listContent.unshift({
    //     content: content.value,
    //     date: date.value,
    //     time: time.value,
    // })

    // console.log(listContent)

    // let htmlStr = ''

    // listContent.forEach(function (item) {
    //     // console.log('item',item)
    //     htmlStr = htmlStr + `
    //     <div class="item">
    //     <div>
    //       <p>內容：${item.content}</p>
    //       <p>時間：${item.date} ${item.time}</p>
    //     </div>
    //     </div>
    //     `
    // })

    // // for (let index = 0; index < array.length; index++) {
    // //     const element = array[index];

    // // }

    // console.log(htmlStr)
    // list.innerHTML = htmlStr

    // render()

    renderFeature.render()

})


deletedBtn.addEventListener('click', function () {

    listContent.pop()

    // listContent.shift()

    // let htmlStr = ''
    // listContent.forEach(function (item) {
    //     // console.log('item',item)
    //     htmlStr = htmlStr + `
    //     <div class="item">
    //     <div>
    //       <p>內容：${item.content}</p>
    //       <p>時間：${item.date} ${item.time}</p>
    //     </div>
    //     </div>
    //     `
    // })

    // // for (let index = 0; index < array.length; index++) {
    // //     const element = array[index];

    // // }

    // console.log(htmlStr)
    // list.innerHTML = htmlStr

    // render()

    renderFeature.render()
})

