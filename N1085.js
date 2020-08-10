var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().trim();
//var input = "6 2 10 3"
var data = new Array()

function setting() {
	var dots = input.split(' ')
	dots.forEach((e) => {
		data.push(parseInt(e))
	})
}

function solution() {
	console.log(Math.min(data[0], data[1], data[2]-data[0], data[3]-data[1]))
}

setting()
solution()
