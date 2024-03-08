/*
Написать программу, выводящую на экран фигуру из звёздочек.
a – количество звёздочек на первой строчке;
b – количество строк от первой до центральной и от
центральной до последней;
c – количество звёздочек, на которое увеличивается
последовательность с каждой строкой.
 */
fun main() {
    arraysStars(5, 2, 2)
}

fun arraysStars(a: Int, b: Int, c: Int) {
    val symbol = "*"
    var count = a
    for (i in 0..c * b) {
        var image: String = ""
        image += symbol.repeat(count)
        println(image)
        count = if (i < b) (count + c) else count -c
    }
}
