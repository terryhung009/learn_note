//for迴圈

// for (let i = 0; i < 10; i = i + 1) {
//     console.log(i);
// }

let classA = [100, 70, 59, 40];
classA.push(30);
// console.log(classA[0]);
// console.log(classA[1]);
// console.log(classA[2]);
// console.log(classA[3]);




for (let i = 0; i < classA.length; i++) {
    // console.log('i:', classA[i])
    if (i === 2) {
        classA[i] = 999
    }
}

console.log('classA', classA);

const a1 = {
    name: '布魯斯',
    desc: '貼文一',
}

console.log(a1.name);
console.log(a1.desc);

//物件一、物件二
const posts = [
    {
        name: '布魯斯',
        desc: '貼文一',
    },
    {
        name: '布魯斯2號',
        desc: '貼文二',
    }
]

for (let i = 0; i < posts.length; i++) {
    // console.log('i:', classA[i])
    if (i === 1) {
        let post = posts[i]
        console.log(post)
    }
}

//while迴圈

let condition = true;
let target = 10;
let j = 0;

while (condition) {
    if (j === target) {
        condition = false;
    }
    console.log(j)
    j++
}