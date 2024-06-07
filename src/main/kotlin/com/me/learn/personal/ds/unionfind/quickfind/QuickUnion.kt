package com.me.learn.personal.ds.unionfind.quickfind

/**
 * Solves dynamic connectivity problem
 * Lazy approach
 * Use array[N] data structure
 * Each element of the array contains the root of its index.
 * Thus forms a tree like structure.
 *
 * index:   0   1   2   3   4   5   6   7   8   9
 * parent:  0   1   2   3   4   5   6   7   8   9
 *
 * When union is performed for union(4, 3) then root of 3 is 3 and root of 4 is 4.
 * Connect root of 4 with root of 3
 * 3 is the parent of 4
 *
 *  index:   0   1   2   3   4   5   6   7   8   9
 *  parent:  0   1   2   3   3   5   6   7   8   9
 *
 *              3
 *             /
 *            4
 *
 *  When union is performed for union(3, 8) then root of 3 is 3 and root of 8 is 8.
 *  Connect root of 3 with root of 8
 *  8 is the parent of 3
 *
 *  index:   0   1   2   3   4   5   6   7   8   9
 *  parent:  0   1   2   8   3   5   6   7   8   9
 *
 *                 8
 *                /
 *               3
 *             /
 *            4
 *
 *  Too tall tree is the problem of QuickUnion. To avoid this go for Weighted Quick Union.
 */
class QuickUnion(size: Int) {
    private val parents: IntArray

    init {
        parents = (0 until size)
            .map { it }
            .toIntArray()
    }

    fun getRoot(i: Int): Int {
        val iRoot = parents[i]
        return if (i == iRoot) {
            iRoot
        } else {
            getRoot(iRoot)
        }
    }

    fun isConnected(i: Int, j: Int): Boolean {
        return getRoot(i) == getRoot(j)
    }

    fun union(i: Int, j: Int) {
        val iRoot = getRoot(i)
        val jRoot = getRoot(j)

        if (iRoot != jRoot) {
            parents[iRoot] = jRoot
        }
    }

    fun print() {
        println("============Result============")
        print("Index:\t")
        parents.mapIndexed { index, _ ->
            print("$index\t")
        }
        println()
        print("Parent:\t")
        parents.map {
            print("$it\t")
        }
        println()
        println("==============================")
    }
}

fun main() {
    val obj = QuickUnion(10)
    obj.union(4, 3)
    obj.print()
    obj.union(3, 8)
    obj.print()
    obj.union(6, 5)
    obj.print()
    obj.union(9, 4)
    obj.print()
    obj.union(2, 1)
    obj.print()
    obj.union(5, 0)
    obj.print()
    obj.union(7, 2)
    obj.print()

    println("Union 6 and 1")
    println("-------------")
    obj.union(6, 1)
    obj.print()

    println("Union 7 and 3")
    println("-------------")
    obj.union(7, 3)
    /**
     *
     *                8
     *             /  \  \
     *           1     3  9
     *         / \ \    \
     *        0  2  7    4
     *       /
     *      5
     *     /
     *    6
     */
    println("Root of 7 is ${obj.getRoot(7)}")
    println("Root of 3 is ${obj.getRoot(3)}")
    obj.print()
}