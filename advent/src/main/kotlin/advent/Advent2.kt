package advent

// part one

fun advent2(input: String): Int =
        input.split("\n")
                .asSequence()
                .map { Regex("(\\d*)-(\\d*) (.): (.*)").matchEntire(it)!!.groupValues }
                .map {
                    Matchy(min = it[1].toInt(), max = it[2].toInt(), matchingChar = it[3].first(), input = it[4])
                }
                .filter { m -> m.input.count { it == m.matchingChar } in m.min..m.max }
                .count()

data class Matchy(val min: Int, val max: Int, val matchingChar: Char, val input: String)

// part two

fun advent2b(input: String): Int =
        input.split("\n")
                .asSequence()
                .map { Regex("(\\d*)-(\\d*) (.): (.*)").matchEntire(it)!!.groupValues }
                .map {
                    Matchy2(
                            pos1 = it[1].toInt() - 1,
                            pos2 = it[2].toInt() - 1,
                            matchingChar = it[3].first(),
                            input = it[4]
                    )
                }
                // If they're the same and they match, then we don't want that.
                .filter { it.input[it.pos1] != it.input[it.pos2] }
                .filter { it.matchingChar in listOf(it.input[it.pos1], it.input[it.pos2]) }
                .count()

data class Matchy2(val pos1: Int, val pos2: Int, val matchingChar: Char, val input: String)
