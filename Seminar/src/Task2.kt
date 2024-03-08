fun main() {
    /*
    Реализовать функции sumAll, createOutputString и multiplyBy
    так, чтобы программа выводила следующие строчки.
    sumAll = 26
    sumAll = 0
    sumAll = 27
    Alice has age of 42
    Bob has age of 23
    student Carol has age of 19
    Daniel has age of 32
    null
    12
     */
    println("sumAll = ${sumAll(1, 5, 20)}")
    println("sumAll = ${sumAll()}")
    println("sumAll = ${sumAll(2, 3, 4, 5, 6, 7)}")

    println(createOutputString("Alice"))
    println(createOutputString("Bob", 23))
    println(createOutputString(isStudent = true, name = "Carol", age = 19))
    println(createOutputString("Daniel", 32, isStudent = null))

    println(multiplyBy(null, 4))
    println(multiplyBy(3, 4))
}

/**
 * Принимает переменное число аргументов типа Int. Возвращает сумму
 * всех чисел, либо 0, если не передан ни один аргумент.
 */
private fun sumAll(vararg numbers: Int): Int {
    if (numbers.isEmpty()) return 0
    else {
        var sum = 0
        for (element in numbers) {
            sum += element
        }
        return sum
    }
}

private fun sumAll2(vararg numbers: Int): Int {
    return numbers.sum()
}

/**
 * Формирует строку, используя параметры name, age и
 * isStudent. У параметров age и isStudent есть значения по умолчанию.
 */
private fun createOutputString(
    name: String,
    age: Int = 42, isStudent: Boolean? = false
): String {
    return if (isStudent == true) "student $name has age of $age"
    else "$name has age of $age"
}

private fun createOutputString2(
    name: String,
    age: Int = 42, isStudent: Boolean? = null
): String =
    when (isStudent) {
        true -> "student $name has age of $age"
        else -> "$name has age of $age"
    }

/**
 * Принимает два числа типа Int и возвращает их произведение.
 * Вместо первого числа, можно передать null, в этом случае функция должна
 * вернуть null.
 */
private fun multiplyBy(i: Int?, b: Int?): Int? {
    return if (i != null && b != null) {
        i * b
    } else {
        null
    }
}

