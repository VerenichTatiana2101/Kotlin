interface Producer<out T> {
    fun produce(): T
}

class IntProducer : Producer<Int> {
    override fun produce(): Int {
        return 10
    }
}

class StringProducer : Producer<String> {
    override fun produce(): String {
        return "fcjytt"
    }
}

interface Consumer<in T>{
    fun consume(e : T)
}

class NumberConsumer: Consumer<Number>{
    override fun consume(e: Number) {}
}

fun foo(p: Producer<Number>) : Number{
    return p.produce()
}

fun <T> foo2(p: Producer<T>): T{
    return p.produce()
}

fun main() {
    val pint = IntProducer()
    val pstr = StringProducer()

    val intcon = NumberConsumer()
    val numcon: Consumer<Int> = intcon

    foo(pint)
    //foo(pstr) //ошибка, т.к стинг
    foo2(pint)
    foo2(pstr)
}