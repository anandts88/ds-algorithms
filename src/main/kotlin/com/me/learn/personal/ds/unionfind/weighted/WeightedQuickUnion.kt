package com.me.learn.personal.ds.unionfind.weighted

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

    private fun getRoot(i: Int): Int {
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
    obj.union(4, 3)
    obj.print()
    obj.union(3, 8)
    obj.print()
    obj.union(6, 5)
    obj.print()
    obj.union(2, 1)
    obj.print()
    obj.union(9, 4)
    obj.print()
    obj.union(5, 0)
    obj.print()
    obj.union(7, 2)
    obj.print()
    obj.union(6, 1)
    obj.print()
    obj.union(7, 3)
    obj.print()
}