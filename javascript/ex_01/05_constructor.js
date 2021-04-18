function SoccerPlayer() {
    this.position = "Forward";
}

var VanPersie = new SoccerPlayer();
console.log(VanPersie.position);

// =================================================================
function SoccerPlayer2(name, position) {
    this.name = name;
    this.position = position;
    this.whatIsYourName = function () {
        return "My name is " + this.name;
    }
    this.whatIsYourPosition = function() {
        return "My position is " + this.position;
    }
}

var player = new SoccerPlayer2("beomseok Ko", "LB");
console.log(player.whatIsYourPosition());
console.log(player.whatIsYourName());
