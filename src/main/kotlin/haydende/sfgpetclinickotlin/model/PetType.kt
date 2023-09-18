package haydende.sfgpetclinickotlin.model

import jakarta.persistence.*

@Entity
open class PetType(

    id: Long? = null,

    @Column
    open val name: String? = null

): BaseEntity(id)