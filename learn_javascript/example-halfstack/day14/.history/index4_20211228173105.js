var express = require('express');
var app = express();
var fs = require('fs');

function render(filename, params) {
    var data = fs.readFileSync(filename, 'utf8');
    for (var key in params) {
        data = data.replace('{' + key + '}', params[key]);
    }
    return data;
}

app.get('/users/:name', function(req, res) {
    res.send(render('index.html', {
        name: req.params.name
    }));
})

app.listen(3000, function() {
    console.log('Example app listening on port 3000!')
})