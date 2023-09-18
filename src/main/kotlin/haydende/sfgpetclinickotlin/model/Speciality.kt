package haydende.sfgpetclinickotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
open class Speciality(

    id: Long? = null,

    @Column
    open var description: String? = null

): BaseEntity(id)