package haydende.sfgpetclinickotlin.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
open class Pet(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long?,
    @Column
    open var name: String?,
    @Column
    open val birthDate: LocalDate?,
    @OneToOne
    open var petType: PetType?,
    @ManyToOne
    open var owner: Owner?,
    @OneToMany(
        mappedBy = "pet",
        cascade = [CascadeType.ALL]
    )
    open var visits: MutableSet<Visit>?
) {
}