package advent

fun advent5a(input: String): Int = Advent5().maxSeatId(input)

fun advent5b(input: String): Int = Advent5().findMySeat(input)

class Advent5 {
    fun maxSeatId(input: String): Int = input
        .split("\n")
        .map(::parse)
        .map(::calculateSeatDescription)
        .maxOf { it.seatId }

    fun findMySeat(input: String): Int = input
        .split("\n")
        .map(::parse)
        .map(::calculateSeatDescription)
        .let(::findEmptySeat)
        .seatId

    fun parse(input: String): BoardingPass =
        Regex("([FB]{7})([LR]{3})").matchEntire(input)!!
            .groupValues
            .let { BoardingPass(it[1], it[2]) }

    data class BoardingPass(val row: String, val column: String)

    fun calculateSeatDescription(boardingPass: BoardingPass): SeatDescription =
        SeatDescription(
            row = bin(boardingPass.row, low = "F", high = "B"),
            column = bin(boardingPass.column, low = "L", high = "R")
        )

    private fun bin(input: String, low: String, high: String): Int = input
        .replace(low, "0")
        .replace(high, "1")
        .toInt(2)

    data class SeatDescription(val row: Int, val column: Int) {
        val seatId: Int = row * 8 + column

        companion object {
            fun from(id: Int): SeatDescription = SeatDescription(
                row = id shr 3,
                column = id % 8,
            )
        }
    }

    private fun findEmptySeat(seats: List<SeatDescription>): SeatDescription = seats
        .map { it.seatId }
        .let { symmetricDifference(it, (it.minOf { a -> a }..it.maxOf { a -> a }).toList()).first() }
        .let { SeatDescription.from(it) }

    // Source: https://github.com/IvanMwiruki/30-seconds-of-kotlin#symmetricdifference
    // This is the opposite of the intersection between two sets, i.e. returns the items
    // that are unique across the sets.
    private fun <T> symmetricDifference(first: List<T>, second: List<T>): List<T> =
        ((first subtract second) + (second subtract first)).toList()
}