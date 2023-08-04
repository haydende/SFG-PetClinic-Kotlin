package haydende.sfgpetclinickotlin.model

import java.time.LocalDate

data class Pet(
    override val id: Long,
    var name: String,
    val birthDate: LocalDate,
    val petType: PetType,
    var owner: Owner,
    val visits: Set<Visit>
) : BaseEntity(id) {
}