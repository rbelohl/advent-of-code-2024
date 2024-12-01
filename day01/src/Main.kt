import java.io.File
import kotlin.math.absoluteValue

fun main(args: Array<String>) {
    val filename = args[0]

    val lines = File(filename).readLines()

    val split = lines.map { it.split("\\s+".toRegex()) }

    val sortedLeft = split.map { it[0].toInt() }.sorted()
    val sortedRight = split.map { it[1].toInt() }.sorted()

    val result1 = sortedLeft.zip(sortedRight)
        .sumOf { (it.first - it.second).absoluteValue }

    val result2 = sortedLeft.sumOf { leftNumber ->
        leftNumber * sortedRight.count { it == leftNumber }
    }

    println(result1)
    println(result2)
}