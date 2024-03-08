class UserView {

    fun userChoice(){
        var person: Person? = null
        val commandController = CommandController()
        val helpCom = HelpCommand()

        while (true) {
            println(
                "Введите команду:\n" +
                        "add <Имя> phone <Номер телефона>\n" +
                        "add <Имя> email <Адрес электронной почты>\n" +
                        "show\n" + "help\n" + "exit"
            )

            val command = commandController.readCommand()

            println(command)

            if (!command.isValid()) {
                println("Ошибка! Команда не распознана!")
                helpCom.helpCommand()
            } else {
                when (command) {
                    is AddPhoneCommand -> {
                        person = Person(command.name)
                        person.phone = command.phone
                    }

                    is AddEmailCommand -> {
                        person = Person(command.name)
                        person.email = command.email
                    }

                    is HelpCommand -> {

                        command.helpCommand()
                    }
                    is ShowCommand -> {
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
}