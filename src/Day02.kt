import kotlin.collections.forEach

fun main() {
    fun part1(input: List<String>): Long {
        return input[0].split(",").sumOf { range ->
            val r = range.split("-")
            (r[0].toLong()..r[1].toLong()).sumOf { i ->
                val num = i.toString()
                if (num.length % 2 == 0 && num.take(num.length / 2) == num.drop(num.length / 2)) num.toLong() else 0L
            }
        }
    }

    fun part2(input: List<String>): Long {
        return input[0].split(",").sumOf { range ->
            val r = range.split("-")
            (r[0].toLong()..r[1].toLong()).sumOf { i ->
                val num = i.toString()
                for (chunkSize in 1..num.length/2){
                    if(num.chunked(chunkSize).all { it== num.take(chunkSize)})
                        return@sumOf i
                }
                0L
            }
        }
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the test file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 1227775554L)

    // Read the input from the input file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
