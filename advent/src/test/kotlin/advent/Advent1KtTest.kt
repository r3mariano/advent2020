package advent

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Advent1KtTest : FreeSpec({
    "yep" {
        advent1("""
            1721
            979
            366
            299
            675
            1456
        """.trimIndent()) shouldBe 241861950
    }

})
