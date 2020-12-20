package advent

import java.lang.IllegalStateException

class Advent9 {
    fun firstXmas(preamble: Int, input: String): Long {
        val list = input.split("\n").map { it.toLong() }
        val workingSet = list.subList(0, preamble)
        val candidates = list.drop(preamble)
        return pushUntilInvalidXmas(workingSet, candidates)
    }

    fun pushUntilInvalidXmas(workingSet: List<Long>, candidates: List<Long>): Long = when {
        candidates.isEmpty() -> throw IllegalStateException("sequence should have invalid xmas")
        validXmas(workingSet, candidates[0]) -> {
            pushUntilInvalidXmas(
                workingSet.drop(1) + candidates[0],
                candidates.drop(1)
            )
        }
        else -> candidates[0]
    }

    fun validXmas(workingSet: List<Long>, candidate: Long) =
        workingSet.any { a -> (workingSet - a).any { b -> a + b == candidate } }

    fun findWeakness(input: String, weakness: Long): Long {
        val list = input.split("\n").map { it.toLong() }
        val candidate = contiguousSum(list, weakness)
        return candidate.min()!! + candidate.max()!!
    }

    fun contiguousSum(workingSet: List<Long>, weakness: Long): List<Long> =
        workingSet.indices
            .map<Int, Pair<Int, Int>?> { i ->
                for (j in i + 1..workingSet.size - 2) {
                    if (workingSet.subList(i, j).sum() == weakness) {
                        return@map Pair(i, j)
                    }
                }
                return@map null
            }.filterNotNull()
            .first()
            .let { workingSet.subList(it.first, it.second) }
}