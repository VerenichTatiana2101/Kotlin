data class AddPhoneCommand(val name: String, val phone: String) : Command {
    override fun isValid(): Boolean {
        // Проверка валидности номера телефона
        return phone.matches(Regex("^\\+?[0-9\\-\\s]{7,}$"))
    }
}