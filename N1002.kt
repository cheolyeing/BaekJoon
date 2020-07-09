import java.io.*
import java.util.*

class Point(x: Int, y: Int, r: Int) {
    val x: Int = x
    val y: Int = y
    val r: Int = r
}

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val tc: Int = br.readLine().toInt()

    for (t in 1..tc step 1) {
        val st = StringTokenizer(br.readLine())
        val x1: Int = st.nextToken().toInt()
        val y1: Int = st.nextToken().toInt()
        val r1: Int = st.nextToken().toInt()

        val x2: Int = st.nextToken().toInt()
        val y2: Int = st.nextToken().toInt()
        val r2: Int = st.nextToken().toInt()

        val cho = Point(x1, y1, r1)
        val baek = Point(x2, y2, r2)

        val d: Int = squareDistance(cho, baek)

        var result: Int = 0

        when {
            x1 == x2 && y1 == y2 && r1 == r2 -> result = -1
            (r1 + r2) * (r1 + r2) > d && (r2 - r1) * (r2 - r1) < d -> result = 2
            (r1 + r2) * (r1 + r2) == d || (r2 - r1) * (r2 - r1) == d -> result = 1
            else -> result = 0
        }

        bw.write("${result}\n")
    }
    bw.flush()
}

fun squareDistance(p1: Point, p2: Point): Int {
    return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y)
}
