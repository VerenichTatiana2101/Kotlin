import Person.Companion.find
import Person.Companion.showCont

class UserView {

    fun userChoice() {
        var person: Person? = null
        val commandSorter = CommandSorter()

        while (true) {
            println(
                "Введите команду:\n" +
                        "add <Имя> phone <Номер телефона>\n" +
                        "add <Имя> email <Адрес электронной почты>\n" +
                        "show\n" +
                        "find\n" +
                        "help\n" +
                        "exit"
            )

            val command = commandSorter.readCommand()

            println(command)

            when (command) {
                is Command.AddPhoneCommand -> {
                    person = Person(command.name)
                    person.addPhone(command.name, command.phone)
                    //addPerson(person)
                }

                is Command.AddEmailCommand -> {
                    person = Person(command.name)
                    person.addEmail(command.name, command.email)
                }

                is Command.HelpCommand -> {
                    command.helpCommand()
                }
                is Command.ShowPersons ->{
                    while(true){
                        println("Введите <Номер телефона> или <Адрес электронной почты> для поиска\n или exit чтобы выйти")
                        val data = readln()
                        if (data == "exit"){
                            userChoice()
                        } else find(data)
                    }
                }
                is Command.ShowByName ->{
                    while(true){
                        println("Введите <Имя> для поиска\n или exit чтобы выйти")
                        val data = readln()
                        if (data == "exit"){
                            userChoice()
                        } else showCont(data)
                    }
                }
            }
        }
    }
}
