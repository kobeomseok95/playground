var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');   // http request logging

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');

var app = express();    // app 객체 선언, express()로 생성, 웹 서버 특징 기술

// view engine setup
app.set('views', path.join(__dirname, 'views'));    // 뷰 템플릿 경로 라우팅
app.set('view engine', 'jade');   // 뷰에 사용되는 엔진

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/users', usersRouter);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
