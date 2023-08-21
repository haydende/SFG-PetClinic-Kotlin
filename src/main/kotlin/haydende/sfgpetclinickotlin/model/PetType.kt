package haydende.sfgpetclinickotlin.model

import jakarta.persistence.*

@Entity
open class PetType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null,
    @Column
    open val name: String? = null
)