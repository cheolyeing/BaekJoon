import java.io.*;
import java.util.*;

private val bw = BufferedWriter(OutputStreamWriter(System.`out`))

var apt = Array(15, { IntArray(15, { i -> 0 }) })
var k: Int = 0
var n: Int = 0

fun main(args: Array<String>) {
    buildApt()
    init()
    solution()
}

fun buildApt() {
    for (x in 1..14) {
        apt[0][x] = x
    }

    for (x in 1..14) {
        for (y in 1..14) {
            apt[x][y] = apt[x - 1][y] + apt[x][y - 1]
        }
    }
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var tc: Int = br.readLine().toInt()

    for (x in 1..tc) {
        k = br.readLine().toInt()
        n = br.readLine().toInt()
        bw.write(apt[k][n].toString()+"\n")
    }
}

private fun solution() {
    bw.flush()
    bw.close()
}
