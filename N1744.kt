import java.io.*;
import java.util.*;

private val bw = BufferedWriter(OutputStreamWriter(System.`out`))
var n: Int = 0
var listPlus = ArrayList<Int>()
var listMinus = ArrayList<Int>()

fun main(args: Array<String>) {
    init()
    solution()
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    for (x in 1..n) {
        val num: Int = br.readLine().toInt()
        if (num > 0) listPlus.add(num)
        else listMinus.add(num)
    }
}

private fun solution() {
    Collections.sort(listPlus)
    Collections.sort(listMinus)

    var ans: Int = 0
    for (x in 0..listMinus.lastIndex - 1 step 2)
        ans += listMinus.get(x) * listMinus.get(x + 1)

    for (x in 0..listPlus.lastIndex step 2)
        if (listPlus.lastIndex - x - 1 >= 0) {
            var num1: Int = listPlus.get(listPlus.lastIndex - x)
            var num2: Int = listPlus.get(listPlus.lastIndex - (x + 1))
            if (num1 == 1 || num2 == 1) ans += num1 + num2
            else ans += num1 * num2
        }

    if (listMinus.size % 2 == 1) ans += listMinus.get(listMinus.lastIndex)
    if (listPlus.size % 2 == 1) ans += listPlus.get(0)

    bw.write(ans.toString())
    bw.flush()
    bw.close()
}
