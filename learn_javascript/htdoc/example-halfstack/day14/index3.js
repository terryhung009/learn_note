var express = require('express');
var app = express();

app.get('/users/:name', function (req, res) {
  res.send(
    '<h2> Hello, ' + req.params.name + '</h2>' 
  );
})

app.listen(3000, function () {
  console.log('Example app listening on port 3000!')
})