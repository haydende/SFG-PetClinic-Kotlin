package haydende.sfgpetclinickotlin.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
open class Visit(

    id: Long?,

    @Column
    open val date: LocalDate,

    @Column
    open var description: String,

    @ManyToOne
    @JoinColumn(name = "pet_id")
    open var pet: Pet

): BaseEntity(id)