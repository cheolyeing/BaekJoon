import java.io.*;
import java.util.*;

class Node(val t: Int, val p: Int) : Comparable<Node> {
    var time: Int = t
    var pos: Int = p

    override fun compareTo(other: Node): Int {
        return this.time - other.time
    }
}

private val bw = BufferedWriter(OutputStreamWriter(System.`out`))
var arr = IntArray(100001, { i -> Int.MAX_VALUE })
var a = 0
var b = 0
var n = 0
var m = 0

fun main(args: Array<String>) {
    init()
    solution()
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(br.readLine())
    a = st.nextToken().toInt()
    b = st.nextToken().toInt()
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()
}

private fun solution() {
    var pq = PriorityQueue<Node>()

    pq.add(Node(0, n))
    arr[n] = 0

    while (!pq.isEmpty()) {
        var cur: Node = pq.poll()
        if (cur.pos == m) {
            bw.write(cur.time.toString())
            break
        }
        for (x in nextPos(cur.pos)) {
            if (inRange(x) && cur.time + 1 < arr[x]) {
                arr[x] = cur.time + 1
                pq.add(Node(cur.time + 1, x))
            }
        }
    }

    bw.flush()
    bw.close()
}

fun nextPos(pos: Int): IntArray {
    return intArrayOf(pos + 1, pos - 1, pos * a, pos * b, pos + a, pos + b, pos - a, pos - b)
}

fun inRange(pos: Int): Boolean {
    return pos >= 0 && pos <= 100000
}
