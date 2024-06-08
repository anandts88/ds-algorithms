package com.me.learn.personal.ds.stack.dtsa

import com.me.learn.personal.ds.stack.Stack

class DijikstrasTwoStackAlgorithm(
    val expression: String
) {
    fun execute() {
        val valueStack = Stack<Int>(expression.length)
        val operatorStack = Stack<Char>(expression.length)
        expression.forEach {
            if (it == '+' || it == '*' || it == '-' || it == '/' || it == '%') {
                operatorStack.push(it)
            } else if (it == ')') {
                val topElement = valueStack.pop() ?: 0
                val previousElement = valueStack.pop() ?: 0
                val operator = operatorStack.pop()

                val result = when (operator) {
                    '+' -> previousElement + topElement
                    '-' -> previousElement - topElement
                    '*' -> previousElement * topElement
                    '/' -> previousElement / topElement
                    '%' -> previousElement % topElement
                    else -> null
                }

                valueStack.push(result)
            } else if (it != '(' && it != ' ') {
                valueStack.push(it.digitToInt())
            }
        }

        println("Result is ${valueStack.pop()}")
    }
}

fun main() {
    val alg = DijikstrasTwoStackAlgorithm("(1 + (( 2 + 3 ) * (4 * 3)))")
    alg.execute()
}