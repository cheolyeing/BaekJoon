var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().trim();
//var input = "2\n1\n3\n2\n3"
	
var tc = 0
var data = new Array()
var apt = Array.from(Array(15), ()=>new Array(15).fill(1))

function setting() {
	var line = input.split('\n')
	tc = parseInt(line[0])
	
	for(var i=1; i<line.length; i+=2) {
		var k = parseInt(line[i])
		var n = parseInt(line[i+1])
		data.push([k, n])
	}
}

function solution() {
	for(var i=0; i<15; i++) {
		for(var j=2; j<15; j++) {
			if(i==0) apt[i][j] = j
			else apt[i][j] = apt[i-1][j] + apt[i][j-1]
		}
	}
}

setting()
solution()
data.forEach((e) => {console.log(apt[e[0]][e[1]])})
