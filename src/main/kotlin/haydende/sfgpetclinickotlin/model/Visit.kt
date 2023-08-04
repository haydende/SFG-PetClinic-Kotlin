package haydende.sfgpetclinickotlin.model

import java.time.LocalDate

data class Visit(
    override val id: Long,
    val date: LocalDate,
    var description: String,
    val pet: Pet
) : BaseEntity(id) {
}