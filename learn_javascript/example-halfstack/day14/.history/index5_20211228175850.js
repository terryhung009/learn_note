var express = require('express');
var app = express();

app.set('view engine', 'ejs');
app.get('/users/:name', function(req, res) {

    res.render('index', { // 這邊不用寫 views/index 是因為 express 預設 template 就是會放在 views 資料夾裡面
        name: req.params.name,
        items: ['peter', 'nick', 'cake']
    })
})

app.listen(3000, function() {
    console.log('Example app listening on port 3000!')
})