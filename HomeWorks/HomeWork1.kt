import kotlin.system.exitProcess

/*
Написать программу, которая обрабатывает введённые пользователем в консоль команды:
exit
help
add <Имя> phone <Номер телефона>
add <Имя> email <Адрес электронной почты>

После выполнения команды, кроме команды exit, программа ждёт следующую команду.
 */

fun main() {
    userChoice()
}

fun userChoice() {
    while (true) {
        println(
            "Введите команду:\n" +
                    "add <Имя> phone <Номер телефона>\n" +
                    "add <Имя> email <Адрес электронной почты>\n" +
                    "help\n" +
                    "exit"
        )

        val inCommand = readlnOrNull()?.trim()

        when {
            inCommand?.startsWith("add ") == true
            -> validInputCommand(inCommand)?.let { addData(whatDo(inCommand), it) }

            inCommand == "help" -> helpCommand()
            inCommand == "exit" -> exitProcess(0)
            else -> println("Команда не распознана")
        }
    }
}

fun helpCommand() {
    println("help")
    println(
        "'add <Имя> phone <Номер телефона>' " +
                "-проверка соответствия введённой команды и номера телефона\n" +
                "'add <Имя> email <Адрес электронной почты>' " +
                "-проверка соответствия введённой команды и валидности электронного адреса\n" +
                "'help' -описание рабочих команд\n" +
                "'exit' -выход из программы\n" +
                "Обязательное соблюдение формата ввода, наличие угловых скобок!!!\n"
    )
}

fun addData(vararg validData: String) {
    val com = validData[0]
    val parts = validData[1].split(" ")

    if (com == "phone") {
        if (isValidPhoneNumber(parts[1])) {
            println("Имя: ${parts[0]}, Телефон: ${parts[1]}")
        } else {
            println("Неверный формат номера телефона.\n")
        }
    } else if (com == "email") {
        if (isValidEmail(parts[1])) {
            println("Имя: ${parts[0]}, Адрес электронной почты: ${parts[1]}")
        } else {
            println("Неверный формат электронной почты.\n")
        }
    } else {
        println("Ошибка введённой команды!")
    }
}

fun whatDo(command: String): String {
    val parts = command.split(" ")
    return parts[2]
}

fun isValidPhoneNumber(number: String): Boolean {
    val regex = """^\+[0-9]{10,13}$""".toRegex()
    return number.matches(regex)
}

fun isValidEmail(email: String): Boolean {
    val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    return email.matches(emailRegex)
}

fun validInputCommand(command: String): String? {
    val parts = command.split(" ")

    return if (parts.size == 4 && parts[1].startsWith("<")
        && parts[1].endsWith(">")
        && parts[3].startsWith("<")
        && parts[3].endsWith(">")
    ) {
        val name = parts[1].substring(1 until parts[1].length - 1)
        val value = parts[3].substring(1 until parts[3].length - 1)
        //println("$name $value")
        "$name $value"
    } else {
        println("Вы ввели некорректные данные - $command или")
        null
    }
}
