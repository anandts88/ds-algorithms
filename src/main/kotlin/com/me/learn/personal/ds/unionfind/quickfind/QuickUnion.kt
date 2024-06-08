package com.me.learn.personal.ds.unionfind.quickfind

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