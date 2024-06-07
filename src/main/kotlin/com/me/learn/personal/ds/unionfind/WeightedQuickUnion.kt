package com.me.learn.personal.ds.unionfind

/**
 * Quick find end up in very large tree. Traversing long tree is costly.
 * So we use weighted tree.
 * Implementation is almost same as QuickUnion.
 * Difference is we will maintain weight of tree. No of elements in the tree in separate array.
 * While doing union we will
 *  1. Find root of both elements  i and j.
 *  2. Get weight of both elements  i and j.
 *  3. Smaller tree go under bigger tree.
 *  4. if the weight of i root is smaller than weight of j root then
 *          i root goes under j root.
 *          weight of j root has to be incremented to calculate new weight by summing with weight of i root.
 *     else
 *          j root goes under i root.
 *          weight of i root has to be incremented to calculate new weight by summing with weight of j root.
 *
 */
class WeightedQuickUnion(size: Int) {
    private val parents: IntArray
    private val weight: IntArray

    init {
        parents = (0 until size)
            .map { it }
            .toIntArray()

        weight = (0 until size)
            .map { 1 }
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
            if (weight[iRoot] < weight[jRoot]) {
                parents[iRoot] = jRoot
                weight[jRoot] += weight[iRoot]
            } else {
                parents[jRoot] = iRoot
                weight[iRoot] += weight[jRoot]
            }
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
        print("Weight:\t")
        weight.map {
            print("$it\t")
        }
        println()
        println("==============================")
    }
}

fun main() {
    val obj = WeightedQuickUnion(10)
    /**
     * 0 1 2 3 4 5 6 7 8 9
     *
     * Weights
     *  0   1   2   3   4   5   6   7   8   9
     *  1   1   1   1   1   1   1   1   1   1
     */

    println("Union 4 and 3")
    println("-------------")
    obj.union(4, 3)
    /**
     *
     * Weights
     *  0   1   2   3   4   5   6   7   8   9
     *  1   1   1   1   2   1   1   1   1   1
     *
     * 0 1 2 5 6 7 8 9
     *
     *       4
     *      /
     *     3
     */
    obj.print()

    println("Union 3 and 8")
    println("-------------")
    obj.union(3, 8)
    /**
     *
     * Weights
     *  0   1   2   3   4   5   6   7   8   9
     *  1   1   1   1   3   1   1   1   3   1
     *
     * 0 1 2 5 6 7 9
     *
     *       4
     *      / \
     *     3   8
     */
    obj.print()

    println("Union 6 and 5")
    println("-------------")
    obj.union(6, 5)
    /**
     *
     * Weights
     *  0   1   2   3   4   5   6   7   8   9
     *  1   1   1   1   3   1   2   1   3   1
     *
     * 0 1 2 7 9
     *
     *       6
     *      /
     *     5
     *
     *       4
     *      / \
     *     3   8
     */
    obj.print()

    println("Union 2 and 1")
    println("-------------")
    obj.union(2, 1)
    /**
     *
     * Weights
     *  0   1   2   3   4   5   6   7   8   9
     *  1   1   2   1   3   1   2   1   3   1
     *
     * 0 7 9
     *
     *       2
     *      /
     *     1
     *
     *       6
     *      /
     *     5
     *
     *       4
     *      / \
     *     3   8
     */
    obj.print()

    println("Union 9 and 4")
    println("-------------")
    obj.union(9, 4)
    /**
     *
     * Weights
     *  0   1   2   3   4   5   6   7   8   9
     *  1   1   2   1   4   1   2   1   3   1
     *
     * 0 7 9
     *
     *       2
     *      /
     *     1
     *
     *       6
     *      /
     *     5
     *
     *        4
     *    /  /  \
     *   9  3   8
     */
    obj.print()

    println("Union 5 and 0")
    println("-------------")
    obj.union(5, 0)
    /**
     *
     * Weights
     *  0   1   2   3   4   5   6   7   8   9
     *  1   1   2   1   4   1   3   1   3   1
     *
     * 7 9
     *
     *       2
     *      /
     *     1
     *
     *       6
     *      / \
     *     5   0
     *
     *        4
     *    /  /  \
     *   9  3   8
     */
    obj.print()

    println("Union 7 and 2")
    println("-------------")
    obj.union(7, 2)
    /**
     *
     * Weights
     *  0   1   2   3   4   5   6   7   8   9
     *  1   1   3   1   4   1   3   1   3   1
     *
     * 9
     *
     *       2
     *      / \
     *     1   7
     *
     *       6
     *      / \
     *     5   0
     *
     *        4
     *    /  /  \
     *   9  3   8
     */
    obj.print()

    println("Union 6 and 1")
    println("-------------")
    obj.union(6, 1)
    /**
     *
     * Weights
     *  0   1   2   3   4   5   6   7   8   9
     *  1   1   3   1   4   1   6   1   3   1
     *
     *
     *           6
     *       /   \  \
     *      5    0   2
     *             /  \
     *            1   7
     *
     *        4
     *    /  /  \
     *   9  3   8
     */
    obj.print()

    println("Union 7 and 3")
    println("-------------")
    obj.union(7, 3)
    /**
     *
     * Weights
     *  0   1   2   3   4   5   6   7   8   9
     *  1   1   3   1   4   1   10  1   3   1
     *
     *
     *               6
     *       /   \  \        \
     *      5    0   2          4
     *             /  \     /   \   \
     *            1   7    9    3   8
     *
     */
    obj.print()
}