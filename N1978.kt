import java.io.*;
import java.util.*;

private val bw = BufferedWriter(OutputStreamWriter(System.`out`))
var n: Int = 0
var ans: Int = 0

fun main(args: Array<String>) {
    init()
    solution()
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()

    val st = StringTokenizer(br.readLine())
    for (x in 1..n step 1) {
        var num: Int = st.nextToken().toInt()
        if (isPrime(num))
            ans++
    }
    bw.write(ans.toString())
}

private fun solution() {

    bw.flush()
    bw.close()
}

fun isPrime(num: Int): Boolean {
    if (num == 1) return false
    for (x in 2..Math.sqrt(num.toDouble()).toInt() step 1) {
        if (num % x == 0) return false
    }
    return true
}
