import kotlin.system.exitProcess

class CommandSorter {
    fun readCommand(): Command {
        val input = readlnOrNull() ?: ""
        val tokens = input.split(" ")

        return when {
            input.startsWith("add") && tokens.size == 4 && tokens[2] == "phone" -> {
                if (Command.AddPhoneCommand(tokens[1], tokens[3]).isValid()) {
                    Command.AddPhoneCommand(tokens[1], tokens[3])
                } else {
                    println("Неверный номер телефона. Пожалуйста, укажите действительный номер телефона.")
                    Command.HelpCommand()

                }
            }

            input.startsWith("add") && tokens.size == 4 && tokens[2] == "email" -> {
                if (Command.AddEmailCommand(tokens[1], tokens[3]).isValid()) {
                    Command.AddEmailCommand(tokens[1], tokens[3])
                } else {
                    println("Неверный адрес электронной почты. Пожалуйста, укажите действительный адрес электронной почты.")
                    Command.HelpCommand()
                }
            }

            input == "help" -> Command.HelpCommand()
            input == "find" -> Command.ShowPersons()// добавить аргумент, перенести метод
            input == "show" -> Command.ShowByName()
            input == "exit" -> exitProcess(0)

            else -> {
                println("Ошибка! Команда не распознана!")
                Command.HelpCommand()
            }
        }
    }
}