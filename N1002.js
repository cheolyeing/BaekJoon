var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().trim();
//var input = "3\n0 0 13 40 0 37\n0 0 3 0 7 4\n1 1 1 1 1 5\n0 0 7 6 0 2"

var tc = 0
var data = new Array()

function setting() {
	var line = input.split('\n')
	tc = parseInt(line[0])
	line.forEach((e)=>{
		var dots = new Array()
		if(e!=tc+"") {
			var pos = e.split(' ')
			pos.forEach((p)=>{
				dots.push(parseInt(p))
			})
			data.push(dots)
		}
	})
}

function solution(dots) {
	var x1 = dots[0]
	var y1 = dots[1]
	var r1 = dots[2]
	var x2 = dots[3]
	var y2 = dots[4]
	var r2 = dots[5]
	var d = distance(x1, y1, x2, y2)
	
	if(x1==x2 && y1==y2 && r1==r2) return -1
	if(square(r1+r2)==d) return 1
	if(square(r1-r2)==d) return 1
	if(square(r1-r2)<d && d<square(r1+r2)) return 2
	return 0
}

function distance(x1, y1, x2, y2) {
	var x = Math.abs(x1-x2)
	var y = Math.abs(y1-y2)
	return x*x + y*y
}

function square(val) {
	return val*val
}

setting()
data.forEach((dots)=>{console.log(solution(dots))})
