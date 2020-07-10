import java.io.*;
import java.util.*;

private val bw = BufferedWriter(OutputStreamWriter(System.`out`))
var input: String = ""

fun main(args: Array<String>) {
    init()
    solution()
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    input = br.readLine()
}

private fun solution() {
    for (x in 0..input.length) {
        if(canPalindrom(x)) {
            bw.write((input.length+x).toString())
            break
        }
    }
    bw.flush()
    bw.close()
}

fun canPalindrom(x: Int): Boolean {
    var rightIdx: Int = 0
    var leftIdx: Int = 0
    if ((x + input.length) % 2 == 0) {
        rightIdx = (x + input.length) / 2
        leftIdx = rightIdx - 1
    } else {
        rightIdx = (x + input.length) / 2 + 1
        leftIdx = rightIdx - 2
    }

    while (true) {
        if (rightIdx >= input.length) break
        if (input.get(rightIdx++) != input.get(leftIdx--)) return false
    }

    return true
}
