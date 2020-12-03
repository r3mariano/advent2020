package advent

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Advent3KtTest : FreeSpec({
    "counts trees using the sample input" {
        advent3a("""
            ..##.......
            #...#...#..
            .#....#..#.
            ..#.#...#.#
            .#...##..#.
            ..#.##.....
            .#.#.#....#
            .#........#
            #.##...#...
            #...##....#
            .#..#...#.#
        """.trimIndent()) shouldBe 7
    }

    "counts trees using the puzzle input" {
        advent3a(puzzle3) shouldBe 252
    }

    "counts trees on multiple paths using the sample input" {
        advent3b("""
            ..##.......
            #...#...#..
            .#....#..#.
            ..#.#...#.#
            .#...##..#.
            ..#.##.....
            .#.#.#....#
            .#........#
            #.##...#...
            #...##....#
            .#..#...#.#
        """.trimIndent()) shouldBe 336
    }

    "counts trees on multiple paths using the puzzle input" {
        advent3b(puzzle3) shouldBe 252
    }

})

private val puzzle3 = """
        ......##....#...#..#.#....#....
        .......#...#..#..#....##.......
        #.#...#........###.#.##..#.....
        .......#.....##.#..##...##.##..
        .#...#.#...##..........#..#....
        #.......##.....###.#...#......#
        .........#....#.#.......#..#...
        ..#.......####.......###..##...
        .#.#.##..#.#...##..#...###...##
        ...................#...........
        ....#.#.......#..........#.#..#
        ..#.#...........####.#.......#.
        .....#.##..#..##..#.#...#......
        #.##...###..#................##
        ...#...#...#..##.#............#
        #.##....##....#........#..#....
        ..#......#.#.....##.......#....
        .......#......#....#......#....
        .#........##.....#.#...#...#.#.
        ..........##.#...#..#..........
        #####..##......#.....#......#.#
        ......#...............##...#...
        ..#.#.##..#...#.#........#...#.
        ..........#......#..........###
        ..#...##.##..##..........#.....
        ........#.##.#.....#..#...#....
        #.....#.........#..............
        ..........##.##....#..#..#.....
        ..#...........#.......#........
        ........#..#.....#.#.#...#.....
        #.......##.....#.....#...#.##..
        ###.#.#....#..#.....#........#.
        ..#..#..#..........#....#....#.
        ..#...##...#.#.##.....#..#.....
        ...#....###...........##.#.....
        .##.................##.#.......
        ........#...#.##..#...#........
        .##..#............##..........#
        ............###.#....#..#......
        .....##....#.....#......#.....#
        ....#.....#.##.......#...#.#...
        .##.#......#.........#...##....
        ..##......#......#...........#.
        .......#.#.............#.......
        .##.#...#..##....##.......#....
        ...#......##.#.#......#.....###
        #.#....#.......#.#......#....#.
        #......#.#.....#...........#..#
        ##.#..##...#........#.##.#....#
        .....#........#........#...#...
        ...............#.......#..#....
        .#.#.#..#.#...#.......#.....##.
        .#.#.............#..#....#.....
        ....#.......#..##.........###..
        .#.....#.#....#..#..#....#.....
        ........#......#.....#.#....#..
        ##......#....##.....#.#..#.#...
        .#...#..#.##.#.##.##.....#.....
        #...#....#.........##.#....#...
        .........##..#.....#..#...#.#..
        .#............#..........#.#...
        ...........#.....#......#.#....
        #...#...#.....#..#....#........
        #..##.....#..#.......#....#...#
        #..#..#..........#......#...#..
        ...#...#.#.##.#...#....#...##..
        ......##....##....#....##..####
        ...###.#..#....#.......#.......
        #.........##......#...#........
        ..........#....#.......#.......
        #....##................##....##
        .........#....#.#.......##.#...
        .....#......###.......#..#...##
        ###.....#..##....###...........
        .....#...#....#.....##......###
        .#..#...#......##........##..#.
        #.#.#.#....#.............#.....
        ......#.....##.#....#..##...#..
        ..#............#.#....#..#...#.
        .............#.#...##.......#..
        ...#....#.##.#...#.#..##...###.
        ...#..............#.......#....
        ......###.#............#.....#.
        .##...###..#.####...#..........
        ...#..#...#.#.#..#......#..#...
        .#....##.###....#........#.....
        ..#..#....#.........##.........
        ..........##.###........#.#...#
        .........#...#..#........#.....
        .......#.....#...###...........
        .....#.#..##......#...#...#....
        .....#....#..#........##.#..#..
        ...#...........#............#..
        ##.....#....#.#...#...#....##..
        ...#.....#.....#...##...#...#..
        ...##.#..........##...#.#.##.#.
        ....#.#.##.......#.#...#......#
        ......###...#....#.##........#.
        .....#.........#...#...#..#..##
        .........#................#....
        .##..###..................#.#.#
        .##...........#...........#....
        #...#........#.....#..#...##...
        .....#..#...#.........#.......#
        ..#..............#......#......
        #....#...............#.#.......
        ...#........#.#....#..#.###.##.
        .......#..##..#...#..#...###...
        ..........##..#.......##.##....
        ##.#..#.#...##..........#......
        .#.##.#...##.....#....#....#.##
        ...#.#......#...#.##..##.......
        ##.......#.#......#....##..#.#.
        ...#..#.##.........#...#.....#.
        .##.##..##...#........#..#.....
        .#.##.............#.#.#.....#..
        .......#.....................#.
        ......#...#....#..#..........#.
        ..#..#....#.#................#.
        ..#.....#..#.#......#......###.
        ...#...##..##....#..#...###.#..
        ...#.....#............##......#
        .......#.#.#......#.....###....
        .....#......#.....#.........#.#
        #...#.#...#..#...#..#....#.....
        #..##...#..##.............#..#.
        ##....##.......#.#.......#..#.#
        ..............#...#..#......#..
        ..#...#...#.#...#.#............
        #..........#...#.............#.
        ..........##......#........#...
        #...#...#....#.#...........#...
        ..#.#.#...##......#.#...#.#..#.
        .......#.......#.............#.
        .#..........#..................
        ..##...#......#..........#....#
        .#..##..........#...#..........
        ...#....#..#.#.....##..##.#..#.
        ...#...#...#..#....##..#....#..
        ..............#.#.....#......##
        ..............####....#.#..#...
        .#........##....#...#.#...#..#.
        .#..##.###....#.#.....##..#....
        ...###.#.........#..#..#.##.#..
        .....#..#.....#..#...##......##
        .#.#.##.............#...##.....
        ....##........#........#.......
        .......#.....###..............#
        #.##.......##....#.#.....#.#...
        ........#....#............#..##
        ...#.#..#.......#..........#...
        ..##....#..##......###.#.....#.
        .#..#.#.##....#.......#........
        ........#.####.#.......#.##....
        ..........##...............#...
        .#..#.....#....##..#..##...#..#
        ....#.#.....#.#.........#####..
        ...#.##....#...###.##.#..#.....
        .#...........#.............##.#
        ..#....#....####.....#.#....#..
        ......##.......#....#..#.......
        .####...##.#.#..#.####.#.#.....
        ###.........#..#.#.#.#........#
        ...#...#..#.............#.##...
        .........#....#......#.....#.#.
        ...#....#......#..#......#....#
        ..#...#..........##..##........
        .....##........#......#.....#..
        ...#....#....#....#..#....#....
        ##...#...........##............
        .......#..##..#.......##.#.....
        ...............#.##.....#......
        #.#....##.#.....#...#..........
        ........#......#...#......#.#.#
        ..#..#.....#.#........#........
        ..####.....##.#.##.......#.#.#.
        .#.##.#.......##......#.....#..
        ....#.....##.........#.....#...
        .#.#...###.#.#..........#....#.
        .........##.#.#.....#..#.......
        ......#..#...#..#..###.#.#.....
        .....#...#.#..#.#.......#.#...#
        ......##........#..#...#......#
        #..##...#...#..#.....#..#..#..#
        ......#....#...........#.#.....
        ...#.......#...............#...
        #.........#......#.............
        ..###..................#......#
        #.....#.#.#.......##....#......
        .........#...........#....#.#..
        .###....##.##..##.............#
        .##.#......#...#...##..........
        ....#........###......#.#......
        ...........#..#.##.#...........
        .#..#.......#......#.#####.....
        ....##....##......#....#...#...
        .......#..#.....#.#...###...#.#
        ..##.....#.......#.#.#..#.....#
        .#...#............#....##...#..
        .#..#...##.......#.............
        ..##.......#...........#.#....#
        ...#.#...#....#..#.....#.......
        ...#........#...##...#.#..#.#..
        #........#..........#..........
        ......#......#.........#.......
        ...##...#.....#.......#...#.##.
        ......##..##......#..###..#....
        ....##....#..###.#.....##......
        ##.##..#.....#..#..............
        ..#.#..#....#....#....#.#...#.#
        .#.....##.#.##.#..#.#..........
        ...#......##.#...##..##...#....
        .###.....#......#.......#.....#
        ....##.......#.....#..#....#...
        ..........#..##....#..##.#....#
        ...#....#..##.#........#.#.#...
        ...#.#...#....#.......#..##.#.#
        #..#..........#.#...#....#.....
        #..#...........................
        ........#.....#.....#.#...#.#..
        #...#..#...#..........###...#.#
        .....##.#..##.#.#.#.##....#....
        #.......#....#.#..#..#..#.#....
        ..###.#.......#.#.##...........
        #....#..#..........#.##..#.#...
        ..#..#........##....#..##......
        #...##..#.........#.#....#.#...
        ##..###..##...#.........#.#...#
        ###..#....#..##...#.#..#.#.....
        .#.##.#......#............#....
        .#...#.##.#.........##.........
        ##.....###.....#........#..#...
        ...........##.#................
        .#......###......#....#..####..
        #...##.....#.....#..##....#.#..
        ..#....#.......#.#.#......#...#
        #.....#........#....#.#...#....
        ..##...............#....#..###.
        .#....#.......#..#...#.........
        .##.#..#..#...#..#..#....#....#
        .......#.#....#.....##...#.....
        .#....#.#.#...........#........
        .........#..##..#..#...#.......
        ##..##...#......#.....#........
        #...........#.....#..###......#
        .#...........#....#...#...##.#.
        ..............##.###.#.#####.##
        ........#.#...#.............##.
        #...................###..#.##..
        #.....#...##...................
        .....##..........#..#.#........
        .#....##.#....#....###....#...#
        .......#.#...........#.#.....#.
        ......#........###...#...##....
        .##..........#..#..#...........
        ....#.......#..#.....##.#..#...
        ..#.##......#..#.....#..#......
        ......#...#..##....#.#..#..#.#.
        #.........................#...#
        ###.#.......#......##....#..#..
        ..##.###.#...#.............#...
        .....#...#...#......#....#####.
        #..........#.#.##.#.#.....#..#.
        ....#.........#...#.#.........#
        #.##.........#...#...#.####..##
        .##.................#..........
        ##.....#............#..#.#.....
        #.#...#.#........#........#...#
        .#...........#....#..#.......#.
        .#.......#..........##..#.##..#
        .#..##....#..##......#.#..##...
        #......#............#.......#.#
        .##...............#...#...#....
        .......##.#..#..##.....#.......
        ...#.......#..###.....#....#...
        ......#............#...........
        ####............#.........#.##.
        #......#.#..#...#.....#..#.....
        ...........#...#..##.......####
        #.#...##..#....#.#.........#.#.
        ...#....#..#.......#.........#.
        .........#.#.#...#....#........
        .#.....#........#..#.........#.
        ....#....#..#.....#...#........
        ..#....#.#.....#..##...........
        .#...#..#..#.##.###....#.......
        #......##.......##..##.........
        ...#.........#.......##.#......
        .#...#...#.......#........##...
        ..#.............#.......#.....#
        ..#...........#.#.#...#.......#
        .....##..#....#..............#.
        #.#.....#.#....................
        .....#..##..#...#.....#........
        ..#.......#..####..#....#.##.#.
        #....#.....#.....#...#......#..
        ..#....##...#....#..#..#.....#.
        ..#.####..............##.......
        .#.........#..#...#.......##...
        #....#.#........#....#...#...##
        .....#..#....#.#..#...#.#.##...
        .##.................#...##.....
        .##.##.##...#...........#...##.
        ..#....#..#.....#..#......##...
        .#...........#......#....#..#.#
        .#.#............#..#..#...#....
        ....#......#.....#.#.#.....#...
        #.......##.............#.......
        ....#....................#.#...
        ......#........#..#.#.....#.#..
        .....#..#....#.#........#....#.
        ...##.........#...#.##....#..#.
        .#....#..#...#.#.#......#......
        #......#.#.##.#..#..#.....##...
        ......#....#.#...#..#.#........
        ..#.....##.....#...#.#.......#.
        ......#.#.....#........#.......
        ......#.#.#...#..#.#.#.#.......
        ..#.#.##..#..#..#.#.##...#.....
        ......#.#.#......#.....#...#...
        .....#.##....#..##...#...#....#
        ..#.....#...........#..#..##...
        ..#..#.......#....#....###.#...
    """.trimIndent()