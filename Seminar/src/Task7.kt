
/*
Задание №2 “Операции с коллекциями”
Семинар 3. Функции и коллекции
При помощи стандартных функций-расширений для работы с
коллекциями вывести на экран:
1. Количество людей в городе London в возрасте от 21 до 30 лет
включительно.
2. Список имён без повторений для города Berlin.
3. Список городов, в которых есть хотя бы один человек по
имени Oliver.
 */

data class Entry(
    val city: String,
    val name: String,
    val age: Int
)
val entries = listOf(
    Entry("London", "Liam", 28),
    Entry("Berlin", "Oliver", 24),
    Entry("Madrid", "Oliver", 45),
    Entry("Berlin", "Jerry", 29),
    Entry("London", "Oliver", 19),
    Entry("Madrid", "Kate", 16),
    Entry("Berlin", "Oliver", 34),
    Entry("London", "Kate", 25),
    Entry("Berlin", "Oliver", 23),
    Entry("Milan", "Jerry", 28),
    Entry("Paris", "Charles", 44)
)



fun main() {
    //------1-----//
    val londonPeopleCount = entries.count { it.city == "London" && it.age in 21..30 }
    println("Количество людей в городе London (21-30 лет): $londonPeopleCount")
    //----или----//
    val londonCountPeople = entries
        .filter { it.city == "London" && it.age in 21..30 }
        .count()
    println("Количество людей в городе London (21-30 лет): $londonCountPeople")

    //------2------//
    val berlinUniqueNames = entries
        .filter { it.city == "Berlin" }
        .distinctBy { it.name }//уникальность, можно .toSet()
        .map { it.name }
    println("Уникальные имена для города Berlin: $berlinUniqueNames")

    //------3-------//
    val citiesWithOliver = entries
        .filter { it.name == "Oliver" }
        .map { it.city }
        .distinct()
    println("Города с хотя бы одним человеком по имени Oliver: $citiesWithOliver")

}
