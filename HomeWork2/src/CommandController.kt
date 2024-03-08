import kotlin.system.exitProcess

class CommandController {
    fun readCommand(): Command {
        val input = readlnOrNull() ?: ""
        val tokens = input.split(" ")

        return when {
            input.startsWith("add") && tokens.size == 4 && tokens[2] == "phone" -> {
                AddPhoneCommand(tokens[1], tokens[3])
            }

            input.startsWith("add") && tokens.size == 4 && tokens[2] == "email" -> {
                AddEmailCommand(tokens[1], tokens[3])
            }

            input == "help" -> {
                HelpCommand()
            }

            input == "show" -> {
                ShowCommand(null)
            }

            input == "exit" -> exitProcess(0)

            else -> {
                object : Command {
                    override fun isValid(): Boolean {
                        return false
                    }
                }
                HelpCommand()
            }
        }
    }

}