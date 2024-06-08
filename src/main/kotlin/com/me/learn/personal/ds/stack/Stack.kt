package com.me.learn.personal.ds.stack

class Stack<T>(
    size: Int
) {
    private var elements: Array<T?> = arrayOfNulls<Any?>(size) as Array<T?>
    private var pointer = 0

    private fun isEmpty(): Boolean {
        return pointer == 0
    }

    fun push(element: T?) {
        elements[pointer] = element
        pointer++

        if (pointer == elements.size) {
            resize(2 * elements.size)
        }
    }

    fun pop(): T? {
        if (!isEmpty()) {
            pointer--
            val element = elements[pointer]
            elements[pointer] = null

            if (pointer > 0 && pointer == (elements.size) / 4) {
                resize(elements.size / 2)
            }

            return element
        } else {
            throw Exception("Stack is empty.")
        }
    }

    private fun resize(capacity: Int) {
        val newElements: Array<T?> = arrayOfNulls<Any?>(capacity) as Array<T?>
        (0 until pointer).forEach {
            newElements[it] = elements[it]
        }

        elements = newElements
    }

    fun print() {
        print("Index\t")
        elements.forEachIndexed { index, _ ->
            print("$index\t")
        }
        println()
        print("Element\t")
        elements.forEach {
            print("$it\t")
        }
        println()
        println("Pointer\t$pointer\tSize\t${elements.size}")
        println("=========================================")
    }
}

fun main() {
    val stack = Stack<Int>(2)
    stack.push(5)
    stack.print()
    stack.push(3)
    stack.print()
    stack.pop()
    stack.print()
    stack.pop()
    stack.print()
    stack.pop()
    stack.print()
}