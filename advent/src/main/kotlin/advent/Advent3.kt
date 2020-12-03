package advent

// part one

fun advent3a(input: String): Int = countTrees(transform(input), mx = 3, my = 1)

// part two

fun advent3b(input: String): Long = with(transform(input)) {
    listOf(
        1 to 1,
        3 to 1,
        5 to 1,
        7 to 1,
        1 to 2
    )
        .map { pair -> countTrees(slopeMap = this, mx = pair.first, my = pair.second) }
        .fold(1) { acc, i -> acc.times(i) }
}

private fun transform(input: String) = input
    .split("\n")
    .map { it.toCharArray() }

private tailrec fun countTrees(
    slopeMap: List<CharArray>, mx: Int, my: Int, x: Int = 0, y: Int = 0, trees: Int = 0
): Int = when {
    y >= slopeMap.size -> trees
    else -> countTrees(slopeMap, mx, my,
        x = (x + mx) % slopeMap[0].size,
        y = y + my,
        trees = if (slopeMap[y][x] == '#') trees + 1 else trees
    )
}