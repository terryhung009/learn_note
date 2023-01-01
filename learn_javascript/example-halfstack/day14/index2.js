var express = require('express');
var app = express();

app.get('/', function (req, res) {
  res.send('index');
})

app.get('/users/:userId/articles', function (req, res) {
  res.send('這是 user: ' + req.params.userId + ' 的文章');
})

app.get('/questions', function (req, res) {
  res.send('這是問答頁面');
})

app.get('/articles', function (req, res) {
  res.send('這是文章列表，你想看的 tab 是：' + req.query.tab);
})

app.listen(3000, function () {
  console.log('Example app listening on port 3000!')
})