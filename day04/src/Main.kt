import java.io.File

fun main(args: Array<String>) {
    val filename = args[0]

    val lines = File(filename).readLines()

    val padded = lines.joinToString(" ".repeat(lines[0].length))
    val w = lines[0].length * 2

    val patterns1 = listOf(
        "XMAS",
        "SAMX",
        "(?=(X.{$w}M.{$w}A.{$w}S))",
        "(?=(S.{$w}A.{$w}M.{$w}X))",
        "(?=(X.{${w - 1}}M.{${w - 1}}A.{${w - 1}}S))",
        "(?=(S.{${w - 1}}A.{${w - 1}}M.{${w - 1}}X))",
        "(?=(X.{${w - 2}}M.{${w - 2}}A.{${w - 2}}S))",
        "(?=(S.{${w - 2}}A.{${w - 2}}M.{${w - 2}}X))",
    )

    val patterns2 = listOf(
        "(?=(M.M.{${w - 2}}A.{${w - 2}}S.S))",
        "(?=(M.S.{${w - 2}}A.{${w - 2}}M.S))",
        "(?=(S.M.{${w - 2}}A.{${w - 2}}S.M))",
        "(?=(S.S.{${w - 2}}A.{${w - 2}}M.M))"
    )

    val result1 = patterns1.sumOf { it.toRegex().findAll(padded).count() }
    val result2 = patterns2.sumOf { it.toRegex().findAll(padded).count() }

    println(result1)
    println(result2)
}