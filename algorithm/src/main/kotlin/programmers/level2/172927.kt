package programmers.level2

class `172927` {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var fatigue: Int = 0
        val pickAxe = PickAxe.of(picks)
        return minerals.toList()
            .map { Mineral.valueOf(it.uppercase()) }
            .chunked(5)
            .take(pickAxe.totalPickAxes())
            .sortedWith(compareBy { it.sumOf { it.priority } })
            .reversed()
            .fold(0) { acc, minerals ->
                acc + pickAxe.pick(minerals)
            }
    }

    data class PickAxe(
        var diamond: Int,
        var iron: Int,
        var stone: Int,
    ) {
        fun totalPickAxes(): Int {
            return diamond + iron + stone
        }

        fun pick(minerals: List<Mineral>): Int {
            return if (diamond > 0) {
                diamond -= 1
                minerals.sumOf { PickAxeFatigability.DIAMOND.to(it) }
            } else if (iron > 0) {
                iron -= 1
                minerals.sumOf { PickAxeFatigability.IRON.to(it) }
            } else if (stone > 0) {
                stone -= 1
                minerals.sumOf { PickAxeFatigability.STONE.to(it) }
            } else 0
        }

        companion object {
            fun of(picks: IntArray): PickAxe {
                return PickAxe(
                    diamond = picks[0],
                    iron = picks[1],
                    stone = picks[2],
                )
            }
        }
    }

    enum class Mineral(
        val priority: Int,
    ) {
        DIAMOND(25),
        IRON(5),
        STONE(1),
        ;
    }

    enum class PickAxeFatigability{
        DIAMOND {
            override fun to(mineral: Mineral): Int {
                return when (mineral) {
                    Mineral.DIAMOND -> 1
                    Mineral.IRON -> 1
                    Mineral.STONE -> 1
                }
            }
        },
        IRON {
            override fun to(mineral: Mineral): Int {
                return when (mineral) {
                    Mineral.DIAMOND -> 5
                    Mineral.IRON -> 1
                    Mineral.STONE -> 1
                }
            }
        },
        STONE {
            override fun to(mineral: Mineral): Int {
                return when (mineral) {
                    Mineral.DIAMOND -> 25
                    Mineral.IRON -> 5
                    Mineral.STONE -> 1
                }
            }
        },
        ;

        abstract fun to(mineral: Mineral): Int
    }
}
