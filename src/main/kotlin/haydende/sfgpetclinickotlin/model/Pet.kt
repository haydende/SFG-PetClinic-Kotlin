package haydende.sfgpetclinickotlin.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
open class Pet(

    id: Long? = null,

    @Column
    open var name: String? = null,

    @Column
    open val birthDate: LocalDate? = null,

    @OneToOne
    open var petType: PetType? = null,

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    open var owner: Owner? = null,

    @OneToMany(
        mappedBy = "pet",
        cascade = [CascadeType.ALL]
    )
    open var visits: MutableSet<Visit?> = mutableSetOf()

): BaseEntity(id)