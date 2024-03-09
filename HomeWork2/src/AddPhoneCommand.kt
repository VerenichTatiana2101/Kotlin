class AddPhoneCommand(val name: String, val phone: String) : Command {
    override fun isValid(): Boolean {
        return phone.matches(Regex("^\\+?[0-9\\-\\s]{7,}$"))
    }

    override fun toString(): String {
        return "AddPhoneCommand: name=$name, phone=$phone"
    }
}