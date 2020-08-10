var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().trim();
//var input = "6 8 10\n25 52 60\n5 12 13\n0 0 0"
var data = new Array()

function setting() {
	var line = input.split('\n')
	line.forEach((e) => {
		var sides = new Array()
		var side = e.split(' ')
		side.forEach((s) => {
			sides.push(parseInt(s))
		})
		data.push(sides)
	})
}

function solution() {
	data.forEach((s) => {pita(s)})
}

function pita(side) {
	var a = side[0]
	var b = side[1]
	var c = side[2]
	var max = Math.max(a,b,c)
	
	if(a==0 && b==0 && c==0) return
	if(a*a + b*b + c*c - 2*max*max == 0) console.log('right')
	else console.log('wrong')
}

setting()
solution()
