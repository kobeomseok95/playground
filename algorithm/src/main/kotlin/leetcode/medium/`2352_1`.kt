package leetcode.medium

class `2352_1` {
    fun equalPairs(grid: Array<IntArray>): Int {
        var count = 0
        val n = grid.size
        (0 until n).forEach { i ->
            (0 until n).forEach { j ->
                var allEquals = true

                (0 until n).forEach { k ->
                    if (grid[i][k] != grid[k][j]) {
                        allEquals = false
                    }
                }

                if (allEquals) {
                    count += 1
                }
            }
        }
        return count
    }
}

class `2352_2` {
    fun equalPairs(grid: Array<IntArray>): Int {
        val n = grid.size
        val rotatedGrid = getRotatedGrid(n, grid)

        var count = 0
        (0 until n).forEach { i ->
            (0 until n).forEach { j ->
                if (grid[i].contentEquals(rotatedGrid[j])) {
                    count += 1
                }
            }
        }

        return count
    }

    private fun getRotatedGrid(n: Int, grid: Array<IntArray>): Array<IntArray> {
        return (0 until n).map { i ->
            (0 until n).map { j ->
                grid[j][i]
            }.toIntArray()
        }.toTypedArray()
    }
}
