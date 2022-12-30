var express = require('express');
var app = express();
var fs = require('fs');

function render(filename, params, callback) {
    fs.readFile(filename, 'utf8', function(err, data) {
        if (err) return cabllack(err);
        for (var key in params) {
            data = data.replace('{' + key + '}', params[key]);
        }
        callback(null, data); // 用 callback 傳回結果
    });
}

app.get('/users/:name', function(req, res) {
    render('index.html', {
        name: req.params.name
    }, function(err, data) {
        res.send(data); // 這邊要寫一個 function 才能接收到資料
    });
})

app.listen(3000, function() {
    console.log('Example app listening on port 3000!')
})