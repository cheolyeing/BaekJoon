var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().trim();
//var input = "17\n17"
	
var m = 0
var n = 0
var sum = 0
var min = 10000
var prime = new Array()

function setting() {
	var line = input.split('\n')
	m = parseInt(line[0])
	n = parseInt(line[1])
	eratosthenes()
}

function eratosthenes() {
	for(var i=0; i<n+1; i++) prime.push(true)
	
	prime[0] = false
	prime[1] = false
	
	for(var i=2; i<Math.sqrt(n)+1; i++) {
		if(!prime[i]) continue
		for(var j=2*i; j<n+1; j+=i) {
			prime[j] = false
		}
	}
}

function solution() {
	for(var i=m; i<n+1; i++) {
		if(prime[i]) {
			sum += i
			min = Math.min(min, i)
		}
	}
	
	console.log(min==10000 ? -1 : sum + '\n' + min)
}

setting()
solution()
