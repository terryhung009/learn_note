let A = [9000, 8500, 5500, 6500];
let B = A.forEach(function (value, index, array) {
    return value*2; // forEach 沒有在 return 的，所以不會有作用
});
console.log(B); // undefined