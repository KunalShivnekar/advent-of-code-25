fun main() {
    fun part1(input: List<String>): Int {
        var num = 50
        return input.count{ line->
            val dir = if(line.startsWith("R")) 1 else -1
            num += line.drop(1).toInt() * dir
            num %= 100
            num == 0
        }
    }

    fun part2(input: List<String>): Int {
        var num = 50
        var res = 0
        input.forEach { line->
            val dir = if(line.startsWith("R")) 1 else -1
            val amt = line.drop(1).toInt()
            repeat(amt){
                num += dir
                num %= 100
                if(num == 0)
                    res++
            }
        }
        return res
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 3)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
