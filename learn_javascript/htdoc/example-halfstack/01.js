// document.addEventListener("DOMContentLoaded", function (event) {
//     var btn = document.querySelector('#btn');
//     btn.addEventListener('click', function () {
//         alert('click!');
//     })
// });

// document.addEventListener("DOMContentLoaded", function (event) {
//     var btn = document.querySelector('#btn');
//     btn.addEventListener('click', onClick);

//     function onClick() {
//         alert('click!');
//     }
// });

document.addEventListener("DOMContentLoaded", function (event) {
    var btn = document.querySelector('#btn');
    btn.addEventListener('click', function () {
        alert('click!');
    })

    var toggle = document.getElementById('toggle');
    var isVisible = true;
    toggle.addEventListener('click', function () {
        isVisible = !isVisible;
        var post = document.getElementsByClassName('post')[0];
        console.log(post);
        post.style.display = isVisible ? 'block' : 'none';
        toggle.innerHTML = isVisible ? 'hide' : 'show';
    })
    
    var str = 'abcde';
    function reverse(str) {
        var ret = '';
        for (var i = str.length - 1; i >= 0; i--) {
            ret += str[i];
        }
        return ret;
    }

    function reverse2(str) {
        return str.split('').reverse().join('');
    }

    console.log(reverse(str) === reverse2(str));

});