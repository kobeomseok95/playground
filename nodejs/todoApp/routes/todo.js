var express = require('express');
var router = express.Router();

// todo 보여주기
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});

// todo 상세 보여주기
router.get('/:id', function(req, res, next) {
  console.log('id : ' + req.params.id);
});

// todo 등록
router.post('/', function(req, res, next) {
  
});

// todo 수정
router.patch('/:id', function(req, res, next) {
  console.log('id : ' + req.params.id);
});

// todo 삭제
router.delete('/:id', function(req, res, next) {
  console.log('id : ' + req.params.id);
})

module.exports = router;
