sealed class ExitCommand(val message: String) : Command {
    override fun isValid(): Boolean = true // Всегда считаем команду корректной
}