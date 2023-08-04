package haydende.sfgpetclinickotlin.model

data class Owner(
    override val id: Long,
    override var firstName: String,
    override var secondName: String,
    var city: String,
    var telephone: String,
    val pets: Set<Pet>
) : Person(id, firstName, secondName) {
}