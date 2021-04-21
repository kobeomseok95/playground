var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function (req, res, next) {
  res.render('index', {
    title: 'Pug' 
  });
});

router.get('/test', function (req, res, next) {
  res.render('test', { 
    title: 'Test 페이지', 
    message: 'Welcome to Goorm Edu', 
  });
});

module.exports = router;
