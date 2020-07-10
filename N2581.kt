import java.io.*;
import java.util.*;

private val bw = BufferedWriter(OutputStreamWriter(System.`out`))
var m: Int = 0
var n: Int = 0

fun main(args: Array<String>) {
    init()
    solution()
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    m = br.readLine().toInt()
    n = br.readLine().toInt()

}

private fun solution() {
    var prime = Array(n + 1, { i -> true })

    prime[1] = false
    for (x in 2..(n / 2) step 1) {
        if (!prime[x]) continue
        for (y in 2 * x..n step x) {
            prime[y] = false
        }
    }

    var ans: Int = 0
    var min: Int = Int.MAX_VALUE
    for (x in m..n step 1) {
        if (prime[x]) {
            ans += x
            min = Math.min(min, x)
        }
    }
    var answer: String = ans.toString() + "\n" + min.toString()
    if (ans == 0) bw.write((-1).toString()
    )
    else bw.write(answer)
    bw.flush()
    bw.close()
}
