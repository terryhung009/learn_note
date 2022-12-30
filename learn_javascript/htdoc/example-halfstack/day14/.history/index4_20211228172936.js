app.get('/users/:name', function(req, res) {
    res.send(render('index.html', {
        name: req.params.name
    }));
})