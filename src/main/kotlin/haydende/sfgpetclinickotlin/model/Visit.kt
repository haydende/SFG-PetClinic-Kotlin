package haydende.sfgpetclinickotlin.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
open class Visit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long?,
    open val date: LocalDate,
    open var description: String,
    @ManyToOne
    @JoinColumn(name = "pet_id")
    open var pet: Pet
)