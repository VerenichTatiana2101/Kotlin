class UserView {

    fun userChoice() {
        var person: Person? = null
        val commandSorter = CommandSorter()

        while (true) {
            println(
                "Введите команду:\n" +
                        "add <Имя> phone <Номер телефона>\n" +
                        "add <Имя> email <Адрес электронной почты>\n" +
                        "show\n" + "help\n" + "exit"
            )

            val command = commandSorter.readCommand()

            println(command)

            when (command) {
                is Command.AddPhoneCommand -> {
                    person = Person(command.name)
                    person.phone = command.phone
                }

                is Command.AddEmailCommand -> {
                    person = Person(command.name)
                    person.email = command.email
                }

                is Command.HelpCommand -> {
                    command.helpCommand()
                }

                is Command.ShowCommand -> {
                    if (person == null) {
                        println("Not initialized")
                    } else {
                        if (person.phone.isNotEmpty()) {
                            println("Person: ${person.name}, Phone: ${person.phone}")
                        }
                        if (person.email.isNotEmpty()) {
                            println("Person: ${person.name}, Email: ${person.email}")
                        }
                    }
                }
            }
        }
    }
}
