package com.me.learn.personal.ds.unionfind.precolates

import com.me.learn.personal.ds.unionfind.weighted.WeightedQuickUnion

/**
 * Precolaition means a 2D matrix. With a tap on top of matrix and drain on bottom of matrix.
 * When you open a tap we need to find a way for water at top to drain at bottom.
 * At first all the martix will be closed.
 * We need to open element of matix one by one to check if the water drains.
 * Open means the element of matrix is just open.
 * Full means the element of matrix is fulled with water, basically it is connected to tap.
 * Precolates means water from tab is connected to drain.
 *
 * 1. Open a matrix element
 * 2. If the element is in first row of matrix then connect it to top(tap).
 *      1. If the siblings on right, left or bottom are open then connect them
 * 3. If the element is in last row of matrix then connect it to bottom(drain).
 *      1. If the siblings on right, left or bottom are open then connect them
 * 4. If the element if in any other row then just open it
 *      1. If the siblings on right, left or bottom are open then connect them
 * 5. Repeat by randomly supplying the matrix slot to open.
 * 6. If top and bottom are connected then it means it precolates.
 *
 *  Example for 3x3 matrix.
 *
 *  Note - (C) means closed.
 *       - (O) means opened.
 *       - (F) means opened and full.
 *
 *      (0, 0)(C)  (0, 1)(C)  (0,2)(C)
 *      (1, 0)(C)  (1, 1)(C)  (1,2)(C)
 *      (2, 0)(C)  (2, 1)(C)  (2,2)(C)
 *
 * Convert the matrix to nodes. Also will introduce notes for tap and drain.
 *
 *                 (0)(Tap)
 *
 *          (1)(C)  (2)(C)  (3)(C)
 *          (4)(C)  (5)(C)  (6)(C)
 *          (7)(C)  (8)(C)  (9)(C)
 *
 *                (10)(Drain)
 *
 *  Open Matrix element (1, 1) which is node (5)
 *
 *                 (0)(Tap)
 *
 *          (1)(C)  (2)(C)  (3)(C)
 *          (4)(C)  (5)(O)  (6)(C)
 *          (7)(C)  (8)(C)  (9)(C)
 *
 *                (10)(Drain)
 *
 *  Node 5 is in middle row and there is not siblings are open, so no further connection required
 *
 *  Open Matrix element (0, 1) which is node (2)
 *
 *                 (0)(Tap)
 *                     |
 *          (1)(C)  (2)(O)  (3)(C)
 *                     |
 *          (4)(C)  (5)(O)  (6)(C)
 *          (7)(C)  (8)(C)  (9)(C)
 *                (10)(Drain)
 *
 *  Node 2 is in first row so connect to tap and node 5 at bottom of 2 is open so connect to 5
 *
 *  Open Matrix element (2, 2) which is node (9)
 *
 *                 (0)(Tap)
 *                     |
 *          (1)(C)  (2)(O)  (3)(C)
 *                     |
 *          (4)(C)  (5)(O)  (6)(C)
 *          (7)(C)  (8)(C)  (9)(O)
 *                          /
 *                (10)(Drain)
 *
 *  Node 9 is in last row so connect to drain and there is not siblings are open, so no further connection required
 *
 *  Open Matrix element (1, 2) which is node (6)
 *
 *                 (0)(Tap)
 *                     |
 *          (1)(C)  (2)(O)   (3)(C)
 *                     |
 *          (4)(C)  (5)(O) _ (6)(O)
 *                             |
 *          (7)(C)  (8)(C)   (9)(O)
 *                           /
 *                (10)(Drain)
 *
 *  Node 6 is in middle row and siblings 5 and 9 are already open so connect to them.
 *
 *  Now the matrix precolates, since node 0 and 10 are connected.
 *
 */

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