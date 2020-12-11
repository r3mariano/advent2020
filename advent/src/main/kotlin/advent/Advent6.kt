package advent

fun advent6(input: String): Int = Advent6().countAnyYesses(input)
fun advent6b(input: String): Int = Advent6().countAllYesses(input)

class Advent6 {
    fun countAnyYesses(input: String): Int = input
        .split("\n\n")
        .map(::distinct)
        .sum()

    fun distinct(group: String): Int = group
        .replace("\n", "")
        .toCharArray()
        .distinct()
        .count()

    fun countAllYesses(input: String): Int = input
        .split("\n\n")
        .map(::intersection)
        .sum()

    fun intersection(group: String): Int = group
        .split("\n")
        .map { it.toCharArray().asIterable() }
        .reduce { acc, s -> acc.intersect(s.asIterable()) }
        .count()
}