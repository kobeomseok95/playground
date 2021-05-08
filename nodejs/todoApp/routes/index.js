var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: '간단한 ToDo 리스트 예제 실습' });
});

module.exports = router;
