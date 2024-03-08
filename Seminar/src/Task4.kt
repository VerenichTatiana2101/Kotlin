/*
Построить иерархию классов таким образом, чтобы после
выполнения функции main был выведен корректный результат
вычисления 3 формул. 
 */
fun main() {
    // Формулы 1-3
    // Соответствует формуле 4 + 2.5 * 2
    printOperationResult(
        Plus(
            Value(4.0),
            Multiply(
                Value(2.5),
                Value(2.0)
            )
        )
    )

    // Соответствует формуле (1 + 3.5) * (2.5 + 2)
    printOperationResult(
        Multiply(
            Plus(
                Value(1.0),
                Value(3.5)
            ),
            Plus(
                Value(2.5),
                Value(2.0)
            )
        )
    )

    // Соответствует формуле 10
    printOperationResult(
        Value(10.0)
    )
}

class Plus(val value: Operation, val value1: Operation) : Operation {
    override fun calculate() = value.calculate() + value1.calculate()
}

class Multiply(val value: Operation, val value1: Operation) : Operation {
    override fun calculate() = value.calculate() * value1.calculate()
}

class Value(val value: Double) : Operation {
    override fun calculate() = value
}

fun printOperationResult(operation: Operation) {
    val result = operation.calculate()
    println(result)
}

sealed interface Operation {
    fun calculate(): Double
}

