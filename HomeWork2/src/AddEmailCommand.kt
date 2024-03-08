data class AddEmailCommand(val name: String, val email: String) : Command {
    override fun isValid(): Boolean {
        // Проверка валидности адреса электронной почты
        return email.matches(Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\$"))
    }
}
