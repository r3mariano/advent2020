package advent

fun advent4(input: String): Int = Advent4().process(input)
fun advent4b(input: String): Int = Advent4().processWithValidation(input)

class Advent4 {
    fun process(input: String): Int =
        input.split("\n\n")
            .map(::parsePassport)
            .filter(::checkRequiredFields)
            .count()

    fun processWithValidation(input: String): Int =
        input.split("\n\n")
            .map(::parsePassport)
            .filter(::checkRequiredFields)
            .filter(::checkValid)
            .count()

    private fun parsePassport(input: String): Passport =
        input.split(Regex("[ \n]"))
            .map { it.split(":") }
            .fold(emptyMap()) { passport, field ->
                passport + (field[0] to field[1]) }

    // Key assumption: passport only has these fields. No need to check cid.
    private fun checkRequiredFields(passport: Passport): Boolean =
        passport.keys.containsAll(listOf(
            "byr",
            "iyr",
            "eyr",
            "hgt",
            "hcl",
            "ecl",
            "pid",
        ))

    private fun checkValid(passport: Passport): Boolean =
         passport.entries.map { when(it.key) {
            "byr" -> it.key to (it.value.toIntOrNull() in 1920..2002)
            "iyr" -> it.key to (it.value.toIntOrNull() in 2010..2020)
            "eyr" -> it.key to (it.value.toIntOrNull() in 2020..2030)
            "hgt" -> it.key to (checkValidHeight(it.value))
            "hcl" -> it.key to (checkHexColour(it.value))
            "ecl" -> it.key to (it.value in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth"))
            "pid" -> it.key to (checkPassportId(it.value))
            else -> it.key to true
        } }
             .all { it.second }

    private fun checkValidHeight(value: String): Boolean {
        val groupValues = Regex("(\\d*)(cm|in)")
            .matchEntire(value)
            ?.groupValues
            ?: return false
        return when(groupValues[2]) {
            "cm" -> groupValues[1].toIntOrNull() in 150..193
            "in" -> groupValues[1].toIntOrNull() in 59..76
            else -> false
        }
    }

    private fun checkHexColour(value: String): Boolean =
        value.matches(Regex("^#[0-9a-f]{6}$"))

    private fun checkPassportId(value: String): Boolean =
        value.matches(Regex("^[0-9]{9}$"))
}

typealias Passport = Map<String, String>

