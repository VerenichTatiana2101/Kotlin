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
                    "'show' -выводит последнее значение, введённой с помощью команды add\n"+
                    "'exit' -выход из программы\n"
        )
    }

     override fun toString(): String {
         return "HelpCommand"
     }
}