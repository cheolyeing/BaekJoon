import java.io.*;
import java.util.*;

private val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main(args: Array<String>) {
    init()
    solution()
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    while (true) {
        val st = StringTokenizer(br.readLine())
        var a: Int = st.nextToken().toInt()
        var b: Int = st.nextToken().toInt()
        var c: Int = st.nextToken().toInt()
        if (a == 0 && b == 0 && c == 0) break
        bw.write(triangle(a, b, c))
    }
}

private fun solution() {

    bw.flush()
    bw.close()
}

fun triangle(a: Int, b: Int, c: Int): String {
    var A: Int = Math.max(Math.max(a, b), c)
    var B: Int = Math.min(Math.min(a, b), c)
    var C: Int = a + b + c - A - B

    if (A * A == B * B + C * C) return "right\n"
    return "wrong\n"
}
