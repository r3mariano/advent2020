package advent

fun advent7a(input: String): Int = Advent7().allContainersForString(input)

fun advent7b(input: String): Int = Advent7().allBagsInside(input)

class Advent7 {
    fun bag(sentence: String) = sentence
        .split(",", "contain")
        .asSequence() // does this make things more performant?
        .map { it.trim().replace(".", "") }
        .map { Regex("(\\d*)? ?(.*) bags?").matchEntire(it)!!.groupValues }
        .map { BagRule(it[1].toIntOrNull() ?: 0, it[2]) }
        .filter { it.colour != "no other" }
        .toList()
        .let { Bag(
            colour = it[0].colour,
            containing = it.drop(1)
        ) }

    fun directContainers(colour: BagColour, bags: List<Bag>): List<Bag> =
        bags.filter { bag -> bag.containing.any { it.colour == colour }}

    fun allContainers(colour: BagColour, bags: List<Bag>): List<Bag> =
        directContainers(colour, bags)
            .flatMap { allContainers(it.colour, bags) + it }
            .distinct()

    fun allContainersForString(input: String): Int = input
        .split("\n")
        .map(::bag)
        .let { allContainers("shiny gold", it) }
        .count()

    // part two
    fun bagsDirectlyInside(colour: BagColour, bags: List<Bag>): List<BagColour> = bags
        .find { it.colour == colour }
        ?.containing
        ?.flatMap { bagRule -> (1..bagRule.count).map { bagRule.colour } }
        ?: emptyList()

    fun bagsInside(
        colour: BagColour,
        bags: List<Bag>
    ): List<BagColour> = listOf(colour) + bagsDirectlyInside(colour, bags)
        .flatMap { bagsInside(it, bags) }

    fun allBagsInside(input: String): Int = input
        .split("\n")
        .map(::bag)
        .let { bagsInside("shiny gold", it) }
        .count() - 1
}

data class Bag(
    val colour: BagColour,
    val containing: List<BagRule> = emptyList()
)

data class BagRule(
    val count: Int = 0,
    val colour: BagColour
)

typealias BagColour = String
