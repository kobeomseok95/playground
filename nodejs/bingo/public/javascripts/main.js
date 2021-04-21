var bingo = {
	is_my_turn: Boolean,
	socket: null,
		
	init: function(socket){
		var self = this;
		var user_cnt = 0;
		
		this.is_my_turn = false;
		
		socket = io();

		socket.on("check_number", function (data) {
			self.where_is_it(data.num);
			self.print_msg(data.username + "님이 '" + data.num + "'을 선택했습니다.");
		});
		
		socket.on("game_started", function(data){
			console.log("enter the game_started");
			self.print_msg(data.username + " 님이 게임을 시작했습니다.");
			$("#start_button").hide();
		});
		
		socket.on("update_users", function (data, user_count) {
			console.log(data);
			user_cnt = user_count;
			self.update_userlist(data, socket);
		});

		//join
		socket.on("connect", function() {
			socket.emit("join", { username: $('#username').val() });
		});
		
		var numbers = [];
		for(var i=1; i<=25; i++){
			numbers.push(i);
		}
		
		numbers.sort(function (a,b) {
			var temp = parseInt(Math.random() * 10);
			var isOddOrEven = temp%2;
			var isPosOrNeg = temp > 5 ? 1 : -1;
			return (isOddOrEven*isPosOrNeg);
		});
		
		$("table.bingo-board td").each(function (i) {
			$(this).html(numbers[i]);
			
			$(this).click(function (){
				if(user_cnt == 1){
					self.print_msg("<알림> 최소 2명부터 게임이 가능합니다.");
				}
				else{
					self.select_num(this, socket);
				}
			});
		});
		
		$("#start_button").click(function () {
			if(user_cnt == 1){
			   self.print_msg("<알림> 최소 2명부터 게임이 가능합니다.");
			}
			else{
				socket.emit('game_start', { username: $('#username').val() });
				self.print_msg("<알림> 게임을 시작했습니다.");
				$("#start_button").hide();
			}
		});
		
	}, // init 끝

	select_num: function (obj, socket) {
		if(this.is_my_turn && !$(obj).attr("checked")) {
			//send num to other players
			socket.emit("select", { 
				username: $('#username').val(), 
				num: $(obj).text() 
			});		
			this.check_num(obj);
			
			this.is_my_turn = false;
		}
		else {
			this.print_msg("<알림> 차례가 아닙니다!");
		}
	},
	
	where_is_it: function (num) {
		var self = this;
		var obj = null;
		
		$("table.bingo-board td").each(function (i) {
			if ($(this).text() == num) {
				self.check_num(this);
			}
		});
	},
	
	check_num: function (obj) {
		$(obj).css("text-decoration", "line-through");
		$(obj).css("color", "lightgray");
		$(obj).attr("checked", true);
	},
	
	update_userlist: function (data, this_socket) {
		var self = this;
		$("#list").empty();
		console.log(data);
		
		$.each(data, function (key, value) {
			var turn = "(-) ";
			if(value.turn === true) {
				turn = "(*) ";
				
				if(value.id == this_socket.id ) {
					self.is_my_turn = true;
				}
			}
			if(value.id == this_socket.id){
				$("#list").append("<font color='DodgerBlue'>" + turn + value.name + "<br></font>");
			}
			else{
				$("#list").append("<font color='black'>" + turn + value.name  + "<br></font>");
			}
		});
	},
	
	
	print_msg: function (msg) {
		$("#logs").append(msg + "<br />");
		$('#logs').scrollTop($('#logs')[0].scrollHeight);
	}
};

$(document).ready(function () {
	bingo.init();
});
