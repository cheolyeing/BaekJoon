import java.io.*;
import java.util.*;

private val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main(args: Array<String>) {
    init()
    solution()
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(br.readLine())

    val x = st.nextToken().toInt()
    val y = st.nextToken().toInt()
    val w = st.nextToken().toInt()
    val h = st.nextToken().toInt()

    var r : Int = Math.min(w-x, x)
    var c : Int = Math.min(h-y, y)

    var answer : Int = Math.min(r, c)
    bw.write(answer.toString())
}

private fun solution() {
    bw.flush()
    bw.close()
}
