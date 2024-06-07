package com.me.learn.personal.ds.unionfind

class Precolation(
    private val size: Int
) {
    private val opened: BooleanArray = BooleanArray(size * size)
    private var numberOfOpenItems = 0
    private val totalNode = (size * size) + 2
    private val firstNodeIndex = 0
    private val lastNodesIndex = totalNode - 1
    private val qf = WeightedQuickUnion(totalNode)

    private fun getNodePosition(row: Int, column: Int): Int {
        return (row * size) + column + 1
    }

    fun open(row: Int, column: Int) {
        val position = getNodePosition(row, column)
        if (!opened[position - 1]) {
            opened[position - 1] = true
            numberOfOpenItems++

            if (row == 0) {
                qf.union(firstNodeIndex, position)
            }

            if (row == size - 1) {
                qf.union(lastNodesIndex, position)
            }

            val topRow = row - 1
            if (topRow > -1) {
                val topNodePosition = getNodePosition(topRow, column)
                if (opened[topNodePosition - 1]) {
                    qf.union(topNodePosition, position)
                }
            }

            val bottomRow = row + 1
            if (bottomRow < size) {
                val bottomNodePosition = getNodePosition(bottomRow, column)
                if (opened[bottomNodePosition - 1]) {
                    qf.union(bottomNodePosition, position)
                }
            }


            val leftColumn = column - 1
            if (leftColumn > -1) {
                val leftColumnPosition = getNodePosition(row, leftColumn)
                if (opened[leftColumnPosition - 1]) {
                    qf.union(leftColumnPosition, position)
                }
            }

            val rightColumn = column + 1
            if (rightColumn < size) {
                val rightColumnPosition = getNodePosition(row, rightColumn)
                if (opened[rightColumnPosition - 1]) {
                    qf.union(rightColumnPosition, position)
                }
            }
        }
    }

    fun isFull(row: Int, column: Int): Boolean {
        val position = getNodePosition(row, column)
        return qf.isConnected(firstNodeIndex, position)
    }

    fun isOpen(row: Int, column: Int): Boolean {
        val position = getNodePosition(row, column)
        return opened[position]
    }

    fun isPrecolates(): Boolean {
        return qf.isConnected(firstNodeIndex, lastNodesIndex)
    }
}

fun main() {
    val precolation = Precolation(3)
    precolation.open(0, 0)
    precolation.open(1, 0)
    precolation.open(1, 1)
    precolation.open(2, 1)
    println(precolation.isPrecolates())
}