package advent

fun advent1(input: String): Int {
    val ints = input.split("\n")
            .map { it.toInt() }
    for (i in ints) {
        for (j in ints) {
            for (k in ints) {
                if (i + j + k == 2020) {
                    return listOf(i, j, k)
                            .fold(1) { acc, x -> acc * x }
                }
            }
        }
    }
    return 0
}

