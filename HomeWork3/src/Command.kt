sealed interface Command {
    fun isValid(): Boolean

    class AddEmailCommand(val name: String, val email: String) : Command {
        override fun isValid(): Boolean {
            return email.matches(Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\$"))
        }

        override fun toString(): String {
            return "AddEmailCommand: name=$name, email=$email"
        }
    }

    class AddPhoneCommand(val name: String, val phone: String) : Command {
        override fun isValid(): Boolean {
            val regex = """^\+[0-9]{10,13}$""".toRegex()
            return phone.matches(regex)
        }

        override fun toString(): String {
            return "AddPhoneCommand: name=$name, phone=$phone"
        }
    }

    class ShowPersons() : Command{
        override fun isValid(): Boolean {
            return true
        }

        override fun toString(): String {
            return "ShowPerson"
        }
    }

    class ShowByName() : Command{
        override fun isValid(): Boolean {
            return true
        }

        override fun toString(): String {
            return "ShowByName"
        }
    }

    class HelpCommand() : Command {
        override fun isValid(): Boolean {
            return true
        }

        fun helpCommand() {
            println("help")
            println(
                "'add <Имя> phone <Номер телефона>' " +
                        "-проверка соответствия введённой команды и номера телефона\n" +
                        "'add <Имя> email <Адрес электронной почты>' " +
                        "-проверка соответствия введённой команды и валидности электронного адреса\n" +
                        "'help' -описание рабочих команд\n" +
                        "'show' -по имени человека выводит связанные с ним телефоны и адреса электронной почты\n" +
                        "'find' -по email или телефону выводит список людей, для которых записано такое значение\n" +
                        "'exit' -выход из программы\n"
            )
        }
        override fun toString(): String {
            return "HelpCommand"
        }
    }
}