var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().trim();
//var input = "4\n1 3 5 7"
	
var num = 0
var cnt = 0
var data = new Array()
var prime = new Array()

function setting() {
	var line = input.split('\n')
	num = parseInt(line[0])
	var nums = line[1].split(' ')
	nums.forEach((e) => {
		data.push(parseInt(e))
	})
}

function eratosthenes() {
	for(var i=0; i<1001; i++) prime.push(true)
	
	prime[0] = false
	prime[1] = false
	
	for(var i=2; i<1001; i++) {
		if(!prime[i]) continue
		for(var j=2*i; j<1001; j+=i) {
			prime[j] = false
		}
	}
}

function solution() {
	data.forEach((d) => {
		if(prime[d]) cnt++
	})
	console.log(cnt)
}

setting()
eratosthenes()
solution()
