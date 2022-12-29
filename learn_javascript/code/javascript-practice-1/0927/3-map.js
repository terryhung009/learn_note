let A = [9000, 8500, 5500, 6500];
let B = A.map(function (value, index, array) {
    return value*2;
});

console.log(A) // [9000, 8500, 5500, 6500] - 原陣列不會被修改
console.log(B) // [18000, 17000, 11000, 13000] - 發財摟 ^____^