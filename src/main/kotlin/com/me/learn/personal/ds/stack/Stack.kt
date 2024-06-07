package com.me.learn.personal.ds.stack

class Stack<T>(
    private val size: Int
) {
    private var elements: Array<T?> = arrayOfNulls<Any?>(size) as Array<T?>
    private var pointer = -1

    private fun isEmpty(): Boolean {
        return pointer < 0
    }

    fun push(element: T?) {
        elements[++pointer] = element
        val maxIndex = elements.size - 1
        if (pointer == maxIndex && maxIndex >= size - 2) {
            resize(2 * maxIndex)
        }
    }

    fun pop(): T? {
        if (!isEmpty()) {
            val element = elements[pointer]
            elements[pointer] = null
            pointer--

            val minIndex = (elements.size - 1) / 4
            if (pointer == minIndex) {
                resize((elements.size - 1) / 4)
            }

            return element
        } else {
            throw Exception("Stack is empty.")
        }
    }

    fun resize(capacity: Int) {
        val newElements: Array<T?> = arrayOfNulls<Any?>(capacity) as Array<T?>
        elements.forEachIndexed { index, element ->
            newElements[index] = element
        }
        elements = newElements
    }
}