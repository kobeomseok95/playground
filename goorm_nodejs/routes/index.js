var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function (req, res, next) {
  res.render('index', { title: '메인' });
});

router.get('/test', function (req, res, next) {
  res.render('test', { title: 'Test 페이지' });
});

module.exports = router;
