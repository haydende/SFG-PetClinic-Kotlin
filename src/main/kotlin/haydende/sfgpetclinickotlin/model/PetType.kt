package haydende.sfgpetclinickotlin.model

data class PetType(
    override val id: Long,
    val name: String
) : BaseEntity(id) {
}