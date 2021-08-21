var express = require('express');
var app = express();

app.get('/', function(req, res) {
    res.send('<h1>Hello Express</h1>');
})

app.listen(8000, () =>
    console.log('express is ready at http://localhost:8000')
);
