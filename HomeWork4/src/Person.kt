import java.io.File

data class Person(
    val name: String,
    var phones: MutableList<String> = mutableListOf(),
    var emails: MutableList<String> = mutableListOf()
) {

    fun addPhone(name: String, phone: String) {
        val existingPerson = phoneBook[name]
        if (existingPerson != null) {
            existingPerson.phones.add(phone)
        } else {
            val newPerson = Person(name)
            newPerson.phones.add(phone)
            addPerson(newPerson)
        }
    }

    fun addEmail(name: String, email: String) {
        val existingPerson = phoneBook[name]
        if (existingPerson != null) {
            existingPerson.emails.add(email)
        } else {
            val newPerson = Person(name)
            newPerson.emails.add(email)
            //phoneBook[name] = newPerson
            addPerson(newPerson)
        }
    }

    fun show() {
        println("Имя: $name")
        println("Телефоны: ${phones.joinToString(", ")}")
        println("Emails: ${emails.joinToString(", ")}")
    }


    companion object {
        private val phoneBook: MutableMap<String, Person> = mutableMapOf()

        fun addPerson(person: Person) {
            phoneBook[person.name] = person
        }

        fun find(value: String) {
            val matchingPeople = phoneBook.values.filter { person ->
                person.phones.contains(value) || person.emails.contains(value)
            }
            if (matchingPeople.isNotEmpty()) {
                println("Люди с телефоном или email '$value':")
                matchingPeople.forEach { it.show() }
            } else {
                println("Нет записей для телефона или email '$value'")
            }
        }

        fun showCont(value: String) {
            val matchingPeople = phoneBook.values.filter { person ->
                person.name.contains(value)
            }
            if (matchingPeople.isNotEmpty()) {
                println("Контакты с именем '$value':")
                matchingPeople.forEach { it.show() }
            } else {
                println("Нет записей для '$value'")
            }
        }

        fun export(filePath: String) {
            val jsonObjects = phoneBook.values.map { person ->
                json {
                    addProperty("name", person.name)
                    addProperty("phone", person.phones)
                    addProperty("email", person.emails)
                }
            }
            val jsonFormat = "[${jsonObjects.joinToString(", ")}]"
            File(filePath).writeText(jsonFormat)
            println("Данные успешно экспортированы в файл: $filePath")
        }
    }
}




