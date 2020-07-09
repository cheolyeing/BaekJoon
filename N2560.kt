import java.io.*;
import java.util.*;

var a: Int = 0
var b: Int = 0
var d: Int = 0
var n: Int = 0
val mod: Int = 1000

var arr = Array(1000002) { IntArray(2) }

fun main(args: Array<String>) {
    init()
    solution()
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(br.readLine())
    a = st.nextToken().toInt()
    b = st.nextToken().toInt()
    d = st.nextToken().toInt()
    n = st.nextToken().toInt()
}

private fun solution() {
    arr[0][0] = 1
    arr[0][1] = 1
    if (a == 1) arr[1][0] = 1
    else arr[1][0] = 0
    arr[1][1] = 1 + arr[1][0]

    for (x in 2..n step 1) {
        var res: Int = 0
        if (x - a >= 0) {
            res += arr[x - a][1]
        }
        if (x - b >= 0) {
            res -= arr[x - b][1]
        }
        res %= mod
        arr[x][0] = res
        arr[x][1] = (arr[x - 1][1] + res)

        //println("${arr[x][0]} ${arr[x][1]}")
    }
    var ans: Int = 0
    ans += arr[n][1]
    if (n - d >= 0) ans -= arr[n - d][1]
    ans = (ans + 1000) % mod

    print(ans)
}
