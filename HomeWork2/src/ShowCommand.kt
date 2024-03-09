class ShowCommand(val person: Person?) : Command {
    override fun isValid(): Boolean {
        return true
    }

    override fun toString(): String {
        return "ShowCommand"
    }
}