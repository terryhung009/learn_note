// document.addEventListener("DOMContentLoaded", function (event) {
//     var btn = document.querySelector('#btn');
//     btn.addEventListener('click', function () {
//         alert('click!');
//     })
// });

document.addEventListener("DOMContentLoaded", function (event) {
    var btn = document.querySelector('#btn');
    btn.addEventListener('click', onClick);

    function onClick() {
        alert('click!');
    }
});