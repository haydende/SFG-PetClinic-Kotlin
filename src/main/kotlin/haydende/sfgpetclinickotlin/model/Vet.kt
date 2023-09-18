package haydende.sfgpetclinickotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany

@Entity
open class Vet(

    id: Long? = null,

    @Column
    open var firstName: String,

    @Column
    open var lastName: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "vet_specialities",
        joinColumns = [
            JoinColumn(
                name = "vet_id",
                referencedColumnName = "id",
                nullable = false,
                updatable = false
            )
        ],
        inverseJoinColumns = [
            JoinColumn(
                name = "speciality_id",
                referencedColumnName = "id",
                nullable = false,
                updatable = false
            )
        ]
    )
    open var specialities: MutableSet<Speciality> = mutableSetOf()

): BaseEntity(id)