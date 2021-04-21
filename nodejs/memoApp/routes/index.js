var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');

mongoose.connect('', 
  {useNewUrlParser: true});
var db = mongoose.connection;
db.on('error', console.error.bind(console, "connection error:"));
db.once('open', () => {
	console.log("DB connected");
});

var Schema = mongoose.Schema;

var Memo = new Schema({
	author: String,
	contents: String,
	date: Date
});

var memoModel = mongoose.model('Memo', Memo);

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

router.get('/load', function(req, res, next) {
	memoModel.find({}, function(err, data){
		res.json(data);
	});
});

router.post('/write', function(req,res,next) {
	var author = req.body.author;
	var contents = req.body.contents;
	var date = Date.now();
	
	var memo = new memoModel();
	
	memo.author = author;
	memo.contents = contents;
	memo.date = date;
	memo.comments = [];
	

	memo.save(function (err) {
		if (err) {
			throw err;
		}
		else {
			res.json({status: "SUCCESS"});
		}
	});
});

router.post('/del', function(req, res, next) {
	var _id = req.body._id;
	memoModel.deleteOne({_id: _id}, function(err, result) {
		if(err) {
			throw err;
		}
		else {
			res.json({status: "SUCCESS"});
		}
	});
});

router.post('/modify', function(req, res, next) {
	var _id = req.body._id;
	var contents = req.body.contents;
	
	memoModel.findOne({_id: _id}, function(err, memo) {
		if(err) {
			throw err;
		}
		else {
			memo.contents = contents;
			
			memo.save(function (err) {
				if (err) {
					throw err;
				}
				else {
					res.json({status: "SUCCESS"});
				}
			});
		}
	});
});

module.exports = router;
